/**
 * 
 */
var setting = {
	async : {
		enable : true,
		url : "/Refined/roleinfo/rolepermissionData.do",
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
		enable : false,
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

$(document).ready(function () {
	$.fn.zTree.init($("#queryPermission"), setting);
});