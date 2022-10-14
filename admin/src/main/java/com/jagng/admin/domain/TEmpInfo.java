package com.jagng.admin.domain;

import java.math.BigDecimal;
import com.jagng.common.annotation.Excel;
import com.jagng.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 员工信息;对象 t_emp_info
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
public class TEmpInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 性别;0：女 1：男 */
    @Excel(name = "性别;0：女 1：男")
    private String sex;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private Long deptId;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phone;

    /** 底薪 */
    @Excel(name = "底薪")
    private BigDecimal base;

    /** 提成 */
    @Excel(name = "提成")
    private BigDecimal commission;

    /** 入职时间 */
    @Excel(name = "入职时间")
    private String entryTime;

    /** 生日*/
    @Excel(name = "生日")
    private String birthday;

    /**
     * 部门名称
     */
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setBase(BigDecimal base) 
    {
        this.base = base;
    }

    public BigDecimal getBase() 
    {
        return base;
    }
    public void setCommission(BigDecimal commission) 
    {
        this.commission = commission;
    }

    public BigDecimal getCommission() 
    {
        return commission;
    }
    public void setEntryTime(String entryTime) 
    {
        this.entryTime = entryTime;
    }

    public String getEntryTime() 
    {
        return entryTime;
    }
    public void setBirthday(String birthday) 
    {
        this.birthday = birthday;
    }

    public String getBirthday() 
    {
        return birthday;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("sex", getSex())
            .append("deptId", getDeptId())
            .append("phone", getPhone())
            .append("base", getBase())
            .append("commission", getCommission())
            .append("entryTime", getEntryTime())
            .append("birthday", getBirthday())
            .toString();
    }
}
