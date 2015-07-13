<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<table id="accountList" class="TableList tcenter"  width="100%" cellpadding="0" cellspacing="0">
	  <tbody id="tboday">
		  <thead>
		    <tr>
		      <td width="5%" align="center" nowrap=""><input type="checkbox" id="checkAll" name="checkAll"></td>
		      <td width="15%" align="center" nowrap="">账户ID</td>
		      <td width="15%" align="center" nowrap="">打卡号</td>
		      <td width="20%" align="center" nowrap="">姓名</td>
		      <td width="25%" align="center" nowrap="">分支</td>
		      <td width="20%" align="center" nowrap="">操作时间</td>
		    </tr>
		  </thead>
			<c:forEach var="account" items="${page.items }">
			<tr>
				<td align="center" nowrap=""><input type="checkbox" name="checkItem" value="${account.accountId }"></td>
				<td align="center" nowrap="">${account.accountId }</td>
				<td align="center" nowrap="">${account.signinNo }</td>
				<td align="center" nowrap="">${account.name }</td>
				<td align="center" nowrap="">${account.branchName }</td>
				<td align="center" nowrap=""><fmt:formatDate value="${account.updateDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
		</c:forEach>
   </tbody>
</table>
<script type="text/javascript">
	$("#pageNo").text('${page.pageNo}');
	$("#totalPage").text('${page.totalPage}');
	$(document).ready(function(){
		Account.checkAll();
		// 分页查询
		//Account.pageQuery();
	});
</script>