
//删除地址 调用此方法
function deleteAddress(aid) {
	// 弹出提示框询问用户是否确认删除
	swal({ 
		  title: "你确定要删除这条记录吗？", 
		  text: "", 
		  type: "warning",
		  showCancelButton: true, 
		  confirmButtonColor: "orange",
		  confirmButtonText: "确定",
		  cancelButtonText: "取消"
	}).then(function(){
		
		  // 发送ajax请求，删除指定类型的记录
		  $.ajax({
			  type:"post",
			  url:"addressServlet",
			  data:{
				  actionName:"deleteAddresss",
				  aid:aid
			  },
			  success:function(result) {
				  // 判断是否删除成功
				  if (result.code == 1) {
					  // 删除成功
					  // 提示用户删除成功
					 
					  swal(result.msg,"","success");
					  // 删除的DOM操作
					  deleteDom(aid);
				  } else {
					// 提示用户删除失败
					  swal(result.msg,"","error");
				  }
			  }
		  });
	});
}


function deleteDom(aid) {
	
	
	// 1、得到table对象
	var myTable = $("#myTable");
	// 2、得到table对象的子元素tr （得到table的子元素tbody，再得到子元素tr）
	var trs = myTable.children().children();
	// 3、判断tr的长度
	if (trs.length > 2) {
		// 如果大于2（表头+多条类型记录），直接移除指定tr对象  （tr元素添加id属性值，id="tr_" + typeId）
		$("#tr_" + aid).remove();
	} else {
		// 如果等于2，（表头+1条类型记录），移除整个table对象，并设置提示信息 （给table的父元素div,绑定id属性值）
		myTable.remove();
		$("#myDiv").html("<h2>暂未查询到类型记录！</h2>");
	}
}


//前台修改地址, 直接调用此方法, 设置模态框初始值
function openUpdateDialog(aid) {
	
	// 设置修改模态框的标题
	$("#myModalLabel").html(" 修改地址");
	
	// 获取要修改的行记录
	var tr = $("#tr_" + aid);
	// 给模态框赋默认值; 地址名 和是否默认,  1代表默认
	var tname = tr.children().eq(1).text();
	var tis=tr.children().eq(2).text();
	if("是"==tis){
		tis=1;
	}else{
		tis=0;
	}
	
	// 给模态框的文本框赋值
	$("#address").val(tname);
	$("#isdefault").val(tis);
	
	//清空提示信息
	$("#msg").text("");

	// 给typeId的隐藏域赋值
	$("#aid").val(aid);
	
	// 打开模态框
	$("#myModal").modal("show");
	
}

/**
 * 通过id绑定按钮的点击事件，打开添加模态框
 */
$("#addbtn").click(function(){
	
	// 每次打开模态框时，清空模态框中的文本框和隐藏域的值
	$("#address").val("");
	$("#aid").val("");
	$("#isdefault").val("");
	
	// 清空提示信息
	$("#msg").html("");
	
	// 设置添加模态框的标题
	$("#myModalLabel").html("添加地址");
	
	// 打开模态框
	$("#myModal").modal("show");
});





/**
 * 获取模态框中的值，发送ajax请求
 */
function submitAddress() {
	
	// 获取文本框的值
	var address = $("#address").val();
	var isdefault=$("#isdefault").val();
	// 修改操作：隐藏域中色typeId （如果是添加操作，则为null；不需要单独判断typeId的值，若为null则为添加操作；不为空则为修改操作）
	var aid =  $("#aid").val();
	
	// 判断类型名称是否为空
	if (isEmpty(address)) {
		$("#msg").html("地址不可为空！");
		return;
	}
	
	// 发送ajax请求后台，验证类型名是否可用
	// 请求路径   请求参数   回调函数
	$.get("addressServlet", {actionName:"checkAddress",address:address,isdefault:isdefault, aid:aid},function(result){
		// 判断是否可用
		if (result.code != 1) {
			// 提示用户不可用
			$("#msg").html(result.msg);
			return;
		} else {
			// 必须等待验证结果返回之后才能调用更新方法
			// 请求后台调用 执行更新或添加的接口
			
			$.ajax({
				type:"post",
				url:"addressServlet",
				data:{
					
					//aid 为空, 则调用 add  否则调用update
					actionName:"addOrUpdate",
					address:address,
					aid:aid,
					isdefault: isdefault
					
				},
				success:function(result){
					// 判断是否更新成功
					if (result.code == 1) {
						// 成功
						// 提示用户成功
						swal("更新成功","","success");
						// DOM操作, 异步加载页面
						loadPage(result.result);
						
						
						// 如果typeId不为空，则为修改操作；为空则为添加操作
//						if (isEmpty(aid)) {
//							// 添加的 DOM操作   
//							addDom(result.result);
//							
//						}  else  {
//							// 修改的DOM操作   
//							updateDom(aid,address);
//						}
					} else {
						// 失败
						$("#msg").html(result.msg);
						
						swal(result.msg,"","error");
					}
					// 关闭模态框
					$("#myModal").modal("hide");
					
				}
			});
			
			
		}
	});
	
	
	
}

