/**
 * @File DeptinfoService.java
 * @Type DeptinfoService
 */
package com.tina.service;

import java.util.List;
import java.util.Map;

import com.tina.entity.AdvancedDeptinfo;
import com.tina.entity.Deptinfo;
import com.tina.entity.DeptinfoExample;

/**
 * @author 何悟隆
 * @datetime 2018年5月3日 下午9:05:06
 * 
 */
public interface DeptinfoService {

	List<Deptinfo> queryDeptinfoAll(DeptinfoExample deptinfoExample);

	List<AdvancedDeptinfo> queryDeptinfoPage(Map<String, Object> map);
	
	Deptinfo queryDeptinfoByPrimaryKey(Integer deptno);
	
	int addDeptinfo(Deptinfo deptinfo);
	
	int modifyDeptinfo(Deptinfo deptinfo);
	
	int removeDeptinfo(Integer[] deptnos);
	
	int countDeptinfo(Map<String, Object> map);
	
}
