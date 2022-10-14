package com.jagng.admin.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.jagng.admin.biz.MemberBiz;
import com.jagng.admin.biz.OrderBiz;
import com.jagng.admin.vo.SettlementParam;
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
import com.jagng.admin.domain.TOrder;
import com.jagng.admin.service.ITOrderService;
import com.jagng.common.utils.poi.ExcelUtil;
import com.jagng.common.core.page.TableDataInfo;

/**
 * 订单;Controller
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@RestController
@RequestMapping("/admin/order")
public class TOrderController extends BaseController
{
    @Resource
    private ITOrderService tOrderService;

    @Resource
    private OrderBiz orderBiz;

    /**
     * 查询订单;列表
     */
    @PreAuthorize("@ss.hasPermi('admin:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(TOrder tOrder)
    {
        startPage();
        List<TOrder> list = tOrderService.selectTOrderList(tOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单;列表
     */
    @PreAuthorize("@ss.hasPermi('admin:order:export')")
    @Log(title = "订单;", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TOrder tOrder)
    {
        List<TOrder> list = tOrderService.selectTOrderList(tOrder);
        ExcelUtil<TOrder> util = new ExcelUtil<TOrder>(TOrder.class);
        util.exportExcel(response, list, "订单;数据");
    }

    /**
     * 获取订单;详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(tOrderService.selectTOrderById(id));
    }

    /**
     * 新增订单;
     */
    @PreAuthorize("@ss.hasPermi('admin:order:add')")
    @Log(title = "订单;", businessType = BusinessType.INSERT)
    @GetMapping("/addOrder")
    public AjaxResult add()
    {
        return orderBiz.addOrder();
    }

    /**
     * 修改订单;
     */
    @PreAuthorize("@ss.hasPermi('admin:order:edit')")
    @Log(title = "订单;", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TOrder tOrder)
    {
        return toAjax(tOrderService.updateTOrder(tOrder));
    }

    /**
     * 删除订单;
     */
    @PreAuthorize("@ss.hasPermi('admin:order:remove')")
    @Log(title = "订单;", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(tOrderService.deleteTOrderByIds(ids));
    }

    /**
     * 订单结算
     * @param settlementParam 结算参数
     * @return AjaxResult
     */
    @Log(title = "订单",businessType = BusinessType.SETTLEMENT)
    @PostMapping("/settlement")
    public AjaxResult settlement(@RequestBody SettlementParam settlementParam){
        return orderBiz.settlement(settlementParam);
    }

    /**
     * 订单结算
     * @param id 主键
     * @return AjaxResult
     */
    @Log(title = "订单",businessType = BusinessType.REFUND)
    @GetMapping("/refund/{id}")
    public AjaxResult refund(@PathVariable("id") Integer id){
        return orderBiz.refund(id);
    }

    /**
     * 取消订单
     * @param id 主键
     * @return AjaxResult
     */
    @Log(title = "订单",businessType = BusinessType.CANCEL)
    @GetMapping("/cancel/{id}")
    public AjaxResult cancel(@PathVariable("id") Integer id){
        return orderBiz.cancel(id);
    }
}
