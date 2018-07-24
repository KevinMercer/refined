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
				<td class="inputTd" style="width: 200px;"><select id="product_id_put" name="product_id" class="form-control">
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
				<td class="infoTd"><span>入库数量：</span></td>
				<td class="inputTd"><input id="put" type="text" name="put" value="" class="form-control" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="inputTd"><input type="button" id="putProductBtn" name="putProductBtn" value="提交入库" class="btn btn-success" /></td>
				<td class="infoTd"><input type="reset" name="resetBtn" value="重置信息" class="btn btn-warning" /></td>
				<td></td>
			</tr>
		</table>
		<input type="hidden" id="oldname" name="oldname" readonly="readonly" value="" />
	</form>
</body>
</html>