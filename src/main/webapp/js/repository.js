/**
 * 
 */
var storageTable;

function createStorageTable() {
	storageTable = $("#storageTable").bootstrapTable({
		url : "/Refined/repository/storageData.do",
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
			field : "storage_no",
			title : "操作日志编号"
		}, {
			field : "product_id",
			title : "操作产品编号",
			visible : false
		}, {
			field : "product_name",
			title : "操作产品名称"
		}, {
			field : "storage_date",
			title : "操作时间",
			formatter : function(value, row, index) {
				return changeDateFormat(value)
			}
		}, {
			field : "operator",
			title : "操作员工工号",
			visible : false
		}, {
			field : "empname",
			title : "操作员工"
		}, {
			field : "number",
			title : "操作数量"
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

function changeDateFormat(cellval) {
	return cellval.split(" ")[0];
}

function reportProduct() {
	$.ajax({
		url : "/Refined/repository/reportProduct.do",
		dataType : "text",
		type : "post",
		success : function(data) {
			bootbox.dialog({
				title : "选择产品",
				message : data
			});
		}
	});
}

function report() {
	$.ajax({
		url : "/Refined/repository/report.do",
		dataType : "json",
		type : "post",
		data : {
			product_id : $("#product_id_report").val()
		},
		success : function(data) {
			var effectRow = parseInt(data.effectRow);
			if (effectRow == 0) {
				$("#report_tip").html("产品出入库平衡");
			} else if (effectRow > 0) {
				$("#report_tip").html("产品入库较多，应考虑减少产量");
			} else {
				$("#report_tip").html("产品出库较多，应考虑增加产量");
			}
		}
	});
}


$(document).ready(function() {
	var $table = $("#storageTable");
	var $remove = $("#removeProduct");
	var $edit = $("#editProduct");
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
	if (storageTable == null) {
		createStorageTable();
	}
	$("#report").click(function() {
		reportProduct();
	});
	$("#reportProductBtn").click(function () {
		report();
    });
});