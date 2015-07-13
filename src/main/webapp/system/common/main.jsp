<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>主页</title>
</head>
<frameset rows="80,*,30" frameborder="no" border="0" framespacing="0">
	<frame src="<c:url value='/system/common/top.jsp'/>" name="topFrame" scrolling="no" noresize="noresize" bid="topFrame" />
	<frame src="<c:url value='/system/common/middel.jsp'/>" name="mainFrame" id="mainFrame" />
	<frame src="<c:url value='/system/common/down.jsp'/>" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame" /> 
</frameset>
<noframes>
	<body>
	</body>
</noframes>
</html>