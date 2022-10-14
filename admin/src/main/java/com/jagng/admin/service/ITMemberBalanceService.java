package com.jagng.admin.service;

import java.util.List;
import com.jagng.admin.domain.TMemberBalance;

/**
 * 会员账户余额变动明细;Service接口
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
public interface ITMemberBalanceService 
{
    /**
     * 查询会员账户余额变动明细;
     * 
     * @param id 会员账户余额变动明细;主键
     * @return 会员账户余额变动明细;
     */
    public TMemberBalance selectTMemberBalanceById(Integer id);

    /**
     * 查询会员账户余额变动明细;列表
     * 
     * @param tMemberBalance 会员账户余额变动明细;
     * @return 会员账户余额变动明细;集合
     */
    public List<TMemberBalance> selectTMemberBalanceList(TMemberBalance tMemberBalance);

    /**
     * 新增会员账户余额变动明细;
     * 
     * @param tMemberBalance 会员账户余额变动明细;
     * @return 结果
     */
    public int insertTMemberBalance(TMemberBalance tMemberBalance);

    /**
     * 修改会员账户余额变动明细;
     * 
     * @param tMemberBalance 会员账户余额变动明细;
     * @return 结果
     */
    public int updateTMemberBalance(TMemberBalance tMemberBalance);

    /**
     * 批量删除会员账户余额变动明细;
     * 
     * @param ids 需要删除的会员账户余额变动明细;主键集合
     * @return 结果
     */
    public int deleteTMemberBalanceByIds(Integer[] ids);

    /**
     * 删除会员账户余额变动明细;信息
     * 
     * @param id 会员账户余额变动明细;主键
     * @return 结果
     */
    public int deleteTMemberBalanceById(Integer id);
}
