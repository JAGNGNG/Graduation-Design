package com.jagng.admin.biz;

import com.jagng.admin.domain.TMember;
import com.jagng.admin.service.ITMemberService;
import com.jagng.common.core.domain.AjaxResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class MemberBiz {

    @Resource
    private ITMemberService memberService;

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
}
