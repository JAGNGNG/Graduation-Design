package com.jagng.admin.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.jagng.admin.biz.OrderDtlBiz;
import com.jagng.admin.vo.AddOrderWareParam;
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
import com.jagng.admin.domain.TOrderDtl;
import com.jagng.admin.service.ITOrderDtlService;
import com.jagng.common.utils.poi.ExcelUtil;
import com.jagng.common.core.page.TableDataInfo;

/**
 * 订单明细;Controller
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@RestController
@RequestMapping("/admin/dtl")
public class TOrderDtlController extends BaseController
{
    @Resource
    private ITOrderDtlService tOrderDtlService;

    @Resource
    private OrderDtlBiz orderDtlBiz;

    /**
     * 查询订单明细;列表
     */
    @PreAuthorize("@ss.hasPermi('admin:dtl:list')")
    @GetMapping("/list")
    public TableDataInfo list(TOrderDtl tOrderDtl)
    {
        startPage();
        List<TOrderDtl> list = tOrderDtlService.selectTOrderDtlList(tOrderDtl);
        return getDataTable(list);
    }

    /**
     * 导出订单明细;列表
     */
    @PreAuthorize("@ss.hasPermi('admin:dtl:export')")
    @Log(title = "订单明细;", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TOrderDtl tOrderDtl)
    {
        List<TOrderDtl> list = tOrderDtlService.selectTOrderDtlList(tOrderDtl);
        ExcelUtil<TOrderDtl> util = new ExcelUtil<TOrderDtl>(TOrderDtl.class);
        util.exportExcel(response, list, "订单明细;数据");
    }

    /**
     * 获取订单明细;详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:dtl:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tOrderDtlService.selectTOrderDtlById(id));
    }

    /**
     * 新增订单明细;
     */
    @PreAuthorize("@ss.hasPermi('admin:dtl:add')")
    @Log(title = "订单明细;", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AddOrderWareParam addOrderWareParam)
    {
        return orderDtlBiz.addOrderWare(addOrderWareParam);
    }

    /**
     * 修改订单明细;
     */
    @PreAuthorize("@ss.hasPermi('admin:dtl:edit')")
    @Log(title = "订单明细;", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TOrderDtl tOrderDtl)
    {
        return toAjax(tOrderDtlService.updateTOrderDtl(tOrderDtl));
    }

    /**
     * 删除订单明细;
     */
    @PreAuthorize("@ss.hasPermi('admin:dtl:remove')")
    @Log(title = "订单明细;", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tOrderDtlService.deleteTOrderDtlByIds(ids));
    }
}
