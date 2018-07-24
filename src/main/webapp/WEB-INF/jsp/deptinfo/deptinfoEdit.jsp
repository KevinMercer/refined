<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/deptinfo.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/datepicker/My97DatePicker/WdatePicker.js"></script>
<title>新建部门</title>
</head>
<body>
	<form id="editDeptinfoForm" method="post" name="editDeptinfoForm">
		<table class="addTable">
			<tr>
				<td class="infoTd"><span>部门名称：</span></td>
				<td class="inputTd" style="width: 200px;"><input type="text" id="deptname" name="deptname" value="${requestScope.deptinfo.deptname }" class="form-control" /></td>
				<td><span id="tipSpan_acc" style="width: 100px;"></span></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>部门简述：</span></td>
				<td class="inputTd"><input id="deptdesc" type="text" name="deptdesc" value="${requestScope.deptinfo.deptname }" class="form-control" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>指定负责人：</span></td>
				<td class="inputTd"><select name="manager" class="form-control">
						<c:forEach items="${requestScope.empinfos }" var="empinfos">
							<option value="${empinfos.empno }" <c:if test="${empinfos.empno eq requestScope.deptinfo.manager }"> selected="selected" </c:if> >${empinfos.empname }</option>
						</c:forEach>
				</select></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="inputTd"><input type="button" id="editDeptBtn" name="editDeptBtn" value="提交修改" class="btn btn-success" /></td>
				<td class="infoTd"><input type="button" name="cancelDeptBtn" id="cancelDeptBtn" value="取消修改" class="btn btn-warning" />
				<td></td>
			</tr>
		</table>
		<input type="hidden" id="oldname" name="oldname" readonly="readonly" value="" />
		<input type="hidden" id="deptno" name="deptno" readonly="readonly" value="${requestScope.deptinfo.deptno }" />
	</form>
</body>
</html>