<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>

<link rel="stylesheet" href="statics/css/bootstrap.min.css">
<link href="statics/sweetalert/sweetalert2.min.css" rel="stylesheet">
<script src="statics/sweetalert/sweetalert2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户地址</title>

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title  text-center">用户地址</h3>

					</div>
					<div class="text-right">
						<button class="btn btn-success btn-sm" type="button" id="addbtn">添加地址</button>
					</div>
				</div>
				<div id="myDiv">
					<c:if test="${resultInfo.code==0 }">
						<h2>${resultIfo.msg }</h2>
					</c:if>
					<c:if test="${resultInfo.code==1 }">
						<table class="table  table-bordered" id="myTable">
							<thead>
								<tr>
									<th>编号</th>
									<th>地址</th>

									<th>是否默认</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="tbody">
								<c:forEach items="${resultInfo.result }" var="item">
									<tr id="tr_${item.aid }">
										<td>${item.aid }</td>
										<td>${item.address }</td>
										<c:if test="${item.isdefault==1 }">
											<td>是</td>
										</c:if>
										<c:if test="${item.isdefault!=1 }">
											<td>否</td>
										</c:if>
										<td>
											<button class="btn btn-primary" type="button"
												onclick="openUpdateDialog(${item.aid })">修改</button>&nbsp;
											<button class="btn btn-danger del" type="button"
												onclick="deleteAddress(${item.aid })">删除</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
					<br/><br/><br/><br/>

				</div>
				<a href="javascript:void(0);" onclick="self.location=document.referrer;">返回订单</a>
			</div>
		</div>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel"></h4>
				</div>
				<div class="modal-body">
					<input type="hidden" id="aid" value="" />
					<div class="form-group">
						<label for="address">地址名称名称</label> <input type="text"
							class="form-control" id="address" placeholder="请输入地址"> <input
							type="text" class="form-control" id="isdefault"
							placeholder="请输入是否默认">
					</div>
				</div>
				<div class="modal-footer">
				
				<!-- 模态框中显示提示信息的地方 -->
					<span id="msg" style="font-size: 12px; color: red;"></span>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						onclick="submitAddress()">提交</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>


	<script src="address/utils.js"></script>
	<script src="statics/js/jquery.1.12.4.min.js"></script>
	<script src="statics/js/bootstrap.min.js"></script>
	<script src="address/address.js"></script>
</html>