package com.jagng.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jagng.admin.mapper.TMemberBalanceMapper;
import com.jagng.admin.domain.TMemberBalance;
import com.jagng.admin.service.ITMemberBalanceService;

import javax.annotation.Resource;

/**
 * 会员账户余额变动明细;Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@Service
public class TMemberBalanceServiceImpl implements ITMemberBalanceService 
{
    @Resource
    private TMemberBalanceMapper tMemberBalanceMapper;

    /**
     * 查询会员账户余额变动明细;
     * 
     * @param id 会员账户余额变动明细;主键
     * @return 会员账户余额变动明细;
     */
    @Override
    public TMemberBalance selectTMemberBalanceById(Integer id)
    {
        return tMemberBalanceMapper.selectTMemberBalanceById(id);
    }

    /**
     * 查询会员账户余额变动明细;列表
     * 
     * @param tMemberBalance 会员账户余额变动明细;
     * @return 会员账户余额变动明细;
     */
    @Override
    public List<TMemberBalance> selectTMemberBalanceList(TMemberBalance tMemberBalance)
    {
        return tMemberBalanceMapper.selectTMemberBalanceList(tMemberBalance);
    }

    /**
     * 新增会员账户余额变动明细;
     * 
     * @param tMemberBalance 会员账户余额变动明细;
     * @return 结果
     */
    @Override
    public int insertTMemberBalance(TMemberBalance tMemberBalance)
    {
        return tMemberBalanceMapper.insertTMemberBalance(tMemberBalance);
    }

    /**
     * 修改会员账户余额变动明细;
     * 
     * @param tMemberBalance 会员账户余额变动明细;
     * @return 结果
     */
    @Override
    public int updateTMemberBalance(TMemberBalance tMemberBalance)
    {
        return tMemberBalanceMapper.updateTMemberBalance(tMemberBalance);
    }

    /**
     * 批量删除会员账户余额变动明细;
     * 
     * @param ids 需要删除的会员账户余额变动明细;主键
     * @return 结果
     */
    @Override
    public int deleteTMemberBalanceByIds(Integer[] ids)
    {
        return tMemberBalanceMapper.deleteTMemberBalanceByIds(ids);
    }

    /**
     * 删除会员账户余额变动明细;信息
     * 
     * @param id 会员账户余额变动明细;主键
     * @return 结果
     */
    @Override
    public int deleteTMemberBalanceById(Integer id)
    {
        return tMemberBalanceMapper.deleteTMemberBalanceById(id);
    }
}
