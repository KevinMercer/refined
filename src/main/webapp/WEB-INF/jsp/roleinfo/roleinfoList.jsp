<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../frame/head_source.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/datatable/media/css/jquery.dataTables.css" />
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/datatable/media/js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/roleinfo.js"></script>
<title>角色列表</title>
</head>
<body class="easyui-layout">
	<%@include file="../frame/head.jsp"%>
	<div data-options="region:'center',title:'操作中心'">
		<div class="container" style="margin: 30px 0px;width: 1000px;height: 400px;overflow: visible;">
			<div id="bodyDiv" class="bodyFrameDiv">
				<div class="tableDiv">
					<table id="roleinfoTable" class="table-hover table-bordered table-striped">
						<thead>
							<tr>
								<th><span>选择</span></th>
								<th><span>角色名称</span></th>
								<th><span>角色明细</span></th>
								<th><span>相关操作</span></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
