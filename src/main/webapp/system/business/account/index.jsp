<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>账户管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value='/components/style/main.css'/>" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<c:url value='/components/jquery/jquery.js'/>"></script>
<script type="text/javascript" src="<c:url value='/components/js/jquery.reveal.js'/>"></script>
<script type="text/javascript" src="<c:url value='/components/js/jquery.validate.js'/>"></script>
<script type="text/javascript" src="<c:url value='/system/js/account.js'/>"></script>
<script type="text/javascript">
	$(document).ready(function(){
		Account.init();
	});
</script>
<!--弹层--->
<style>
.reveal-modal {
	height: 202px;
}
</style>

</head>
<body>
<div class="mainbox">
	<!--位置开始-->
	<div class="place"><a href="#">首页</a> >数据管理 >账户绑定</div>
	<!--位置结束-->
	<!--查询开始-->
	<div class="widget">
	    <div class="widget_body">
	      <div id="overtime" class="search">
	        <ul>
	          <li class="searchList"> 
	          	<span class="searchList_in"> 
	          		<span class="formdata">账户ID</span>
	          		<span class="formtext">
	            		<input id="queryAccountId" type="text" class="text"/>
	           		</span>
		            <span class="mL10 fleft">
		            	<input id="queryBtn" type="button" value="查询" class="mbutton">
		          	</span>
	          	</span>
	          </li>
	        </ul>
	      </div>
	    </div>
	</div>
	<!--查询结束-->
	
	<!--列表开始--->
	<div class="widget">
    	<div class="widget_body pB50">
			<div class="buttonlist"> 
				<a href="#" id="bindBtn" class="mbutton mR3 binding fleft" ><span>绑定</span></a> 
				<a href="#" id="unbindBtn" class="mbutton mR3 unbind fleft" ><span>解绑</span></a>
			</div>
      		<%@include file="list.jsp" %>
	      	<!--分页开始--->
	      	<div class="dataTables_paginate paging_full_numbers" id="data-table_paginate">
	      		<a tabindex="0" class="first" id="first">&lt&lt</a>
	      		<a tabindex="0" class="previous" id="previous">&lt</a>
	      		<span class="pagenumber">
	      			<span id="pageNo" class="nowpage">${page.pageNo}</span>/<span id="totalPage" class="allpage">${page.totalPage}</span></span>
	      		</span>
	      		<a tabindex="0" class="next" id="next">&gt</a>
	      		<a tabindex="0" class="last" id="last">&gt&gt</a>
	      	</div>
	      	<!--分业结束---> 
    	</div>
	</div>
	<!--列表结束---> 
</div>
<div id="bindModal" class="reveal-modal">
   <h2><a id="bindModalCloseBtn" class="close-reveal-modal close">&#215;</a>绑定</h2>
   <div id="bindModalPopup"></div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		Account.validateBind();
		Account.checkAll();
	});
</script>
</body>
</html>
