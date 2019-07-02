<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="divBody">
		<div class="divContent">
			<%--上一页 --%>
			<c:choose>
				<c:when test="${page.pageNum eq 1 }">
					<span class="spanBtnDisabled">上一页</span>
				</c:when>
				<c:otherwise>
					<a href="${page.url }&pageNum=${page.pageNum-1 }" class="aBtn bold">上一页</a>
				</c:otherwise>
			</c:choose>

			<%-- 显示页码列表 --%>
			<c:forEach begin="${page.start }" end="${page.end }" var="i">
				<c:choose>
					<c:when test="${i eq page.pageNum }">
						<span class="spanBtnSelect">${i }</span>
					</c:when>
					<c:otherwise>
						<a href="${page.url }&pageNum=${i}" class="aBtn">${i }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<%-- 显示点点点 --%>
			<c:choose>
				<c:when test="${page.end != page.totalPages}">
					<span class="spanApostrophe">...</span>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>




			<%--下一页 --%>

			<c:choose>
				<c:when test="${page.pageNum eq page.totalPages }">
					<span class="spanBtnDisabled">下一页</span>
				</c:when>
				<c:otherwise>
					<a href="${page.url }&pageNum=${page.pageNum+1 }" class="aBtn bold">下一页</a>
				</c:otherwise>
			</c:choose>


			<%-- 共N页 到M页 --%>
			<span>共${page.totalPages }页</span> <span>到</span> <input type="text"
				class="inputPageCode" id="pageCode" value="${page.pageNum }" /> <span>页</span>
			<a href="javascript:_go();" class="aSubmit">确定</a>
		</div>
	</div>
	<br/><br/><br/><br/>
</body>

<script type="text/javascript">

	/* 页面跳转 点击确定时调用的函数 */
	function _go() {
		var pageNum = $("#pageCode").val();//获取文本框中的当前页码
		if(!/^[1-9]\d*$/.test(pageNum)) {//对当前页码进行整数校验
			$("#pageCode").val("");
			alert('请输入正确的页码！');
			return;
		}
		if(pageNum > ${page.totalPages} || pageNum<1) {//判断当前页码是否大于最大页
			$("#pageCode").val("");
			alert('请输入正确的页码！');
			return;
		}
		location = "${page.url}&pageNum="+pageNum; 
	}
</script>
</html>