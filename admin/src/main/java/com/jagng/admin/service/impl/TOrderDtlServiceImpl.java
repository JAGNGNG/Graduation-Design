package com.jagng.admin.service.impl;

import java.util.List;

import com.jagng.admin.dto.EmpInfoDTO;
import com.jagng.admin.dto.SalaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jagng.admin.mapper.TOrderDtlMapper;
import com.jagng.admin.domain.TOrderDtl;
import com.jagng.admin.service.ITOrderDtlService;

import javax.annotation.Resource;

/**
 * 订单明细;Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@Service
public class TOrderDtlServiceImpl implements ITOrderDtlService 
{
    @Resource
    private TOrderDtlMapper tOrderDtlMapper;

    /**
     * 查询订单明细;
     * 
     * @param id 订单明细;主键
     * @return 订单明细;
     */
    @Override
    public TOrderDtl selectTOrderDtlById(String id)
    {
        return tOrderDtlMapper.selectTOrderDtlById(id);
    }

    /**
     * 查询订单明细;列表
     * 
     * @param tOrderDtl 订单明细;
     * @return 订单明细;
     */
    @Override
    public List<TOrderDtl> selectTOrderDtlList(TOrderDtl tOrderDtl)
    {
        return tOrderDtlMapper.selectTOrderDtlList(tOrderDtl);
    }

    /**
     * 新增订单明细;
     * 
     * @param tOrderDtl 订单明细;
     * @return 结果
     */
    @Override
    public int insertTOrderDtl(TOrderDtl tOrderDtl)
    {
        return tOrderDtlMapper.insertTOrderDtl(tOrderDtl);
    }

    /**
     * 修改订单明细;
     * 
     * @param tOrderDtl 订单明细;
     * @return 结果
     */
    @Override
    public int updateTOrderDtl(TOrderDtl tOrderDtl)
    {
        return tOrderDtlMapper.updateTOrderDtl(tOrderDtl);
    }

    /**
     * 批量删除订单明细;
     * 
     * @param ids 需要删除的订单明细;主键
     * @return 结果
     */
    @Override
    public int deleteTOrderDtlByIds(String[] ids)
    {
        return tOrderDtlMapper.deleteTOrderDtlByIds(ids);
    }

    /**
     * 删除订单明细;信息
     * 
     * @param id 订单明细;主键
     * @return 结果
     */
    @Override
    public int deleteTOrderDtlById(String id)
    {
        return tOrderDtlMapper.deleteTOrderDtlById(id);
    }

    @Override
    public List<SalaryDTO> qryOrderDtlForSalary(String yearMonth) {
        return tOrderDtlMapper.qryOrderDtlForSalary(yearMonth);
    }
}
