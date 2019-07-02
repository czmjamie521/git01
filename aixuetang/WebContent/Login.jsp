<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap Min CSS -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <!-- Animate CSS -->
        <link rel="stylesheet" href="assets/css/animate.min.css">
        <!-- IcoFont CSS -->
        <link rel="stylesheet" href="assets/css/icofont.min.css">
        <!-- Owl Carousel CSS -->
        <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
        <!-- Owl Theme Default CSS -->
        <link rel="stylesheet" href="assets/css/owl.theme.default.min.css">
        <!-- Magnific Popup CSS -->
        <link rel="stylesheet" href="assets/css/magnific-popup.css">
        <!-- Main CSS -->
        <link rel="stylesheet" href="assets/css/main.css">
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="assets/css/responsive.css">
        <!-- Favicon -->
        <link rel="icon" type="image/png" href="assets/img/favicon.png">
        <!-- font -awesome -->
  		<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
        
        <title>EduSplash - Education Responsive HTML Template</title>
    </head>
    <body>      
        <!-- Login -->
        <section class="login-section pt-100 pb-180">
            <div class="container">
                <div class="register-form box-content">
                    <h3 class="title">登录你的账户</h3>
                    <form>
                        <div class="form-group">
                            <input type="text" class="form-control" id="id_username" placeholder="请输入用户名" name="uname" value="">
                        </div>

                        <div class="form-group">
                        
                            <input type="password" class="form-control " id="id_password" placeholder="请输入密码" name="upwd" value="" >
                        	
                        </div>	
							        <a href="javascript:void(0)">
							          <span class="glyphicon glyphicon-eye-open" onclick="seePwd()" id="eye"></span>
							        </a>
                        <div class="form-foot"> 
                        
                            <button type="button" class="btn default-btn" id="btn" onclick="login_on()">登录</button>
                            <span style="font-size:12px ; color:red" id="msg"></span>
                            <p>没有帐户?<a href="registerservlet?actionName=registering">立即注册</a></p>
                        </div>
                    </form>
                   
                </div>
            </div>
        </section>
        <!-- End Login -->      
        <!-- JQuery Min JS -->
        <script src="assets/js/jquery.1.12.4.min.js"></script>
        <!-- Popper Min JS -->
        <script src="assets/js/popper.min.js"></script>
        <!-- Bootstrap Min JS -->
        <script src="assets/js/bootstrap.min.js"></script>
        <!-- Owl Carousel JS -->
        <script src="assets/js/owl.carousel.min.js"></script>
        <!-- Magnific Popup JS -->
        <script src="assets/js/jquery.magnific-popup.min.js"></script>
        <!-- WayPonits JS -->
        <script src="assets/js/waypoints.js"></script>
        <!-- CounterUp JS -->
        <script src="assets/js/jquery.counterup.min.js"></script>
		<!-- Tilt JS -->
        <script src="assets/js/tilt.jquery.min.js"></script>
        <!-- Form Validator JS FILES -->
        <script src="assets/js/form-validator.min.js"></script>
        <!-- Contact Form JS -->
        <script src="assets/js/contact-form-script.js"></script>
        <!-- Script JS -->
        <script src="assets/js/script.js"></script>
        <!-- utils判断非空 -->
        <script src="statics/js/utils.js"></script>
        <!-- login的js -->
        <script src="statics/js/Login.js"></script>
        <script src="statics/js/SeeUpwd.js"></script>
    </body>
</html>