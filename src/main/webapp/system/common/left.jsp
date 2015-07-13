<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<c:url value='/components/style/demo.css'/>" type="text/css">
    <link rel="stylesheet" href="<c:url value='/components/style/style.css'/>" type="text/css">
 <!--[if IE 6]> 
<script src="js/DD_belatedPNG_0.0.8a.js" type="text/javascript" ></script> 
<script type="text/javascript"> 
DD_belatedPNG.fix('#m01 span em,#m02 span em,#m03 span em,#m04 span em,#m05 span em,.L1 a:link span, .L1 a:visited span,.L1 a:link.active span, .L1 a:hover.active span, .L1 a:active.active span, .L1 a:visited.active span'); 
</script>  
<![endif]-->
</head>
<body class="panel" >
<div id="sub_tabs" class="sub_tabs"></div>
<div id="body"> 
  <ul id="menu">
    <li class="L1"><a href="javascript:c('m02');" id="m02"><span><em></em>数据管理</span></a></li>
    <ul id="m02d" style="display:none;" class="U1">
      <li class="L21"><a href="<c:url value='/account/index'/>" target="maincontent"><span>账户</span></a></li>
    </ul>
  </ul>
</div>
<script type="text/javascript" src="<c:url value='/components/js/menu.js'/>"></script>
</body>
</html>
