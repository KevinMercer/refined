/**
 * 
 */
var setting = {
	async : {
		enable : true,
		url : "/Refined/permission/permissionData.do",
		autoParam : [ "perid=id", "pername=name", "level" ],
		dataFilter : null
	},
	view : {
		expandSpeed : "500",
		addHoverDom : addHoverDom,
		removeHoverDom : removeHoverDom,
		selectedMulti : false,
		showLine : true
	},
	edit : {
		enable : true,
		drag : {
			isMove : true,
			isCopy : true,
			prev : false,
			next : false
		},
		renameTitle : "更新权限",
		removeTitle : "删除权限",
		showRenameBtn : true,
		showRemoveBtn : true
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
			checked : "checked",
			rootPid : null
		}
	},
	callback : {
		beforeRemove : beforeRemove,
		beforeEditName : beforeRename,
		beforeDrop : beforeDrop
	}
};

function filter(treeId, parentNode, childNodes) {
	if (!childNodes)
		return null;
	for (var i = 0, l = childNodes.length; i < l; i++) {
		childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
	}
	return childNodes;
}
function beforeRemove(treeId, treeNode) {
	bootbox.confirm({
		message : "是否删除该权限",
		buttons : {
			confirm : {
				label : "是",
				className : "btn-success"
			},
			cancel : {
				label : "否",
				className : "btn-danger"
			}
		},
		callback : function(result) {
			if (result == true) {
				$.ajax({
					url : "/Refined/permission/executeRemove.do",
					dataType : "json",
					type : "post",
					data : {
						perid : treeNode.perid,
						oldParent : treeNode.parentid
					},
					success : function(data) {
						var effectRow = parseInt(data.effectRow);
						if (effectRow >= 1) {
							$(".bootbox-close-button").click();
							$.fn.zTree.init($("#treeDemo"), setting);
							return true;
						} else if (effectRow == 0) {
							bootbox.alert("删除失败！错误代码：000。数据库异常，请联系nice数据库管理员！");
							return false;
						} else if (effectRow == -1) {
							bootbox.alert("删除失败！错误代码001。服务器异常，请稍后重试！");
							return false;
						} else if (effectRow == -2) {
							bootbox.alert("删除失败！错误代码002。该权限下还有子权限，暂时无法删除！");
							return false;
						} else {
							bootbox.alert("删除失败！错误代码404。服务器异常，请稍后重试。");
							return false;
						}
					}
				});
			}
		}
	});
	return false;
}
function beforeRename(treeId, treeNode, newName) {
	if (treeNode.perid == 1001) {
		bootbox.alert("根节点暂不支持修改！");
		return false;
	}
	$.ajax({
		url : "/Refined/permission/editPermission.do",
		type : "post",
		dataType : "text",
		data : {
			perid : treeNode.perid
		},
		success : function(message) {
			bootbox.dialog({
				"title" : "修改权限",
				"message" : message
			});
		}
	});
	/*
	 * if (newName.length == 0) { setTimeout(function() { var zTree =
	 * $.fn.zTree.getZTreeObj("treeDemo"); zTree.cancelEditName();
	 * alert("节点名称不能为空."); }, 0); return false; }
	 */
	return false;
}
function doEditPermission() {
	if ($("#tipSpan").html() == "" || $("#tipSpan").html() == "权限名可用！") {
		$.ajax({
			url : "/Refined/permission/executeEdit.do",
			dataType : "json",
			type : "post",
			data : $("#editForm").serialize(),
			success : function(data) {
				var effectRow = parseInt(data.effectRow);
				if (effectRow >= 1) {
					$(".bootbox-close-button").click();
					$.fn.zTree.init($("#treeDemo"), setting);
				} else {
					bootbox.alert("添加失败！");
				}
			}
		});
	}
}

