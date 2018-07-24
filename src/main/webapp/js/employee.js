/**
 * 
 */
var empTable;

function createEmpTable() {
	empTable = $("#empinfoTable").bootstrapTable({
		url : "/Refined/empinfo/empinfoData.do",
		cache : false,
		method : "post",
		contentType : "application/x-www-form-urlencoded",
		toolbar : '#emptool',
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
		queryParamsType : 'limit',
		queryParams : queryParams,
		columns : [ {
			title : "选择",
			checkbox : true
		}, {
			field : "empno",
			title : "员工编号"
		}, {
			field : "empname",
			title : "员工姓名"
		}, {
			field : "deptno",
			title : "部门编号",
			visible : false
		}, {
			field : "deptinfo.deptname",
			title : "所属部门"
		}, {
			field : "roleid",
			title : "角色编号"
		}, {
			field : "roleinfo.roleName",
			title : "所属职位"
		}, {
			field : "superior",
			title : "上司编号",
			visible : false
		}, {
			field : "manager.empname",
			title : "所属上司"
		}, {
			field : "hiredate",
			title : "雇用日期"
		}, {
			field : "telephone",
			title : "联系电话"
		}, {
			field : "email",
			title : "邮箱地址"
		} ]
	});
}

var queryParams = function(params) {
	var temp = {
		pageSize : params.limit,
		pageNumber : params.offset,
		searchStr : params.search
	};
	return temp;
};

function verifyEmpForm() {
	if ($("#empname").val() == "") {
		bootbox.alert("请填写员工姓名");
		return false;
	}
	if ($("#password").val() == "") {
		bootbox.alert("请填写登陆密码");
		return false;
	}
	if ($("#hiredate").val() == "") {
		bootbox.alert("请填写雇佣日期");
		return false;
	}
	if ($("#telephone").val() == "" || !/^1[3|4|5|7|8][0-9]{9}$/.test($("#telephone").val())) {
		bootbox.alert("请填写正确的手机号码");
		return false;
	}
	if ($("#email").val() == "" || !/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test($("#email").val())) {
		bootbox.alert("请填写正确的邮箱地址");
		return false;
	}
	return true;
}

function addEmp() {
	$.ajax({
		url : "/Refined/empinfo/addEmp.do",
		dataType : "text",
		type : "post",
		success : function(data) {
			bootbox.dialog({
				title : "新增员工",
				message : data
			});
		}
	});
}

function executeAdd() {
	if (verifyEmpForm()) {
		$.ajax({
			url : "/Refined/empinfo/executeAdd.do",
			dataType : "json",
			type : "post",
			data : $("#addEmpForm").serialize(),
			success : function(data) {
				var effectRow = parseInt(data.effectRow);
				if (effectRow > 0) {
					$(":button[name='refresh']").click();
					$("#removeEmp").prop("disabled", true);
					$("#editEmp").prop("disabled", true);
					$(".bootbox-close-button").click();
				} else {
					bootbox.alert("添加失败。");
				}
			}
		});
	}
}

function editEmp() {
	var selectObj = JSON.stringify(empTable.bootstrapTable('getSelections'));
	var res = JSON.parse(selectObj);
	var empno = res[0]["empno"];
	$.ajax({
		url : "/Refined/empinfo/editEmp.do",
		dataType : "text",
		type : "post",
		data : {
			empno : empno
		},
		success : function(data) {
			bootbox.dialog({
				title : "编辑员工",
				message : data
			});
		}
	});
}

function executeEdit() {
	if (verifyEmpForm()) {
		$.ajax({
			url : "/Refined/empinfo/executeEdit.do",
			dataType : "json",
			type : "post",
			data : $("#editEmpForm").serialize(),
			success : function(data) {
				var effectRow = parseInt(data.effectRow);
				if (effectRow > 0) {
					$(":button[name='refresh']").click();
					$("#removeEmp").prop("disabled", true);
					$("#editEmp").prop("disabled", true);
					$(".bootbox-close-button").click();
				} else {
					bootbox.alert("修改失败。");
				}
			}
		});
	}
}

function removeEmp() {
	bootbox.confirm({
		message : "您正在做一个危险的动作：你将要删除一些重要的员工信息，请确认是否继续？",
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
				var selectObj = JSON.stringify(empTable.bootstrapTable('getSelections'));
				var res = JSON.parse(selectObj);
				var empnos = "";
				for (var i = 0; i < res.length; i++) {
					empnos += res[i]["empno"] + ", ";
				}
				empnos = empnos.substr(0, empnos.length - 2);
				$.ajax({
					url : "/Refined/empinfo/removeEmp.do",
					dataType : "json",
					type : 'post',
					data : {
						empnos : empnos
					},
					success : function(data) {
						var effectRow = parseInt(data.effectRow);
						if (effectRow > 0) {
							$(":button[name='refresh']").click();
							$("#removeEmp").prop("disabled", true);
							$("#editEmp").prop("disabled", true);
						} else {
							bootbox.alert("删除失败，请稍后重试。");
						}
					}
				});
			}
		}
	});
}

$(document).ready(function() {
	var $table = $("#empinfoTable");
	var $remove = $("#removeEmp");
	var $edit = $("#editEmp");
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
	if (empTable == null) {
		createEmpTable();
		$("#addEmp").click(function() {
			addEmp();
		});
		$("#editEmp").click(function() {
			editEmp();
		});
	}
	$("#submitEmpBtn").click(function() {
		executeAdd();
	});
	$("#editEmpBtn").click(function() {
		executeEdit();
	});
	$("#removeEmp").click(function () {
    	removeEmp();
    });
});