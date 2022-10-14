package com.jagng.admin.mapper;

import java.util.List;
import java.util.Map;

import com.jagng.admin.domain.TEmpInfo;
import com.jagng.admin.dto.EmpInfoDTO;
import org.apache.ibatis.annotations.Param;

/**
 * 员工信息;Mapper接口
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
public interface TEmpInfoMapper 
{
    /**
     * 查询员工信息;
     * 
     * @param id 员工信息;主键
     * @return 员工信息;
     */
    public TEmpInfo selectTEmpInfoById(Integer id);

    /**
     * 查询员工信息;列表
     * 
     * @param tEmpInfo 员工信息;
     * @return 员工信息;集合
     */
    public List<TEmpInfo> selectTEmpInfoList(TEmpInfo tEmpInfo);

    /**
     * 新增员工信息;
     * 
     * @param tEmpInfo 员工信息;
     * @return 结果
     */
    public int insertTEmpInfo(TEmpInfo tEmpInfo);

    /**
     * 修改员工信息;
     * 
     * @param tEmpInfo 员工信息;
     * @return 结果
     */
    public int updateTEmpInfo(TEmpInfo tEmpInfo);

    /**
     * 删除员工信息;
     * 
     * @param id 员工信息;主键
     * @return 结果
     */
    public int deleteTEmpInfoById(String id);

    /**
     * 批量删除员工信息;
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTEmpInfoByIds(String[] ids);

    EmpInfoDTO selectEmpInfoDTO(@Param("phone") String phone);
}