function verifyPername() {
	var $pername = $("#pername").val();
	var $oldname = $("#oldname").val();
	var $tip = $("#tipSpan");
	var mark = false;
	if ($oldname != "") {
		mark = ($pername == $oldname);
	}
	if (!mark) {
		if ($pername == "") {
			$tip.html("权限名不能为空！");
			$tip.css({
				color : "red"
			});
		} else {
			$.ajax({
				url : "verifyPername.do",
				type : "post",
				dataType : "json",
				data : {
					pername : $pername
				},
				success : function(data) {
					var effectRow = parseInt(data.effectRow);
					if (effectRow == 1) {
						$tip.html("权限名已存在！");
						$tip.css({
							color : "red"
						});
					} else {
						$tip.html("权限名可用！");
						$tip.css({
							color : "green"
						});
					}
				}
			});
		}
	} else {
		$tip.html("");
	}
}

var newCount = 1;
function addHoverDom(treeId, treeNode) {
	var sObj = $("#" + treeNode.tId + "_span");
	if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0)
		return;
	var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='添加权限' onfocus='this.blur();'></span>";
	sObj.after(addStr);
	var btn = $("#addBtn_" + treeNode.tId);
	if (btn)
		btn.bind("click", function() {
			/*
			 * var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			 * zTree.addNodes(treeNode, { id : (100 + newCount), pId :
			 * treeNode.id, name : "new node" + (newCount++) }); return false;
			 */
			addPermission(treeNode.perid);
		});
}
;
function addPermission(param) {
	$.ajax({
		url : "/Refined/permission/addPermission.do",
		dataType : "text",
		type : "post",
		data : {
			parentid : param
		},
		success : function(message) {
			bootbox.dialog({
				"title" : "添加权限",
				"message" : message
			});
		}
	});
}
function doAddPermission() {
	if ($("#tipSpan").html() == "" || $("#tipSpan").html() == "权限名可用！") {
		$.ajax({
			url : "/Refined/permission/executeAdd.do",
			dataType : "json",
			type : "post",
			data : $("#addForm").serialize(),
			success : function(data) {
				var effectRow = parseInt(data.effectRow);
				if (effectRow >= 1) {
					$.fn.zTree.init($("#treeDemo"), setting);
					$(".bootbox-close-button").click();
				} else {
					bootbox.alert("添加失败！");
				}
			}
		});
	}
}
function beforeDrop(treeId, treeNodes, targetNode, moveType, isCopy) {
	var myTree = $.fn.zTree.getZTreeObj("treeDemo");
	var dragPerid = treeNodes[0].perid;
	var oldParent = treeNodes[0].getParentNode().perid;
	var newParent = targetNode.perid;
	var isParent = treeNodes[0].isParent;
	bootbox.confirm({
		message : "你确定要移动该子节点吗？",
		buttons : {
			confirm : {
				label : "是",
				className : "btn btn-success"
			},
			cancel : {
				label : "否",
				className : "btn btn-danger"
			}
		},
		callback : function(result) {
			if (result) {
				$.ajax({
					url : "/Refined/permission/executeMove.do",
					dataType : "json",
					type : "post",
					data : {
						"perid" : dragPerid,
						"oldParent" : oldParent,
						"newParent" : newParent,
						"isParent" : isParent
					},
					success : function(data) {
						var effectRow = parseInt(data.effectRow);
						if (effectRow >= 1) {
							$.fn.zTree.init($("#treeDemo"), setting);
							//							myTree.reAsyncChildNodes(targetNode, "norefresh", false);
							return true;
						} else {
							bootbox.alert("移动失败！");
							return false;
						}
					}
				});
			}
		}
	});
	return false;
}
function removeHoverDom(treeId, treeNode) {
	$("#addBtn_" + treeNode.tId).unbind().remove();
}
;
$(document).ready(function() {
	var myTree = $.fn.zTree.init($("#treeDemo"), setting);
	myTree.expandAll(false);
	$("#clickBtn").click(function() {
		doAddPermission();
	});
	$("#updateBtn").click(function() {
		doEditPermission();
	});
	$("#cancelBtn").click(function() {
		$(".bootbox-close-button").click();
	});
	$("#pername").blur(function() {
		verifyPername();
	});
});