/**
 * 
 */



function verifyUser() {
	var username = $("#username").val();
	var password = $("#password").val();
	$.ajax({
		url : "/Refined/userinfo/login.do",
		type : "post",
		dataType : "json",
		data : {
			username : username,
			password : password
		},
		success : function(data) {
			var effectRow = data.effectRow;
			if (effectRow == 0) {
				bootbox.alert("用户名或者密码错误！");
			} else {
				location.href = "/Refined/userinfo/interface.do";
			}
		}
	});
}

function empLogin() {
	var empno = $("#empno").val();
	var password = $("#emppass").val();
	$.ajax({
		url : "/Refined/empinfo/login.do",
		type : "post",
		dataType : "json",
		data : {
			empno : empno,
			password : password
		},
		success : function(data) {
			var effectRow = data.effectRow;
			if (effectRow == 0) {
				bootbox.alert("员工号或者密码错误！");
			} else {
				location.href = "/Refined/empinfo/interface.do";
			}
		}
	});
}

function logout() {
	$.ajax({
		url : "/Refined/userinfo/logout.do",
		type : "post",
		dataType : "json",
		success : function(data) {
			location.href = "D/170719Maven/userinfo/closePage.do";
		}
	});
}

function emplogout() {
	$.ajax({
		url : "/Refined/userinfo/logout.do",
		type : "post",
		dataType : "json",
		success : function(data) {
			location.href = "D/170719Maven/userinfo/closePage.do";
		}
	});
}

$(document).ready(function() {
	$("#loginBtn").click(function() {
		verifyUser();
	});
	$("#logout").click(function() {
		logout();
	});
	$("#empLoginBtn").click(function() {
		empLogin();
	});
	$("#emplogout").click(function () {
		emplogout();
    });
});