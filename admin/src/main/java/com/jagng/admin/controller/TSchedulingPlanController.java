package com.jagng.admin.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.jagng.admin.biz.SchedulingPlanBiz;
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
import com.jagng.admin.domain.TSchedulingPlan;
import com.jagng.admin.service.ITSchedulingPlanService;
import com.jagng.common.utils.poi.ExcelUtil;
import com.jagng.common.core.page.TableDataInfo;

/**
 * 员工排班计划;Controller
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@RestController
@RequestMapping("/admin/plan")
public class TSchedulingPlanController extends BaseController
{
    @Resource
    private ITSchedulingPlanService tSchedulingPlanService;

    @Resource
    private SchedulingPlanBiz schedulingPlanBiz;

    /**
     * 查询员工排班计划;列表
     */
    @PreAuthorize("@ss.hasPermi('admin:plan:list')")
    @GetMapping("/list")
    public TableDataInfo list(TSchedulingPlan tSchedulingPlan)
    {
        startPage();
        List<TSchedulingPlan> list = tSchedulingPlanService.selectTSchedulingPlanList(tSchedulingPlan);
        return getDataTable(list);
    }

    /**
     * 导出员工排班计划;列表
     */
    @PreAuthorize("@ss.hasPermi('admin:plan:export')")
    @Log(title = "员工排班计划;", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TSchedulingPlan tSchedulingPlan)
    {
        List<TSchedulingPlan> list = tSchedulingPlanService.selectTSchedulingPlanList(tSchedulingPlan);
        ExcelUtil<TSchedulingPlan> util = new ExcelUtil<TSchedulingPlan>(TSchedulingPlan.class);
        util.exportExcel(response, list, "员工排班计划;数据");
    }

    /**
     * 获取员工排班计划;详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:plan:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(tSchedulingPlanService.selectTSchedulingPlanById(id));
    }

    /**
     * 新增员工排班计划;
     */
    @PreAuthorize("@ss.hasPermi('admin:plan:add')")
    @Log(title = "员工排班计划;", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TSchedulingPlan tSchedulingPlan)
    {
        return schedulingPlanBiz.addScheduling(tSchedulingPlan);
    }

    /**
     * 修改员工排班计划;
     */
    @PreAuthorize("@ss.hasPermi('admin:plan:edit')")
    @Log(title = "员工排班计划;", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TSchedulingPlan tSchedulingPlan)
    {
        return toAjax(tSchedulingPlanService.updateTSchedulingPlan(tSchedulingPlan));
    }

    /**
     * 删除员工排班计划;
     */
    @PreAuthorize("@ss.hasPermi('admin:plan:remove')")
    @Log(title = "员工排班计划;", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tSchedulingPlanService.deleteTSchedulingPlanByIds(ids));
    }
}
