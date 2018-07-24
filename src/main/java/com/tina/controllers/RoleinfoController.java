/**
 * 
 */
package com.tina.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tina.entity.Permission;
import com.tina.entity.Roleinfo;
import com.tina.service.RoleinfoService;
import com.tina.util.DataTable;
import com.tina.util.Message;

/**
 * @author 何悟隆
 *
 */
@Controller
@RequestMapping("/roleinfo/")
public class RoleinfoController {

	@Resource
	private RoleinfoService roleinfoService;
	@Resource
	private HttpSession session;
	private Roleinfo roleinfo;
	private Map<String, Object> map;
	private List<Roleinfo> roleinfos;
	private List<Permission> permissions;
	private DataTable<Roleinfo> dataTable;
	private int effectRow;
	private Message message;

	@RequestMapping("roleinfoList")
	public String roleinfoList() {
		return "roleinfo/roleinfoList";
	}

	@RequestMapping("roleinfoData")
	@ResponseBody
	public DataTable<Roleinfo> roleinfoData(int start, int length, String key) {
		dataTable = new DataTable<Roleinfo>();
		if (key != null) {
			key = key.trim();
		}
		map = new HashMap<String, Object>();
		map.put("key", key);
		effectRow = roleinfoService.queryCountsRoleinfoWithCondition(key);
		if (-1 >= length) {
			length = effectRow;
		}
		map.put("start", start);
		map.put("length", length);
		roleinfos = roleinfoService.queryRoleinfoByPage(map);
		dataTable.setData(roleinfos);
		dataTable.setRecordsTotal(effectRow);
		dataTable.setRecordsFiltered(effectRow);
		return dataTable;
	}

	@RequestMapping("roleinfoAdd")
	public String jumpToAddPage() {
		return "roleinfo/roleinfoAdd";
	}

	@RequestMapping("executeAdd")
	@ResponseBody
	public Message executeAdd(Roleinfo roleinfo) {
		message = new Message();
		effectRow = roleinfoService.addRoleinfo(roleinfo);
		message.setEffectRow(effectRow);
		return message;
	}

	@RequestMapping("roleinfoEdit")
	public String jumpToEditPage(HttpServletRequest request, Integer roleId) {
		roleinfo = roleinfoService.querySingleRoleinfoByRoleId(roleId);
		request.setAttribute("roleinfo", roleinfo);
		return "roleinfo/roleinfoEdit";
	}

	@RequestMapping("executeEdit")
	@ResponseBody
	public Message executeEdit(Roleinfo roleinfo) {
		message = new Message();
		effectRow = roleinfoService.modifyRoleinfoByRoleId(roleinfo);
		message.setEffectRow(effectRow);
		return message;
	}

	@RequestMapping("executeRemove")
	@ResponseBody
	public Message executeRemove(Integer roleId) {
		message = new Message();
		effectRow = roleinfoService.removeSingleRoleinfoByRoleId(roleId);
		message.setEffectRow(effectRow);
		return message;
	}

	@RequestMapping("executeRemoveBatch")
	@ResponseBody
	public Message executeRemoveBatch(Integer[] roleIds) {
		message = new Message();
		effectRow = roleinfoService.removeBatchRoleinfo(roleIds);
		message.setEffectRow(effectRow);
		return message;
	}

	@RequestMapping("distributePermission")
	public String distributePermission(HttpServletRequest request, Integer roleId) {
		request.setAttribute("roleId", roleId);
		return "role_permission/distribute";
	}

	@RequestMapping("executeDistribute")
	@ResponseBody
	public Message executeDistribute(Integer[] perids, Integer roleId) {
		message = new Message();
		effectRow = roleinfoService.distributePermission(perids, roleId);
		message.setEffectRow(effectRow);
		return message;
	}

	@RequestMapping("executeClearDistribute")
	@ResponseBody
	public Message executeClearDistribute(Integer roleId) {
		message = new Message();
		effectRow = roleinfoService.removeDistribute(roleId);
		message.setEffectRow(effectRow);
		return message;
	}

	@RequestMapping("rolepermission")
	public String rolepermission(HttpServletRequest request, Integer roleId) {
		request.setAttribute("roleId", roleId);
		return "role_permission/rolepermission";
	}

	@RequestMapping("rolepermissionData")
	@ResponseBody
	public List<Permission> rolepermissionData(Integer roleId) {
		if (roleId == null) {
			roleId = (Integer) session.getAttribute("roleId");
		}
		permissions = roleinfoService.queryPermissionByRoleId(roleId);
		return permissions;
	}

	@RequestMapping("verifyRoleinfo")
	@ResponseBody
	public Message verifyRoleinfo(String roleName) {
		message = new Message();
		roleinfo = roleinfoService.querySingleRoleinfoByRoleName(roleName);
		if (roleinfo != null) {
			effectRow = 1;
		} else {
			effectRow = 0;
		}
		message.setEffectRow(effectRow);
		return message;
	}

}
