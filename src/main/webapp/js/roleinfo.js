/**
 * 
 */
var dataTable;
var key = "";
$(document).ready(function() {
	if (dataTable == null) {
		createDataTable();
		$("#addRoleinfo").click(function() {
			addRoleinfo();
		});
	}
	$("#submitAdd").click(function() {
		doAdd();
	});
	$("#submitEdit").click(function() {
		doModify();
	});
	$("#cancelEdit").click(function() {
		$(".bootbox-close-button").click();
	});
	$("#removeBatch").click(function() {
		deleteBatch();
	});
	$("#searchStr").blur(function() {
		key = $("#searchStr").val();
		if (dataTable != null) {
			dataTable.destroy();
		}
		createDataTable(key);
	});
	$("#clearSearch").click(function() {
		key = "";
		if (dataTable != null) {
			dataTable.destroy();
		}
		createDataTable(key);
	});
	$("#searchRoleinfo").click(function() {
		key = $("#searchStr").val();
		if (dataTable != null) {
			dataTable.destroy();
		}
		createDataTable(key);
	});
	$("#roleName").blur(function() {
		verifyRolename();
	});
});

function deleteBatch() {
	var roleChecked = $(":checkbox[name='checkId']:checked");
	var len = roleChecked.length;
	if (len == 0) {
		bootbox.alert("请务必选择一个以上的角色以删除！");
		return null;
	}
	bootbox.confirm({
		message : "您正在做一个危险的动作：你将要删除多个角色的信息，请确认是否继续？",
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
				var roleId = "";
				roleChecked.each(function() {
					roleId = roleId + $(this).val() + ", ";
				});
				roleId = roleId.substring(0, roleId.length - 2);
				$.ajax({
					url : "/Refined/roleinfo/executeRemoveBatch.do",
					type : "post",
					dataType : "json",
					data : {
						"roleIds" : roleId
					},
					success : function(data) {
						if ("0" == data.effectRow) {
							bootbox.alert("数据库异常，删除失败");
						} else {
							bootbox.alert("删除成功！");
							dataTable.draw(true);
							$(".bootbox-close-button").click();
						}
					}
				});
			}
		}
	})
}

function formValidate() {
	var rolename = $("#roleName").val();
	if (rolename == "") {
		bootbox.alert("角色名不能为空！");
		return false;
	}
	return true;
}

function verifyRolename() {
	var mark = false;
	if ($("#oldname").val() != "") {
		mark = ($("#oldname").val() == $("#roleName").val());
	} else {
		mark = false;
	}
	if (!mark) {
		if ($("#roleName").val() == "") {
			$("#tipSpan_add").html("角色名不能为空！");
			$("#tipSpan_add").css({
				color : "red"
			});
		} else {
			$.ajax({
				url : "verifyRoleinfo.do",
				type : 'post',
				dataType : "json",
				data : {
					roleName : $("#roleName").val()
				},
				success : function(data) {
					var effectRow = parseInt(data.effectRow);
					if (effectRow == 1) {
						$("#tipSpan_add").html("角色名已存在！");
						$("#tipSpan_add").css({
							color : "red"
						});
						mark = false;
					} else {
						$("#tipSpan_add").html("角色名可用");
						$("#tipSpan_add").css({
							color : "green"
						});
						mark = true;
					}
				}
			});
		}
	} else {
		$("#tipSpan_add").html("");
	}
	if ($("#tipSpan_add").html() == "" || $("#tipSpan_add").html() == "角色名可用") {
		return true;
	} else {
		return false;
	}
}

function distribute(data) {
	$.ajax({
		url : "/Refined/roleinfo/distributePermission.do",
		type : "post",
		dataType : "text",
		data : {
			roleId : data
		},
		success : function(message) {
			bootbox.dialog({
				title : "为角色分配权限",
				message : message
			});
		}
	});
}

function addRoleinfo() {
	$.ajax({
		url : "/Refined/roleinfo/roleinfoAdd.do",
		dataType : "text",
		type : "post",
		success : function(message) {
			bootbox.dialog({
				"title" : "添加角色",
				"message" : message
			});
		}
	});
}

function queryPermission(data) {
	$.ajax({
		url : "/Refined/roleinfo/rolepermission.do",
		dataType : "text",
		type : "post",
		data : {
			roleId : data
		},
		success : function(message) {
			bootbox.dialog({
				title : "查询权限",
				message : message
			});
		}
	});
}

