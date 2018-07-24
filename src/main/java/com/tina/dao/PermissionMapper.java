package com.tina.dao;

import com.tina.entity.Permission;
import com.tina.entity.PermissionExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author 何悟隆
 *
 */
public interface PermissionMapper {
	long countByExample(PermissionExample example);

	int deleteByExample(PermissionExample example);

	int deleteByPrimaryKey(Integer perid);

	/**
	 * @方法 新增方法，通过唯一非主键删除
	 * @param pername
	 * @return
	 */
	int deleteByUniqueKey(String pername);

	/**
	 * @方法 新增方法，批量删除
	 * @param perids
	 * @return
	 */
	int deleteBatch(List<Integer> perids);

	int insert(Permission record);

	int insertSelective(Permission record);
	
	/**
	 * @方法 新增方法，用于查询子权限
	 * @param parenid
	 * @return
	 */
	int selectChildrenByParentid(Integer parenid);

	List<Permission> selectByExample(PermissionExample example);

	/**
	 * @方法 新增方法，分页查询
	 * @param map
	 * @return
	 */
	List<Permission> selectByPage(Map<String, Object> map);

	/**
	 * @方法 新增方法，查询所有
	 * @return
	 */
	List<Permission> selectAll();

	Permission selectByPrimaryKey(Integer perid);

	/**
	 * @方法 新增方法，通过唯一非主键查找单项数据
	 * @param pername
	 * @return
	 */
	Permission selectByUniqueKey(String pername);
	
	List<Permission> selectPermissionByRoleId(Integer roleId);

	int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

	int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

	int updateByPrimaryKeySelective(Permission record);

	int updateByPrimaryKey(Permission record);
	
	String selectPerURLByPerid(Integer perid);
}