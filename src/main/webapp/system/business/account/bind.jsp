<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="bindForm">
<div class="mainbox"> 
    <div class="widget_body mTop10" style="_padding-bottom:10px;">
      <table class="TableList formtable" width="100%" cellpadding="0" cellspacing="0">
        <tr>
          <td align="right" width="15%">账户ID</td>
          <td><input id="accountId" name="accountId" type="text" class="text"/></td>
        </tr>
        <tr>
          <td align="right" width="15%">打卡号</td>
          <td><input id="signinNo" name="signinNo" type="text" class="text"/></td>
        </tr>
        <tr>
          <td align="right" width="15%">姓名</td>
          <td><input id="name" name="name" type="text" class="text"/></td>
        </tr>
        <tr>
          <td align="right" width="15%">分支</td>
          <td>
          	<select id="branchId" >
          		<c:forEach var="branch" items="${branchs }">
	          		<option value="${branch.id }">${branch.name }</option>
          		</c:forEach>
          	</select>
          </td>
        </tr>
      </table>
    </div> 
</div>
<div class="tcenter mTop10 confirmbg">
    <input id="doBind" type="button" value="绑定" class="mbutton mR3" />
</div>
</form>
<script type="text/javascript">
	$('#doBind').bind("click", function(){
		Account.bind();
	});
	$().ready(function(){
		Account.validateBind();
	});
</script>




