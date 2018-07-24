/**
 * @File DeptinfoController.java
 * @Type DeptinfoController
 */
package com.tina.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tina.entity.AdvancedDeptinfo;
import com.tina.entity.Deptinfo;
import com.tina.entity.Empinfo;
import com.tina.entity.EmpinfoExample;
import com.tina.entity.EmpinfoExample.Criteria;
import com.tina.service.DeptinfoService;
import com.tina.service.EmpinfoService;
import com.tina.util.BootstrapTable;
import com.tina.util.Message;

/**
 * @author 何悟隆
 * @datetime 2018年5月4日 下午9:26:53
 * 
 */
@Controller
@RequestMapping("/deptinfo/")
public class DeptinfoController {

	@Resource
	private DeptinfoService deptinfoService;
	@Resource
	private EmpinfoService empinfoService;
	private EmpinfoExample empinfoExample;
	private BootstrapTable<AdvancedDeptinfo> ADbootstrapTable;
	private List<AdvancedDeptinfo> advancedDeptinfos;
	private List<Empinfo> empinfos;
	private Map<String, Object> map;
	private int effectRow, pageNumber, pageSize, counts;
	private Message message;
	private Deptinfo deptinfo;

	@RequestMapping("deptinfoList")
	private synchronized String deptinfoList() {
		return "deptinfo/deptinfoList";
	}

	@RequestMapping("deptinfoData")
	@ResponseBody
	private synchronized BootstrapTable<AdvancedDeptinfo> deptinfoList(Integer pageNumber, Integer pageSize, String searchStr) {
		ADbootstrapTable = new BootstrapTable<AdvancedDeptinfo>();
		map = new HashMap<String, Object>();
		map.put("key", searchStr);
		counts = deptinfoService.countDeptinfo(map);
		this.pageNumber = pageNumber.intValue();
		this.pageSize = pageSize.intValue();
		if (pageNumber == null || pageNumber.intValue() <= 1) {
			this.pageNumber = 0;
		}
		if (pageSize == null || pageSize.intValue() <= 0) {
			this.pageSize = counts;
		}
		map.put("start", this.pageNumber);
		map.put("length", this.pageSize);
		advancedDeptinfos = deptinfoService.queryDeptinfoPage(map);
		ADbootstrapTable.setRows(advancedDeptinfos);
		ADbootstrapTable.setTotal(counts);
		return ADbootstrapTable;
	}

	@RequestMapping("addDeptinfo")
	private synchronized String addDeptinfo(HttpServletRequest request) {
		empinfoExample = new EmpinfoExample();
		Criteria criteria = empinfoExample.createCriteria();
		criteria.andRoleidBetween(15, 19);
		empinfos = empinfoService.queryEmpinfo(empinfoExample);
		request.setAttribute("empinfos", empinfos);
		return "deptinfo/deptinfoAdd";
	}

	@RequestMapping("executeAdd")
	@ResponseBody
	private synchronized Message executeAdd(Deptinfo deptinfo) {
		message = new Message();
		effectRow = deptinfoService.addDeptinfo(deptinfo);
		message.setEffectRow(effectRow);
		return message;
	}
	
	@RequestMapping("editDeptinfo")
	private synchronized String editDeptinfo(HttpServletRequest request, Integer deptno){
		deptinfo = deptinfoService.queryDeptinfoByPrimaryKey(deptno);
		empinfoExample = new EmpinfoExample();
		Criteria criteria = empinfoExample.createCriteria();
		criteria.andRoleidBetween(15, 19);
		empinfos = empinfoService.queryEmpinfo(empinfoExample);
		request.setAttribute("deptinfo", deptinfo);
		request.setAttribute("empinfos", empinfos);
		return "deptinfo/deptinfoEdit";
	}

	@RequestMapping("executeEdit")
	@ResponseBody()
	private synchronized Message executeEdit(Deptinfo deptinfo){
		message = new Message();
		effectRow = deptinfoService.modifyDeptinfo(deptinfo);
		message.setEffectRow(effectRow);
		return message;
	}
	
	@RequestMapping("removeDept")
	@ResponseBody
	private synchronized Message removeDept(Integer[] deptnos){
		message = new Message();
		effectRow = deptinfoService.removeDeptinfo(deptnos);
		message.setEffectRow(effectRow);
		return message;
	}
	
}
