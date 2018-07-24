<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/permission.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ui/css/mycss.css" />
<title>权限修改</title>
</head>
<body>
	<form id="editForm" method="post" name="addForm">
		<table class="addTable">
			<tr>
				<td class="infoTd">权限名称：</td>
				<td class="inputTd" style="width: 300px;"><input type="text" class="form-control" name="pername" id="pername" value="${permission.pername }" /></td>
				<td class="inputTd" style="width: 100px;"><span id="tipSpan"></span></td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<td class="infoTd">权限地址：</td>
				<td class="inputTd"><input type="text" class="form-control" name="url" id="url" value="${permission.url }" /></td>
				<td class="inputTd"></td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<td class="infoTd">权限ajax：</td>
				<td class="inputTd"><input type="text" class="form-control" name="ajaxPath" id="ajaxPath" value="${permission.ajaxPath }" /></td>
				<td class="inputTd"></td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<td class="infoTd">请选择父类权限：</td>
				<td class="inputTd"><select class="form-control" name="parentid" id="parentid">
						<option>无父类权限(根权限)</option>
						<c:forEach items="${requestScope.permissions }" var="parentper">
							<option value="${parentper.perid }"
								<c:if test="${parentper.perid eq permission.parentid }"> selected="selected" </c:if> >${parentper.pername }</option>
							</c:forEach>
					</select>
				</td>
				<td class="inputTd"></td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<td class="infoTd"><button type="button" name="updateBtn" id="updateBtn" class="btn btn-success">提交修改</button></td>
				<td class="infoTd"><input type="reset" name="cancelBtn" id="cancelBtn" class="btn btn-danger" value="取消修改" /></td>
				<td class="inputTd"></td>
			</tr>
		</table>
		<input type="hidden" readonly="readonly" name="perid" id="perid" value="${permission.perid }" />
		<input type="hidden" readonly="readonly" name="isParent" id="isParent" value="${permission.isParent }" />
		<input type="hidden"	readonly="readonly" name="oldParent" id="oldParent" value="${permission.parentid }" />	
		<input type="hidden" name="oldname" id="oldname" readonly="readonly" value="${permission.pername}"/>
	</form>
</body>
</html>