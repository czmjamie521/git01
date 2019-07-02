<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单详细</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/orderdesc.css'/>">
  </head>

<script type="text/javascript">
$(function(){
	//为"提交收货信息"添加点击事件
	$("#confirmInfo").click(function(){
		//调用验证方法
		checkOrderInfo();
	});
	
	//为"管理收货地址"添加点击事件
	$("#manageAddr").click(function(){
		location= "addressServlet?actionName=searchAddress&orderid=${order.orderid}";
	})
	
	//为"取消订单" 添加点击事件
	$("#cancelOrder").click(function(){
		if(confirm("是否确认删除订单?")){
			$.ajax({
				url:"order",
				data:{
					actionName:"deleteOrder",
					orderid: '${order.orderid }'
				},
				type:"post",
				dataType:"json",
				cache:false,
				success: function(result){
					//删除成功, 需要调用 接口, 分页显示 所有订单
					if(result =="删除成功"){
						alert("删除成功");
						location ="order?actionName=showOrder&pageNum=1";
					}else{
						//删除失败, 仅alert
						alert("删除失败");
					}
					
				}
				
			});
		}
	})
	
	//为"支付订单" 按钮设置点击事件
	$("#payOrder").click(function(){
		$.ajax({
			url:"order",
			data:{
				actionName:"payOrder",
				aid: $("option:selected").attr("aid"),		//被显示的地址的主键
				orderid: '${order.orderid }',
				phone: $("#phone").val()
			},
			type:"post",
			dataType:"json",
			cache:false,
			success: function(result){
				if(result.code ==0){
					//如果未成功支付, 提示原因
					alert(result.msg);
					//如果需要用户登录, 设置location
					if(result.msg =="请登录后支付"){
						location ="Login.jsp";
					}
					return;
				}
				
				alert(result.msg);
				//请求"显示订单"的接口
				location ="order?actionName=showOrder&pageNum=1";
			}
			
		});
	})
})

//验证收货信息
function checkOrderInfo(){
	//验证手机号有效
	var phone =$("#phone").val();
	var regex =/^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/;
	if(!regex.test(phone)){
		alert("请输入有效的手机号!");
		return;
	}
	//验证地址非空
	var addr =$("#addr").val();
	if(null ==addr || ""==addr.trim()){
		alert("请添加地址!");
		return;
	}
	
	//修改用户手机号, 更新收货地址到后台
	var orderid ="${order.orderid}";
	var addr =$("#addr").val();
	var aid =$("option:selected").attr("aid");
	//发送异步请求, 提交更改
	$.ajax({
		url:"order",
		data:{
			actionName:"checkOrderInfo",
			orderid: orderid,
			phone: phone,
			aid: aid,
			addr: addr
		},
		type:"post",
		dataType:"json",
		cache:false,
		success: function(result){
			if(result ==1){
				alert("提交更改成功!")
			}
		}
		
	});
	
}

</script>
<body>
	<div class="divOrder">
		
