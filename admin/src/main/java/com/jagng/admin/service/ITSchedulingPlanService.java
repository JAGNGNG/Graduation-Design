package com.jagng.admin.service;

import java.util.List;
import com.jagng.admin.domain.TSchedulingPlan;

/**
 * 员工排班计划;Service接口
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
public interface ITSchedulingPlanService 
{
    /**
     * 查询员工排班计划;
     * 
     * @param id 员工排班计划;主键
     * @return 员工排班计划;
     */
    public TSchedulingPlan selectTSchedulingPlanById(Integer id);

    /**
     * 查询员工排班计划;列表
     * 
     * @param tSchedulingPlan 员工排班计划;
     * @return 员工排班计划;集合
     */
    public List<TSchedulingPlan> selectTSchedulingPlanList(TSchedulingPlan tSchedulingPlan);

    /**
     * 新增员工排班计划;
     * 
     * @param tSchedulingPlan 员工排班计划;
     * @return 结果
     */
    public int insertTSchedulingPlan(TSchedulingPlan tSchedulingPlan);

    /**
     * 修改员工排班计划;
     * 
     * @param tSchedulingPlan 员工排班计划;
     * @return 结果
     */
    public int updateTSchedulingPlan(TSchedulingPlan tSchedulingPlan);

    /**
     * 批量删除员工排班计划;
     * 
     * @param ids 需要删除的员工排班计划;主键集合
     * @return 结果
     */
    public int deleteTSchedulingPlanByIds(String[] ids);

    /**
     * 删除员工排班计划;信息
     * 
     * @param id 员工排班计划;主键
     * @return 结果
     */
    public int deleteTSchedulingPlanById(String id);
}
