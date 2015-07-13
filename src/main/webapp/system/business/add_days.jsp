<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>JQery:日历</title>
<script type="text/javascript" src="<c:url value='/components/jquery/jquery.js'/>"></script>
<script type="text/javascript" src="<c:url value='/components/js/kalendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/system/js/add_days.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/components/style/kalendar.css'/>" />
<link href="<c:url value='/components/style/main.css'/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="mainbox">
<!--位置开始-->
<div class="place"><a href="#">首页</a> > 业务设置 > 月工作日</div>
<!--位置结束--> 
<!--日历开始--->
<div class="widget">
  <div class="widget_title">月工作日设置</div>
  <div class="widget_body tcenter pB50">
 	<form action="<c:url value='/signdays/add'/>" method="post" onsubmit="return isValid();">
    <div id='wrap'> </div>
    <div class="tcenter mTop10">
      <input type="submit" value="添加" class="mbutton mR10"/>
      <input type="reset" value="重置" class="mbutton mR10">
      <input type="button" value="返回" class="mbutton" onclick="history.go(-1);"/>
    </div>
   </form>
  </div>
</div>
</body>
</html>