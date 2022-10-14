package com.jagng.admin.domain;

import java.math.BigDecimal;
import com.jagng.common.annotation.Excel;
import com.jagng.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 会员信息;对象 t_member
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
public class TMember extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 顾客名称 */
    @Excel(name = "顾客名称")
    private String customerName;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phone;

    /** 会员类别;数据字典member_type_dict */
    @Excel(name = "会员类别;数据字典member_type_dict")
    private String memberType;

    /** 余额 */
    @Excel(name = "余额")
    private BigDecimal balance;

    /** 入会时间;日期格式（yyyy-MM-dd） */
    @Excel(name = "入会时间;日期格式", readConverterExp = "y=yyy-MM-dd")
    private String membershipTime;

    /**
     * 会员类型名
     */
    private String memberTypeName;


    public String getMemberTypeName() {
        return memberTypeName;
    }

    public void setMemberTypeName(String memberTypeName) {
        this.memberTypeName = memberTypeName;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setMemberType(String memberType) 
    {
        this.memberType = memberType;
    }

    public String getMemberType() 
    {
        return memberType;
    }
    public void setBalance(BigDecimal balance) 
    {
        this.balance = balance;
    }

    public BigDecimal getBalance() 
    {
        return balance;
    }
    public void setMembershipTime(String membershipTime) 
    {
        this.membershipTime = membershipTime;
    }

    public String getMembershipTime() 
    {
        return membershipTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("customerName", getCustomerName())
            .append("phone", getPhone())
            .append("memberType", getMemberType())
            .append("balance", getBalance())
            .append("membershipTime", getMembershipTime())
            .toString();
    }
}
