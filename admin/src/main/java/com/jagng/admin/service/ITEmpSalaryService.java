package com.jagng.admin.service;

import java.util.List;
import com.jagng.admin.domain.TEmpSalary;

/**
 * 员工薪酬Service接口
 * 
 * @author ruoyi
 * @date 2022-10-15
 */
public interface ITEmpSalaryService 
{
    /**
     * 查询员工薪酬
     * 
     * @param id 员工薪酬主键
     * @return 员工薪酬
     */
    public TEmpSalary selectTEmpSalaryById(Long id);

    /**
     * 查询员工薪酬列表
     * 
     * @param tEmpSalary 员工薪酬
     * @return 员工薪酬集合
     */
    public List<TEmpSalary> selectTEmpSalaryList(TEmpSalary tEmpSalary);

    /**
     * 新增员工薪酬
     * 
     * @param tEmpSalary 员工薪酬
     * @return 结果
     */
    public int insertTEmpSalary(TEmpSalary tEmpSalary);

    /**
     * 修改员工薪酬
     * 
     * @param tEmpSalary 员工薪酬
     * @return 结果
     */
    public int updateTEmpSalary(TEmpSalary tEmpSalary);

    /**
     * 批量删除员工薪酬
     * 
     * @param ids 需要删除的员工薪酬主键集合
     * @return 结果
     */
    public int deleteTEmpSalaryByIds(Long[] ids);

    /**
     * 删除员工薪酬信息
     * 
     * @param id 员工薪酬主键
     * @return 结果
     */
    public int deleteTEmpSalaryById(Long id);
}
