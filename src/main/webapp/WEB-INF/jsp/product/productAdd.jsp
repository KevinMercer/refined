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
				<td class="infoTd"><span>产品名称：</span></td>
				<td class="inputTd" style="width: 200px;"><input type="text" id="product_name" name="product_name" value="" class="form-control" /></td>
				<td><span id="tipSpan_acc" style="width: 100px;"></span></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>首批产量：</span></td>
				<td class="inputTd"><input id="repository" type="text" name="repository" value="" class="form-control" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>产出时间：</span></td>
				<td class="inputTd"><input id="create_time" type="text" name="create_time" value="" class="form-control" onclick="WdatePicker()" onfocus="WdatePicker()" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>预计上市时间：</span></td>
				<td class="inputTd"><input id="market_time" type="text" name="market_time" value="" class="form-control" onclick="WdatePicker()" onfocus="WdatePicker()" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>产品简述：</span></td>
				<td class="inputTd"><input id="product_desc" type="text" name="product_desc" value="" class="form-control" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="infoTd"><span>是否启用：</span></td>
				<td class="inputTd">
					<select name="enable" class="form-control">
						<option value="0">停用</option>
						<option value="1">启用</option>
					</select>
				</td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><br> <br></td>
			</tr>
			<tr>
				<td class="inputTd"><input type="button" id="submitProductBtn" name="submitProductBtn" value="提交新增" class="btn btn-success" /></td>
				<td class="infoTd"><input type="reset" name="resetBtn" value="重置信息" class="btn btn-warning" /></td>
				<td></td>
			</tr>
		</table>
		<input type="hidden" id="oldname" name="oldname" readonly="readonly" value="" />
	</form>
</body>
</html>