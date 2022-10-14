package com.jagng.admin.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.jagng.admin.biz.WareBiz;
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
import com.jagng.admin.domain.TWare;
import com.jagng.admin.service.ITWareService;
import com.jagng.common.utils.poi.ExcelUtil;
import com.jagng.common.core.page.TableDataInfo;

/**
 * 库存信息;Controller
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@RestController
@RequestMapping("/admin/ware")
public class TWareController extends BaseController
{
    @Resource
    private ITWareService tWareService;

    @Resource
    private WareBiz wareBiz;

    /**
     * 查询库存信息;列表
     */
    @PreAuthorize("@ss.hasPermi('admin:ware:list')")
    @GetMapping("/list")
    public TableDataInfo list(TWare tWare)
    {
        startPage();
        List<TWare> list = tWareService.selectTWareList(tWare);
        return getDataTable(list);
    }

    /**
     * 导出库存信息;列表
     */
    @PreAuthorize("@ss.hasPermi('admin:ware:export')")
    @Log(title = "库存信息;", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TWare tWare)
    {
        List<TWare> list = tWareService.selectTWareList(tWare);
        ExcelUtil<TWare> util = new ExcelUtil<TWare>(TWare.class);
        util.exportExcel(response, list, "库存信息;数据");
    }

    /**
     * 获取库存信息;详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:ware:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(tWareService.selectTWareById(id));
    }

    /**
     * 新增库存信息;
     */
    @PreAuthorize("@ss.hasPermi('admin:ware:add')")
    @Log(title = "库存信息;", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TWare tWare)
    {
        return wareBiz.addWare(tWare);
    }

    /**
     * 修改库存信息;
     */
    @PreAuthorize("@ss.hasPermi('admin:ware:edit')")
    @Log(title = "库存信息;", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TWare tWare)
    {
        return toAjax(tWareService.updateTWare(tWare));
    }

    /**
     * 删除库存信息;
     */
    @PreAuthorize("@ss.hasPermi('admin:ware:remove')")
    @Log(title = "库存信息;", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tWareService.deleteTWareByIds(ids));
    }
}
