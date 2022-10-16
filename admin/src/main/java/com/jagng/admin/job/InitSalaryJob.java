package com.jagng.admin.job;

import com.jagng.admin.biz.SalaryBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 * @description: 初始化薪酬数据job
 * @author: JAGNG
 * @create: 2022-10-15 23:56
 **/
@Component
public class InitSalaryJob {
    Logger log = LoggerFactory.getLogger(InitSalaryJob.class);

    @Resource
    private SalaryBiz salaryBiz;

    @Scheduled(cron = "0 0 0 1 * ?")
    public void initSalary(){
        salaryBiz.initSalary("");
        log.info(String.format("(%s)员工薪酬数据初始化完成", YearMonth.now().minusMonths(1L).format(DateTimeFormatter.ofPattern("yyyy-MM"))));
    }
}
