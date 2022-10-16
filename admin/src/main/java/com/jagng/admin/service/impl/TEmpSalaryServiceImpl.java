package com.jagng.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jagng.admin.mapper.TEmpSalaryMapper;
import com.jagng.admin.domain.TEmpSalary;
import com.jagng.admin.service.ITEmpSalaryService;

/**
 * 员工薪酬Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-15
 */
@Service
public class TEmpSalaryServiceImpl implements ITEmpSalaryService 
{
    @Autowired
    private TEmpSalaryMapper tEmpSalaryMapper;

    /**
     * 查询员工薪酬
     * 
     * @param id 员工薪酬主键
     * @return 员工薪酬
     */
    @Override
    public TEmpSalary selectTEmpSalaryById(Long id)
    {
        return tEmpSalaryMapper.selectTEmpSalaryById(id);
    }

    /**
     * 查询员工薪酬列表
     * 
     * @param tEmpSalary 员工薪酬
     * @return 员工薪酬
     */
    @Override
    public List<TEmpSalary> selectTEmpSalaryList(TEmpSalary tEmpSalary)
    {
        return tEmpSalaryMapper.selectTEmpSalaryList(tEmpSalary);
    }

    /**
     * 新增员工薪酬
     * 
     * @param tEmpSalary 员工薪酬
     * @return 结果
     */
    @Override
    public int insertTEmpSalary(TEmpSalary tEmpSalary)
    {
        return tEmpSalaryMapper.insertTEmpSalary(tEmpSalary);
    }

    /**
     * 修改员工薪酬
     * 
     * @param tEmpSalary 员工薪酬
     * @return 结果
     */
    @Override
    public int updateTEmpSalary(TEmpSalary tEmpSalary)
    {
        return tEmpSalaryMapper.updateTEmpSalary(tEmpSalary);
    }

    /**
     * 批量删除员工薪酬
     * 
     * @param ids 需要删除的员工薪酬主键
     * @return 结果
     */
    @Override
    public int deleteTEmpSalaryByIds(Long[] ids)
    {
        return tEmpSalaryMapper.deleteTEmpSalaryByIds(ids);
    }

    /**
     * 删除员工薪酬信息
     * 
     * @param id 员工薪酬主键
     * @return 结果
     */
    @Override
    public int deleteTEmpSalaryById(Long id)
    {
        return tEmpSalaryMapper.deleteTEmpSalaryById(id);
    }
}
