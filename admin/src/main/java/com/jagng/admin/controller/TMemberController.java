package com.jagng.admin.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.jagng.admin.biz.MemberBiz;
import com.jagng.admin.vo.MemberRechargeParam;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
import com.jagng.admin.domain.TMember;
import com.jagng.admin.service.ITMemberService;
import com.jagng.common.utils.poi.ExcelUtil;
import com.jagng.common.core.page.TableDataInfo;

/**
 * 会员信息;Controller
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@RestController
@RequestMapping("/admin/member")
public class TMemberController extends BaseController
{
    @Resource
    private ITMemberService tMemberService;

    @Resource
    private MemberBiz memberBiz;

    /**
     * 查询会员信息;列表
     */
    @PreAuthorize("@ss.hasPermi('admin:member:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMember tMember)
    {
        startPage();
        List<TMember> list = tMemberService.selectTMemberList(tMember);
        return getDataTable(list);
    }

    /**
     * 导出会员信息;列表
     */
    @PreAuthorize("@ss.hasPermi('admin:member:export')")
    @Log(title = "会员信息;", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TMember tMember)
    {
        List<TMember> list = tMemberService.selectTMemberList(tMember);
        ExcelUtil<TMember> util = new ExcelUtil<TMember>(TMember.class);
        util.exportExcel(response, list, "会员信息;数据");
    }

    /**
     * 获取会员信息;详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:member:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(tMemberService.selectTMemberById(id));
    }

    /**
     * 新增会员信息;
     */
    @PreAuthorize("@ss.hasPermi('admin:member:add')")
    @Log(title = "会员信息;", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMember tMember)
    {
        return memberBiz.addMember(tMember);
    }

    /**
     * 修改会员信息;
     */
    @PreAuthorize("@ss.hasPermi('admin:member:edit')")
    @Log(title = "会员信息;", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMember tMember)
    {
        return toAjax(tMemberService.updateTMember(tMember));
    }

    /**
     * 删除会员信息;
     */
    @PreAuthorize("@ss.hasPermi('admin:member:remove')")
    @Log(title = "会员信息;", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(tMemberService.deleteTMemberByIds(ids));
    }


    @Log(title = "会员", businessType = BusinessType.RECHARGE)
    @PostMapping("/recharge")
    public AjaxResult recharge(@RequestBody MemberRechargeParam rechargeParam){
        return memberBiz.recharge(rechargeParam);
    }
}
