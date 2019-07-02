//为评价框绑定鼠标移事件
window.onload=function(){
	//获取教师id
	var id=$("#teacherid").val();
	console.log(id)
	//发送ajax请求
	 $.ajax({
		  type:"get",
		  url:"teacherservlet",
		  data:{
			  //查询该教师是否有课程
			  actionName:"seach",
			  teacherid:id,
		  },
		  success:function(result) {
			  // 判断是否查询成功
			  if (result.code == 1) { 
				 //进行DOM操作,获取表格对象
				 
				  var tr=$("#tablebody").children().children();
				//循环读取对象中的数据
				  console.log(result.result.length);
				  for(var i=0;i<result.result.length;i++){
				 th="<tr>";
				 th+="<th>"+result.result[i].coursename+"</th>" ;
				 th+="<th>$"+result.result[i].price+"</th>";
				 th+="<th>"+result.result[i].desc+"</th>";
				 th+="</tr>"
				 $("#tablebody").append(th);
				
			 }
			  } 
			  
			  //没有查询课程信息
			  if(result.code==0){
				  //移除整个表格
				  $("#table").remove();
				 
				  $("#teachermsg").html("该教师暂无课程信息!");
			  }
			  
			  
			  
		  }
	  });
	 
	 console.log("wadwd");
	//获取该教师的所有的评价信息	  
		var id=$("#teacherid").val();
		  $.ajax({
			  type:"get",
			  url:"teacherservlet",
			  data:{
				  actionName:"loadcomment",
				  teacherid:id,
			  },
			  success:function(result) {
				  //表示查询成功
				 if(result.code==1){
				//循环读取获取返回的集合对象
				for(var i=0;i<result.result.length;i++){
				
				var tr="<div class='media'>";
				tr+="<img class='mr-3' src='instructorservlet?actionName=pictory&file="+result.result[i].head+"'>";
				tr+="<div class='media-body'>";
				tr+="<h5 class='mt-0'+>"+result.result[i].uname+"</h5>";
				tr+=" <span class='data'>"+result.result[i].public_time+"</span>";
				tr+="<p>"+result.result[i].comment+"</p> </div></div>" ;
				
			
				//得到评论的框的对象
				  $("#addcomment").append(tr)
	
				}	 
				//为评论数目span赋值
				  $("#commentsize").text("("+result.size+")");
					 
				 }
				 else{
				
					
					  $("#teacherreviews").html("该教师暂无评价信息");
				 }
				
			  }
		  })	 	  
		   
};

$("#review").blur(function(){
	//获取意见框的文本值
	var review=$("#review").val();
	//判断是否为空
	
	if(review==null||review.trim()==""){
		$("#msg").html("意见不能为空！");
		$("#submit").prop('disabled',true);
	}
}).focus(function(){
	$("#msg").html(" ");
		$("#submit").prop('disabled',false);
})


//需求：1.该学生必须选择该老师的课程才能评论
//    2.学生用户无论是否购买都可以可以评论子评论
//获取按键
$("#submit").click(function(){
	//获取评论框的文本值和教师id
	var review=$("#review").val();
	var id=$("#teacherid").val();
	//ajax后台校验
	console.log(review)
	console.log(id)
	 $.ajax({
		  type:"get",
		  url:"teacherservlet",
		  data:{
			  actionName:"cheakuser",
			  teacherid:id,
		  },
		  success:function(result) {
			  // 判断是否查询成功
			  if (result.code ==0) { 
				 //进行DOM操作,获取表格对象
				  $("#msg").html("请先购买该课程在进行评价！");
				  $("#submit").prop('disabled',true);
			 }
			  //查询到该学生已经购买了该课程
			  if(result.code ==1){
				  //进行ajax进行更新评论功能
				 /**1.获取评论框的文本值
				  * 2.提交相关的参数，包括教师Id，评论内容，以及评论时间
				  */ 
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
	
				  var review=$("#review").val();
				  $.ajax({
					  type:"get",
					  url:"teacherservlet",
					  data:{
						  actionName:"addteachercomment",
						  teacherid:id,
						  comment:review,
						  currentdate:currentdate
					  },
					  success:function(result) {
						//
						 if(result.code==1){
							 
							 var tr="<div class='media'>";
								tr+="<img class='mr-3' src='instructorservlet?actionName=pictory&file="+result.result.head+"'>";
								tr+="<div class='media-body'>";
								tr+="<h5 class='mt-0'+>"+result.result.uname+"</h5>";
								tr+=" <span class='data'>"+result.result.public_time+"</span>";
								tr+="<p>"+result.result.comment+"</p> </div></div>" ; 
							
								 $("#addcomment").append(tr)
								 //清空评论框的内容
								 var review=$("#review").val("");
								//重新为前台计数赋值
								 $("#commentsize").text("("+result.size+")");
								 
						 }
						  
						  
						  
					  }
					 
					
				  })	 
				  
				 
				  
				  
			  }
			  
		  
		  }
	  });
	
	
});
