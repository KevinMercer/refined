<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/employee.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/datepicker/My97DatePicker/WdatePicker.js"></script>
<title>新增员工</title>
</head>
<body>
	<form id="addEmpForm" method="post" name="addEmpForm">
		<table class="addTable">
			<tr>
				<td class="infoTd"><span>员工姓名：</span></td>
				<td class="inputTd" style="width: 200px;"><input type="text" id="empname" name="empname" value="" class="form-control" /></td>
				<td><span id="tipSpan_acc" style="width: 100px;"></span></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>登录密码：</span></td>
				<td class="inputTd"><input id="password" type="password" name="password" value="" class="form-control" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>所属部门：</span></td>
				<td class="inputTd"><select name="deptno" class="form-control">
						<c:forEach items="${requestScope.deptinfos }" var="dept">
							<option value="${dept.deptno }">${dept.deptname }</option>
						</c:forEach>
				</select></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>所属职位：</span></td>
				<td class="inputTd"><select name="roleid" class="form-control">
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
				<td class="infoTd"><span>雇佣日期：</span></td>
				<td class="inputTd"><input id="hiredate" type="text" name="hiredate" value="" class="form-control" onclick="WdatePicker()" onfocus="WdatePicker()" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>所属上司：</span></td>
				<td class="inputTd"><select name="superior" class="form-control">
					<c:forEach items="${requestScope.empinfos }" var="emp">
							<option value="${emp.empno }">${emp.empname }</option>
						</c:forEach>
				</select></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>联系电话：</span></td>
				<td class="inputTd"><input id="telephone" type="text" name="telephone" value="" class="form-control" /></td>
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
				<td class="inputTd"><input type="button" id="submitEmpBtn" name="submitEmpBtn" value="提交新增" class="btn btn-success" /></td>
				<td class="infoTd"><input type="reset" name="resetBtn" value="重置信息" class="btn btn-warning" /></td>
				<td></td>
			</tr>
		</table>
		<input type="hidden" id="oldname" name="oldname" readonly="readonly" value="" />
	</form>
</body>
</html>