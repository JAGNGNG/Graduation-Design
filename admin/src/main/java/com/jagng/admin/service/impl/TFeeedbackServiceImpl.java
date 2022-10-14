package com.jagng.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jagng.admin.mapper.TFeeedbackMapper;
import com.jagng.admin.domain.TFeeedback;
import com.jagng.admin.service.ITFeeedbackService;

/**
 * 顾客反馈记录;Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@Service
public class TFeeedbackServiceImpl implements ITFeeedbackService 
{
    @Autowired
    private TFeeedbackMapper tFeeedbackMapper;

    /**
     * 查询顾客反馈记录;
     * 
     * @param id 顾客反馈记录;主键
     * @return 顾客反馈记录;
     */
    @Override
    public TFeeedback selectTFeeedbackById(String id)
    {
        return tFeeedbackMapper.selectTFeeedbackById(id);
    }

    /**
     * 查询顾客反馈记录;列表
     * 
     * @param tFeeedback 顾客反馈记录;
     * @return 顾客反馈记录;
     */
    @Override
    public List<TFeeedback> selectTFeeedbackList(TFeeedback tFeeedback)
    {
        return tFeeedbackMapper.selectTFeeedbackList(tFeeedback);
    }

    /**
     * 新增顾客反馈记录;
     * 
     * @param tFeeedback 顾客反馈记录;
     * @return 结果
     */
    @Override
    public int insertTFeeedback(TFeeedback tFeeedback)
    {
        return tFeeedbackMapper.insertTFeeedback(tFeeedback);
    }

    /**
     * 修改顾客反馈记录;
     * 
     * @param tFeeedback 顾客反馈记录;
     * @return 结果
     */
    @Override
    public int updateTFeeedback(TFeeedback tFeeedback)
    {
        return tFeeedbackMapper.updateTFeeedback(tFeeedback);
    }

    /**
     * 批量删除顾客反馈记录;
     * 
     * @param ids 需要删除的顾客反馈记录;主键
     * @return 结果
     */
    @Override
    public int deleteTFeeedbackByIds(String[] ids)
    {
        return tFeeedbackMapper.deleteTFeeedbackByIds(ids);
    }

    /**
     * 删除顾客反馈记录;信息
     * 
     * @param id 顾客反馈记录;主键
     * @return 结果
     */
    @Override
    public int deleteTFeeedbackById(String id)
    {
        return tFeeedbackMapper.deleteTFeeedbackById(id);
    }
}
