package com.jagng.admin.service.impl;

import java.util.List;
import com.jagng.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jagng.admin.mapper.TOrderMapper;
import com.jagng.admin.domain.TOrder;
import com.jagng.admin.service.ITOrderService;

import javax.annotation.Resource;

/**
 * 订单;Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@Service
public class TOrderServiceImpl implements ITOrderService 
{
    @Resource
    private TOrderMapper tOrderMapper;

    /**
     * 查询订单;
     * 
     * @param id 订单;主键
     * @return 订单;
     */
    @Override
    public TOrder selectTOrderById(Integer id)
    {
        return tOrderMapper.selectTOrderById(id);
    }

    /**
     * 查询订单;列表
     * 
     * @param tOrder 订单;
     * @return 订单;
     */
    @Override
    public List<TOrder> selectTOrderList(TOrder tOrder)
    {
        return tOrderMapper.selectTOrderList(tOrder);
    }

    /**
     * 新增订单;
     * 
     * @param tOrder 订单;
     * @return 结果
     */
    @Override
    public int insertTOrder(TOrder tOrder)
    {
        tOrder.setCreateTime(DateUtils.getNowDate());
        return tOrderMapper.insertTOrder(tOrder);
    }

    /**
     * 修改订单;
     * 
     * @param tOrder 订单;
     * @return 结果
     */
    @Override
    public int updateTOrder(TOrder tOrder)
    {
        return tOrderMapper.updateTOrder(tOrder);
    }

    /**
     * 批量删除订单;
     * 
     * @param ids 需要删除的订单;主键
     * @return 结果
     */
    @Override
    public int deleteTOrderByIds(Integer[] ids)
    {
        return tOrderMapper.deleteTOrderByIds(ids);
    }

    /**
     * 删除订单;信息
     * 
     * @param id 订单;主键
     * @return 结果
     */
    @Override
    public int deleteTOrderById(Integer id)
    {
        return tOrderMapper.deleteTOrderById(id);
    }
}
