package com.jagng.admin.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.jagng.admin.biz.EmpBiz;
import com.jagng.common.utils.ServletUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jagng.common.annotation.Log;
import com.jagng.common.core.controller.BaseController;
import com.jagng.common.core.domain.AjaxResult;
import com.jagng.common.enums.BusinessType;
import com.jagng.admin.domain.TEmpInfo;
import com.jagng.admin.service.ITEmpInfoService;
import com.jagng.common.utils.poi.ExcelUtil;
import com.jagng.common.core.page.TableDataInfo;

/**
 * 员工信息;Controller
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@RestController
@RequestMapping("/admin/emp")
public class TEmpInfoController extends BaseController
{
    @Resource
    private ITEmpInfoService tEmpInfoService;

    @Resource
    private EmpBiz empBiz;

    /**
     * 查询员工信息;列表
     */
    @PreAuthorize("@ss.hasPermi('admin:emp:list')")
    @GetMapping("/list")
    public TableDataInfo list(TEmpInfo tEmpInfo)
    {
        startPage();
        List<TEmpInfo> list = tEmpInfoService.selectTEmpInfoList(tEmpInfo);
        return getDataTable(list);
    }

    /**
     * 导出员工信息;列表
     */
    @PreAuthorize("@ss.hasPermi('admin:emp:export')")
    @Log(title = "员工信息;", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TEmpInfo tEmpInfo)
    {
        List<TEmpInfo> list = tEmpInfoService.selectTEmpInfoList(tEmpInfo);
        ExcelUtil<TEmpInfo> util = new ExcelUtil<TEmpInfo>(TEmpInfo.class);
        util.exportExcel(response, list, "员工信息;数据");
    }

    /**
     * 获取员工信息;详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:emp:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(tEmpInfoService.selectTEmpInfoById(id));
    }

    /**
     * 新增员工信息;
     */
    @PreAuthorize("@ss.hasPermi('admin:emp:add')")
    @Log(title = "员工信息;", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TEmpInfo tEmpInfo) {
        return empBiz.addEmp(tEmpInfo);
    }

    /**
     * 修改员工信息;
     */
    @PreAuthorize("@ss.hasPermi('admin:emp:edit')")
    @Log(title = "员工信息;", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TEmpInfo tEmpInfo)
    {
        return toAjax(tEmpInfoService.updateTEmpInfo(tEmpInfo));
    }

    /**
     * 删除员工信息;
     */
    @PreAuthorize("@ss.hasPermi('admin:emp:remove')")
    @Log(title = "员工信息;", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tEmpInfoService.deleteTEmpInfoByIds(ids));
    }
}
