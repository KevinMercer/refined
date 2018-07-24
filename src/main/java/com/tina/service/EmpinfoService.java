/**
 * 
 */
package com.tina.service;

import java.util.List;
import java.util.Map;

import com.tina.entity.Empinfo;
import com.tina.entity.AdvancedEmpinfo;
import com.tina.entity.EmpinfoExample;

/**
 * @author 何悟隆
 *
 */
public interface EmpinfoService {

	int addEmpinfo(Empinfo empinfo);
	
	int removeEmpinfoByEmpno(Integer empno);
	
	int removeEmpinfoByDeptno(Integer deptno);
	
	int removeEmpinfoBatch(Integer[] empnos);
	
	int modifyEmpinfoByEmpno(Empinfo empinfo);
	
	int modifyEmpinfoByExample(Empinfo empinfo, EmpinfoExample empinfoExample);
	
	int queryCountsEmpinfoWithConditions(Integer deptno, Integer roleId, Integer manager, String key);
	
	List<AdvancedEmpinfo> queryEmpinfoByPage(Map<String, Object> map);
	
	List<Empinfo> queryEmpinfo(EmpinfoExample empinfoExample);
	
	Empinfo querySingleEmpinfoByEmpno(Integer empno);
	
	AdvancedEmpinfo querySingleEmpinfoByDoubleKey(Map<String, Object> map);
	
}
