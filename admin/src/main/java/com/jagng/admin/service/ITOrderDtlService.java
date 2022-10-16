package com.jagng.admin.service;

import java.util.List;
import com.jagng.admin.domain.TOrderDtl;
import com.jagng.admin.dto.EmpInfoDTO;
import com.jagng.admin.dto.SalaryDTO;

/**
 * 订单明细;Service接口
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
public interface ITOrderDtlService 
{
    /**
     * 查询订单明细;
     * 
     * @param id 订单明细;主键
     * @return 订单明细;
     */
    public TOrderDtl selectTOrderDtlById(String id);

    /**
     * 查询订单明细;列表
     * 
     * @param tOrderDtl 订单明细;
     * @return 订单明细;集合
     */
    public List<TOrderDtl> selectTOrderDtlList(TOrderDtl tOrderDtl);

    /**
     * 新增订单明细;
     * 
     * @param tOrderDtl 订单明细;
     * @return 结果
     */
    public int insertTOrderDtl(TOrderDtl tOrderDtl);

    /**
     * 修改订单明细;
     * 
     * @param tOrderDtl 订单明细;
     * @return 结果
     */
    public int updateTOrderDtl(TOrderDtl tOrderDtl);

    /**
     * 批量删除订单明细;
     * 
     * @param ids 需要删除的订单明细;主键集合
     * @return 结果
     */
    public int deleteTOrderDtlByIds(String[] ids);

    /**
     * 删除订单明细;信息
     * 
     * @param id 订单明细;主键
     * @return 结果
     */
    public int deleteTOrderDtlById(String id);

    /**
    * 统计员工提成金额
    * @author JAGNG
    * @date 2022/10/15 23:03
    **/
    public List<SalaryDTO> qryOrderDtlForSalary(String yearMonth);


}