/**
 * 修改类型的DOM操作
 * 	1、修改指定行的类型名称单元格的值
 * 	2、修改左侧类型名分组的类型名
 * @param typeId
 * @param typeName
 */
function updateDom (aid,address) {
	// 1、修改指定行的类型名称单元格的值
	var tr = $("#tr_" + aid);
	// 修改类型名称单元格的值
	tr.children().eq(1).text(address);
	
}


/**
 * 添加类型
 * 	表格：
 * 		1、表格存在，追加tr记录
 * 		2、表格不存在，创建表格，追加tr，将表格追加到div中
 *	左侧分组：
 *		1、追加li记录
 * @param noteType
 */
function addDom (noteType) {
	
	if(noteType.isdefault==1){
		isdefault="是";
	}else{
		isdefault="否";
	}
	
	// 拼接tr字符串
	var tr = '<tr id="tr_'+noteType.aid+'">';
	tr += '<td>'+noteType.aid+'</td><td>'+noteType.address+'</td><td>'+isdefault+'</td>';
	tr += '<td><button class="btn btn-primary" type="button" onclick="openUpdateDialog('+noteType.aid+')">修改</button>&nbsp&nbsp&nbsp;';
	tr += '<button class="btn btn-danger del" type="button" onclick="deleteType('+noteType.aid+')">删除</button>';
	tr += '</td></tr>';
	
	// 得到table对象
	var myTable = $("#myTable");
	// 判断表格对象是否存在 （判断表格的length是否大于0）
	if (myTable.length > 0) {
		// 表格存在，则直接追加tr对象
		myTable.append(tr);
	} else {
		// 表格不存在，创建表格，追加tr，将表格追加到div中
		var table = '<table class="table table-hover table-striped " id="myTable">';
		table += '<tbody> <tr> <th>编号</th> <th>地址</th> <th>是否默认</th><th>操作</th> </tr>';
		table += tr + '</tbody></table>';
		// 直接将表格赋值到div中 （覆盖默认的h2标签）
		$("#myDiv").html(table);
	}
	
	
}

//根据地址数组, 加载当前界面
function loadPage(addressList){
	var len =addressList.length;
	var tbody ="";
	var isdefault ="否";
	for(var i=0;i<len;i++){
		if(addressList[i].isdefault ==1){
			isdefault ="是";
		}
		var tr = '<tr id="tr_'+addressList[i].aid+'">';
		tr += '<td>'+addressList[i].aid+'</td><td>'+addressList[i].address+'</td><td>'+isdefault+'</td>';
		tr += '<td><button class="btn btn-primary" type="button" onclick="openUpdateDialog('+addressList[i].aid+')">修改</button>&nbsp&nbsp&nbsp;';
		tr += '<button class="btn btn-danger del" type="button" onclick="deleteAddress('+addressList[i].aid+')">删除</button>';
		tr += '</td></tr>';
		
		tbody +=tr;
		isdefault ="否";
	}
	var myDiv ="<table class='table  table-bordered' id='myTable'>"+
							"<thead><tr><th>编号</th><th>地址</th><th>是否默认</th><th>操作</th></tr></thead>"+
							"<tbody id='tbody'></tbody></table>";
	$("#myDiv").html(myDiv);
	$("#tbody").html(tbody);
	
}


















