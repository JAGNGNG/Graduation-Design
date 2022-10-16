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
import com.jagng.admin.domain.TFeedback;
import com.jagng.admin.service.ITFeedbackService;
import com.jagng.common.utils.poi.ExcelUtil;
import com.jagng.common.core.page.TableDataInfo;

/**
 * 顾客反馈记录;Controller
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@RestController
@RequestMapping("/admin/feedback")
public class TFeedbackController extends BaseController
{
    @Autowired
    private ITFeedbackService tFeedbackService;

    /**
     * 查询顾客反馈记录;列表
     */
    @PreAuthorize("@ss.hasPermi('admin:feedback:list')")
    @GetMapping("/list")
    public TableDataInfo list(TFeedback tFeedback)
    {
        startPage();
        List<TFeedback> list = tFeedbackService.selectTFeedbackList(tFeedback);
        return getDataTable(list);
    }

    /**
     * 导出顾客反馈记录;列表
     */
    @PreAuthorize("@ss.hasPermi('admin:feedback:export')")
    @Log(title = "顾客反馈记录;", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TFeedback tFeedback)
    {
        List<TFeedback> list = tFeedbackService.selectTFeedbackList(tFeedback);
        ExcelUtil<TFeedback> util = new ExcelUtil<TFeedback>(TFeedback.class);
        util.exportExcel(response, list, "顾客反馈记录;数据");
    }

    /**
     * 获取顾客反馈记录;详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:feedback:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(tFeedbackService.selectTFeedbackById(id));
    }

    /**
     * 新增顾客反馈记录;
     */
    @PreAuthorize("@ss.hasPermi('admin:feedback:add')")
    @Log(title = "顾客反馈记录;", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TFeedback tFeedback)
    {
        return toAjax(tFeedbackService.insertTFeedback(tFeedback));
    }

    /**
     * 修改顾客反馈记录;
     */
    @PreAuthorize("@ss.hasPermi('admin:feedback:edit')")
    @Log(title = "顾客反馈记录;", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TFeedback tFeedback)
    {
        return toAjax(tFeedbackService.updateTFeedback(tFeedback));
    }

    /**
     * 删除顾客反馈记录;
     */
    @PreAuthorize("@ss.hasPermi('admin:feedback:remove')")
    @Log(title = "顾客反馈记录;", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(tFeedbackService.deleteTFeedbackByIds(ids));
    }
}
