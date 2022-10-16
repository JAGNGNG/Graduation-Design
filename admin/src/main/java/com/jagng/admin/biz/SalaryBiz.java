package com.jagng.admin.biz;

import com.jagng.admin.domain.TEmpInfo;
import com.jagng.admin.domain.TEmpSalary;
import com.jagng.admin.dto.SalaryDTO;
import com.jagng.admin.service.ITEmpInfoService;
import com.jagng.admin.service.ITEmpSalaryService;
import com.jagng.admin.service.ITOrderDtlService;
import com.jagng.common.core.domain.AjaxResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: 员工薪酬biz
 * @author: JAGNG
 * @create: 2022-10-15 22:41
 **/
@Component
public class SalaryBiz {

    @Resource
    private ITOrderDtlService orderDtlService;

    @Resource
    private ITEmpSalaryService salaryService;

    @Resource
    private ITEmpInfoService empInfoService;

    @Transactional(rollbackFor = Exception.class)
    public AjaxResult initSalary(String month){
        //支持参数传递薪酬计算月份,用于手动执行job
        if (!StringUtils.hasText(month)){
            String yearMonth = YearMonth.now().minusMonths(1L).format(DateTimeFormatter.ofPattern("yyyy-MM"));
            month = yearMonth;
        }
        //统计员工提成薪资
        List<SalaryDTO> salaryList = orderDtlService.qryOrderDtlForSalary(month);
        Map<Integer,SalaryDTO> hasCommEmpMap = salaryList
                .stream()
                .collect(Collectors.toMap(SalaryDTO::getEmpId,salaryDTO -> salaryDTO));
        //组建员工薪酬初始化数据
        List<TEmpInfo> emps = empInfoService.selectTEmpInfoList(new TEmpInfo());
        for (TEmpInfo emp : emps) {
            TEmpSalary empSalary = new TEmpSalary();
            empSalary.setSalaryMonth(month);
            empSalary.setEmpId(emp.getId());
            List<TEmpSalary> existsEmpSalarys = salaryService.selectTEmpSalaryList(empSalary);
            //不存在指定月份薪酬数据则新增
            if (hasCommEmpMap.containsKey(emp.getId())){
                empSalary.setMonthCommission(hasCommEmpMap.get(emp.getId()).getCommission());
                empSalary.setBase(hasCommEmpMap.get(emp.getId()).getBase());
                empSalary.setSalary(empSalary.getMonthCommission().add(empSalary.getBase()));
            }
            //存在指定月份薪酬数据则新增
            else {
                empSalary.setBase(emp.getBase());
                empSalary.setSalary(emp.getBase());
                empSalary.setMonthCommission(BigDecimal.ZERO);
            }
            if (CollectionUtils.isEmpty(existsEmpSalarys)){
                salaryService.insertTEmpSalary(empSalary);
            }else {
                empSalary.setId(existsEmpSalarys.get(0).getId());
                salaryService.updateTEmpSalary(empSalary);
            }
        }
        return AjaxResult.success();
    }
}
