package com.jagng.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jagng.admin.mapper.TSchedulingPlanMapper;
import com.jagng.admin.domain.TSchedulingPlan;
import com.jagng.admin.service.ITSchedulingPlanService;

import javax.annotation.Resource;

/**
 * 员工排班计划;Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@Service
public class TSchedulingPlanServiceImpl implements ITSchedulingPlanService 
{
    @Resource
    private TSchedulingPlanMapper tSchedulingPlanMapper;

    /**
     * 查询员工排班计划;
     * 
     * @param id 员工排班计划;主键
     * @return 员工排班计划;
     */
    @Override
    public TSchedulingPlan selectTSchedulingPlanById(Integer id)
    {
        return tSchedulingPlanMapper.selectTSchedulingPlanById(id);
    }

    /**
     * 查询员工排班计划;列表
     * 
     * @param tSchedulingPlan 员工排班计划;
     * @return 员工排班计划;
     */
    @Override
    public List<TSchedulingPlan> selectTSchedulingPlanList(TSchedulingPlan tSchedulingPlan)
    {
        return tSchedulingPlanMapper.selectTSchedulingPlanList(tSchedulingPlan);
    }

    /**
     * 新增员工排班计划;
     * 
     * @param tSchedulingPlan 员工排班计划;
     * @return 结果
     */
    @Override
    public int insertTSchedulingPlan(TSchedulingPlan tSchedulingPlan)
    {
        return tSchedulingPlanMapper.insertTSchedulingPlan(tSchedulingPlan);
    }

    /**
     * 修改员工排班计划;
     * 
     * @param tSchedulingPlan 员工排班计划;
     * @return 结果
     */
    @Override
    public int updateTSchedulingPlan(TSchedulingPlan tSchedulingPlan)
    {
        return tSchedulingPlanMapper.updateTSchedulingPlan(tSchedulingPlan);
    }

    /**
     * 批量删除员工排班计划;
     * 
     * @param ids 需要删除的员工排班计划;主键
     * @return 结果
     */
    @Override
    public int deleteTSchedulingPlanByIds(String[] ids)
    {
        return tSchedulingPlanMapper.deleteTSchedulingPlanByIds(ids);
    }

    /**
     * 删除员工排班计划;信息
     * 
     * @param id 员工排班计划;主键
     * @return 结果
     */
    @Override
    public int deleteTSchedulingPlanById(String id)
    {
        return tSchedulingPlanMapper.deleteTSchedulingPlanById(id);
    }
}
