<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/zTree/zTree_v3-3.5.29/css/demo.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/zTree/zTree_v3-3.5.29/css/zTreeStyle/zTreeStyle.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/bootstrap/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ui/css/mycss.css" />
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/bootstrap/bootbox.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/zTree/zTree_v3-3.5.29/js/jquery.ztree.core.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/zTree/zTree_v3-3.5.29/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/zTree/zTree_v3-3.5.29/js/jquery.ztree.exedit.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/rolepermission.js"></script>
<title>权限查询</title>
</head>
<body>
	<div class="content_wrap">
		<div class="zTreeDemoBackground left">
			<ul id="queryPermission" class="ztree"></ul>
		</div>
	</div>
	<input type="hidden" readonly="readonly" id="roleId" name="roleId" value="${requestScope.roleId }" />
</body>
</html>