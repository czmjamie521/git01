<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>订单列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/assets/css/list.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/pager/pager.css'/>" />
</head>

<body>
	<div class="divMain">
		<div class="divTitle">
			<span style="margin-left: 150px; margin-right: 280px;">商品信息</span> <span
				style="margin-left: 40px; margin-right: 38px;">金额</span> <span
				style="margin-left: 50px; margin-right: 40px;">订单状态</span> <span
				style="margin-left: 50px; margin-right: 50px;">操作</span>
		</div>
		<br />
		<table align="center" border="0" width="100%" cellpadding="0"
			cellspacing="0">

			<!-- 循环List, 将订单数据显示出来 -->
			<c:forEach items="${page.dataList }" var="order">
				<tr class="tt">
					<td width="320px"><a href="order?actionName=viewOrder&orderid=${order.orderid }">
						订单号：${order.orderid } </a></td>
					<td width="200px">下单时间：
						<fmt:formatDate value="${order.ordertime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr style="padding-top: 10px; padding-bottom: 10px;">
					<td colspan="2"></td>
					<td width="115px">$ <span class="price_t">${order.total }
					</span>
					</td>
					<td width="142px"><c:choose>
							<c:when test="${order.status eq 1 }">
							(等待付款)
						</c:when>
							<c:when test="${order.status eq 2 }">
							(交易成功)
						</c:when>
						</c:choose> <!-- 
				(准备发货)
				(等待确认)
				(交易成功)
				(已取消)
	 --></td>
					<td><a href="order?actionName=viewOrder&orderid=${order.orderid }">查看</a><br />
						<a href="<c:url value='/jsps/order/desc.jsp'/>">支付</a><br /> <a
						href="<c:url value='/jsps/order/desc.jsp'/>">删除</a><br /></td>
				</tr>

			</c:forEach>
		</table>

		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		
	</div>

	<%@include file="/jsps/pager/pager.jsp" %>
</body>


</html>
