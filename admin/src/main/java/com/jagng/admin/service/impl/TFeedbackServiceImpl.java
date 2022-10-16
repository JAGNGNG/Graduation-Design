package com.jagng.admin.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jagng.admin.mapper.TFeedbackMapper;
import com.jagng.admin.domain.TFeedback;
import com.jagng.admin.service.ITFeedbackService;

/**
 * 顾客反馈记录;Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@Service
public class TFeedbackServiceImpl implements ITFeedbackService
{
    @Autowired
    private TFeedbackMapper tFeedbackMapper;

    /**
     * 查询顾客反馈记录;
     * 
     * @param id 顾客反馈记录;主键
     * @return 顾客反馈记录;
     */
    @Override
    public TFeedback selectTFeedbackById(Integer id)
    {
        return tFeedbackMapper.selectTFeedbackById(id);
    }

    /**
     * 查询顾客反馈记录;列表
     * 
     * @param tFeedback 顾客反馈记录;
     * @return 顾客反馈记录;
     */
    @Override
    public List<TFeedback> selectTFeedbackList(TFeedback tFeedback)
    {
        return tFeedbackMapper.selectTFeedbackList(tFeedback);
    }

    /**
     * 新增顾客反馈记录;
     * 
     * @param tFeedback 顾客反馈记录;
     * @return 结果
     */
    @Override
    public int insertTFeedback(TFeedback tFeedback)
    {
        tFeedback.setFeedbackTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return tFeedbackMapper.insertTFeedback(tFeedback);
    }

    /**
     * 修改顾客反馈记录;
     * 
     * @param tFeedback 顾客反馈记录;
     * @return 结果
     */
    @Override
    public int updateTFeedback(TFeedback tFeedback)
    {
        return tFeedbackMapper.updateTFeedback(tFeedback);
    }

    /**
     * 批量删除顾客反馈记录;
     * 
     * @param ids 需要删除的顾客反馈记录;主键
     * @return 结果
     */
    @Override
    public int deleteTFeedbackByIds(Integer[] ids)
    {
        return tFeedbackMapper.deleteTFeedbackByIds(ids);
    }

    /**
     * 删除顾客反馈记录;信息
     * 
     * @param id 顾客反馈记录;主键
     * @return 结果
     */
    @Override
    public int deleteTFeedbackById(Integer id)
    {
        return tFeedbackMapper.deleteTFeedbackById(id);
    }
}
