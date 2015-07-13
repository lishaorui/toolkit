function isValid(){
	var year=$("#year").find("select[name='year']").val();
	if(!year){
		$("#year").find("select[name='year']").focus();
		alert("请选择年");
		return false;
	}
	var month=$("#month").find("select[name='year']").val();
	if(!month){
		$("#month").find("select[name='year']").focus();
		alert("请选择月");
		return false;
	}
	//下面这个验证可能会去掉
	if(!$("input[name='workday']").is(':checked')){
		alert("请选择工作日");
  		return false;
  	}
	return true;
}