package com.jagng.admin.domain;

import java.math.BigDecimal;
import com.jagng.common.annotation.Excel;
import com.jagng.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 订单;对象 t_order
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
public class TOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 订单金额 */
    @Excel(name = "订单金额")
    private BigDecimal amount;

    /** 订单状态;0：待结算 1：已结算  2：已退款 3：已取消 */
    @Excel(name = "订单状态;0：待结算 1：已结算 2：已取消")
    private Integer state;

    /** 会员id */
    @Excel(name = "会员id")
    private Integer memberId;

    /** 是否为会员;0：否 1：是 */
    @Excel(name = "是否为会员;0：否 1：是")
    private Integer member;

    /**
     * 会员名称
     */
    private String memberName;

    /**
     * 会员手机号
     */
    private String phone;

    /**
     * 订单编号
     */
    private String orderNo;


    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }
    public void setState(Integer state)
    {
        this.state = state;
    }

    public Integer getState()
    {
        return state;
    }
    public void setMemberId(Integer memberId)
    {
        this.memberId = memberId;
    }

    public Integer getMemberId()
    {
        return memberId;
    }
    public void setMember(Integer member)
    {
        this.member = member;
    }

    public Integer getMember()
    {
        return member;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("amount", getAmount())
            .append("state", getState())
            .append("memberId", getMemberId())
            .append("member", getMember())
            .append("createTime", getCreateTime())
            .toString();
    }
}
