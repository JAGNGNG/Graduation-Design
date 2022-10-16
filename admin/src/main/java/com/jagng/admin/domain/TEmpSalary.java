package com.jagng.admin.domain;

import java.math.BigDecimal;
import com.jagng.common.annotation.Excel;
import com.jagng.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 员工薪酬对象 t_emp_salary
 * 
 * @author ruoyi
 * @date 2022-10-15
 */
public class TEmpSalary extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 员工id */
    @Excel(name = "员工id")
    private Integer empId;

    /** 年月 */
    @Excel(name = "年月")
    private String salaryMonth;

    /** 员工薪资 */
    @Excel(name = "员工薪资")
    private BigDecimal salary;

    /** 当月提成 */
    @Excel(name = "当月提成")
    private BigDecimal monthCommission;

    /** 员工底薪 */
    private BigDecimal Base;

    /** 员工名称 */
    private String empName;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
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

    public void setSalary(BigDecimal salary) 
    {
        this.salary = salary;
    }

    public BigDecimal getSalary() 
    {
        return salary;
    }
    public void setMonthCommission(BigDecimal monthCommission) 
    {
        this.monthCommission = monthCommission;
    }

    public BigDecimal getMonthCommission() 
    {
        return monthCommission;
    }

    public BigDecimal getBase() {
        return Base;
    }

    public void setBase(BigDecimal base) {
        Base = base;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSalaryMonth() {
        return salaryMonth;
    }

    public void setSalaryMonth(String salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("empId", getEmpId())
            .append("salary", getSalary())
            .append("monthCommission", getMonthCommission())
            .toString();
    }
}
