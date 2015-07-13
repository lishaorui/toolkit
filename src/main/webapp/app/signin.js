

Signin = function(){};

Signin.init = function (){
	$("#queryBtn").bind("click", function(){
		Signin.query();
	}); 
	
	
	// 生成验证码
	$("#captchaImage").bind("click", function(){
		$(this).hide().attr("src", "captchaImage?"+Math.floor(Math.random()*100)).fadeIn();
	});
	
	$(".singer_r_img").bind("click", function(){
		var captcha = $("#captchaCode").val();
		if(captcha == 'undefined' || captcha == null || captcha == ''){
			alert("请输入验证码");
			return false;
		}
		
		var that = $(this);
		$.ajax({
			url: "sign-in",
			type:'post',
			dataType:'json',
			data:{
				'captcha' : captcha
			},
			success:function(data){
				var resultCode = data.resultCode;
				if(resultCode == 0){
					that.addClass("current");
					setTimeout(function(){
						that.removeClass("current");
					},10000);// 10m后恢复
				}					
				else
					alert(data.resultMessage);
				// 更换验证码
				$("#captchaImage").hide().attr("src", "captchaImage?"+Math.floor(Math.random()*100)).fadeIn();
				// 清空验证码输入框
				$("#captchaCode").val("");
				Signin.query();
				return false;
			}
		}).fail(function(){
			alert("签到异常...");
		});
	}); 
};

Signin.query = function(){
	var queryDate = $("#queryMonth").val();
	var year, month; 
	if(queryDate == ''){
		year = 0;
		month = 0;
	}else{
		var array = queryDate.split("-");
		year = array[0];
		month = array[1];
	}
	$.ajax({
		url: "personalList",
		type:'post',
		dataType:'html',
		data:{
			'year': year,
			'month':month
		},
		success:function(data){
			$("#signinlist").html(data);
		}
	}).fail(function(){
		alert("查询异常...");
	});
};

Signin.showWeek = function(){
    var week = function(){
        var objDate= new Date();
        var week = objDate.getDay();
        switch(week)
        {
                case 0:
	                week="周日";
	                break;
                case 1:
	                week="周一";
	                break;
                case 2:
	                week="周二";
	                break;
                case 3:
	                week="周三";
	                break;
                case 4:
	                week="周四";
	                break;
                case 5:
	                week="周五";
	                break;
                case 6:
	                week="周六";
	                break;
        }
        $("#sing_for_number").html( week );
    };
    week();
};

/**
 * 详情展示
 */
Signin.show = function(day){
	$("#oneday").html(day);
	$.ajax({
		url: "show",
		type:'post',
		dataType:'html',
		data:{
			'day': day
		},
		success:function(data){
			$("#showModalPopup").html(data);
			$("#showModal").reveal();
		}
	}).fail(function(){
		alert("查询异常...");
	});
	
};

