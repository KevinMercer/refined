<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../frame/head_source.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/zTree/zTree_v3-3.5.29/css/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/zTree/zTree_v3-3.5.29/js/jquery.ztree.core.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/zTree/zTree_v3-3.5.29/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/zTree/zTree_v3-3.5.29/js/jquery.ztree.exedit.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/permission.js"></script>
<title>权限列表</title>
<style type="text/css">
.ztree li span.button.add {
	margin-left: 2px;
	margin-right: -1px;
	background-position: -144px 0;
	vertical-align: top;
	*vertical-align: middle
}
</style>
</head>
<body class="easyui-layout">
	<%@include file="../frame/head.jsp"%>
	<div data-options="region:'center',title:'操作中心'">
	<div class="content_wrap">
		<div class="zTreeDemoBackground left">
			<ul id="treeDemo" class="ztree"></ul>
		</div>
	</div>
	</div>
</body>
</html>
