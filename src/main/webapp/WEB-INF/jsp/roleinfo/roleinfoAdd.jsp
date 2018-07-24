<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/roleinfo.js"></script>
<title>添加角色</title>
</head>
<body>
	<form id="addForm" name="addForm">
		<table class="addTable">
			<tr>
				<td class="infoTd"><span>请输入角色信息：</span></td>
				<td class="inputTd" style="width: 200px;"><input type="text" name="roleName" id="roleName" class="form-control" /></td>
				<td class="inputTd" style="width: 100px;">
					<span id="tipSpan_add"></span>
				</td>
			</tr>
			<tr>
				<td colspan="3"><br /><br /></td>
			</tr>
			<tr>
				<td class="infoTd"><span>请输入角色描述：</span></td>
				<td class="inputTd"><input type="text" name="roleDesc" id="roleDesc" class="form-control" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br /><br /></td>
			</tr>
			<tr>
				<td class="inputTd"><button type="button" id="submitAdd" name="submitAdd" class="btn btn-success">提交添加</button></td>
				<td class="infoTd"><input type="reset" value="重置信息" name="reset" class="btn btn-danger"/></td>
				<td></td>
			</tr>
		</table>
		<input type="hidden" id="oldname" name="oldname" readonly="readonly" value=""/>
	</form>
</body>
</html>