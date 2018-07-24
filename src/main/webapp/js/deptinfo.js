/**
 * 
 */
var deptinfoTable;

function createDeptinfoTable() {
	deptinfoTable = $("#deptinfoTable").bootstrapTable({
		url : "/Refined/deptinfo/deptinfoData.do",
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
			field : "deptno",
			title : "部门编号"
		}, {
			field : "deptname",
			title : "部门名称"
		}, {
			field : "manager",
			title : "负责人工号",
			visible : false
		}, {
			field : "empinfo.empname",
			title : "部门负责人"
		}, {
			field : "member",
			title : "部门人数"
		}, {
			field : "deptdesc",
			title : "部门简述"
		}, {
			field : "empinfo.telephone",
			title : "负责人电话"
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

function verifyDeptForm() {
	if ($("#deptname").val() == "") {
		bootbox.alert("请填写部门名称！");
		return false;
	}
	return true;
}

function addDept() {
	$.ajax({
		url : "/Refined/deptinfo/addDeptinfo.do",
		dataType : "text",
		type : "post",
		success : function(data) {
			bootbox.dialog({
				title : "新建部门",
				message : data
			});
		}
	});
}

function executeAdd() {
	if (verifyProductForm()) {
		$.ajax({
			url : "/Refined/deptinfo/executeAdd.do",
			dataType : "json",
			type : "post",
			data : $("#addDeptinfoForm").serialize(),
			success : function(data) {
				var effectRow = parseInt(data.effectRow);
				if (effectRow > 0) {
					$(":button[name='refresh']").click();
					$("#removeDept").prop("disabled", true);
					$("#editDept").prop("disabled", true);
					$(".bootbox-close-button").click();
				} else {
					bootbox.alert("添加失败。");
				}
			}
		});
	}
}

function editDept() {
	var selectObj = JSON.stringify(deptinfoTable.bootstrapTable('getSelections'));
	var res = JSON.parse(selectObj);
	var deptno = res[0]["deptno"];
	$.ajax({
		url : "/Refined/deptinfo/editDeptinfo.do",
		dataType : "text",
		type : "post",
		data : {
			deptno : deptno
		},
		success: function (data) {
			bootbox.dialog({
				title : "编辑信息",
				message : data
			});
		}
	});
}

function executeEdit() {
	if(verifyDeptForm()){
		$.ajax({
			url : "/Refined/deptinfo/executeEdit.do",
			dataType : "json",
			type : "post",
			data : $("#editDeptinfoForm").serialize(),
			success : function(data) {
				var effectRow = parseInt(data.effectRow);
				if (effectRow > 0) {
					$(":button[name='refresh']").click();
					$("#removeDept").prop("disabled", true);
					$("#editDept").prop("disabled", true);
					$(".bootbox-close-button").click();
				} else {
					bootbox.alert("修改失败。");
				}
			}
		});
	}
}

function removeDept() {
	bootbox.confirm({
		message : "您正在做一个危险的动作：你将要解散一些重要的部门，请确认是否继续？",
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
				var selectObj = JSON.stringify(deptinfoTable.bootstrapTable('getSelections'));
				var res = JSON.parse(selectObj);
				var deptnos = "";
				for (var i = 0; i < res.length; i++) {
					deptnos += res[i]["deptno"] + ", ";
				}
				deptnos = deptnos.substr(0, deptnos.length - 2);
				$.ajax({
					url : "/Refined/deptinfo/removeDept.do",
					dataType : "json",
					type : 'post',
					data : {
						deptnos : deptnos
					},
					success : function(data) {
						var effectRow = parseInt(data.effectRow);
						if (effectRow > 0) {
							$(":button[name='refresh']").click();
							$("#removeDept").prop("disabled", true);
							$("#editDept").prop("disabled", true);
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
	var $table = $("#deptinfoTable");
	var $remove = $("#removeDept");
	var $edit = $("#editDept");
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
	if (deptinfoTable == null) {
		createDeptinfoTable();
		$("#addDept").click(function() {
			addDept();
		});
		$("#editDept").click(function() {
			editDept();
		});
	}
	$("#submitDeptBtn").click(function() {
		executeAdd();
	});
	$("#editDeptBtn").click(function() {
		executeEdit();
	});
	$("#removeDept").click(function() {
		removeDept();
	});
});