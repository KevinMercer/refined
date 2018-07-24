package com.tina.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tina.entity.Userinfo;
import com.tina.entity.UserinfoContainRoleinfo;
import com.tina.entity.UserinfoExample;

public interface UserinfoMapper {
    long countByExample(UserinfoExample example);

    int deleteByExample(UserinfoExample example);

    int deleteByPrimaryKey(Integer userId);
    
    int deleteBatch(List<Integer> userIds);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    List<Userinfo> selectByExample(UserinfoExample example);
    
    List<Userinfo> selectUserinfosByPage(Map<String, Object> map);
    
    List<UserinfoContainRoleinfo> selectUserinfoContainRoleinfo(Map<String, Object> map);

    Userinfo selectByPrimaryKey(Integer userId);
    
    Userinfo selectByUsername(String username);
    
    Userinfo selectUserinfoByDoubleKey(Map<String, String> map);
    
    int selectCountUserinfo();
    
    int selectUsersByRoleId(Integer roleId);

    int updateByExampleSelective(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

    int updateByExample(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
    
    String selectUsernameByEmail(String email);
    
}