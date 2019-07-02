$('#id_password').keyup(function(){//添加键盘按键监听事件，当按键松开时做事
	var value = $(this).val();//取出输入框的值
	//当输入框未进行输入时清除所有密码强度显示
	if(value == undefined || value == ''){
		$(".qiangdu").removeClass("active");
		return;
	}

var weight = 0;
for(var i=0; i<value.length; i++){
	var c = value.substring(i, i+1);//循环取出每一个字符
	var reg1 = /[0-9]/;//正则表达式，匹配数字
	var reg2 = /[a-z]/;//正则表达式，匹配小写字符
	var reg3 = /[A-Z]/;//正则表达式，匹配大写字符
	if(reg1.test(c)){
		//进行按位或运算，如果下一个字符还是数字，
		//再与2进行按位或运算，就不会改变密码强
		//度的值，后面的运算，原理一致
		weight |= 2;//如果是数字，强度值+2
	} else if(reg2.test(c)){
		weight |= 4;//如果是小写字符，强度值+4
	} else if(reg3.test(c)){
		weight |= 8;//如果是大写字符，强度值+8
	} else {
		weight |= 16;//如果是特殊字符，强度值+16
	}
}
//强度值0-10为弱，10-20为中，>20为强
if(weight > 0 && weight <= 10){
	//强度值为弱时，清除所有已激活的强度显示
	$(".qiangdu").removeClass("active");
	//将强度弱显示出来
	$(".qiangdu:eq(0)").addClass("active");
} else if(weight > 10 && weight <= 20){
	//强度值为中时，清除所有已激活的强度显示
	$(".qiangdu").removeClass("active");
	//将强度弱显示出来
	$(".qiangdu:eq(0)").addClass("active");
	//将强度中显示出来
	$(".qiangdu:eq(1)").addClass("active");
} else {
	//强度值为中时，清除所有已激活的强度显示
	$(".qiangdu").removeClass("active");
	//将所有强度显示出来
	$(".qiangdu").addClass("active");
}
})
		