<!-- 
			(等待付款)
			(已付款)
 -->
		　　<span>　下单时间：
			<fmt:formatDate value="${order.ordertime }" pattern="yyyy-MM-dd HH:mm:ss"/>
		</span>
	</div>
	<div class="divContent">
	
	
		<!-- 点击支付订单 所需表单 -->
		<form action="order?actionName=payOrder" id="pryOrder">
			
			<div class="div2">
				<h3>收货人信息</h3>
			
				姓名: <input type="text" value="${sessionScope.user.uname }" disabled name="uname" id="uname"/>
				手机号: <input type="text" value="${sessionScope.user.phone }" name="phone" id="phone"/>
				&nbsp;&nbsp;
				<br/>
				<br/>
				<!-- 收货地址, 下拉菜单 -->
				收货地址:
				<c:choose>
					<c:when test="${empty aList }">
						<a href="address.jsp">请添加地址</a>
					</c:when>
					<c:otherwise>
					
						<c:choose>
						
							<c:when test="${!empty order.addr }">
								<select name="addr" id="addr">
								<!-- 前台判断逻辑: 是订单地址, option需要选中, 是默认地址, 需要被标识出来 -->
									<c:forEach items="${aList }" var="address">
										<c:choose>
											<c:when test="${address.aid ==order.addr.aid && address.isdefault ==1 }">
												<option value="${address.address} (默认地址)" aid="${address.aid }" selected>${address.address } (默认地址)</option>
											</c:when>
											<c:when test="${address.aid ==order.addr.aid && address.isdefault !=1 }">
												<option value="${address.address }" aid="${address.aid }" selected>${address.address }</option>
											</c:when>
											<c:when test="${address.aid !=order.addr.aid && address.isdefault ==1 }">
												<option value="${address.address } (默认地址)" aid="${address.aid }">${address.address } (默认地址)</option>
											</c:when>
											<c:otherwise>
												<option value="${address.address } " aid="${address.aid }">${address.address }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</c:when>
							
							
							<c:otherwise>
								<select name="addr" id="addr">
									<c:forEach items="${aList }" var="address">
										<c:choose>
											<c:when test="${address.isdefault ==1 }">
												<option selected value="${address.address } (默认地址)" aid="${address.aid }">${address.address } (默认地址)</option>
											</c:when>
											<c:otherwise>
												<option value="${address.address } " aid="${address.aid }">${address.address }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							
							</c:otherwise>
						</c:choose>
						
					</c:otherwise>
				</c:choose>
				
				<br/>
				<br/>
					<a href="/aixuetang/addressServlet?actionName=searchAddress"><button type="button" >管理收货地址</button></a>
					
				<br/>
				<br/>
					<button type="button" id="confirmInfo">确认收货信息</button>
					
					<!-- 错误信息提示框 -->
					<span id="msg"></span>
				<br/>
				<br/>
			</div>
			
			<!-- 商品清单 -->
			<div class="div2">
				<dl>
					<dt>商品清单</dt>
					<dd>
						<table cellpadding="0" cellspacing="0">
							<tr>
								<th class="tt">商品名称</th>
								<th class="tt" align="left">单价</th>
								<th class="tt" align="left">数量</th>
								<th class="tt" align="left">小计</th>
							</tr>
	
							<c:forEach items="${order.orderitemlist }" var="item">
	
							<tr style="padding-top: 20px; padding-bottom: 20px;" height="100px">
								<td class="td" width="400px">
									<div class="bookname">
									  <img align="middle" width="70" src="statics/img/course/${item.course.picture }"/>
									  <a href="courseservlet?actionName=singleCourse&courseid=${item.course.courseid }">
									  		${item.course.coursename}</a>
									</div>
								</td>
								<td class="td" >
									$ <span>${item.course.price }</span>
								</td>
								<td class="td">
									<span>${item.quantity }</span>
								</td>
								<td class="td">
									<span>&yen;${item.subtotal }</span>
								</td>			
							</tr>
							
							</c:forEach>
	
						</table>
					</dd>
				</dl>
			</div>
		
			<div style="margin: 10px 10px 10px 550px;">
				<span style="font-weight: 900; font-size: 15px;">合计金额：</span>
				$ <span class="price_t">${order.total }</span>
	
				<br/><br/><br/>
			    <button type="button" id="cancelOrder">取消订单</button> &nbsp;&nbsp;
			    <br/><br/>
			    <c:if test="${order.status ==1 }">
					<button type="button" id="payOrder">支付订单</button><br/>	
					
						<%
						/* 为支付订单设置token 防止重复提交 */
							session.setAttribute("payOrder", "payOrder");
						%>
				</c:if>
				<c:if test="${order.status ==2 }">
					<span style="color:green">支付完成</span>
				</c:if>
			</div>
			
			<!-- 隐藏域, 将orderid 提交后台 -->
			<input type="hidden"  name="orderid" value=${order.orderid }/>
		</form>	
		<!-- 表单结束 -->
		
	</div>
</body>
<script src="/address/address.js"></script>
</html>

