/**
 * 
 */
package com.tina.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tina.dao.EmpinfoMapper;
import com.tina.entity.AdvancedEmpinfo;
import com.tina.entity.Empinfo;
import com.tina.entity.EmpinfoExample;
import com.tina.entity.EmpinfoExample.Criteria;
import com.tina.service.EmpinfoService;

/**
 * @author 何悟隆
 *
 */
@Service
public class EmpinfoServiceImp implements EmpinfoService {
	
	@Resource
	private EmpinfoMapper empinfoMapper;
	private EmpinfoExample empinfoExample;
	private Criteria empinfoCriteria;
	private List<Integer> empnos;
	private List<AdvancedEmpinfo> advancedEmpinfos;
	private int effectRow, counts;
	private Empinfo empinfo;
	private AdvancedEmpinfo advancedEmpinfo;

	/**
	 * 
	 */
	public EmpinfoServiceImp() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tina.service.EmpinfoService#addEmpinfo(com.tina.entity.Empinfo)
	 */
	@Override
	public int addEmpinfo(Empinfo empinfo) {
		// TODO Auto-generated method stub
		if(empinfo == null){
			return -1;
		}
		effectRow = empinfoMapper.insertSelective(empinfo);
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.EmpinfoService#removeEmpinfoByEmpno(java.lang.Integer)
	 */
	@Override
	public int removeEmpinfoByEmpno(Integer empno) {
		// TODO Auto-generated method stub
		if(empno == null){
			return -1;
		}
		effectRow = empinfoMapper.deleteByPrimaryKey(empno);
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.EmpinfoService#removeEmpinfoByDeptno(java.lang.Integer)
	 */
	@Override
	public int removeEmpinfoByDeptno(Integer deptno) {
		// TODO Auto-generated method stub
		if(deptno == null){
			return -1;
		}
		effectRow = empinfoMapper.deleteEmpinfoByDeptno(deptno);
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.EmpinfoService#removeEmpinfoBatch(java.lang.Integer[])
	 */
	@Override
	public int removeEmpinfoBatch(Integer[] empnos) {
		// TODO Auto-generated method stub
		if(empnos == null){
			return -1;
		}
		this.empnos = new ArrayList<>();
		for (int i = 0; i < empnos.length; i++) {
			if(empnos[i] == null){
				return -1;
			}
			this.empnos.add(empnos[i]);
		}
		effectRow = empinfoMapper.deleteEmpinfoBatch(this.empnos);
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.EmpinfoService#modifyEmpinfoByEmpno(com.tina.entity.
	 * Empinfo)
	 */
	@Override
	public int modifyEmpinfoByEmpno(Empinfo empinfo) {
		// TODO Auto-generated method stub
		if(empinfo == null){
			return -1;
		}
		effectRow = empinfoMapper.updateByPrimaryKeySelective(empinfo);
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.EmpinfoService#modifyEmpinfoByExample(com.tina.entity.
	 * Empinfo, com.tina.entity.EmpinfoExample)
	 */
	@Override
	public int modifyEmpinfoByExample(Empinfo empinfo, EmpinfoExample empinfoExample) {
		// TODO Auto-generated method stub
		if(empinfo == null || empinfoExample == null){
			return -1;
		}
		effectRow = empinfoMapper.updateByExampleSelective(empinfo, empinfoExample);
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tina.service.EmpinfoService#queryEmpinfoByPage(java.util.Map)
	 */
	@Override
	public List<AdvancedEmpinfo> queryEmpinfoByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return empinfoMapper.selectEmpinfoByPage(map);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tina.service.EmpinfoService#querySingleEmpinfoByEmpno(java.lang.
	 * Integer)
	 */
	@Override
	public Empinfo querySingleEmpinfoByEmpno(Integer empno) {
		// TODO Auto-generated method stub
		if(empno == null){
			return empinfo;
		}
		empinfo = empinfoMapper.selectByPrimaryKey(empno);
		return empinfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.EmpinfoService#querySingleEmpinfoByDoubleKey(java.util.
	 * Map)
	 */
	@Override
	public AdvancedEmpinfo querySingleEmpinfoByDoubleKey(Map<String, Object> map) {
		// TODO Auto-generated method stub
		if(map ==null){
			return advancedEmpinfo;
		}
		advancedEmpinfo = empinfoMapper.selectEmpinfoByDoubleKey(map);
		return advancedEmpinfo;
	}

	@Override
	public int queryCountsEmpinfoWithConditions(Integer deptno, Integer roleId, Integer manager, String key) {
		// TODO Auto-generated method stub
		empinfoExample = new EmpinfoExample();
		empinfoCriteria = empinfoExample.createCriteria();
		if(deptno != null){
			empinfoCriteria.andDeptnoEqualTo(deptno);
		}
		if(roleId != null){
			empinfoCriteria.andRoleidEqualTo(roleId);
		}
		if(manager != null){
			empinfoCriteria.andSuperiorEqualTo(manager);
		}
		if(key != null && key != "" && !"".equals(key)){
			empinfoCriteria.andEmpnameLike("%" + key + "%");
		}
		counts = (int) empinfoMapper.countByExample(empinfoExample);
		return counts;
	}

	@Override
	public List<Empinfo> queryEmpinfo(EmpinfoExample empinfoExample) {
		// TODO Auto-generated method stub
		return empinfoMapper.selectByExample(empinfoExample);
	}

}
