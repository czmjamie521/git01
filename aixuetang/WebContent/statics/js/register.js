//验证用户名唯一性

$("#id_username").blur(function(){
	var uname=$("#id_username").val();
	
	if(isEmpty(uname)){
		$("#msg").html("用户名不能为空,请填写用户名!");
		$("#id_username").focus();
		$("#btn").prop("disabled",true);
		return;
	}
	$("#msg").html("");
	$.ajax({
		type:"post",
		url:"registerservlet",
		data:{
			uname:uname,
			actionName:"unique"
		},
		success:function(result){
			if(result.code==0){
				$("#msg").html(result.msg);
				$("#btn").prop("disabled",true);
				return;
			}
			else{
				$("#btn").prop("disabled",false);
				
			}
		}
	})
})

function signUp(){
	//获得框中的值
	var uname=$("#id_username").val();
	var email=$("#id_email").val();
	var phone=$("#id_phone_number").val();
	var upwd=$("#id_password").val();
	var reupwd=$("#id_repeat_password").val();
	var head=$("#file-selector").val();
	//判断非空
	if(isEmpty(head)){
		$("#msg").html("* head不能为空,请填写号码!");
		return;
	}
	if(checkEmail(email)){
		$("#msg").html("* email,请填写号码!");
		return;
	}
	if(checkphone(phone)){
		$("#msg").html("* 号码格式错误,请填写号码!");
		return;
	}
	if(isEmpty(upwd)){
		$("#msg").html("* 用户密码不能为空,请填写密码!");
		return;
	}
	

	if(isEmpty(reupwd)){
		$("#msg").html("* 确认密码不能为空,请填写确认密码");
		return;
	}
	//确认密码和密码必须相同
	if(upwd!=reupwd){
		$("#msg").html("* 确认密码和密码必须相同,请填写确认密码");
		return;
	}
	//向后台发送ajax
	$.ajax({
		type:"post",
		url:"registerservlet",
		data:{
			uname:uname,
			email:email,
			phone:phone,
			upwd:upwd,
			head:head,
			actionName:"register"
				
		},
		success:function(result){
			if(result.code==0){
//				
				 swal(result.msg,"","success");
				return;
			}
			else{
				$("#msg").html(result.msg);
				window.location.href="userservlet?actionName=logining";
			}
		}
	})
}  
