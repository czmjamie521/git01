//预加载聚焦事件
$(function(){
	$("#id_username").focus();
})
//失焦事件
$("#id_username").blur(function(){
	//得到id_username的值
	var uname=$("#id_username").val();
	//判断id_username的值是否非空
	//如果为空
	if(isEmpty(uname)){
		//重新聚焦
		$("#id_username").focus();
		//提示信息
		$("#msg").html("* 用户名信息不能为空");
		//login键失效
		$("#btn").prop("disabled",true);
		return;
	}
	$("#msg").html("");
	//发送ajax请求验证是否有该用户
	$.ajax({
		type:"post",
		url:"userservlet",
		data:{
			uname:uname,
			actionName:"checkuname",//加引号
		},
		success:function(result){
			if(result.code==0){
				$("#msg").html(result.msg);
				$("#id_username").focus();
				return;
			}else{
				$("#btn").prop("disabled",false);
			}
		}
	})
})
//登录功能
//onclick登录事件
function login_on(){
	//获得参数uname和upwd
	var uname=$("#id_username").val();
	var upwd=$("#id_password").val();
	//判断密码非空
	if(isEmpty(upwd)){
		$("#msg").html("用户密码不能为空");
		return;
	}
	//ajax向后台发送
	$.ajax({
		type:"post",
		url:"userservlet",
		data:{
			uname:uname,
			upwd:upwd,
			actionName:"login",
			
		},
		success:function(result){
			if(result.code==1){
			window.location.href="mainweb.jsp";
				
			}
			else{
				$("#msg").html(result.msg);
				return;
			}
			
		}
	})
	
}
