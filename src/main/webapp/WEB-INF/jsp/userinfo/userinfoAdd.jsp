<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/userinfo.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/datepicker/My97DatePicker/WdatePicker.js"></script>
<title>添加用户</title>
</head>
<body>
	<form id="addUserForm" method="post" name="addUserForm">
		<table class="addTable">
			<tr>
				<td class="infoTd"><span>用户名：</span></td>
				<td class="inputTd" style="width: 200px;"><input type="text" id="username" name="username" value="" class="form-control" /></td>
				<td><span id="tipSpan_acc" style="width: 100px;"></span></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>登录密码：</span></td>
				<td class="inputTd"><input id="pass" type="password" name="password" value="" class="form-control" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>角色名：</span></td>
				<td class="inputTd"><select name="roleId" class="form-control">
						<c:forEach items="${requestScope.roles }" var="role">
							<option value="${role.roleId }">${role.roleName }</option>
						</c:forEach>
				</select></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>出生日期：</span></td>
				<td class="inputTd"><input id="borndate" type="text" name="borndate" id="borndate" value="" class="form-control" onclick="WdatePicker()" onfocus="WdatePicker()" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>真实姓名：</span></td>
				<td class="inputTd"><input id="realname" type="text" name="realname" value="" class="form-control" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>邮箱地址：</span></td>
				<td class="inputTd"><input id="email" type="text" name="email" value="" class="form-control" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="inputTd"><input type="button" id="submitUserBtn" name="submitUserBtn" value="提交新增" class="btn btn-success" /></td>
				<td class="infoTd"><input type="reset" name="resetBtn" value="重置信息" class="btn btn-warning" /></td>
				<td></td>
			</tr>
		</table>
		<input type="hidden" id="oldname" name="oldname" readonly="readonly" value=""/>
	</form>
</body>
</html>