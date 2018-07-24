<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../frame/head_source.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ui/css/component.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ui/css/demo.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ui/css/normalize.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ui/css/mycss.css" />
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/interface.js"></script>
<title>员工管理</title>
</head>
<body>
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
						<input type="text" class="form-control" placeholder="例如：张三" id="searchStr">
					</div>
					<button type="button" class="btn btn-success" id="searchUserinfo">搜索</button>
					<button type="button" class="btn btn-info" id="addUserinfo">添加用户</button>
					<button type="button" class="btn btn-danger" id="removeBatch">批量删除</button> -->
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="">员工号：${sessionScope.account.empno } 员工姓名：${sessionScope.account.empname }</a></li>
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
	<div class="grid">
		<table style="height: auto;text-align: center; width: auto;margin: 20px auto;padding: 0px;">
			<tr>
				<td>
					<figure class="effect-sadie" style="width: 200px;height: 200px;background-size: 200px 200px;background-image: url('${pageContext.request.contextPath }/ui/icon/employeemanager.jpg');">
						<%-- <img alt="${permission.pername }" src="${pageContext.request.contextPath }/ui/icon/${permission.picname }.jpg" class="protal"> --%>
						<figcaption>
							<h2>
								<span>库存日志查询</span>
							</h2>
							<p></p>
							<a onclick="jumpToOperationPageEmp('/Refined/repository/storageList.do')">点击进入</a>
						</figcaption>
					</figure>
				</td>
				<td>
					<figure class="effect-sadie" style="width: 200px;height: 200px;background-size: 200px 200px;background-image: url('${pageContext.request.contextPath }/ui/icon/approve.jpg');">
						<%-- <img alt="${permission.pername }" src="${pageContext.request.contextPath }/ui/icon/${permission.picname }.jpg" class="protal"> --%>
						<figcaption>
							<h2>
								<span>出库审批</span>
							</h2>
							<p></p>
							<a onclick="jumpToOperationPageEmp('/Refined/repository/approveList.do')">点击进入</a>
						</figcaption>
					</figure>
				</td>
			</tr>
		</table>
	</div>
	<p class="copyright" style="margin-bottom: 30px;">Copyright &copy; 1997-2017 BruceHeCorporation All Rights Reserved 布鲁斯公司 版权所有</p>
</body>
</html>