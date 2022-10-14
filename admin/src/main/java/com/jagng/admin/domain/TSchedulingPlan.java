package com.jagng.admin.domain;

import com.jagng.common.annotation.Excel;
import com.jagng.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 员工排班计划;对象 t_scheduling_plan
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
public class TSchedulingPlan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 员工id */
    @Excel(name = "员工id")
    private Integer empId;

    /** 当班日期;日期格式(yyyy-MM-dd) */
    @Excel(name = "当班日期;日期格式(yyyy-MM-dd)")
    private String planDate;

    /** 轮班优先级 */
    @Excel(name = "轮班优先级")
    private Integer priority;

    /** 班牌类型;数据字典ware_type_dict */
    @Excel(name = "班牌类型")
    private String brandType;

    /**
     * 员工名称
     */
    private String empName;

    /**
     * 班牌类型名称
     */
    private String brandTypeName;


    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getBrandTypeName() {
        return brandTypeName;
    }

    public void setBrandTypeName(String brandTypeName) {
        this.brandTypeName = brandTypeName;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setEmpId(Integer empId)
    {
        this.empId = empId;
    }

    public Integer getEmpId()
    {
        return empId;
    }
    public void setPlanDate(String planDate) 
    {
        this.planDate = planDate;
    }

    public String getPlanDate()
    {
        return planDate;
    }
    public void setPriority(Integer priority)
    {
        this.priority = priority;
    }

    public Integer getPriority()
    {
        return priority;
    }
    public void setBrandType(String brandType) 
    {
        this.brandType = brandType;
    }

    public String getBrandType() 
    {
        return brandType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("empId", getEmpId())
            .append("planDate", getPlanDate())
            .append("priority", getPriority())
            .append("brandType", getBrandType())
            .toString();
    }
}
