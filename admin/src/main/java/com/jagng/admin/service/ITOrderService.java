package com.jagng.admin.service;

import java.util.List;
import com.jagng.admin.domain.TOrder;

/**
 * 订单;Service接口
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
public interface ITOrderService 
{
    /**
     * 查询订单;
     * 
     * @param id 订单;主键
     * @return 订单;
     */
    public TOrder selectTOrderById(Integer id);

    /**
     * 查询订单;列表
     * 
     * @param tOrder 订单;
     * @return 订单;集合
     */
    public List<TOrder> selectTOrderList(TOrder tOrder);

    /**
     * 新增订单;
     * 
     * @param tOrder 订单;
     * @return 结果
     */
    public int insertTOrder(TOrder tOrder);

    /**
     * 修改订单;
     * 
     * @param tOrder 订单;
     * @return 结果
     */
    public int updateTOrder(TOrder tOrder);

    /**
     * 批量删除订单;
     * 
     * @param ids 需要删除的订单;主键集合
     * @return 结果
     */
    public int deleteTOrderByIds(Integer[] ids);

    /**
     * 删除订单;信息
     * 
     * @param id 订单;主键
     * @return 结果
     */
    public int deleteTOrderById(Integer id);
}
