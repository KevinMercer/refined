/**
 * @File DeptinfoServiceImp.java
 * @Type DeptinfoServiceImp
 */
package com.tina.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tina.dao.DeptinfoMapper;
import com.tina.entity.AdvancedDeptinfo;
import com.tina.entity.Deptinfo;
import com.tina.entity.DeptinfoExample;
import com.tina.service.DeptinfoService;

/**
 * @author 何悟隆
 * @datetime 2018年5月3日 下午9:05:54
 * 
 */
@Service
public class DeptinfoServiceImp implements DeptinfoService {
	
	@Resource
	private DeptinfoMapper deptinfoMapper;
	private List<Deptinfo> deptinfos;
	private List<AdvancedDeptinfo> advancedDeptinfos;
	private List<Integer> deptnos;

	/**
	 * 
	 */
	public DeptinfoServiceImp() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.tina.service.DeptinfoService#queryDeptinfoAll()
	 */
	@Override
	public List<Deptinfo> queryDeptinfoAll(DeptinfoExample deptinfoExample) {
		// TODO Auto-generated method stub
		deptinfos = deptinfoMapper.selectByExample(deptinfoExample);
		return deptinfos;
	}

	@Override
	public List<AdvancedDeptinfo> queryDeptinfoPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return deptinfoMapper.selectDeptinfoPage(map);
	}

	@Override
	public int addDeptinfo(Deptinfo deptinfo) {
		// TODO Auto-generated method stub
		return deptinfoMapper.insertSelective(deptinfo);
	}

	@Override
	public int modifyDeptinfo(Deptinfo deptinfo) {
		// TODO Auto-generated method stub
		return deptinfoMapper.updateByPrimaryKeySelective(deptinfo);
	}

	@Override
	public int removeDeptinfo(Integer[] deptnos) {
		// TODO Auto-generated method stub
		if(deptnos == null || deptnos.length <= 0){
			return 0;
		}
		this.deptnos = new ArrayList<Integer>();
		for (int i = 0; i < deptnos.length; i++) {
			this.deptnos.add(deptnos[i]);
		}
		return deptinfoMapper.deleteDeptinfoBatch(this.deptnos);
	}

	@Override
	public int countDeptinfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return deptinfoMapper.countDept(map);
	}

	@Override
	public Deptinfo queryDeptinfoByPrimaryKey(Integer deptno) {
		// TODO Auto-generated method stub
		return deptinfoMapper.selectByPrimaryKey(deptno);
	}

}
