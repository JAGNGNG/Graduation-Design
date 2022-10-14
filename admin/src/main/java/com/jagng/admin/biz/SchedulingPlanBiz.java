package com.jagng.admin.biz;

import com.jagng.admin.domain.TSchedulingPlan;
import com.jagng.admin.service.ITSchedulingPlanService;
import com.jagng.common.core.domain.AjaxResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Component
public class SchedulingPlanBiz {

    @Resource
    private ITSchedulingPlanService schedulingPlanService;

    @Transactional(rollbackFor = Exception.class)
    public AjaxResult addScheduling(TSchedulingPlan schedulingPlan){
        TSchedulingPlan queryParam = new TSchedulingPlan();
        queryParam.setPlanDate(schedulingPlan.getPlanDate());
        queryParam.setEmpId(schedulingPlan.getEmpId());
        List<TSchedulingPlan> existsPlans = schedulingPlanService.selectTSchedulingPlanList(queryParam);
        if (!CollectionUtils.isEmpty(existsPlans)){
            return AjaxResult.error(String.format("该员工在(%s)已排班",schedulingPlan.getPlanDate()));
        }
        queryParam.setBrandType(schedulingPlan.getBrandType());
        queryParam.setPriority(schedulingPlan.getPriority());
        existsPlans = schedulingPlanService.selectTSchedulingPlanList(queryParam);
        if (!CollectionUtils.isEmpty(existsPlans)){
            return AjaxResult.error("员工排班优先级权重重复");
        }
        return schedulingPlanService.insertTSchedulingPlan(schedulingPlan)>0?AjaxResult.success():AjaxResult.error("新增失败");
    }
}
