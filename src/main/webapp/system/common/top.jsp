<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" href="<c:url value='/components/style/style.css'/>" type="text/css">
<script type="text/javascript">
	function logout(){
		window.parent.open("<%=path %>"+"/logout","_self");
	}

</script>
</head>
<!--[if IE 6]> 
<script src="js/DD_belatedPNG_0.0.8a.js" type="text/javascript" ></script> 
<script type="text/javascript"> 
DD_belatedPNG.fix('#head,.home,.modify,.help,.exit,.toprightbar,img,background'); 
</script>  
<![endif]--> 
</head>
<body>
<div id="head">
  <div id="logo">系统管理</div>
  <div id="quick-menu" class="toprightbar">
   <a class="home" href="home.jsp" id="userinfo" target="maincontent">首页</a>
   <a class="exit" href="javascript:void(0)" onclick="javascript:logout()" id="exit">退出</a>
     </div>
  <br class="clearfloat" />
</div>
</body>
</html>
