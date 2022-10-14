package com.jagng.admin.biz;

import com.jagng.admin.domain.*;
import com.jagng.admin.service.*;
import com.jagng.admin.vo.SettlementParam;
import com.jagng.common.core.domain.AjaxResult;
import com.jagng.common.core.domain.entity.SysDictData;
import com.jagng.common.exception.ServiceException;
import com.jagng.common.utils.DictUtils;
import com.jagng.common.utils.uuid.Seq;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class OrderBiz {

    @Resource
    private ITOrderService orderService;

    @Resource
    private ITMemberService memberService;

    @Resource
    private ITMemberBalanceService memberBalanceService;

    @Resource
    private ITOrderDtlService orderDtlService;

    @Resource
    private ITEmpInfoService empInfoService;

    @Resource
    private ITWareService wareService;

    @Transactional(rollbackFor = Exception.class)
    public AjaxResult addOrder(){
        TOrder tOrder = new TOrder();
        tOrder.setOrderNo(Seq.getId());
        tOrder.setCreateTime(new Date());
        tOrder.setState(0);
        tOrder.setAmount(BigDecimal.ZERO);
        tOrder.setMember(0);
        return orderService.insertTOrder(tOrder)>0?AjaxResult.success():AjaxResult.error("新增失败");
    }

    @Transactional(rollbackFor = Exception.class)
    public AjaxResult settlement(SettlementParam settlementParam){
        BigDecimal transAmount = settlementParam.getAmount();
        //会员结算
        if (settlementParam.getMember() == 1){
            TMember member = memberService.selectTMemberById(settlementParam.getMemberId());
            //计算折扣后需要支付的金额
            List<SysDictData> memberTypes = DictUtils.getDictCache("member_type_dict");
            SysDictData currentType = new SysDictData();
            for (SysDictData memberType : memberTypes) {
                if (Objects.equals(memberType.getDictValue(),member.getMemberType())){
                    currentType = memberType;
                    break;
                }
            }
            BigDecimal discountAmount =settlementParam.getAmount().multiply(new BigDecimal(currentType.getRemark())).setScale(2, RoundingMode.CEILING);
            if (member.getBalance().compareTo(discountAmount)<0){
                throw new ServiceException(String.format("会员余额不足,订单折扣后金额%s,会员余额%s",discountAmount,member.getBalance()));
            }
            transAmount = discountAmount;

            //修改会员余额
            member.setBalance(member.getBalance().subtract(discountAmount));
            memberService.updateTMember(member);
            //记录会员余额变动明细
            TMemberBalance memberBalance = new TMemberBalance();
            memberBalance.setOrderNo(settlementParam.getOrderNo());
            memberBalance.setOrderId(settlementParam.getId());
            memberBalance.setChangeAmount(transAmount);
            memberBalance.setChangeDirection(1);
            memberBalance.setChangeTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            memberBalance.setTradeAmount(transAmount);
            memberBalance.setMemberId(settlementParam.getMemberId());
            memberBalanceService.insertTMemberBalance(memberBalance);
        }

        //计算员工提成
        TOrderDtl queryDtlParam = new TOrderDtl();
        queryDtlParam.setOrderNo(settlementParam.getOrderNo());
        List<TOrderDtl> orderDtls = orderDtlService.selectTOrderDtlList(queryDtlParam);
        if (CollectionUtils.isEmpty(orderDtls)){
            throw new ServiceException(String.format("订单(%s)不存在产品，请检查订单明细产品",settlementParam.getOrderNo()));
        }
        for (TOrderDtl orderDtl : orderDtls) {
           TEmpInfo empInfo = empInfoService.selectTEmpInfoById(orderDtl.getEmpId());
           orderDtl.setCommission(orderDtl.getDetailedAmount().multiply(empInfo.getCommission()).setScale(2,RoundingMode.CEILING));
            orderDtlService.updateTOrderDtl(orderDtl);
        }

        //修改订单状态
        TOrder order = new TOrder();
        order.setId(settlementParam.getId());
        order.setState(1);
        order.setMember(settlementParam.getMember());
        order.setMemberId(settlementParam.getMemberId());
        orderService.updateTOrder(order);
        return AjaxResult.success();
    }

    @Transactional(rollbackFor = Exception.class)
    public AjaxResult refund(Integer id){
        TOrder order = orderService.selectTOrderById(id);
        if (order.getMember() == 1){
            //退还会员余额
            TMember member = memberService.selectTMemberById(order.getMemberId());
            TMemberBalance queryBalParam = new TMemberBalance();
            queryBalParam.setOrderId(id);
            TMemberBalance payMemberBalance = memberBalanceService.selectTMemberBalanceList(queryBalParam).get(0);
            member.setBalance(member.getBalance().add(payMemberBalance.getChangeAmount()));
            memberService.updateTMember(member);
            //记录会员余额变动明细
            TMemberBalance refundBal = new TMemberBalance();
            refundBal.setOrderId(id);
            refundBal.setOrderNo(order.getOrderNo());
            refundBal.setMemberId(member.getId());
            refundBal.setTradeAmount(payMemberBalance.getTradeAmount());
            refundBal.setChangeAmount(payMemberBalance.getChangeAmount());
            refundBal.setChangeDirection(0);
            refundBal.setChangeTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            memberBalanceService.insertTMemberBalance(refundBal);
        }
        //清空员工提成
        TOrderDtl queryDtlParam = new TOrderDtl();
        queryDtlParam.setOrderNo(order.getOrderNo());
        List<TOrderDtl> orderDtlList = orderDtlService.selectTOrderDtlList(queryDtlParam);
        for (TOrderDtl orderDtl : orderDtlList) {
            orderDtl.setCommission(BigDecimal.ZERO);
            orderDtlService.updateTOrderDtl(orderDtl);
        }
        //修改订单状态
        order.setState(0);
        orderService.updateTOrder(order);
        return AjaxResult.success();
    }

    @Transactional(rollbackFor = Exception.class)
    public AjaxResult cancel(Integer id){
        TOrder order = orderService.selectTOrderById(id);
        //释放库存
        TOrderDtl queryDtlParam = new TOrderDtl();
        queryDtlParam.setOrderNo(order.getOrderNo());
        List<TOrderDtl> orderDtlList = orderDtlService.selectTOrderDtlList(queryDtlParam);
        for (TOrderDtl orderDtl : orderDtlList) {
            //返还产品库存
            TWare queryWareParam = new TWare();
            queryWareParam.setWareCode(orderDtl.getWareCode());
            TWare ware = wareService.selectTWareList(queryWareParam).get(0);
            if (!Objects.equals(ware.getWareType(),"service")){
                int updateRow = 0;
                //乐观锁自旋
                while (updateRow == 0) {
                    ware.setWareNum(ware.getWareNum() + orderDtl.getWareNum());
                    updateRow = wareService.updateTWare(ware);
                    ware = wareService.selectTWareById(ware.getId());
                }
            }
        }
        //修改订单状态为关闭
        order.setState(2);
        orderService.updateTOrder(order);
        return AjaxResult.success();
    }
}
