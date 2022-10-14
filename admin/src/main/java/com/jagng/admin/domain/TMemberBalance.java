package com.jagng.admin.domain;

import java.math.BigDecimal;

import com.jagng.common.annotation.Excel;
import com.jagng.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 会员账户余额变动明细;对象 t_member_balance
 *
 * @author ruoyi
 * @date 2022-10-10
 */
public class TMemberBalance extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 会员id
     */
    @Excel(name = "会员id")
    private Integer memberId;

    /**
     * 变动金额
     */
    @Excel(name = "变动金额")
    private BigDecimal changeAmount;

    /**
     * 变动时间;日期格式(yyyy-MM-dd)
     */
    @Excel(name = "变动时间;日期格式(yyyy-MM-dd)")
    private String changeTime;

    /**
     * 变动方向;0:收入1:支出
     */
    @Excel(name = "变动方向;0:收入1:支出")
    private Integer changeDirection;

    /**
     * 订单id
     */
    @Excel(name = "订单id")
    private String orderNo;

    /**
     * 订单Id
     */
    private Integer orderId;

    /**
     * 交易金额;交易金额，记录充值活动如充300送100记录顾客时间支付金额
     */
    @Excel(name = "交易金额;交易金额，记录充值活动如充300送100记录顾客时间支付金额")
    private BigDecimal tradeAmount;

    /**
     * 会员名称
     */
    private String memberName;

    /**
     * 会员手机号码
     */
    private String phone;

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

    public void setChangeAmount(BigDecimal changeAmount) {
        this.changeAmount = changeAmount;
    }

    public BigDecimal getChangeAmount() {
        return changeAmount;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime;
    }

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeDirection(Integer changeDirection) {
        this.changeDirection = changeDirection;
    }

    public Integer getChangeDirection() {
        return changeDirection;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("memberId", getMemberId())
                .append("changeAmount", getChangeAmount())
                .append("changeTime", getChangeTime())
                .append("changeDirection", getChangeDirection())
                .append("orderId", getOrderId())
                .append("tradeAmount", getTradeAmount())
                .append("orderNo", getOrderNo())
                .toString();
    }
}
