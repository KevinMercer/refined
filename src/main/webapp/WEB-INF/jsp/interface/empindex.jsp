<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../frame/head_source.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ui/css/component.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ui/css/demo.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ui/css/normalize.css">
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/interface.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/js/login.js"></script>
<title>欢迎光临</title>
</head>
<body class="easyui-layout">
	<%@include file="../frame/head.jsp" %>
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
											<a onclick="jumpToOperationPageEmp('${permission.url}')">点击进入</a>
										</figcaption>
									</figure>
								</td>
							</c:if>
							<c:if test="${(info['index'] +1) mod 4 == 0 }">
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
