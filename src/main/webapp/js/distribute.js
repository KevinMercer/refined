/**
 * 
 */
var myTree;
var mark = false;
var setting = {
	async : {
		enable : true,
		url : "/Refined/permission/permissionData.do",
		autoParam : [ "perid=id", "pername=name", "level" ],
		otherParam : {"roleId" : $("#roleId").val()},
		dataFilter : null
	},
	view : {
		expandSpeed : "fast",
		selectedMulti : false,
		showLine : true
	},
	edit : {
		enable : false,
		drag : {
			isMove : true,
			isCopy : true,
			prev : false,
			next : false
		},
		renameTitle : "更新权限",
		removeTitle : "删除权限",
		showRenameBtn : false,
		showRemoveBtn : false
	},
	check : {
		chkStyle : "checkbox",
		enable : true,
		nocheckInherit : false
	},
	data : {
		keep : {
			leaf : true,
			parent : true
		},
		key : {
			name : "pername",
			title : "pername"
		},
		simpleData : {
			enable : true,
			idKey : "perid",
			pIdKey : "parentid",
			rootPid : null
		}
	}
};

function submitDistribute() {
	var nodes = myTree.getCheckedNodes(true);
	if (nodes.length <= 0) {
		bootbox.alert("请务必选择至少一个权限！");
		return false;
	}
	var perids = "";
	for (var i = 0; i < nodes.length; i++) {
		perids = perids + nodes[i].perid + ", ";
	}
	perids = perids.substr(0, perids.length - 2);
	$.ajax({
		url : "/Refined/roleinfo/executeDistribute.do",
		type : "post",
		dataType : "json",
		data : {
			perids : perids,
			roleId : $("#roleId").val()
		},
		success : function(data) {
			var effectRow = parseInt(data.effectRow);
			if (effectRow >= 1) {
				$(".bootbox-close-button").click();
			} else if (effectRow == 0) {
				bootbox.alert("权限分配失败！错误代码：000。数据库异常，请联系你的数据库管理员！");
			} else {
				bootbox.alert("权限分配失败！错误代码：001。服务器异常，请稍后重试！");
			}
		}
	});
}

function clearDistribute() {
	bootbox.confirm({
		message : "你确定清空该角色下所有的权限吗？",
		buttons : {
			confirm : {
				label : "确定",
				className : "btn btn-success"
			},
			cancel : {
				label : "取消",
				className : "btn btn-warning"
			}
		},
		callback : function(result) {
			if (result) {
				$.ajax({
					url : "/Refined/roleinfo/executeClearDistribute.do",
					type : "post",
					dataType : "json",
					data : {
						roleId : $("#roleId").val()
					},
					success : function(data) {
						var effectRow = parseInt(data.effectRow);
						if (effectRow >= 1) {
							bootbox.alert("权限清除成功，清除了" + effectRow + "行记录。");
							$.fn.zTree.init($("#permissionTree"), setting);
						} else if (effectRow == 0) {
							bootbox.alert("权限已被清空，无法再次清除！");
						} else {
							bootbox.alert("权限清除失败！错误代码：001。服务器异常，请稍后重试！");
						}
					}
				});
			}
		}
	});
}

function cancelDistribute() {
	$(".bootbox-close-button").click();
}

function expandAllNodes() {
	myTree.expandAll(mark);
	mark = !mark;
}

$(document).ready(function() {
	myTree = $.fn.zTree.init($("#permissionTree"), setting);
	$("#clickHere").click(function() {
		expandAllNodes();
	});
	$("#cancelDistribute").click(function() {
		cancelDistribute();
	});
	$("#submitDistribute").click(function() {
		submitDistribute();
	});
	$("#clearDistribute").click(function() {
		clearDistribute();
	});
});