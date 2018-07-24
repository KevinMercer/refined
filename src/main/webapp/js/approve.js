/**
 * 
 */

var approveTable;

function createApproveTable() {
	approveTable = $("#approveTable").bootstrapTable({
		url : "/Refined/repository/approveData.do",
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
		columns : [ {
			title : "选择",
			checkbox : true
		}, {
			field : "extract_no",
			title : "审批单编号"
		}, {
			field : "empno",
			title : "送审人编号",
			visible : false
		}, {
			field : "empname",
			title : "操作员工"
		}, {
			field : "product_id",
			title : "操作产品编号",
			visible : false
		}, {
			field : "product_name",
			title : "操作产品名称"
		}, {
			field : "extract_date",
			title : "送审时间",
			formatter : function(value, row, index) {
				return changeDateFormat(value)
			}
		}, {
			field : "extract",
			title : "操作数量"
		} ]
	});
}

function changeDateFormat(cellval) {
	return cellval.split(" ")[0];
}


$(document).ready(function() {
	var $table = $("#approveTable");
	var $done = $("#done");
	var $undone = $("#undone");
	$table.on('check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table', function() {
		var len = $table.bootstrapTable('getSelections').length;
		if (len == 1) {
			$undone.prop("disabled", false);
			$done.prop("disabled", false);
		} else {
			$undone.prop("disabled", true);
			$done.prop("disabled", true);
		}
	});
	if (approveTable == null) {
		createApproveTable();
	}
});