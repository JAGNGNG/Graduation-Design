package com.jagng.admin.biz;

import com.jagng.admin.domain.*;
import com.jagng.admin.dto.EmpInfoDTO;
import com.jagng.admin.service.*;
import com.jagng.admin.vo.AddOrderWareParam;
import com.jagng.common.core.domain.AjaxResult;
import com.jagng.common.exception.ServiceException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Component
public class OrderDtlBiz {

    @Resource
    private ITWareService wareService;

    @Resource
    private ITOrderDtlService orderDtlService;

    @Resource
    private ITOrderService orderService;

    @Resource
    private ITSchedulingPlanService planService;

    @Resource
    private ITEmpInfoService empInfoService;

    @Transactional(rollbackFor = Exception.class)
    public AjaxResult addOrderWare(AddOrderWareParam addOrderWareParam) {
        //更新库存数据
        TWare queryWareParam = new TWare();
        queryWareParam.setWareCode(addOrderWareParam.getWareCode());
        TWare ware = wareService.selectTWareList(queryWareParam).get(0);

        //非服务类产品库存数量需要更新
        if (!Objects.equals(ware.getWareType(), "service")) {
            if (Objects.isNull(addOrderWareParam.getWareNum()) || addOrderWareParam.getWareNum() == 0) {
                throw new ServiceException("产品数量不能为0");
            }
            int updateRow = 0;
            //乐观锁自旋
            while (updateRow == 0) {
                if (ware.getWareNum() < addOrderWareParam.getWareNum()) {
                    throw new ServiceException("库存不足");
                }
                ware.setWareNum(ware.getWareNum() - addOrderWareParam.getWareNum());
                updateRow = wareService.updateTWare(ware);
                ware = wareService.selectTWareById(ware.getId());
            }
        }

        //添加订单明细数据
        BigDecimal detailedAmount = ware.getWarePrice().multiply(new BigDecimal(addOrderWareParam.getWareNum()));
        for (Integer empId : addOrderWareParam.getEmpIds()) {
            TOrderDtl orderDtl = new TOrderDtl();
            //服务类订单产品需要更新服务员工排班表
            if (Objects.equals(ware.getWareType(), "service")) {
                //设定订单明细数量
                orderDtl.setWareNum(1);
                //更新服务人员排班优先级
                TEmpInfo empInfo = empInfoService.selectTEmpInfoById(empId);
                EmpInfoDTO empInfoDTO = empInfoService.selectEmpInfoDTO(empInfo.getPhone());
                //见习服务人员不参与排班
                if (!empInfoDTO.getPostCode().contains("stu")){
                    TSchedulingPlan queryPlanParam = new TSchedulingPlan();
                    queryPlanParam.setPlanDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    queryPlanParam.setEmpId(empId);
                    List<TSchedulingPlan> empPlans = planService.selectTSchedulingPlanList(queryPlanParam);
                    if (CollectionUtils.isEmpty(empPlans)){
                        throw new ServiceException(String.format("员工(%s)今日未排班,请核对排班表安排其他服务人员",empInfo.getName()));
                    }
                    TSchedulingPlan empPlan = empPlans.get(0);
                    queryPlanParam.setEmpId(null);
                    queryPlanParam.setBrandType(empPlans.get(0).getBrandType());
                    List<TSchedulingPlan> brandTypePlans = planService.selectTSchedulingPlanList(queryPlanParam);
                    Integer maxPriority = brandTypePlans.stream()
                            .max(Comparator.comparing(TSchedulingPlan::getPriority))
                            .get()
                            .getPriority();
                    empPlan.setPriority(empPlan.getPriority()+maxPriority);
                    planService.updateTSchedulingPlan(empPlan);
                }
            }else {
                orderDtl.setWareNum(addOrderWareParam.getWareNum());
            }
            //增加订单明细信息
            orderDtl.setOrderNo(addOrderWareParam.getOrderNo());
            orderDtl.setDetailedAmount(detailedAmount);
            orderDtl.setWareCode(addOrderWareParam.getWareCode());
            orderDtl.setEmpId(empId);
            orderDtlService.insertTOrderDtl(orderDtl);
        }

        //更新订单数据--订单总金额
        TOrder queryOrderParam = new TOrder();
        queryOrderParam.setOrderNo(addOrderWareParam.getOrderNo());
        TOrder order = orderService.selectTOrderList(queryOrderParam).get(0);
        order.setAmount(order.getAmount().add(detailedAmount));
        orderService.updateTOrder(order);
        return AjaxResult.success();
    }
}
