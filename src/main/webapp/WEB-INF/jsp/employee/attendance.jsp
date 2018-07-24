<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/bootstrap/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/bootstraptable/dist/bootstrap-table.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ui/css/mycss.css" />
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/bootstraptable/dist/bootstrap-table.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/bootstrap/bootbox.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/bootstraptable/dist/extensions/editable/bootstrap-table-editable.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/bootstraptable/dist/locale/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/login.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/employee.js"></script>
<style>
table {
	text-align: center
}
</style>
<title>人资假勤</title>
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
	<div id="bodyDiv" class="bodyFrameDiv">
		<div align="right">
			
		</div>
		<div align="center">
			<script language="javascript">
				var my = new Date();
			
				function showc() {
					var k = 1;
					var j = 1;
					var today;
					var tomonth;
					var theday = 1; //日期
					var max;
					var temp;
					var tempday; //这个月第一天的星期
					document.write("<b>" + my.getFullYear() + "-" + (my.getMonth() + 1) + "</b>");
					document.write("<table border='1' width='273' height='158'>");
					document.write("<tr>");
					document.write("<td height='23' width='39'><font color='red'>Sun</font></td>");
					document.write("<td height='23' width='39'>Mon</td>");
					document.write("<td height='23' width='39'>Tue</td>");
					document.write("<td height='23' width='39'>Wed</td>");
					document.write("<td height='23' width='39'>Thu</td>");
					document.write("<td height='23' width='39'>Fri</td>");
					document.write("<td height='23' width='39'>Sat</td>");
					document.write("</tr>");
					temp = my.getDate();
					my.setDate(1);
					//document.write (my.getDate());
					tempday = my.getDay(); //返回第一天是星期几
					my.setDate(temp);
					today = my.getDay(); //返回现在星期几
			
					switch ( (my.getMonth() + 1) ) {
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						max = 31;
						break;
					case 4:
					case 6:
					case 9:
					case 11:
						max = 30;
						break;
					default:
						max = 29; //这里没有考虑闰月！！
					//document.write (max);
					}
					for (k = 0; k < 6; k++) {
						document.write("<tr>");
						for (j = 0; j <= 6; j++) {
							document.write("<td height='23' width='39'>");
							if (j >= (tempday)) {
								tempday = 0; //设置为最小，相当于取消判断条件
								if (theday <= max) {
									document.write("<a title=" + my.getFullYear() + "-" + (my.getMonth() + 1) + "-" + theday + " target='_blank' href=detail.asp?date=" + theday + ">");
									if (theday == my.getDate())
										document.write("<font color='green'>[" + theday + "]</font></a>");
									else if (j == 0)
										document.write("<font color='red'>" + theday + "</font></a>");
									else
										document.write(theday + "</a>");
									theday++;
								}
							}
							document.write("</td>");
						}
						document.write("</tr>");
					}
					document.write("</table>");
				}
				showc();
			</script>
		</div>
	</div>
	<p class="copyright" style="margin-bottom: 30px;">Copyright &copy; 1997-2017 BruceHeCorporation All Rights Reserved 布鲁斯公司 版权所有</p>
</body>
</html>