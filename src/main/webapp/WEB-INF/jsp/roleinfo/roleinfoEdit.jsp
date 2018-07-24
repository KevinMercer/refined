<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/roleinfo.js"></script>
<title>编辑角色信息</title>
</head>
<body>
	<form id="editForm" name="editForm">
		<table class="addTable">
			<tr>
				<td class="infoTd"><span>请输入角色信息：</span></td>
				<td class="inputTd"><input type="text" name="roleName" id="roleName" class="form-control" value="${requestScope.roleinfo.roleName }" /></td>
				<td class="inputTd" style="width: 200px;"><span id="tipSpan_add"></span></td>
			</tr>
			<tr>
				<td colspan="3"><br />
				<br /></td>
			</tr>
			<tr>
				<td class="infoTd"><span>请输入角色描述：</span></td>
				<td class="inputTd"><input type="text" name="roleDesc" id="roleDesc" class="form-control" value="${requestScope.roleinfo.roleDesc }" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br />
				<br /></td>
			</tr>
			<tr>
				<td class="inputTd"><button type="button" id="submitEdit" name="submitEdit" class="btn btn-success">提交修改</button></td>
				<td class="infoTd"><input type="button" value="取消修改" name="cancelEdit" class="btn btn-danger" id="cancelEdit" /></td>
				<td></td>
			</tr>
		</table>
		<input type="hidden" readonly="readonly" value="${requestScope.roleinfo.roleId }" id="roleId" name="roleId" class="form-control" />
		<input type="hidden" id="oldname" name="oldname" readonly="readonly" value="${requestScope.roleinfo.roleName }"/>
	</form>
</body>
</html>