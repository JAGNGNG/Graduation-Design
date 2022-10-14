package com.jagng.admin.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jagng.admin.mapper.TWareMapper;
import com.jagng.admin.domain.TWare;
import com.jagng.admin.service.ITWareService;

import javax.annotation.Resource;

/**
 * 库存信息;Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@Service
public class TWareServiceImpl implements ITWareService 
{
    @Resource
    private TWareMapper tWareMapper;

    /**
     * 查询库存信息;
     * 
     * @param id 库存信息;主键
     * @return 库存信息;
     */
    @Override
    public TWare selectTWareById(Integer id)
    {
        return tWareMapper.selectTWareById(id);
    }

    /**
     * 查询库存信息;列表
     * 
     * @param tWare 库存信息;
     * @return 库存信息;
     */
    @Override
    public List<TWare> selectTWareList(TWare tWare)
    {
        return tWareMapper.selectTWareList(tWare);
    }

    /**
     * 新增库存信息;
     * 
     * @param tWare 库存信息;
     * @return 结果
     */
    @Override
    public int insertTWare(TWare tWare)
    {

        return tWareMapper.insertTWare(tWare);
    }

    /**
     * 修改库存信息;
     * 
     * @param tWare 库存信息;
     * @return 结果
     */
    @Override
    public int updateTWare(TWare tWare)
    {
        return tWareMapper.updateTWare(tWare);
    }

    /**
     * 批量删除库存信息;
     * 
     * @param ids 需要删除的库存信息;主键
     * @return 结果
     */
    @Override
    public int deleteTWareByIds(String[] ids)
    {
        return tWareMapper.deleteTWareByIds(ids);
    }

    /**
     * 删除库存信息;信息
     * 
     * @param id 库存信息;主键
     * @return 结果
     */
    @Override
    public int deleteTWareById(String id)
    {
        return tWareMapper.deleteTWareById(id);
    }
}
