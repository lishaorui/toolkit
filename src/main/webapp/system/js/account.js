Account = function(){};

Account.init = function(){
	Account.pageQuery();
	// 处理分页状态
	Account.pagestatus();
	// 查询列表
	$("#queryBtn").bind("click", function(){
		Account.query();
	}); 
	
	Account.checkAll();
	
	// 绑定
	$('#bindBtn').bind("click", function(){
		Account.openBindWin();
	});
	// 解绑
	$('#unbindBtn').bind("click", function(){
		Account.openUnbindWin();
	});
};

Account.checkAll = function(){
	// 全选处理
	$('#checkAll').bind("click", function(){
		// PS：jQuery1.8+在操作checkbox时使用prop替换了attr
		if($(this).prop("checked")){
			$("input[name='checkItem']").each(function(){
				$(this).attr("checked", true);
			});
		}else{
			$("input[name='checkItem']").each(function(){
				$(this).attr("checked", false);
			});
		}
	});
};


/**
 * 校验
 */
Account.validateBind = function(){
	$("#bindForm").validate({
		rules:{
			accountId:{
				required:true,
				maxlength:50
			},
			signinNo:{
				required:true,
				maxlength:10
			},
			name:{
				required:true,
				maxlength:20
			}
		},
		messages:{
			accountId:{
				required: "必填项",
				maxlength: $.validator.format("最多输入 {0} 个字符"),
			},
			signinNo:{
				required: "必填项",
				maxlength: $.validator.format("最多输入 {0} 个字符"),
			},
			name:{
				required: "必填项",
				maxlength: $.validator.format("最多输入 {0} 个字符"),
			}
		}
	});
};

Account.doChecked = function(){
	var len=$("input[name='checkItem']:checked").length;
	if(len<1){
		alert('请选中要处理的记录');
		return false;
	}else{
		return true;
	}
};

Account.query = function(){
	var pageNo = $("#pageNo").val();
	if(pageNo == null || pageNo == '')
		pageNo = 1;
	Account.doQuery(pageNo);
};

Account.openBindWin = function(){
	$.ajax({
		url: "goBind",
		type:'get',
		dataType:'html',
		data:{
		},
		success:function(data){
			$("#bindModalPopup").html(data);
			$("#bindModal").reveal();
		}
	}).fail(function(){
		alert("查询异常...");
	});
};

Account.openUnbindWin = function(){
	var doUnbind = false;
	var len=$("input[name='checkItem']:checked").length;
	if(len<1){
		alert('请选中要处理的记录');
		doUnbind =  false;
	}else{
		doUnbind = true;
	}
	
	if(doUnbind && confirm("确定要解绑吗？")){
		Account.unbind();
	}
};

Account.bind = function(){
	if($("#bindForm").valid()){
		var accountId = $("#accountId").val();
		var signinNo = $("#signinNo").val();
		var name = $("#name").val();
		var branchId = $("#branchId").val();
		$.ajax({
			url: 'bind',
			type: 'post',
			dataType: 'json',
			data:{
				'accountId': accountId,
				'signinNo': signinNo,
				'name':name,
				'branchId':branchId
			},
			success : function(data) {
				if(data.resultCode == 0){
					$("#bindModalCloseBtn").click();
					Account.query();
				}
				alert(data.resultMessage);
			}
		}).fail(function() {
			alert("绑定异常！");
		});
	}
	
};

Account.unbind = function(){
	var accountIds = "";
	$("input[name='checkItem']:checked").each(function(){
		accountIds = accountIds+$(this).val()+"," ;
	});
	
	$.ajax({
		url: 'unbind',
		type: 'post',
		dataType: 'json',
		data:{
			'accountIds': accountIds
		},
		success : function(data) {
			alert(data.resultMessage);
			if(data.resultCode == 0)
				Account.query();
		}
	}).fail(function() {
		alert("解绑异常！");
	});
};

//翻页按钮是否可用处理
Account.pagestatus = function(){
	var pageNo = $("#pageNo").text();
	var totalPage = $("#totalPage").text();
	if(pageNo == totalPage){
		// 下一页按钮不可用，末页不可用
		$("#next").attr('class','disable_pages');
		$("#last").attr('class','disable_pages');
	}else{
		// 下一页按钮可用，末页可用
		$("#next").attr('class','next');
		$("#last").attr('class','last');
	}
	if(pageNo == 1){
		// 上一页不可用，首页不可用
		$("#previous").attr('class','disable_pages');
		$("#first").attr('class','disable_pages');
	}else{
		// 上一页可用，首页可用
		$("#previous").attr('class','previous');
		$("#first").attr('class','first');
	}
	
	if(pageNo == 0 && totalPage == 0){
		$("#next").attr('class','disable_pages');
		$("#last").attr('class','disable_pages');
		$("#previous").attr('class','disable_pages');
		$("#first").attr('class','disable_pages');
	}
	
};

Account.pageQuery = function(){
	$("#first").bind("click", function(){
		var pageNo = $("#pageNo").text();
		if(pageNo == 1)
			return false;
		Account.doQuery(1);
	});
	$("#last").bind("click", function(){
		var pageNo = $("#pageNo").text();
		var totalPage = $("#totalPage").text();
		if(pageNo == totalPage)
			return false;
		Account.doQuery($("#totalPage").text());
	}); 
	$("#previous").bind("click", function(){
		var pageNo = $("#pageNo").text();
		if(pageNo == 1)
			return false;
		Account.doQuery(parseInt(pageNo)- 1);
	}); 
	$("#next").bind("click", function(){
		var pageNo = $("#pageNo").text();
		var totalPage = $("#totalPage").text();
		if(pageNo == totalPage)
			return false;
		Account.doQuery(parseInt(pageNo)+ 1);
	}); 
};

Account.doQuery = function(pageNo){
	var pageSize = 10;
	$.ajax({
		url: "list",
		type:'post',
		dataType:'html',
		data:{
			'accountId':$("#queryAccountId").val(),
			'signinNo':$("#querySigninNo").val(),
			'pageNo':pageNo,
			'pageSize':pageSize
		},
		success:function(data){
			$("#accountList").html(data);
			Account.pagestatus();
		}
	}).fail(function(){
		alert("查询异常...");
	});
};
