<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta charset="UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<title>湖南山顶洞科技有限公司</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
<meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
<meta name="author" content="Codrops" />
<!-- <link rel="shortcut icon" href="../favicon.ico"> -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/simplelogin/css/demo.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/simplelogin/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/simplelogin/css/animate-custom.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plugins/bootstrap/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ui/css/mycss.css" />
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/plugins/bootstrap/bootbox.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/login.js"></script>
</head>
<body>
	<div class="container">
		<!-- Codrops top bar -->
		<div class="codrops-top">
			<!-- <a href=""> <strong>&laquo; Previous Demo: </strong>Responsive Content Navigator
			</a> <span class="right"> <a href=" http://tympanus.net/codrops/2012/03/27/login-and-registration-form-with-html5-and-css3/"> <strong>Back to the Codrops Article</strong>
			</a>
			</span> -->
			<div class="clr"></div>
		</div>
		<!--/ Codrops top bar -->
		<!-- <header>
			<h1>
				Login and Registration Form <span>with HTML5 and CSS3</span>
			</h1>
			<nav class="codrops-demos">
				<span>Click <strong>"Join us"</strong> to see the form switch
				</span> <a href="index.html" class="current-demo">Demo 1</a> <a href="index2.html">Demo 2</a> <a href="index3.html">Demo 3</a>
			</nav>
		</header> -->
		<section>
			<div id="container_demo">
				<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
				<div id="wrapper">
					<div id="login" class="animate form">
						<form id="empLoginForm">
							<h1><span class="nromalTitle">员工登录</span></h1>
							<p>
								<label for="usernamesignup" class="uname" data-icon="u"> 员工号 </label> <input id="empno" name="empno" required="required" type="text" placeholder="例如：2203" />
							</p>
							<!-- <p>
								<label for="emailsignup" class="youmail" data-icon="e"> Your email</label> <input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="" />
							</p> -->
							<p>
								<label for="passwordsignup" class="youpasswd" data-icon="p"> 登录密码 </label> <input id="emppass" name="emppass" required="required" type="password" placeholder="输入密码" />
							</p>
							<!-- <p>
								<label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password </label> <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password"
									placeholder="eg. X8df!90EO" />
							</p> -->
							<p class="signin button">
								<input type="button" value="登录" id="empLoginBtn" />
							</p>
							<p class="change_link">
								<!-- 用户登录入口<a href="#tologin" class="to_register"> 点击这里 </a> -->
							</p>
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>