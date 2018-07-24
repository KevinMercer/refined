/**
 * 
 */
package com.tina.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tina.entity.AdvancedEmpinfo;
import com.tina.entity.Deptinfo;
import com.tina.entity.Empinfo;
import com.tina.entity.Permission;
import com.tina.entity.Roleinfo;
import com.tina.service.DeptinfoService;
import com.tina.service.EmpinfoService;
import com.tina.service.PermissionService;
import com.tina.service.RoleinfoService;
import com.tina.util.BootstrapTable;
import com.tina.util.Message;

/**
 * 
 * @author 何悟隆
 * @datetime 2018年5月3日 下午7:25:56
 *
 */
@Controller
@RequestMapping("/empinfo/")
public class EmpinfoController {

	@Resource
	private EmpinfoService empinfoService;
	@Resource
	private RoleinfoService roleinfoService;
	@Resource
	private PermissionService permissionService;
	@Resource
	private DeptinfoService deptinfoService;
	@Resource
	private HttpSession session;
	private BootstrapTable<AdvancedEmpinfo> AEbootstrapTable;
	private List<AdvancedEmpinfo> advancedEmpinfos;
	private List<Empinfo> empinfos;
	private List<Permission> permissions;
	private List<Roleinfo> roleinfos;
	private List<Deptinfo> deptinfos;
	private Message message;
	private Map<String, Object> map;
	private Empinfo empinfo;
	private int effectRow, pageNumber, pageSize, counts;
	private String defaultPerURL;

	@RequestMapping("login")
	@ResponseBody
	private synchronized Message login(Integer empno, String password) {
		if (empno == null || password == null) {
			return message;
		}
		session.setAttribute("role", "empinfo");
		message = new Message();
		map = new HashMap<>();
		map.put("empno", empno);
		map.put("password", password);
		empinfo = empinfoService.querySingleEmpinfoByDoubleKey(map);
		if (empinfo == null) {
			return message;
		}
		if (empinfo.getRoleid() == null) {
			return message;
		}
		effectRow = empinfo.getRoleid();
		message.setEffectRow(effectRow);
		session.setAttribute("account", empinfo);
		session.setAttribute("roleId", effectRow);
		permissions = roleinfoService.queryPermissionByRoleId(effectRow);
		if (permissions != null) {
			if (permissions.size() > 0) {
				List<Permission> permissions = new ArrayList<Permission>();
				for (Permission permission : this.permissions) {
					if (permission != null) {
						if (permission.getPicname() != null && !"".equals(permission.getPicname())) {
							permissions.add(permission);
						}
					}
				}
				defaultPerURL = permissionService.queryPerURLByPerid(1030);
				session.setAttribute("defaultPerURL", defaultPerURL);
				session.setAttribute("permissionpic", permissions);
				session.setAttribute("permissions", this.permissions);
				return message;
			}
		}
		permissions = new ArrayList<Permission>();
		List<Permission> permissions = new ArrayList<Permission>();
		session.setAttribute("permissionpic", permissions);
		session.setAttribute("permissions", this.permissions);
		return message;
	}

	@RequestMapping("interface")
	private synchronized String jumpToInterface() {
		return "interface/empindex";
	}

	@RequestMapping("empinfoData")
	@ResponseBody
	private synchronized BootstrapTable<AdvancedEmpinfo> empinfoData(Integer pageNumber, Integer pageSize, String searchStr, Integer roleId, Integer deptno, Integer manager) {
		AEbootstrapTable = new BootstrapTable<AdvancedEmpinfo>();
		map = new HashMap<String, Object>();
		counts = empinfoService.queryCountsEmpinfoWithConditions(deptno, roleId, manager, searchStr);
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
		map.put("key", searchStr);
		map.put("roleId", roleId);
		map.put("deptno", deptno);
		map.put("superior", manager);
		advancedEmpinfos = empinfoService.queryEmpinfoByPage(map);
		AEbootstrapTable.setRows(advancedEmpinfos);
		AEbootstrapTable.setTotal(counts);
		return AEbootstrapTable;
	}

	@RequestMapping("empinfoList")
	private synchronized String jumpToEmpinfoList() {
		return "employee/employeeList";
	}

	@RequestMapping("empManager")
	private synchronized String empManager() {
		return "employee/employeeManager";
	}

	@RequestMapping("attendance")
	private synchronized String attendence() {
		return "employee/attendance";
	}

	@RequestMapping("addEmp")
	private synchronized String addEmployee(HttpServletRequest request) {
		roleinfos = roleinfoService.queryRoleinfoAll();
		empinfos = empinfoService.queryEmpinfo(null);
		deptinfos = deptinfoService.queryDeptinfoAll(null);
		request.setAttribute("roles", roleinfos);
		request.setAttribute("empinfos", empinfos);
		request.setAttribute("deptinfos", deptinfos);
		return "employee/employeeAdd";
	}

	@RequestMapping("executeAdd")
	@ResponseBody
	private synchronized Message executeAdd(Empinfo empinfo) {
		message = new Message();
		effectRow = empinfoService.addEmpinfo(empinfo);
		message.setEffectRow(effectRow);
		return message;
	}

	@RequestMapping("editEmp")
	private synchronized String editEmployee(Integer empno, HttpServletRequest request) {
		roleinfos = roleinfoService.queryRoleinfoAll();
		empinfos = empinfoService.queryEmpinfo(null);
		deptinfos = deptinfoService.queryDeptinfoAll(null);
		empinfo = empinfoService.querySingleEmpinfoByEmpno(empno);
		request.setAttribute("roles", roleinfos);
		request.setAttribute("empinfos", empinfos);
		request.setAttribute("deptinfos", deptinfos);
		request.setAttribute("empinfo", empinfo);
		return "employee/employeeEdit";
	}

	@RequestMapping("executeEdit")
	@ResponseBody
	private synchronized Message executeEdit(Empinfo empinfo) {
		message = new Message();
		effectRow = empinfoService.modifyEmpinfoByEmpno(empinfo);
		message.setEffectRow(effectRow);
		return message;
	}
	
	@RequestMapping("removeEmp")
	@ResponseBody
	private synchronized Message removeEmp(Integer[] empnos){
		if (empnos == null || empnos.length <= 0) {
			return message;
		}
		effectRow = empinfoService.removeEmpinfoBatch(empnos);
		message.setEffectRow(effectRow);
		return message;
	}

}
