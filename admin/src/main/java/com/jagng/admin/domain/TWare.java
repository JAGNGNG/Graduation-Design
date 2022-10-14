package com.jagng.admin.domain;

import java.math.BigDecimal;
import com.jagng.common.annotation.Excel;
import com.jagng.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 库存信息;对象 t_ware
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
public class TWare extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 库存名称 */
    @Excel(name = "库存名称")
    private String wareName;

    /** 库存类别;数据字典ware_type_dict */
    @Excel(name = "库存类别;数据字典ware_type_dict")
    private String wareType;

    /**
     * 库存类型名
     */
    private String wareTypeName;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long wareNum;

    /** 库存信息 */
    @Excel(name = "库存信息")
    private String wareContent;

    /** 乐观锁;控制并发 */
    @Excel(name = "乐观锁;控制并发")
    private Long version;

    /** 库存图片地址;多个图片路径使用,隔开 */
    @Excel(name = "库存图片地址;多个图片路径使用,隔开")
    private String wareImg;

    /** 库存价格 */
    @Excel(name = "库存价格")
    private BigDecimal warePrice;

    /**
     * 库存编号
     */
    private String wareCode;

    public String getWareTypeName() {
        return wareTypeName;
    }

    public void setWareTypeName(String wareTypeName) {
        this.wareTypeName = wareTypeName;
    }

    public String getWareCode() {
        return wareCode;
    }

    public void setWareCode(String wareCode) {
        this.wareCode = wareCode;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setWareName(String wareName) 
    {
        this.wareName = wareName;
    }

    public String getWareName() 
    {
        return wareName;
    }
    public void setWareType(String wareType) 
    {
        this.wareType = wareType;
    }

    public String getWareType() 
    {
        return wareType;
    }
    public void setWareNum(Long wareNum) 
    {
        this.wareNum = wareNum;
    }

    public Long getWareNum() 
    {
        return wareNum;
    }
    public void setWareContent(String wareContent) 
    {
        this.wareContent = wareContent;
    }

    public String getWareContent() 
    {
        return wareContent;
    }
    public void setVersion(Long version)
    {
        this.version = version;
    }

    public Long getVersion()
    {
        return version;
    }
    public void setWareImg(String wareImg) 
    {
        this.wareImg = wareImg;
    }

    public String getWareImg() 
    {
        return wareImg;
    }
    public void setWarePrice(BigDecimal warePrice) 
    {
        this.warePrice = warePrice;
    }

    public BigDecimal getWarePrice() 
    {
        return warePrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("wareName", getWareName())
            .append("wareType", getWareType())
            .append("wareNum", getWareNum())
            .append("wareContent", getWareContent())
            .append("version", getVersion())
            .append("wareImg", getWareImg())
            .append("warePrice", getWarePrice())
            .toString();
    }
}
