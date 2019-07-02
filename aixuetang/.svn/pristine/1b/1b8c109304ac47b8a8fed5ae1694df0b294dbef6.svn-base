<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="zxx">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap Min CSS -->
        <link rel="stylesheet" href="statics/css/bootstrap.min.css">
        <!-- Animate CSS -->
        <link rel="stylesheet" href="statics/css/animate.min.css">
        <!-- IcoFont CSS -->
        <link rel="stylesheet" href="statics/css/icofont.min.css">
        <!-- Owl Carousel CSS -->
        <link rel="stylesheet" href="statics/css/owl.carousel.min.css">
        <!-- Owl Theme Default CSS -->
        <link rel="stylesheet" href="statics/css/owl.theme.default.min.css">
        <!-- Magnific Popup CSS -->
        <link rel="stylesheet" href="statics/css/magnific-popup.css">
        <!-- Main CSS -->
        <link rel="stylesheet" href="statics/css/main.css">
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="statics/css/responsive.css">
        <!-- Favicon -->
        <link rel="icon" type="image/png" href="statics/img/mainweb/favicon.png">
        
        <!-- JQuery Min JS -->
        <script src="statics/js/jquery.1.12.4.min.js"></script>
        <!-- Popper Min JS -->
        <script src="statics/js/popper.min.js"></script>
        <!-- Bootstrap Min JS -->
        <script src="statics/js/bootstrap.min.js"></script>
        <!-- Owl Carousel JS -->
        <script src="statics/js/owl.carousel.min.js"></script>
        <!-- Magnific Popup JS -->
        <script src="statics/js/jquery.magnific-popup.min.js"></script>
        <!-- WayPonits JS -->
        <script src="statics/js/waypoints.js"></script>
        <!-- CounterUp JS -->
        <script src="statics/js/jquery.counterup.min.js"></script>
		<!-- Tilt JS -->
        <script src="statics/js/tilt.jquery.min.js"></script>
        <!-- Form Validator JS FILES -->
        <script src="statics/js/form-validator.min.js"></script>
        <!-- Contact Form JS -->
        <script src="statics/js/contact-form-script.js"></script>
        <!-- Script JS -->
        <script src="statics/js/script.js"></script>
        
        <title>EduSplash - Education Responsive HTML Template</title>
    </head>

    <body>
        <!-- Preloader -->
        <div class="preloader">
            <div class="loader">
                <div class="spinner">
                    <div class="double-bounce1"></div>
                    <div class="double-bounce2"></div>
                </div>
            </div>
        </div>
        <!-- End Preloader -->
        
        <!-- Top header -->
        <header class="top-header"> 
            <div class="container"> 
                <div class="row"> 
                    <div class="col-md-6 col-lg-6"> 
                        <ul class="top-info-links"> 
                            <li><i class="icofont-clock-time"></i> 7.30 AM - 9.30 PM</li>
                            <li><i class="icofont-phone-circle"></i> +44 485854789</li>
                        </ul>
                    </div>
                    
                    <div class="col-md-6 col-lg-6 text-right"> 
                        <ul class="top-social-links"> 
                            <li><a href="#"><i class="icofont-twitter"></i></a></li>
                            <li><a href="#"><i class="icofont-facebook"></i></a></li>
                            <li><a href="#"><i class="icofont-linkedin"></i></a></li>
                            <li><a href="#"><i class="icofont-instagram"></i></a></li>
                        </ul>
                        
                        <ul class="login-regi-links">
	                        <c:if test="${empty user.uname }">
	                        <li><a href="userservlet?actionName=logining">登陆</a></li>
	                        </c:if>
	                            <c:if test="${!empty user.uname }">
			                         <li><a href="">用户:${user.uname }</a></li>
			                         <li><a href="userservlet?actionName=logining">切换用户</a></li>
			                         <li><a href="userservlet?actionName=Pay">充值</a></li>
	                        </c:if>
	                            <li><a href="registerservlet?actionName=registering">注册</a></li>
	                             <li><a href="userservlet?actionName=logout">注销</a></li>
                              
                        </ul>
                    </div>
                </div>
            </div>
        </header>
        <!-- End top header -->
  
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-light edu-navbar header-sticky">
            <div class="container">
                <a class="navbar-brand" href="mainweb.jsp">
                    <img src="statics/img/mainweb/logo.png" alt="Logo">
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item dropdown">
                            <a class="nav-link " href="courseservlet?actionName=mainweb">
                                		主页
                            </a>
                      
                        </li>
                     
                        <li class="nav-item dropdown">
                            <a class="nav-link " href="courseservlet?actionName=courseintroduce" >
                          	   关于我们
                            </a>                        
                        </li>
 
                         <li class="nav-item dropdown">
                            <a class="nav-link " href="instructorservlet?actionName=query" >
                          	      教师风采
                            </a>                        
                        </li>                                             
                        <li class="nav-item  dropdown">
                            <a class="nav-link " href="courseservlet?actionName=loadcourse"  >
                           		      星教育课程
                            </a>

                           
                        </li>
                        
                        <!-- 显示购物车界面 -->
                        <li class="nav-item dropdown">
                            <a class="nav-link " href="cart?actionName=showCart" >
                            		   购物车
                            </a>
                        </li>
                        
                        <!-- 显示订单界面 -->
                        <li class="nav-item">
                            <a class="nav-link" href="/aixuetang/order?actionName=showOrder&pageNum=1">
                            	我的订单
                            </a>
                        </li>
                        
                         <li class="nav-item dropdown">
                            <a class="nav-link " href="courseservlet?actionName=singleperson" >
                          	           用户中心
                            </a> 
                       
                       
                    </ul>
                </div>
            </div>
        </nav>
        <!-- End navbar -->
       
        
        <!-- End Search Modal -->
        
        <!-- Page Banner -->
        <div class="page-banner banner-bg-one">
            <div class="container"> 
                <div class="banner-text"> 
                    <h1> 知识改变命运</h1>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item active" aria-current="page">每天都是一个起点,每天都有一点进步,每天都有一点收获!</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        <!-- End Page Banner -->
        <div>
        
        
      <!-- 动态包含页面, 如果没有设置过 changePage, 默认courseshop.jsp -->  
      <c:if test="${empty changePage }">
          <jsp:include page="usercenter.jsp"></jsp:include>
      </c:if>
      
      <c:if test="${!empty changePage }">
          <jsp:include page="${changePage }"></jsp:include>
      </c:if>
      <!-- 动态包含页面 -->  
        
         
       </div>
        <!-- Footer Area -->
        <footer class="footer-area ptb-100">
            <div class="container">
				
				
				
				
				
				
				<!-- 删除的元素, 留待修改 -->  
				
				
				              
				              
				              
                <div class="row">
                    <div class="col-sm-7 col-md-6 col-lg-3">
                        <div class="single-footer-widget">
                            <h3>关于我们</h3>
                            <p>爱学堂专注于:JavaEE,人工智能+Python教育,大数据教育,区块链教育.</p>
                            <p>让你轻松学习,在这里可以找到你理想中的学习教程.</p>
                        </div>
                    </div>
                    
                    <div class="col-sm-5 col-md-6 col-lg-3">
                        <div class="single-footer-widget pl-30">
                            <h3>Quick Menu</h3>
                            <ul class="quick-menu">
                                <li><a href="courseservlet?actionName=mainweb"><i class="icofont-thin-double-right"></i> 主页</a></li>
                                <li><a href="courseservlet?actionName=courseintroduce"><i class="icofont-thin-double-right"></i> 关于我们</a></li>
                                <li><a href="instructorservlet?actionName=query"><i class="icofont-thin-double-right"></i> 教师风采</a></li>
                                <li><a href="courseservlet?actionName=loadcourse"><i class="icofont-thin-double-right"></i> 星教育</a></li>
                                <li><a href="cart?actionName=showCart"><i class="icofont-thin-double-right"></i> 购物车</a></li>
                                <li><a href="用户中心"><i class="icofont-thin-double-right"></i> 用户中心</a></li>
                            </ul>
                        </div>
                    </div>
                    
                    <div class="col-sm-6 col-md-6 col-lg-3">
                        <div class="single-footer-widget">
                            <h3>Instagram Feed</h3>
                            <ul class="instagram-feed">
                                <li><a href="#"><img src="statics/img/instagram-feed/1.jpg" alt="Instagram image"></a></li>
                                <li><a href="#"><img src="statics/img/instagram-feed/2.jpg" alt="Instagram image"></a></li>
                                <li><a href="#"><img src="statics/img/instagram-feed/3.jpg" alt="Instagram image"></a></li>
                                <li><a href="#"><img src="statics/img/instagram-feed/4.jpg" alt="Instagram image"></a></li>
                                <li><a href="#"><img src="statics/img/instagram-feed/5.jpg" alt="Instagram image"></a></li>
                                <li><a href="#"><img src="statics/img/instagram-feed/6.jpg" alt="Instagram image"></a></li>
                                <li><a href="#"><img src="statics/img/instagram-feed/5.jpg" alt="Instagram image"></a></li>
                                <li><a href="#"><img src="statics/img/instagram-feed/2.jpg" alt="Instagram image"></a></li>
                                <li><a href="#"><img src="statics/img/instagram-feed/1.jpg" alt="Instagram image"></a></li>
                            </ul>
                        </div>
                    </div>
                 
                </div>
            </div>
        </footer>
        <!-- End Footer Area -->
        
        <!-- Bottom footer -->
        <div class="bottom-footer">
            <div class="container"> 
                <div class="row"> 
                    <div class="col-md-6 col-lg-6"> 
                        <p>Copyright &copy; 2019.Company name All rights reserved.	</p>
                    </div>
                    
                    <div class="col-md-6 col-lg-6"> 
                        <ul class="social-links">
                            <li><a href="#"><i class="icofont-twitter"></i></a></li>
                            <li><a href="#"><i class="icofont-facebook"></i></a></li>
                            <li><a href="#"><i class="icofont-linkedin"></i></a></li>
                            <li><a href="#"><i class="icofont-instagram"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- End bottom footer -->
       
    
     
        
    </body>
</html>