package com.jagng.admin.service;

import java.util.List;
import com.jagng.admin.domain.TMember;

/**
 * 会员信息;Service接口
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
public interface ITMemberService 
{
    /**
     * 查询会员信息;
     * 
     * @param id 会员信息;主键
     * @return 会员信息;
     */
    public TMember selectTMemberById(Integer id);

    /**
     * 查询会员信息;列表
     * 
     * @param tMember 会员信息;
     * @return 会员信息;集合
     */
    public List<TMember> selectTMemberList(TMember tMember);

    /**
     * 新增会员信息;
     * 
     * @param tMember 会员信息;
     * @return 结果
     */
    public int insertTMember(TMember tMember);

    /**
     * 修改会员信息;
     * 
     * @param tMember 会员信息;
     * @return 结果
     */
    public int updateTMember(TMember tMember);

    /**
     * 批量删除会员信息;
     * 
     * @param ids 需要删除的会员信息;主键集合
     * @return 结果
     */
    public int deleteTMemberByIds(Integer[] ids);

    /**
     * 删除会员信息;信息
     * 
     * @param id 会员信息;主键
     * @return 结果
     */
    public int deleteTMemberById(Integer id);
}
