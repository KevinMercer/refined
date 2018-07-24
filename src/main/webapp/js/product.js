/**
 * 
 */

var productTable;

function createProductTable() {
	productTable = $("#productTable").bootstrapTable({
		url : "/Refined/product/productData.do",
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
			field : "product_id",
			title : "产品编号"
		}, {
			field : "product_name",
			title : "产品名称"
		}, {
			field : "repository",
			title : "库存余量"
		}, {
			field : "create_time",
			title : "出产时间",
			formatter : function(value, row, index) {
				return changeDateFormat(value)
			}
		}, {
			field : "market_time",
			title : "上市时间",
			formatter : function(value, row, index) {
				return changeDateFormat(value)
			}
		}, {
			field : "product_desc",
			title : "产品简述"
		}, {
			field : "enables",
			title : "启停"
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

function verifyProductForm() {
	if ($("#product_name").val() == "") {
		bootbox.alert("请填写产品名称");
		return false;
	}
	if ($("#repository").val() == "") {
		bootbox.alert("请填写首批产量");
		return false;
	}
	if ($("#create_time").val() == "") {
		bootbox.alert("请填写出产日期");
		return false;
	}
	if ($("#market_time").val() == "") {
		bootbox.alert("请填写预计上市日期");
		return false;
	}
	return true;
}

function addProduct() {
	$.ajax({
		url : "/Refined/product/addProduct.do",
		dataType : "text",
		type : "post",
		success : function(data) {
			bootbox.dialog({
				title : "新增产品",
				message : data
			});
		}
	});
}

function executeAdd() {
	if (verifyProductForm()) {
		$.ajax({
			url : "/Refined/product/executeAdd.do",
			dataType : "json",
			type : "post",
			data : $("#addProductForm").serialize(),
			success : function(data) {
				var effectRow = parseInt(data.effectRow);
				if (effectRow > 0) {
					$(":button[name='refresh']").click();
					$("#removeProduct").prop("disabled", true);
					$("#editProduct").prop("disabled", true);
					$(".bootbox-close-button").click();
				} else {
					bootbox.alert("添加失败。");
				}
			}
		});
	}
}

function editProduct() {
	var selectObj = JSON.stringify(productTable.bootstrapTable('getSelections'));
	var res = JSON.parse(selectObj);
	var product_id = res[0]["product_id"];
	$.ajax({
		url : "/Refined/product/editProduct.do",
		dataType : "text",
		type : "post",
		data : {
			product_id : product_id
		},
		success : function(data) {
			bootbox.dialog({
				title : "编辑信息",
				message : data
			});
		}
	});
}

function executeEdit() {
	if (verifyProductForm()) {
		$.ajax({
			url : "/Refined/product/executeEdit.do",
			dataType : "json",
			type : "post",
			data : $("#editProductForm").serialize(),
			success : function(data) {
				var effectRow = parseInt(data.effectRow);
				if (effectRow > 0) {
					$(":button[name='refresh']").click();
					$("#removeProduct").prop("disabled", true);
					$("#editProduct").prop("disabled", true);
					$(".bootbox-close-button").click();
				} else {
					bootbox.alert("修改失败。");
				}
			}
		});
	}
}

function removeProduct() {
	bootbox.confirm({
		message : "您正在做一个危险的动作：你将要删除一些重要的产品信息，请确认是否继续？",
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
				var selectObj = JSON.stringify(productTable.bootstrapTable('getSelections'));
				var res = JSON.parse(selectObj);
				var product_ids = "";
				for (var i = 0; i < res.length; i++) {
					product_ids += res[i]["product_id"] + ", ";
				}
				product_ids = product_ids.substr(0, product_ids.length - 2);
				$.ajax({
					url : "/Refined/product/removeProduct.do",
					dataType : "json",
					type : 'post',
					data : {
						product_ids : product_ids
					},
					success : function(data) {
						var effectRow = parseInt(data.effectRow);
						if (effectRow > 0) {
							$(":button[name='refresh']").click();
							$("#removeProduct").prop("disabled", true);
							$("#editProduct").prop("disabled", true);
							$(".bootbox-close-button").click();
						} else {
							bootbox.alert("删除失败，请稍后重试。");
						}
					}
				});
			}
		}
	});
}

function putStorage() {
	$.ajax({
		url : "/Refined/product/putStorage.do",
		dataType : "text",
		type : "post",
		success : function(data) {
			bootbox.dialog({
				title : "产品入库",
				message : data
			});
		}
	});
}

function executePut() {
	$.ajax({
		url : "/Refined/product/executePut.do",
		dataType : "json",
		type : "post",
		data : {
			product_id : $("#product_id_put").val(),
			put : $("#put").val()
		},
		success : function(data) {
			var effectRow = parseInt(data.effectRow);
			if (effectRow > 0) {
				$(":button[name='refresh']").click();
				$("#removeProduct").prop("disabled", true);
				$("#editProduct").prop("disabled", true);
				$(".bootbox-close-button").click();
			} else {
				bootbox.alert("入库失败，请稍后重试。");
			}
		}
	});
}

function extractRepository() {
	$.ajax({
		url : "/Refined/product/extractStorage.do",
		dataType : "text",
		type : "post",
		success : function(data) {
			bootbox.dialog({
				title : "产品出库",
				message : data
			});
		}
	});
}

function queryRepository() {
	var product_id = $("#product_id_extract option:selected").val();
	$.ajax({
		url : "/Refined/product/queryRepository.do",
		dataType : "json",
		type : "post",
		data : {
			product_id : product_id
		},
		success : function(data) {
			$("#number_tip").html("库存余量：" + data.effectRow);
		}
	});
}

function executeExtract() {
	$.ajax({
		url : "/Refined/product/executeExtract.do",
		dataType : "json",
		data : {
			product_id : $("#product_id_extract").val(),
			put : $("#extract").val(),
			describe : $("#describe").val(),
			copy : $("#copy").val()
		},
		type : "post",
		success : function(data) {
			var effectRow = parseInt(data.effectRow);
			if (effectRow == 1) {
				$(":button[name='refresh']").click();
				$("#removeProduct").prop("disabled", true);
				$("#editProduct").prop("disabled", true);
				$(".bootbox-close-button").click();
			} else if (effectRow == 2) {
				bootbox.alert("已发出出库申请");
			} else {
				bootbox.alert("出库失败");
			}
		}
	});
}

$(document).ready(function() {
	var $table = $("#productTable");
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
	if (productTable == null) {
		createProductTable();
		$("#addProduct").click(function() {
			addProduct();
		});
		$("#editProduct").click(function() {
			editProduct();
		});
	}
	$("#submitProductBtn").click(function() {
		executeAdd();
	});
	$("#editProductBtn").click(function() {
		executeEdit();
	});
	$("#removeProduct").click(function() {
		removeProduct();
	});
	$("#inRepository").click(function() {
		putStorage();
	});
	$("#outRepository").click(function() {
		extractRepository();
	});
	$("#putProductBtn").click(function() {
		executePut();
	});
	$("#product_id_extract").change(function() {
		queryRepository();
	});
	$("#extractProductBtn").click(function() {
		executeExtract();
	});
});