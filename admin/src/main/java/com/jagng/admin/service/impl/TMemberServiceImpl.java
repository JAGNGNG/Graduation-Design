package com.jagng.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jagng.admin.mapper.TMemberMapper;
import com.jagng.admin.domain.TMember;
import com.jagng.admin.service.ITMemberService;

/**
 * 会员信息;Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@Service
public class TMemberServiceImpl implements ITMemberService 
{
    @Autowired
    private TMemberMapper tMemberMapper;

    /**
     * 查询会员信息;
     * 
     * @param id 会员信息;主键
     * @return 会员信息;
     */
    @Override
    public TMember selectTMemberById(Integer id)
    {
        return tMemberMapper.selectTMemberById(id);
    }

    /**
     * 查询会员信息;列表
     * 
     * @param tMember 会员信息;
     * @return 会员信息;
     */
    @Override
    public List<TMember> selectTMemberList(TMember tMember)
    {
        return tMemberMapper.selectTMemberList(tMember);
    }

    /**
     * 新增会员信息;
     * 
     * @param tMember 会员信息;
     * @return 结果
     */
    @Override
    public int insertTMember(TMember tMember)
    {
        return tMemberMapper.insertTMember(tMember);
    }

    /**
     * 修改会员信息;
     * 
     * @param tMember 会员信息;
     * @return 结果
     */
    @Override
    public int updateTMember(TMember tMember)
    {
        return tMemberMapper.updateTMember(tMember);
    }

    /**
     * 批量删除会员信息;
     * 
     * @param ids 需要删除的会员信息;主键
     * @return 结果
     */
    @Override
    public int deleteTMemberByIds(Integer[] ids)
    {
        return tMemberMapper.deleteTMemberByIds(ids);
    }

    /**
     * 删除会员信息;信息
     * 
     * @param id 会员信息;主键
     * @return 结果
     */
    @Override
    public int deleteTMemberById(Integer id)
    {
        return tMemberMapper.deleteTMemberById(id);
    }
}
