package com.jagng.admin.service;

import java.util.List;
import com.jagng.admin.domain.TFeeedback;

/**
 * 顾客反馈记录;Service接口
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
public interface ITFeeedbackService 
{
    /**
     * 查询顾客反馈记录;
     * 
     * @param id 顾客反馈记录;主键
     * @return 顾客反馈记录;
     */
    public TFeeedback selectTFeeedbackById(String id);

    /**
     * 查询顾客反馈记录;列表
     * 
     * @param tFeeedback 顾客反馈记录;
     * @return 顾客反馈记录;集合
     */
    public List<TFeeedback> selectTFeeedbackList(TFeeedback tFeeedback);

    /**
     * 新增顾客反馈记录;
     * 
     * @param tFeeedback 顾客反馈记录;
     * @return 结果
     */
    public int insertTFeeedback(TFeeedback tFeeedback);

    /**
     * 修改顾客反馈记录;
     * 
     * @param tFeeedback 顾客反馈记录;
     * @return 结果
     */
    public int updateTFeeedback(TFeeedback tFeeedback);

    /**
     * 批量删除顾客反馈记录;
     * 
     * @param ids 需要删除的顾客反馈记录;主键集合
     * @return 结果
     */
    public int deleteTFeeedbackByIds(String[] ids);

    /**
     * 删除顾客反馈记录;信息
     * 
     * @param id 顾客反馈记录;主键
     * @return 结果
     */
    public int deleteTFeeedbackById(String id);
}
