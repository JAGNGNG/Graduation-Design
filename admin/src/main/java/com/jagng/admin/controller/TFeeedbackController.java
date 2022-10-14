package com.jagng.admin.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.jagng.admin.domain.TFeeedback;
import com.jagng.admin.service.ITFeeedbackService;
import com.jagng.common.utils.poi.ExcelUtil;
import com.jagng.common.core.page.TableDataInfo;

/**
 * 顾客反馈记录;Controller
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@RestController
@RequestMapping("/admin/feeedback")
public class TFeeedbackController extends BaseController
{
    @Autowired
    private ITFeeedbackService tFeeedbackService;

    /**
     * 查询顾客反馈记录;列表
     */
    @PreAuthorize("@ss.hasPermi('admin:feeedback:list')")
    @GetMapping("/list")
    public TableDataInfo list(TFeeedback tFeeedback)
    {
        startPage();
        List<TFeeedback> list = tFeeedbackService.selectTFeeedbackList(tFeeedback);
        return getDataTable(list);
    }

    /**
     * 导出顾客反馈记录;列表
     */
    @PreAuthorize("@ss.hasPermi('admin:feeedback:export')")
    @Log(title = "顾客反馈记录;", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TFeeedback tFeeedback)
    {
        List<TFeeedback> list = tFeeedbackService.selectTFeeedbackList(tFeeedback);
        ExcelUtil<TFeeedback> util = new ExcelUtil<TFeeedback>(TFeeedback.class);
        util.exportExcel(response, list, "顾客反馈记录;数据");
    }

    /**
     * 获取顾客反馈记录;详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:feeedback:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tFeeedbackService.selectTFeeedbackById(id));
    }

    /**
     * 新增顾客反馈记录;
     */
    @PreAuthorize("@ss.hasPermi('admin:feeedback:add')")
    @Log(title = "顾客反馈记录;", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TFeeedback tFeeedback)
    {
        return toAjax(tFeeedbackService.insertTFeeedback(tFeeedback));
    }

    /**
     * 修改顾客反馈记录;
     */
    @PreAuthorize("@ss.hasPermi('admin:feeedback:edit')")
    @Log(title = "顾客反馈记录;", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TFeeedback tFeeedback)
    {
        return toAjax(tFeeedbackService.updateTFeeedback(tFeeedback));
    }

    /**
     * 删除顾客反馈记录;
     */
    @PreAuthorize("@ss.hasPermi('admin:feeedback:remove')")
    @Log(title = "顾客反馈记录;", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tFeeedbackService.deleteTFeeedbackByIds(ids));
    }
}
