<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				<li><a href="">员工号：${sessionScope.account.empno } 员工姓名：${sessionScope.account.empname }</a></li>
				<li class="dropdown"><a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">管理员菜单<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="">个人中心</a></li>
						<li><a href="">更多功能</a></li>
						<li><a href="">暂未开放</a></li>
						<!-- <li role="separator" class="divider"></li> -->
						<li><a href="" id="emplogout">退出登录</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
<div data-options="region:'north',border:false" style="height:52px;background:#B3DFDA;padding:10px"></div>
<div data-options="region:'west',split:true,title:'个人中心'" style="width:300px;padding:10px;overflow: auto;">
	<table class="personTable">
		<tr>
			<td><span class="personFont">员工编号：</span></td>
			<td><span class="personFont">${sessionScope.account.empno }</span></td>
		</tr>
		<tr>
			<td><span class="personFont">员工姓名：</span></td>
			<td><span class="personFont">${sessionScope.account.empname }</span></td>
		</tr>
		<tr>
			<td><span class="personFont">所属部门</span></td>
			<td><span class="personFont">${sessionScope.account.deptinfo.deptname }</span></td>
		</tr>
		<tr>
			<td><span class="personFont">所属职位：</span></td>
			<td><span class="personFont">${sessionScope.account.roleinfo.roleName }</span></td>
		</tr>
		<tr>
			<td><span class="personFont">联系电话：</span></td>
			<td><span class="personFont">${sessionScope.account.telephone }</span></td>
		</tr>
		<tr>
			<td><span class="personFont">工作邮箱：</span></td>
			<td><span class="personFont">${sessionScope.account.email }</span></td>
		</tr>
	</table>
</div>
<div data-options="region:'east',split:true,collapsed:true,title:'个人中心'" style="width:350px;padding:10px;"></div>
<div data-options="region:'south',border:false" style="height:50px;padding:10px;text-align: center;">
	<span class="copyright">Copyright &copy; 1997-2017 BruceHeCorporation All Rights Reserved 布鲁斯公司 版权所有</span>
</div>