package com.jagng.admin.vo;


import java.util.List;

public class AddOrderWareParam {

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 产品编号
     */
    private String wareCode;

    /**
     * 关联员工id
     */
    private List<Integer> empIds;

    /**
     * 产品数量
     */
    private Integer wareNum;


    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getWareCode() {
        return wareCode;
    }

    public void setWareCode(String wareCode) {
        this.wareCode = wareCode;
    }

    public List<Integer> getEmpIds() {
        return empIds;
    }

    public void setEmpIds(List<Integer> empIds) {
        this.empIds = empIds;
    }

    public Integer getWareNum() {
        return wareNum;
    }

    public void setWareNum(Integer wareNum) {
        this.wareNum = wareNum;
    }
}
