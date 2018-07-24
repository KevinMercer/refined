package com.tina.dao;

import com.tina.entity.Roleinfo;
import com.tina.entity.RoleinfoExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface RoleinfoMapper {

	long countByExample(RoleinfoExample example);

	int deleteByExample(RoleinfoExample example);

	int deleteByPrimaryKey(Integer roleId);

	int deleteByUniqueKey(String roleName);

	int deleteBatch(List<Integer> roleIds);

	int insert(Roleinfo record);

	int insertSelective(Roleinfo record);
	
	List<Roleinfo> selectRoleinfoAll();

	List<Roleinfo> selectByExample(RoleinfoExample example);

	List<Roleinfo> selectByPage(Map<String, Object> map);

	Roleinfo selectByPrimaryKey(Integer roleId);

	Roleinfo selectByUniqueKey(String roleName);

	int updateByExampleSelective(@Param("record") Roleinfo record, @Param("example") RoleinfoExample example);

	int updateByExample(@Param("record") Roleinfo record, @Param("example") RoleinfoExample example);

	int updateByPrimaryKeySelective(Roleinfo record);

	int updateByPrimaryKey(Roleinfo record);

}