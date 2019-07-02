//取消按钮回到首页
function Deselect(){
	window.location.href="mainweb.jsp"
}
function pay(){
	var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
	var money=$("#money").val()
	if(!reg.test(money)){
		$("#msg").val("金额格式不正确");
	}
	
	$.ajax({
		type:"post",
		url:"userservlet",
		data:{
			money:money,
			actionName:"paying"
		},
		success:function(result){
			if(result.code==1){
				$("#msg").html(result.msg);
			window.location.href="userservlet?actionName=Pay";
				return;
			}else{
				$("#msg").html(result.msg);
				
				return;
			}
		}
	
			
	})
	
}
