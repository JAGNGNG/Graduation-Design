package com.jagng.admin.domain;

import com.jagng.common.annotation.Excel;
import com.jagng.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 顾客反馈记录;对象 t_feedback
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
public class TFeedback extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 订单id */
    @Excel(name = "订单id")
    private String orderNo;

    /** 反馈意见 */
    @Excel(name = "反馈意见")
    private String feedback;

    /** 质量等级;0：负面 1：中性  2：正面 */
    @Excel(name = "质量等级;0：负面 1：中性  2：正面")
    private Long qualityLevel;

    private String feedbackTime;


    public String getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(String feedbackTime) {
        this.feedbackTime = feedbackTime;
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

    public void setFeedback(String feedback) 
    {
        this.feedback = feedback;
    }

    public String getFeedback() 
    {
        return feedback;
    }
    public void setQualityLevel(Long qualityLevel) 
    {
        this.qualityLevel = qualityLevel;
    }

    public Long getQualityLevel() 
    {
        return qualityLevel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderNo", getOrderNo())
            .append("feedback", getFeedback())
            .append("qualityLevel", getQualityLevel())
            .toString();
    }
}
