/**
 * 
 */
package com.tina.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tina.entity.Permission;
import com.tina.service.PermissionService;
import com.tina.util.Message;

/**
 * @author 何悟隆
 *
 */
@Controller
@RequestMapping("/permission/")
public class PermissionController {

	@Resource
	private PermissionService permissionService;
	private Message message;
	private int effectRow, isParent;
	private List<Permission> permissions;
	private List<Integer> perids;
	private Permission permission;

	@RequestMapping("permissionList")
	public String permissionList() {
		return "permission/permissionList";
	}

	@RequestMapping("permissionData")
	@ResponseBody
	public List<Permission> permissionData(Integer roleId) {
		permissions = permissionService.queryPermissionsAll();
		if (roleId == null) {
			return permissions;
		}
		perids = permissionService.queryPeridByRoleId(roleId);
		if (perids == null || perids.size() <= 0) {
			return this.permissions;
		}
		for (Integer perid : perids) {
			if (perid != null) {
				for (Permission permission : permissions) {
					if (permission != null) {
						if (perid.equals(permission.getPerid())) {
							permission.setChecked(true);
						}
					}
				}
			}
		}
		return this.permissions;
	}

	@RequestMapping("addPermission")
	public String jumpToAddPage(HttpServletRequest request, String parentid) {
		request.setAttribute("parentid", parentid);
		return "permission/permissionAdd";
	}

	@RequestMapping("executeAdd")
	@ResponseBody
	public Message executeAdd(Permission permission) {
		message = new Message();
		effectRow = permissionService.addPermission(permission);
		message.setEffectRow(effectRow);
		return message;
	}

	@RequestMapping("editPermission")
	public String jumpToEditPage(HttpServletRequest request, Integer perid) {
		permission = permissionService.querySinglePermissionByPerid(perid);
		permissions = permissionService.queryPermissionsAll();
		request.setAttribute("permission", permission);
		request.setAttribute("permissions", permissions);
		return "permission/permissionEdit";
	}

	@RequestMapping("executeEdit")
	@ResponseBody
	public Message executeEdit(Permission permission, int oldParent) {
		message = new Message();
		effectRow = permissionService.modifyPermissionByPrimaryKey(permission, oldParent);
		message.setEffectRow(effectRow);
		System.err.println("PermissionController executeEdit permission = " + permission);
		return message;
	}

	@RequestMapping("executeRemove")
	@ResponseBody
	public Message executeRemove(int perid, int oldParent) {
		message = new Message();
		effectRow = permissionService.removePermissionByPerid(perid, oldParent);
		message.setEffectRow(effectRow);
		return message;
	}

	@RequestMapping("executeMove")
	@ResponseBody
	public Message executeMove(int perid, int oldParent, int newParent, boolean isParent) {
		message = new Message();
		if (isParent) {
			this.isParent = 1;
		}
		permission = new Permission(perid, this.isParent, newParent);
		effectRow = permissionService.modifyPermissionByPrimaryKey(permission, oldParent);
		message.setEffectRow(effectRow);
		return message;
	}
	
	@RequestMapping("verifyPername")
	@ResponseBody
	public Message verifyPername(String pername){
		message = new Message();
		permission = permissionService.querySinglePermissionBypername(pername);
		if(permission != null){
			effectRow = 1;
		} else {
			effectRow = 0;
		}
		message.setEffectRow(effectRow);
		return message;
	}

}
