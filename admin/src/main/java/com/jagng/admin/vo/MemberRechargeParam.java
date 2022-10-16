package com.jagng.admin.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 * @description: 会员充值参数
 * @author: JAGNG
 * @create: 2022-10-15 10:07
 **/
public class MemberRechargeParam {


    /**
     * 会员id
     */
    @NotNull(message = "会员主键不能为空")
    private Integer id;

    /**
     * 充值金额
     */
    private BigDecimal rechargeAmount;

    /**
     * 交易金额
     */
    private BigDecimal transAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }
}
