<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/product.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/datepicker/My97DatePicker/WdatePicker.js"></script>
<title>新增产品</title>
</head>
<body>
	<form id="addProductForm" method="post" name="addProductForm">
		<table class="addTable">
			<tr>
				<td class="infoTd"><span>选择产品：</span></td>
				<td class="inputTd" style="width: 200px;"><select id="product_id_extract" name="product_id" class="form-control">
						<option value="0">请选择产品</option>
						<c:forEach items="${requestScope.product }" var="product">
							<option value="${product.product_id }">${product.product_name }</option>
						</c:forEach>
				</select></td>
				<td><span id="tipSpan_acc" style="width: 100px;"></span></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>出库数量：</span></td>
				<td class="inputTd"><input id="extract" type="text" name="extract" value="" class="form-control" /></td>
				<td><span id="number_tip"></span></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<c:if test="${sessionScope.account.roleid lt 15 }">
			<tr>
				<td class="infoTd"><span>出库描述：</span></td>
				<td class="inputTd"><input id="describe" type="text" name="describe" value="" class="form-control" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>选择抄送：</span></td>
				<td class="inputTd"><select id="copy" name="copy" class="form-control">
						<c:forEach items="${requestScope.empinfos }" var="empinfo">
							<option value="${empinfo.empno }">${empinfo.empname }</option>
						</c:forEach>
				</select></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			</c:if>
			<tr>
				<c:if test="${sessionScope.account.roleid lt 15 }">

				</c:if>
				<td class="inputTd"><input type="button" id="extractProductBtn" name="extractProductBtn" value="提交出库" class="btn btn-success" /></td>
				<td class="infoTd"><input type="reset" name="resetBtn" value="重置信息" class="btn btn-warning" /></td>
				<td></td>
			</tr>
		</table>
		<input type="hidden" id="oldname" name="oldname" readonly="readonly" value="" />
	</form>
</body>
</html>