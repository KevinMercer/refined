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

import com.tina.entity.Permission;
import com.tina.entity.Roleinfo;
import com.tina.entity.Userinfo;
import com.tina.entity.UserinfoContainRoleinfo;
import com.tina.service.PermissionService;
import com.tina.service.RoleinfoService;
import com.tina.service.UserinfoService;
import com.tina.util.BootstrapTable;
import com.tina.util.Message;

/**
 * 
 * @author 何悟隆
 * @datetime 2018年5月1日 下午3:19:56
 *
 */
@Controller
@RequestMapping("/userinfo/")
public class UserinfoController {

	@Resource
	private UserinfoService userinfoService;
	@Resource
	private HttpSession session;
	@Resource
	private RoleinfoService roleinfoService;
	@Resource
	private PermissionService permissionService;
	private List<Roleinfo> roleinfos;
	private Map<String, Object> map;
	private BootstrapTable<UserinfoContainRoleinfo> UCRbootstrapTable;
	private List<Userinfo> userinfos;
	private List<UserinfoContainRoleinfo> userinfosContainRoleinfo;
	private String defaultPerURL;
	private List<Permission> permissions;
	private Userinfo userinfo;
	private int effectRow, counts, pageNumber, pageSize;
	private Message message;

	@RequestMapping("list")
	private synchronized String userinfoList() {
		return "userinfo/userinfoList";
	}

	/*
	 * @RequestMapping("userinfoData")
	 * 
	 * @ResponseBody public DataTable<UserinfoContainRoleinfo>
	 * userinfoData(String key, Integer start, Integer length) { UCRdataTable =
	 * new DataTable<UserinfoContainRoleinfo>(); counts =
	 * userinfoService.queryCountsUserinfoWithConditions(key); if (length ==
	 * null || length.intValue() <= 0) { length = counts; } if(start == null){
	 * start = 0; } map = new HashMap<String, Object>(); map.put("key", key);
	 * map.put("start", start); map.put("length", length);
	 * userinfosContainRoleinfo =
	 * userinfoService.queryUserinfoContainRoleinfoByPage(map);
	 * UCRdataTable.setData(userinfosContainRoleinfo);
	 * UCRdataTable.setRecordsTotal(counts);
	 * UCRdataTable.setRecordsFiltered(counts); return UCRdataTable; }
	 */

	@RequestMapping("userinfoData")
	@ResponseBody
	private synchronized BootstrapTable<UserinfoContainRoleinfo> userinfoData(Integer pageSize, Integer pageNumber, String searchStr) {
		UCRbootstrapTable = new BootstrapTable<UserinfoContainRoleinfo>();
		counts = userinfoService.queryCountsUserinfoWithConditions(searchStr);
		this.pageNumber = pageNumber.intValue();
		this.pageSize = pageSize.intValue();
		if (pageNumber == null || pageNumber.intValue() <= 1) {
			this.pageNumber = 0;
		}
		if (pageSize == null || pageSize.intValue() <= 0) {
			this.pageSize = counts;
		}
		map = new HashMap<String, Object>();
		map.put("key", searchStr);
		map.put("start", this.pageNumber);
		map.put("length", this.pageSize);
		userinfosContainRoleinfo = userinfoService.queryUserinfoContainRoleinfoByPage(map);
		UCRbootstrapTable.setRows(userinfosContainRoleinfo);
		UCRbootstrapTable.setTotal(counts);
		return UCRbootstrapTable;
	}

	@RequestMapping("userinfoDataList")
	@ResponseBody
	private synchronized List<Userinfo> userinfoDataList() {
		userinfos = userinfoService.queryUserinfoList();
		return userinfos;
	}

	@RequestMapping("login")
	@ResponseBody
	private synchronized Message verifyUser(String username, String password) {
		message = new Message();
		userinfo = userinfoService.querySingleUserinfoByDoubleKey(username, password);
		if (userinfo != null) {
			session.setAttribute("role", "userinfo");
			if (userinfo.getRoleId() != null) {
				effectRow = userinfo.getRoleId();
				message.setEffectRow(effectRow);
				session.setAttribute("account", userinfo);
				session.setAttribute("roleId", effectRow);
				permissions = roleinfoService.queryPermissionByRoleId(effectRow);
				if (permissions != null) {
					if (permissions.size() > 0) {
						System.err.println("this permissions = " + this.permissions);
						session.setAttribute("permissions", this.permissions);
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
						return message;
					}
				}
				permissions = new ArrayList<Permission>();
				List<Permission> permissions = new ArrayList<Permission>();
				session.setAttribute("permissionpic", permissions);
				session.setAttribute("permissions", this.permissions);
			}
		}
		return message;
	}

	@RequestMapping("logout")
	@ResponseBody
	private synchronized Message logout() {
		session.removeAttribute("account");
		session.removeAttribute("roleId");
		session.removeAttribute("permissions");
		session.removeAttribute("permissionpic");
		System.out.println("session清空完毕！");
		return message;
	}

	@RequestMapping("interface")
	private synchronized String jumpToInterface() {
		return "interface/userindex";
	}

	@RequestMapping("closePage")
	private synchronized String closePage() {
		return "index";
	}

	@RequestMapping("currentPermission")
	private synchronized String currentPermission() {
		return "interface/currentPermissions";
	}

	@RequestMapping("executeRemove")
	@ResponseBody
	private synchronized Message executeRemove(Integer[] userIds) {
		message = new Message(-1);
		if (userIds == null || userIds.length <= 0) {
			return message;
		}
		effectRow = userinfoService.removeUserinfoBatch(userIds);
		message.setEffectRow(effectRow);
		return message;
	}

	@RequestMapping("addUser")
	private synchronized String addUser(HttpServletRequest request) {
		System.err.println("addUser In!!!");
		roleinfos = roleinfoService.queryRoleinfoAll();
		request.setAttribute("roles", roleinfos);
		System.err.println("addUser Out!!!");
		return "userinfo/userinfoAdd";
	}

	@RequestMapping("executeAdd")
	@ResponseBody
	private synchronized Message executeAdd(Userinfo userinfo) {
		message = new Message();
		effectRow = userinfoService.addUserinfo(userinfo);
		message.setEffectRow(effectRow);
		return message;
	}

	@RequestMapping("editUser")
	private synchronized String editUser(HttpServletRequest request, Integer userId) {
		userinfo = userinfoService.querySingleUserinfoByPrimaryKey(userId);
		roleinfos = roleinfoService.queryRoleinfoAll();
		request.setAttribute("roles", roleinfos);
		request.setAttribute("userinfo", userinfo);
		return "userinfo/userinfoEdit";
	}

	@RequestMapping("executeEdit")
	@ResponseBody
	private synchronized Message executeEdit(Userinfo userinfo) {
		message = new Message();
		effectRow = userinfoService.modifyUserinfoByPrimaryKey(userinfo);
		message.setEffectRow(effectRow);
		return message;
	}

	@RequestMapping("verifyUsername")
	@ResponseBody
	private synchronized Message verifyUsername(String username) {
		message = new Message();
		userinfo = userinfoService.querySingleUserinfoByUsername(username);
		if (userinfo != null) {
			System.out.println("userinfo controller userinfo" + userinfo);
			effectRow = 1;
		} else {
			effectRow = 0;
		}
		message.setEffectRow(effectRow);
		return message;
	}

}
