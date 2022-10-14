package com.jagng.admin.biz;

import com.jagng.admin.domain.TWare;
import com.jagng.admin.service.ITWareService;
import com.jagng.common.core.domain.AjaxResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

import static com.jagng.common.utils.PageUtils.startPage;

@Component
public class WareBiz {

    @Resource
    private ITWareService wareService;

    @Transactional(rollbackFor = Exception.class)
    public AjaxResult addWare(TWare tWare){
        if (Objects.equals(tWare.getWareType(),"service")){
            tWare.setWareNum(1L);
        }else {
            if (tWare.getWareNum()<=0){
                return AjaxResult.error("库存数量填写不正确");
            }
        }
        tWare.setVersion(1L);
        return  wareService.insertTWare(tWare)>0?AjaxResult.success():AjaxResult.error("新增失败");
    }
}
