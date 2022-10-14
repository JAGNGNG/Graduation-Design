package com.jagng.admin.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson2.JSON;
import com.jagng.admin.dto.EmpInfoDTO;
import com.jagng.common.constant.UserConstants;
import com.jagng.common.core.domain.AjaxResult;
import com.jagng.common.core.domain.entity.SysUser;
import com.jagng.common.utils.SecurityUtils;
import com.jagng.common.utils.ServletUtils;
import com.jagng.common.utils.StringUtils;
import com.jagng.common.utils.bean.BeanUtils;
import com.jagng.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jagng.admin.mapper.TEmpInfoMapper;
import com.jagng.admin.domain.TEmpInfo;
import com.jagng.admin.service.ITEmpInfoService;

import javax.annotation.Resource;

/**
 * 员工信息;Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@Service
public class TEmpInfoServiceImpl implements ITEmpInfoService 
{
    @Resource
    private TEmpInfoMapper tEmpInfoMapper;



    /**
     * 查询员工信息;
     * 
     * @param id 员工信息;主键
     * @return 员工信息;
     */
    @Override
    public TEmpInfo selectTEmpInfoById(Integer id)
    {
        return tEmpInfoMapper.selectTEmpInfoById(id);
    }

    /**
     * 查询员工信息;列表
     * 
     * @param tEmpInfo 员工信息;
     * @return 员工信息;
     */
    @Override
    public List<TEmpInfo> selectTEmpInfoList(TEmpInfo tEmpInfo)
    {
        return tEmpInfoMapper.selectTEmpInfoList(tEmpInfo);
    }

    /**
     * 新增员工信息;
     * 
     * @param tEmpInfo 员工信息;
     * @return 结果
     */
    @Override
    public int insertTEmpInfo(TEmpInfo tEmpInfo)
    {

        return tEmpInfoMapper.insertTEmpInfo(tEmpInfo);
    }

    /**
     * 修改员工信息;
     * 
     * @param tEmpInfo 员工信息;
     * @return 结果
     */
    @Override
    public int updateTEmpInfo(TEmpInfo tEmpInfo)
    {
        return tEmpInfoMapper.updateTEmpInfo(tEmpInfo);
    }

    /**
     * 批量删除员工信息;
     * 
     * @param ids 需要删除的员工信息;主键
     * @return 结果
     */
    @Override
    public int deleteTEmpInfoByIds(String[] ids)
    {
        return tEmpInfoMapper.deleteTEmpInfoByIds(ids);
    }

    /**
     * 删除员工信息;信息
     * 
     * @param id 员工信息;主键
     * @return 结果
     */
    @Override
    public int deleteTEmpInfoById(String id)
    {
        return tEmpInfoMapper.deleteTEmpInfoById(id);
    }

    /**
     * 查询员工岗位信息
     * @param phone 手机号码
     * @return EmpInfoDTO
     */
    @Override
    public EmpInfoDTO selectEmpInfoDTO(String phone) {
        return tEmpInfoMapper.selectEmpInfoDTO(phone);
    }
}
