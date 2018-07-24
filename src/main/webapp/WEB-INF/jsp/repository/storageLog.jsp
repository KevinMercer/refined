<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../frame/head_source.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/bootstraptable/dist/bootstrap-table.css" />
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/bootstraptable/dist/bootstrap-table.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/bootstraptable/dist/extensions/editable/bootstrap-table-editable.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/bootstraptable/dist/locale/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/repository.js"></script>
<title>库存日志</title>
</head>
<body class="easyui-layout">
	<%@include file="../frame/head.jsp"%>
	<div data-options="region:'center',title:'操作中心'">
		<div class="container" style="margin: 30px 0px;width: 1000px;height: 400px;overflow: visible;">
			<div id="bodyDiv" class="bodyFrameDiv">
				<div id="emptool">
					<button id="report" class="btn btn-info">
						<i class="glyphicon glyphicon-list-alt"></i> 出入库建议
					</button>
				</div>
				<table id="storageTable"></table>
			</div>
		</div>
	</div>
</body>
</html>