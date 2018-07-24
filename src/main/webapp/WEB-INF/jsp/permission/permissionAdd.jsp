<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/permission.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ui/css/mycss.css" />
<title>权限添加</title>
</head>
<body>
	<form id="addForm" method="post" name="addForm">
		<table class="addTable">
			<tr>
				<td class="infoTd">权限名称：</td>
				<td class="inputTd" style="width: 300px;"><input type="text" class="form-control" name="pername" id="pername" /></td>
				<td class="inputTd" style="width: 100px;"><span id="tipSpan"></span></td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<td class="infoTd">权限地址：</td>
				<td class="inputTd"><input type="text" class="form-control" name="url" id="url" /></td>
				<td class="inputTd"></td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<td class="infoTd">权限ajax：</td>
				<td class="inputTd"><input type="text" class="form-control" name="ajaxPath" id="ajaxPath" /></td>
				<td class="inputTd"></td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<td class="infoTd"><button type="button" name="clickBtn" id="clickBtn" class="btn btn-success">提交添加</button></td>
				<td class="infoTd"><input type="reset" name="resetBtn" id="resetBtn" class="btn btn-danger" value="重置信息" /></td>
				<td class="inputTd"></td>
			</tr>
		</table>
		<input type="hidden" name="parentid" id="parentid" readonly="readonly" value="${requestScope.parentid }" /> <input type="hidden" name="isParent" id="isParent" readonly="readonly" value="0" />
		<input type="hidden" name="oldname" id="oldname" readonly="readonly" value=""/>
	</form>
</body>
</html>