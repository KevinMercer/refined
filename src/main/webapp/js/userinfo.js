/**
 * 
 */
var mybootTable;

function createStrapTable() {
	mybootTable = $('#userinfoTable').bootstrapTable({
		url : '/Refined/userinfo/userinfoData.do',
		cache : false,
		method : "post",
		contentType : "application/x-www-form-urlencoded",
		toolbar : '#toolbar',
		showToggle : true,
		striped : true,
		pagination : true,
		sortable : false,
		sidePagination : "server",
		pageNumber : 1,
		pageSize : 9,
		pageList : '[5, 9, 10, 25, 50, 100 , ALL]',
		search : true,
		clickToSelect : true,
		height : 500,
		showColumns : true,
		showRefresh : true,
		checkbox : true,
		minimumCountColumns : 2,
		clickToSelect : true,
		smartDisplay : true,
		strictSearch : false,
		queryParamsType : 'limit',
		queryParams : queryParams,
		columns : [ {
			title : "选择",
			checkbox : true
		}, {
			field : "userId",
			title : "用户编号",
			visible : false
		}, {
			field : 'username',
			title : '用户名称'
		}, {
			field : 'roleinfo.roleName',
			title : '所属角色'
		}, {
			field : 'borndate',
			title : '出生日期'
		}, {
			field : 'realname',
			title : '真实姓名'
		}, {
			field : 'email',
			title : '邮箱地址'
		} ]
	});
}

function removeUser() {
	bootbox.confirm({
		message : "您正在做一个危险的动作：你将要删除一些重要用户的信息，请确认是否继续？",
		buttons : {
			confirm : {
				label : "确定",
				className : "btn-success"
			},
			cancel : {
				label : "取消",
				className : "btn-danger"
			}
		},
		callback : function(result) {
			if (result) {
				var selectObj = JSON.stringify(mybootTable.bootstrapTable('getSelections'));
				var res = JSON.parse(selectObj);
				var userIds = "";
				for (var i = 0; i < res.length; i++) {
					userIds += res[i]["userId"] + ", ";
				}
				userIds = userIds.substr(0, userIds.length - 2);
				$.ajax({
					url : "/Refined/userinfo/executeRemove.do",
					dataType : "json",
					type : 'post',
					data : {
						userIds : userIds
					},
					success : function(data) {
						var effectRow = parseInt(data.effectRow);
						if (effectRow > 0) {
							$(":button[name='refresh']").click();
							$("#removeUser").prop("disabled", true);
							$("#editUser").prop("disabled", true);
						} else {
							bootbox.alert("删除失败，请稍后重试。");
						}
					}
				});
			}
		}
	});
}

function validate() {
	var borndate = $("#borndate").val();
	if (!/^((((19|20)\d{2})-(0?(1|[3-9])|1[012])-(0?[1-9]|[12]\d|30))|(((19|20)\d{2})-(0?[13578]|1[02])-31)|(((19|20)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-29))$/.test(borndate)) {
		bootbox.alert("请输入正确的日期格式！");
		return false;
	}
	if ($("#username").val() == "" || $("#pass").val() == "" || $("#realname").val() == "" || $("#email").val() == "") {
		bootbox.alert("请完善信息！");
		return false;
	}
	return true;
}

function verifyUsername() {
	var mark = false;
	if ($("#oldname").val() != "") {
		mark = ($("#oldname").val() == $("#username").val());
	}
	if (!mark) {
		if ($("#username").val() == "") {
			$("#tipSpan_acc").html("用户名不能为空！");
			$("#tipSpan_acc").css({
				color : "red"
			});
			mark = false;
			return mark;
		} else {
			$.ajax({
				url : "verifyUsername.do",
				type : "post",
				dataType : "json",
				data : {
					username : $("#username").val()
				},
				success : function(data) {
					var effectRow = parseInt(data.effectRow);
					if (effectRow >= 1) {
						$("#tipSpan_acc").html("用户名已存在！");
						$("#tipSpan_acc").css({
							color : "red"
						});
					} else {
						$("#tipSpan_acc").html("用户名可用！");
						$("#tipSpan_acc").css({
							color : "green"
						});
					}
				}
			});
		}
	} else {
		$("#tipSpan_acc").html("");
	}
	if ($("#tipSpan_acc").html() == "" || $("#tipSpan_acc").html() == "用户名可用！") {
		return true;
	} else {
		return false;
	}
}

function editUser() {
	var selectObj = JSON.stringify(mybootTable.bootstrapTable('getSelections'));
	var res = JSON.parse(selectObj);
	var userId = res[0]["userId"];
	$.ajax({
		url : "/Refined/userinfo/editUser.do",
		type : "post",
		dataType : "text",
		data : {
			userId : userId
		},
		success : function(message) {
			bootbox.dialog({
				title : "编辑信息",
				message : message
			});
		}
	});
}

function doEdit() {
	if (validate() && verifyUsername()) {
		$.ajax({
			url : "/Refined/userinfo/executeEdit.do",
			type : "post",
			dataType : "json",
			data : $("#editUserForm").serialize(),
			success : function(data) {
				var effectRow = parseInt(data.effectRow);
				if (effectRow > 0) {
					$(":button[name='refresh']").click();
					$("#removeUser").prop("disabled", true);
					$("#editUser").prop("disabled", true);
					$(".bootbox-close-button").click();
				} else {
					bootbox.alert("修改失败，请稍后重试！");
				}
			}
		});
	}
}

function addUser() {
	$.ajax({
		url : "/Refined/userinfo/addUser.do",
		dataType : "text",
		type : "post",
		success : function(message) {
			bootbox.dialog({
				title : "添加用户",
				message : message
			});
		}
	});
}

function doAddUser() {
	if (validate() && verifyUsername()) {
		$.ajax({
			url : "/Refined/userinfo/executeAdd.do",
			dataType : "json",
			type : "post",
			data : $("#addUserForm").serialize(),
			success : function(data) {
				var effectRow = parseInt(data.effectRow);
				if (effectRow > 0) {
					$(":button[name='refresh']").click();
					$("#removeUser").prop("disabled", true);
					$("#editUser").prop("disabled", true);
					$(".bootbox-close-button").click();
				} else {
					bootbox.alert("添加失败。");
				}
			}
		});
	}
}

var queryParams = function(params) {
	var temp = {
		pageSize : params.limit,
		pageNumber : params.offset,
		searchStr : params.search
	};
	return temp;
};

$(document).ready(function() {
	var $table = $("#userinfoTable");
	var $remove = $("#removeUser");
	var $edit = $("#editUser");
	$table.on('check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table', function() {
		var len = $table.bootstrapTable('getSelections').length;
		if (len >= 1) {
			if (len == 1) {
				$edit.prop("disabled", false);
			} else {
				$edit.prop("disabled", true);
			}
			$remove.prop("disabled", false);
		} else {
			$edit.prop("disabled", true);
			$remove.prop("disabled", true);
		}
	});
	if (mybootTable == null) {
		createStrapTable() ;
		$("#addUser").click(function() {
			addUser();
		});
		$edit.click(function() {
			editUser();
		});
		$remove.click(function() {
			removeUser();
		});
	}
	$("#submitUserBtn").click(function() {
		doAddUser();
	});
	$("#editUserBtn").click(function() {
		doEdit();
	});
	$("#username").blur(function() {
		verifyUsername();
	});
});