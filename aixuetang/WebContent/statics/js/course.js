function commentSubmit(commentid,courseid){
	
	var  comment=$("#enterreview").val();
	if(comment==null){
		$("#warn").val("评论不能为空");
		return;
	}
	$.ajax({
	type:"post",
	url:"commentservlet",
	data:{
		actionName:"commentSubmit",
		comment:comment,
		
		courseid:courseid
	},
		success:function(result){
			var a=$("#pingjia1").html();
			var b=$("#pingjia2").html();
			if(result.code!=1){
				$("#warn").val(result.msg);
			}else{
				$("#pingjia1").html(parseInt(a)+1);
				$("#pingjia2").html(parseInt(b)+1);
				//获取当前时间，格式YYYY-MM-DD			   
			        var date = new Date();
			        var seperator1 = "-";
			        var seperator2 = ":";
			        var year = date.getFullYear();
			        var month = date.getMonth() + 1;
			        var strDate = date.getDate();
			        var hour=date.getHours();
			        var mis=date.getMinutes()
			     
			        if (month >= 1 && month <= 9) {
			            month = "0" + month;
			        }
			        if (strDate >= 0 && strDate <= 9) {
			            strDate = "0" + strDate;
			        }
			        if (hour >= 0 && hour <= 9) {
			        	hour = "0" + hour;
			        }
			        if (mis >= 0 && mis <= 9) {
			        	mis = "0" + mis;
			        }
			       			        
			        var currentdate = year + seperator1 + month + seperator1 + strDate+"  "+hour+seperator2+mis;
				var div= "<div class='media'>";
				div +="<img class='mr-3' src='statics/img/tutor/"+result.result.head+"'alt=''>";
				div +=" <div class='media-body'> "
					div +=" <h5 class='mt-0'>"+result.result.uname +"</h5>";
					div +="<span class='date'>"+currentdate+"</span>";						
					div +=" <p>"+result.result.content+"</p> </div> </div>";
					div +=" <a href='javascript:void(0)' onclick='reply(\""+commentid+"\",\""+result.result.commentid+"\","+result.result.courseid+")'>评论</a>";
				$("#review").prepend(div);
			
			}
			
		}

	})
}
	function reply(commentid1,commentid,courseid){
		
		if(commentid==null||courseid==null){
			$("#replywarn").html("网络错误,请重试");
			return;
		}
		$("#myModal").modal("show");
		$("#CommentId").val(commentid);
		$("#CommentId1").val(commentid1);
		$("#courseId").val(courseid);
	
}
	function submitreply(){
		
		var a=$("#pingjia1").html();
		var b=$("#pingjia2").html();
		var courseid=$("#courseId").val();
		var commentid=$("#CommentId").val();
		
		var commentid1=$("#CommentId1").val();
		var name=$("#name"+commentid1).val();
		
		alert(name);
		var comment=$("#comment").val();
		console.log(comment);
		if(comment==null){
			$("#modalwarn").html("评论不可为空");
			return;
		}
		$.ajax({
			type:"post",
			url:"commentservlet",
			data:{
				actionName:"commentSubmit",
				comment:comment,
				courseid:courseid,
				commentid:commentid,
				commentid1:commentid1
			},
				success:function(result){
					if(result.code!=1){
						
					}else{
						$("#pingjia1").html(parseInt(a)+1);
						$("#pingjia2").html(parseInt(b)+1);
						//获取当前时间，格式YYYY-MM-DD			   
				        var date = new Date();
				        var seperator1 = "-";
				        var seperator2 = ":";
				        var year = date.getFullYear();
				        var month = date.getMonth() + 1;
				        var strDate = date.getDate();
				        var hour=date.getHours();
				        var mis=date.getMinutes()
				     
				        if (month >= 1 && month <= 9) {
				            month = "0" + month;
				        }
				        if (strDate >= 0 && strDate <= 9) {
				            strDate = "0" + strDate;
				        }
				        if (hour >= 0 && hour <= 9) {
				        	hour = "0" + hour;
				        }
				        if (mis >= 0 && mis <= 9) {
				        	mis = "0" + mis;
				        }
				       			        
				        var currentdate = year + seperator1 + month + seperator1 + strDate+"  "+hour+seperator2+mis;
				        var e=result.result.commentid;
				        	
					var div="<div class='media'>";
					div +="<img class='mr-3' src='statics/img/tutor/"+result.result.head+"'alt=''>";
					div +=" <div class='media-body'> "
						div +=" <h5 class='mt-0'>"+result.result.uname +"</h5>";
						div +="<span class='date'>"+currentdate+"</span>";
						div += "<h6>回复("+$("#name"+commentid1).val()+")</h6>"						
					div +=" <p>"+result.result.content+"</p> </div> </div>";
						div +="</div><div id=''div_"+result.result.commentid+"'> </div>";
						div +=" <a href='javascript:void(0)' onclick='reply(\""+commentid+"\",\""+e+"\","+result.result.courseid+")'>*评论</a>";
						$("#div_"+commentid).append(div);
						
					}
					$("#myModal").modal("hide");
				}

			})
			
	}

	
	//批量将单个course加入购物车, 点击"加入购物车"调用
	function batchAdd(courseid){
		var amount =$("#amount").val();
		//前台验证课程份数
		if(amount<1 || amount>9){
			alert("只能选择1-9份!");
			return;
		}
		$.ajax({
			url:"cart",
			data:{
				actionName:"batchAdd",
				courseid: courseid,
				amount: amount
			},
			type:"post",
			dataType:"json",
			cache:false,
			success: function(result){
				if(result =="请先登录"){
					location ="Login.jsp";
				}
				alert(result);
			}
		})
	}
	
	function updateuser(){
		
	var useremail=$("#Useremail").val();
	var userphone=$("#phone_number").val();	
	var sex=$("#exampleFormControlSelect1").val();	
	var age=$("#Street_address").val();	
	console.log(useremail,userphone,sex,age);
	if(isempty(useremail)){
		$("#warnmsg").html("邮箱不能为空");	
		return;
	}
	if(checkEmail(useremail)){
		$("#warnmsg").html("邮箱格式不正确，请重新输入！");
		return;
	}
	if(isempty(userphone)){
		$("#warnmsg").html("电话不能为空");		
		return;
	}
	if(checkphone(userphone)){
		$("#warnmsg").html("电话格式不正确，请重新输入！");
		return;
	}
	if(isempty(sex)){	
		$("#warnmsg").html("性别不能为空");
		return;
	}	
	if(isempty(age)){
		$("#warnmsg").html("年龄不能为空");
		return;
	}
	if(checkage(age)){
		$("#warnmsg").html("年龄不能超出范围,1-120岁");
		return;
	}
	$.ajax({
		type:"post",
		url:"userservlet",
		actionName:"updateuser",
		data:{
			actionName:"updateuser",
			useremail:useremail,
			userphone:userphone,
			sex:sex,
			age:age
		},
			success:function(result){
				if(result.code==1){
					alert("修改成功");
					$("#warnmsg").html("");
				}else{
					$("#warnmsg").html("网络波动,请重试");
				}
						
			}
			
	})
		
	}
	function isempty(String){
		var flag=false;
		if(String.length<1||""===String.trim()){
			flag=true;
		}
		return flag;
	}
	//验证邮箱
	 function checkEmail(str){
		 var flag=true;
		    var re = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/; 
		    if (re.test(str)) {
		    	flag=false;	
		    }
		    return flag;
	 }
	 function checkphone(str){
		 var flag=true;
		    var re = /^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/; 
		    if (re.test(str)) {
		    	flag=false;	
		    }
		    return flag;
	 }	  
	
	
		function checkage(str){
		 var flag=true;
		    var re = /^(?:[1-9][0-9]?|1[01][0-9]|120)$/; 
		    if (re.test(str)) {
		    	flag=false;	
		    }
		    return flag;
	 }	  
	
	
	
	
	
	
	
	
	
	
	