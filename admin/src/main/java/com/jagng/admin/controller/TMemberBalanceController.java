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
import com.jagng.admin.domain.TMemberBalance;
import com.jagng.admin.service.ITMemberBalanceService;
import com.jagng.common.utils.poi.ExcelUtil;
import com.jagng.common.core.page.TableDataInfo;

/**
 * 会员账户余额变动明细;Controller
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@RestController
@RequestMapping("/admin/balance")
public class TMemberBalanceController extends BaseController
{
    @Autowired
    private ITMemberBalanceService tMemberBalanceService;

    /**
     * 查询会员账户余额变动明细;列表
     */
    @PreAuthorize("@ss.hasPermi('admin:balance:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMemberBalance tMemberBalance)
    {
        startPage();
        List<TMemberBalance> list = tMemberBalanceService.selectTMemberBalanceList(tMemberBalance);
        return getDataTable(list);
    }

    /**
     * 导出会员账户余额变动明细;列表
     */
    @PreAuthorize("@ss.hasPermi('admin:balance:export')")
    @Log(title = "会员账户余额变动明细;", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TMemberBalance tMemberBalance)
    {
        List<TMemberBalance> list = tMemberBalanceService.selectTMemberBalanceList(tMemberBalance);
        ExcelUtil<TMemberBalance> util = new ExcelUtil<TMemberBalance>(TMemberBalance.class);
        util.exportExcel(response, list, "会员账户余额变动明细;数据");
    }

    /**
     * 获取会员账户余额变动明细;详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:balance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(tMemberBalanceService.selectTMemberBalanceById(id));
    }

    /**
     * 新增会员账户余额变动明细;
     */
    @PreAuthorize("@ss.hasPermi('admin:balance:add')")
    @Log(title = "会员账户余额变动明细;", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMemberBalance tMemberBalance)
    {
        return toAjax(tMemberBalanceService.insertTMemberBalance(tMemberBalance));
    }

    /**
     * 修改会员账户余额变动明细;
     */
    @PreAuthorize("@ss.hasPermi('admin:balance:edit')")
    @Log(title = "会员账户余额变动明细;", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMemberBalance tMemberBalance)
    {
        return toAjax(tMemberBalanceService.updateTMemberBalance(tMemberBalance));
    }

    /**
     * 删除会员账户余额变动明细;
     */
    @PreAuthorize("@ss.hasPermi('admin:balance:remove')")
    @Log(title = "会员账户余额变动明细;", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(tMemberBalanceService.deleteTMemberBalanceByIds(ids));
    }
}