function doAdd() {
	if (formValidate() && ($("#tipSpan_add").html() == "" || $("#tipSpan_add").html() == "角色名可用")) {
		$.ajax({
			url : "/Refined/roleinfo/executeAdd.do",
			dataType : "json",
			type : "post",
			data : $("#addForm").serialize(),
			success : function(data) {
				var effectRow = parseInt(data.effectRow);
				if (effectRow >= 1) {
					dataTable.draw(true);
					$(".bootbox-close-button").click();
				} else if (effectRow == 0) {
					bootbox.alert("数据插入失败！错误代码：000。数据库异常，请联系你的数据库管理员！");
				} else {
					bootbox.alert("数据插入失败！错误代码：001。服务器异常，请稍后重试！");
				}
			}
		});
	}
}

function deleteRole(data) {
	bootbox.confirm({
		message : "你确定要删除该数据吗？",
		buttons : {
			confirm : {
				label : "确定",
				className : "btn btn-success"
			},
			cancel : {
				label : "取消",
				className : "btn btn-danger"
			}
		},
		callback : function(result) {
			if (result) {
				$.ajax({
					url : "/Refined/roleinfo/executeRemove.do",
					type : "post",
					dataType : "json",
					data : {
						roleId : data
					},
					success : function(result) {
						var effectRow = parseInt(result.effectRow);
						if (effectRow >= 1) {
							dataTable.draw(true);
							$(".bootbox-close-button").click();
						} else if (effectRow == 0) {
							bootbox.alert("数据删除失败！错误代码：000。数据库异常，请联系你的数据库管理员。");
						} else if (effectRow == -1) {
							bootbox.alert("数据删除失败！错误代码：002。该角色下还有用户，无法删除！");
						} else {
							bootbox.alert("数据删除失败！错误代码：001。服务器异常，请稍后重试！");
						}
					}
				});
			}
		}
	});
}

function modifyRole(data) {
	$.ajax({
		url : "/Refined/roleinfo/roleinfoEdit.do",
		type : "post",
		dataType : "text",
		data : {
			roleId : data
		},
		success : function(message) {
			bootbox.dialog({
				title : "修改角色信息",
				message : message
			});
		}
	});
}

function doModify() {
	if (formValidate() && ($("#tipSpan_add").html() == "" || $("#tipSpan_add").html() == "角色名可用")) {
		$.ajax({
			url : "/Refined/roleinfo/executeEdit.do",
			type : "post",
			dataType : "json",
			data : $("#editForm").serialize(),
			success : function(data) {
				var effectRow = parseInt(data.effectRow);
				if (effectRow >= 1) {
					dataTable.draw(true);
					$(".bootbox-close-button").click();
				} else if (effectRow == 0) {
					bootbox.alert("数据修改失败！错误代码：000。数据库异常，请联系你的数据库管理员！");
				} else if (effectRow == -1) {
					bootbox.alert("数据删除失败！错误代码：002。该角色下还有用户，无法删除！");
				} else {
					bootbox.alert("数据删除失败！错误代码：001。服务器异常，请稍后重试！");
				}
			}
		});
	}
}

function createDataTable(key) {
	dataTable = $("#roleinfoTable").DataTable({
		searching : false,
		ordering : false,
		serverSide : true,
		"bPaginate" : true,
		"bJQueryUI" : false,
		"sPaginationType" : "full_numbers",
		"aLengthMenu" : [ [ 5, 10, 20, -1 ], [ 5, 10, 20, "显示所有" ] ],
		language : {
			url : "../plugins/datatable/Chinese.json"
		},
		ajax : {
			url : "/Refined/roleinfo/roleinfoData.do",
			dataSrc : "data",
			data : {
				key : key
			}
		},
		columns : [ {
			data : "roleId",
			render : function(data, type, row) {
				return "<input type='checkbox' name='checkId' value='" + data + "'/>";
			}
		}, {
			data : "roleName"
		}, {
			data : "roleDesc"
		}, {
			data : "roleId",
			render : function(data, type, row) {
				return "<button onclick='queryPermission(" + data + ")' class='btn btn-info'>查看权限</button><button onclick='distribute(" + data + ")' class='btn btn-success'>分配权限</button><button onclick='modifyRole(" + data + ")' class='btn btn-warning'>修改角色</button><button onclick='deleteRole(" + data + ")' class='btn btn-danger'>删除角色</button>";
			}
		} ]
	});
}