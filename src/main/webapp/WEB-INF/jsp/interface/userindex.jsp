<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/bootstrap/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/zTree/zTree_v3-3.5.29/css/zTreeStyle/zTreeStyle.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ui/css/component.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ui/css/demo.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ui/css/normalize.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ui/css/mycss.css">
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/bootstrap/bootbox.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/zTree/zTree_v3-3.5.29/js/jquery.ztree.core.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/zTree/zTree_v3-3.5.29/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/zTree/zTree_v3-3.5.29/js/jquery.ztree.exedit.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/interface.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/login.js"></script>
<title>欢迎光临</title>
</head>
<body class="easyui-layout">
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="">山顶洞科技</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="${sessionScope.homePage }">首页 <span class="sr-only">(current)</span></a></li>
					<li class="dropdown"><a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">快速跳转 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="">产品管理</a></li>
							<li><a href="">供应商管理</a></li>
							<li><a href="">订单管理</a></li>
							<!-- <li role="separator" class="divider"></li> -->
							<li><a href="">雇员管理</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="">管理员管理</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left" id="navForm">
					<!-- <button type="reset" class="btn btn-warning" id="clearSearch">清空搜索框</button>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="例如：管理员" id="searchStr">
					</div>
					<button type="button" class="btn btn-success" id="searchRoleinfo">搜索</button>
					<button type="button" class="btn btn-info" id="addRoleinfo">添加角色</button>
					<button type="button" class="btn btn-danger" id="removeBatch">批量删除</button> -->
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="">欢迎用户${sessionScope.account.username }使用本系统</a></li>
					<li class="dropdown"><a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">管理员菜单<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="">个人中心</a></li>
							<li><a href="">更多功能</a></li>
							<li><a href="">暂未开放</a></li>
							<!-- <li role="separator" class="divider"></li> -->
							<li><a href="" id="logout">退出登录</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div data-options="region:'north',border:false" style="height:52px;background:#B3DFDA;padding:10px"></div>
	<div data-options="region:'west',split:true,title:'权限列表'" style="width:300px;padding:10px;overflow: auto;">
		<div class="content_wrap">
			<div class="zTreeDemoBackground left">
				<ul id="currentPermissions" class="ztree"></ul>
			</div>
		</div>
	</div>
	<div data-options="region:'east',split:true,collapsed:true,title:'个人中心'" style="width:350px;padding:10px;"></div>
	<div data-options="region:'south',border:false" style="height:50px;padding:10px;text-align: center;">
		<span class="copyright">Copyright &copy; 1997-2017 BruceHeCorporation All Rights Reserved 布鲁斯公司 版权所有</span>
	</div>
	<div data-options="region:'center',title:'操作中心'">
		<div class="container" style="margin: 30px 0px;width: 1000px;height: 400px;overflow: visible;">
			<div class="grid">
				<table style="height: auto;text-align: center; width: auto;margin: 20px auto;padding: 0px;">
					<tr>
						<c:forEach items="${sessionScope.permissionpic }" var="permission" varStatus="info">
							<c:if test="${permission.picname != null and permission.picname != ''}">
								<td>
									<figure class="effect-sadie" style="width: 200px;height: 200px;background-size: 200px 200px;background-image: url('${pageContext.request.contextPath }/ui/icon/${permission.picname }.jpg');">
										<%-- <img alt="${permission.pername }" src="${pageContext.request.contextPath }/ui/icon/${permission.picname }.jpg" class="protal"> --%>
										<figcaption>
											<h2>
												<span>${permission.pername }</span>
											</h2>
											<p></p>
											<a onclick="jumpToOperationPageUser('${permission.url}')">点击进入</a>
										</figcaption>
									</figure>
								</td>
							</c:if>
							<c:if test="${info['index'] mod 4 == 3 }">
					</tr>
					<tr>
						</c:if>
						</c:forEach>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>