//得到密码框和眼睛对象

//点击事件
function seePwd(){
	var eye=document.getElementById("eye");
	var password=document.getElementById("id_password");
	if(password.type=="password"){
		password.type="text";
		eye.className="glyphicon glyphicon-eye-close";
	}
	else{
		password.type="password";
		eye.className="glyphicon glyphicon-eye-open";
	}
}