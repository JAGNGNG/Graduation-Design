package com.jagng.admin.domain;

import java.math.BigDecimal;
import com.jagng.common.annotation.Excel;
import com.jagng.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 订单明细;对象 t_order_dtl
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
public class TOrderDtl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNo;

    /** 商品id;美容美发产品或者服务类别 */
    @Excel(name = "商品编号")
    private String wareCode;

    /** 商品数量;美容美发产品或者服务数量 */
    @Excel(name = "商品数量")
    private Integer wareNum;

    /** 明细金额;该批次关联产品总金额，仅用于计算员工提成 */
    @Excel(name = "明细金额")
    private BigDecimal detailedAmount;

    /** 关联员工 */
    @Excel(name = "关联员工")
    private Integer empId;

    /** 员工提成 */
    @Excel(name = "员工提成")
    private BigDecimal commission;

    /**
     * 员工名称
     */
    private String empName;

    /**
     * 商品名称
     */
    private String wareName;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderCode) {
        this.orderNo = orderCode;
    }

    public String getWareCode() {
        return wareCode;
    }

    public void setWareCode(String wareCode) {
        this.wareCode = wareCode;
    }

    public void setWareNum(Integer wareNum)
    {
        this.wareNum = wareNum;
    }

    public Integer getWareNum()
    {
        return wareNum;
    }
    public void setDetailedAmount(BigDecimal detailedAmount) 
    {
        this.detailedAmount = detailedAmount;
    }

    public BigDecimal getDetailedAmount() 
    {
        return detailedAmount;
    }
    public void setEmpId(Integer empId)
    {
        this.empId = empId;
    }

    public Integer getEmpId()
    {
        return empId;
    }
    public void setCommission(BigDecimal commission) 
    {
        this.commission = commission;
    }

    public BigDecimal getCommission() 
    {
        return commission;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderCode", getOrderNo())
            .append("wareCode", getWareCode())
            .append("wareNum", getWareNum())
            .append("detailedAmount", getDetailedAmount())
            .append("empId", getEmpId())
            .append("commission", getCommission())
            .toString();
    }
}
