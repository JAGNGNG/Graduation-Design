package com.jagng.admin.dto;

import java.math.BigDecimal;

/**
 * @description: 薪酬DTO
 * @author: JAGNG
 * @create: 2022-10-15 22:49
 **/
public class SalaryDTO {


    /**
     * 员工id
     */
    private Integer empId;

    /**
     * 员工提成
     */
    private BigDecimal commission;

    /**
     * 底薪
     */
    private BigDecimal base;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getBase() {
        return base;
    }

    public void setBase(BigDecimal base) {
        this.base = base;
    }
}
