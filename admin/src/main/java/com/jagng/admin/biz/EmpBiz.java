package com.jagng.admin.biz;

import com.jagng.admin.domain.TEmpInfo;
import com.jagng.admin.service.ITEmpInfoService;
import com.jagng.common.constant.UserConstants;
import com.jagng.common.core.domain.AjaxResult;
import com.jagng.common.core.domain.entity.SysUser;
import com.jagng.common.utils.SecurityUtils;
import com.jagng.common.utils.StringUtils;
import com.jagng.system.service.ISysUserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class EmpBiz {

    @Resource
    private ISysUserService userService;

    @Resource
    private ITEmpInfoService empInfoService;

    @Transactional(rollbackFor = Exception.class)
    public AjaxResult addEmp(TEmpInfo tEmpInfo) {
        //新增系统用户
        SysUser user = new SysUser();
        user.setNickName(tEmpInfo.getName());
        user.setUserName(tEmpInfo.getPhone());
        user.setPhonenumber(tEmpInfo.getPhone());
        user.setDeptId(tEmpInfo.getDeptId());
        user.setSex(tEmpInfo.getSex());
        user.setPassword(SecurityUtils.encryptPassword("admin123"));
        user.setStatus("0");
        user.setDelFlag("0");
        if (UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(user))) {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，登录账号已存在");
        } else if (StringUtils.isNotEmpty(user.getPhonenumber())
                && UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，手机号码已存在");
        } else if (StringUtils.isNotEmpty(user.getEmail())
                && UserConstants.NOT_UNIQUE.equals(userService.checkEmailUnique(user))) {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，邮箱账号已存在");
        }
        userService.insertUser(user);
        //新增员工信息
        tEmpInfo.setEntryTime(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return empInfoService.insertTEmpInfo(tEmpInfo) > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
