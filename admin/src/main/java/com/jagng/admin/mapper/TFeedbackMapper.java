package com.jagng.admin.mapper;

import java.util.List;
import com.jagng.admin.domain.TFeedback;

/**
 * 顾客反馈记录;Mapper接口
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
public interface TFeedbackMapper
{
    /**
     * 查询顾客反馈记录;
     * 
     * @param id 顾客反馈记录;主键
     * @return 顾客反馈记录;
     */
    public TFeedback selectTFeedbackById(Integer id);

    /**
     * 查询顾客反馈记录;列表
     * 
     * @param tFeedback 顾客反馈记录;
     * @return 顾客反馈记录;集合
     */
    public List<TFeedback> selectTFeedbackList(TFeedback tFeedback);

    /**
     * 新增顾客反馈记录;
     * 
     * @param tFeedback 顾客反馈记录;
     * @return 结果
     */
    public int insertTFeedback(TFeedback tFeedback);

    /**
     * 修改顾客反馈记录;
     * 
     * @param tFeedback 顾客反馈记录;
     * @return 结果
     */
    public int updateTFeedback(TFeedback tFeedback);

    /**
     * 删除顾客反馈记录;
     * 
     * @param id 顾客反馈记录;主键
     * @return 结果
     */
    public int deleteTFeedbackById(Integer id);

    /**
     * 批量删除顾客反馈记录;
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTFeedbackByIds(Integer[] ids);
}
