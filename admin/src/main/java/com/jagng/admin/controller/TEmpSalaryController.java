package com.jagng.admin.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.jagng.admin.biz.SalaryBiz;
import com.jagng.common.annotation.Anonymous;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.jagng.common.annotation.Log;
import com.jagng.common.core.controller.BaseController;
import com.jagng.common.core.domain.AjaxResult;
import com.jagng.common.enums.BusinessType;
import com.jagng.admin.domain.TEmpSalary;
import com.jagng.admin.service.ITEmpSalaryService;
import com.jagng.common.utils.poi.ExcelUtil;
import com.jagng.common.core.page.TableDataInfo;

/**
 * 员工薪酬Controller
 * 
 * @author ruoyi
 * @date 2022-10-15
 */
@RestController
@RequestMapping("/admin/salary")
public class TEmpSalaryController extends BaseController
{
    @Resource
    private ITEmpSalaryService tEmpSalaryService;

    @Resource
    private SalaryBiz salaryBiz;

    /**
     * 查询员工薪酬列表
     */
    @PreAuthorize("@ss.hasPermi('admin:salary:list')")
    @GetMapping("/list")
    public TableDataInfo list(TEmpSalary tEmpSalary)
    {
        startPage();
        List<TEmpSalary> list = tEmpSalaryService.selectTEmpSalaryList(tEmpSalary);
        return getDataTable(list);
    }

    /**
     * 导出员工薪酬列表
     */
    @PreAuthorize("@ss.hasPermi('admin:salary:export')")
    @Log(title = "员工薪酬", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TEmpSalary tEmpSalary)
    {
        List<TEmpSalary> list = tEmpSalaryService.selectTEmpSalaryList(tEmpSalary);
        ExcelUtil<TEmpSalary> util = new ExcelUtil<TEmpSalary>(TEmpSalary.class);
        util.exportExcel(response, list, "员工薪酬数据");
    }

    /**
     * 获取员工薪酬详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:salary:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tEmpSalaryService.selectTEmpSalaryById(id));
    }

    /**
     * 新增员工薪酬
     */
    @PreAuthorize("@ss.hasPermi('admin:salary:add')")
    @Log(title = "员工薪酬", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TEmpSalary tEmpSalary)
    {
        return toAjax(tEmpSalaryService.insertTEmpSalary(tEmpSalary));
    }

    /**
     * 修改员工薪酬
     */
    @PreAuthorize("@ss.hasPermi('admin:salary:edit')")
    @Log(title = "员工薪酬", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TEmpSalary tEmpSalary)
    {
        return toAjax(tEmpSalaryService.updateTEmpSalary(tEmpSalary));
    }

    /**
     * 删除员工薪酬
     */
    @PreAuthorize("@ss.hasPermi('admin:salary:remove')")
    @Log(title = "员工薪酬", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tEmpSalaryService.deleteTEmpSalaryByIds(ids));
    }

    @GetMapping("/initSalary")
    @Anonymous
    public AjaxResult initSalary(@RequestParam("yearMonth") String yearMonth){
        return salaryBiz.initSalary(yearMonth);
    }
}
