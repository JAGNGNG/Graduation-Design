package com.jagng.admin.mapper;

import java.util.List;
import com.jagng.admin.domain.TWare;

/**
 * 库存信息;Mapper接口
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
public interface TWareMapper 
{
    /**
     * 查询库存信息;
     * 
     * @param id 库存信息;主键
     * @return 库存信息;
     */
    public TWare selectTWareById(Integer id);

    /**
     * 查询库存信息;列表
     * 
     * @param tWare 库存信息;
     * @return 库存信息;集合
     */
    public List<TWare> selectTWareList(TWare tWare);

    /**
     * 新增库存信息;
     * 
     * @param tWare 库存信息;
     * @return 结果
     */
    public int insertTWare(TWare tWare);

    /**
     * 修改库存信息;
     * 
     * @param tWare 库存信息;
     * @return 结果
     */
    public int updateTWare(TWare tWare);

    /**
     * 删除库存信息;
     * 
     * @param id 库存信息;主键
     * @return 结果
     */
    public int deleteTWareById(String id);

    /**
     * 批量删除库存信息;
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTWareByIds(String[] ids);
}
