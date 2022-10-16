package com.jagng.admin.biz;

import com.jagng.admin.domain.TMember;
import com.jagng.admin.domain.TMemberBalance;
import com.jagng.admin.service.ITMemberBalanceService;
import com.jagng.admin.service.ITMemberService;
import com.jagng.admin.vo.MemberRechargeParam;
import com.jagng.common.core.domain.AjaxResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class MemberBiz {

    @Resource
    private ITMemberService memberService;

    @Resource
    private ITMemberBalanceService balanceService;

    @Transactional(rollbackFor = Exception.class)
    public AjaxResult addMember(TMember member){
        TMember queryParam = new TMember();
        queryParam.setPhone(member.getPhone());
        List<TMember> memberList = memberService.selectTMemberList(queryParam);
        if (!CollectionUtils.isEmpty(memberList)){
            return AjaxResult.error("会员手机号已存在");
        }
        member.setMembershipTime(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return memberService.insertTMember(member)>0?AjaxResult.success():AjaxResult.error("新增失败");
    }

    public AjaxResult recharge(MemberRechargeParam rechargeParam){
        //更新会员表
        TMember member = memberService.selectTMemberById(rechargeParam.getId());
        member.setBalance(member.getBalance().add(rechargeParam.getRechargeAmount()));
        memberService.updateTMember(member);
        //记录账户变动明细
        TMemberBalance memberBalance = new TMemberBalance();
        memberBalance.setMemberId(member.getId());
        memberBalance.setChangeAmount(rechargeParam.getRechargeAmount());
        memberBalance.setTradeAmount(rechargeParam.getTransAmount());
        memberBalance.setChangeDirection(0);
        memberBalance.setChangeTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        balanceService.insertTMemberBalance(memberBalance);
        return AjaxResult.success();
    }
}
