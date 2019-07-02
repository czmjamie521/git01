<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html >
<html lang="zxx">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
        
       
    </head>

    <body>
    <br>
     <div class="col-lg-12"> 
           <div class="search-widget">
            <form action="instructorservlet" method="get">
            <input type="text" class="form-control" name="teachername" id="search_post" placeholder="输入老师的名字以查询..." value="${title }">  
            <input type="hidden" name="actionName" value="query">              
            <button type="submit" class="btn search-btn">
           <i class="icofont-search"></i>
           </button>
          </form>
          </div>
          </div>
        <!-- 教师版面 -->
        <section class="experienced-tutor pt-100 pb-180 white-bg">
        
        
      
        
        
        
        
            <div class="container">
                <div class="section-header">
                    <i class="icofont-education"></i>
                    <h2>教师风采</h2>       
                </div>
                <div class="row"> 
              <c:if test="${empty page }">
                <h3>暂未查询到教师信息</h3>
                </c:if>
                <!-- 能查询到信息循环进行读取 -->
                <c:if test="${!empty page }">  
                <c:forEach items="${page.dataList }" var="items">
                 
                <div class="col-sm-6 col-md-6 col-lg-3"> 
                        <div class="single-tutor gray-border">
                        <!-- 图片地址 -->
                        <a href="instructorservlet?actionName=teacher&teacherid=${items.teacherid }">  <img src="instructorservlet?actionName=pictory&file=${items.head }" alt="tutor"></a>
                            
                            <div class="tutor-title">
                                <h3>${items.teachername }</h3>
                                <p></p>
                            </div>
                            <p class="email-link"><a href="#">${items.email }</a></p>
                            <ul> 
                                <li><a href="#"><i class="icofont-facebook"></i></a></li>
                                <li><a href="#"><i class="icofont-twitter"></i></a></li>
                                <li><a href="#"><i class="icofont-linkedin"></i></a></li>
                                <li><a href="#"><i class="icofont-instagram"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </c:forEach>
             </c:if> 
                
     
               
                <!--导航 -->
                </div>
                <nav class="pagination-outer" aria-label="Page navigation">
                    <ul class="pagination">
                    
                    
                    <c:if test="${page.pageNum != 1 }">
			    		  <li class="page-item">
                            <a href="instructorservlet?actionName=query&pageNamu=${page.prePage }" class="page-link" aria-label="Previous">
                                <i class="icofont-swoosh-left"></i>
                            </a>
                        </li>
			    	</c:if>  
                    
                    
                       <c:forEach begin="${page.startNavPage }"  end="${page.endNavPage }" var="p">
			    		 <li class="page-item active">
                            <a class="page-link" href="instructorservlet?actionName=query&pageNamu=${p }&teachername=${title}">${p }</a>
                        </li>
			    		</c:forEach>
  
						<c:if test="${page.pageNum != page.totalPages }">
				    	 	<li class="page-item">
                            <a href="instructorservlet?actionName=query&pageNamu=${page.nextPage }" class="page-link" aria-label="Next">
                                <i class="icofont-swoosh-right"></i>
                            </a>
                         	</li>
			  			</c:if>
                   </ul>
                </nav>
                <!-- End Pagination -->
          
          </div>   
        </section>
        <!-- End Our Experienced Tutor -->
  
        <!-- Footer Area -->
        <footer class="footer-area ptb-100">
            <div class="container">
                <div class="contact-information-box">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="media single-box bor-right">
                                <div class="align-self-center mr-3">
                                    <i class="icofont-google-map"></i>
                                </div>
                                
                                <div class="media-body">
                                    <h3>Address</h3>
                                    <p>184 Collins Street West Victoria, United States</p>
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-lg-4">
                            <div class="media single-box bor-right">
                                <div class="align-self-center mr-3">
                                    <i class="icofont-envelope"></i>
                                </div>
                                
                                <div class="media-body">
                                    <h3>Email</h3>
                                    <p><a href="#">support@education.com</a></p>
                                    <p><a href="#">info@education.com</a></p>
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-lg-4">
                            <div class="media single-box">
                                <div class="align-self-center mr-3">
                                    <i class="icofont-phone"></i>
                                </div>
                                
                                <div class="media-body">
                                    <h3>Phone</h3>
                                    <p><a href="#">+44 44859 4875</a></p>
                                    <p><a href="#">+44 44859 4875</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-sm-7 col-md-6 col-lg-3">
                        <div class="single-footer-widget">
                            <h3>About Us</h3>
                            <p>Lorem ipsum dolor, consectetur adipisicing sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                            <p>Ut enim ad minim veniam, quis nostrud Svoluptatem.</p>
                        </div>
                    </div>
                    
                    <div class="col-sm-5 col-md-6 col-lg-3">
                        <div class="single-footer-widget pl-30">
                            <h3>Quick Menu</h3>
                            <ul class="quick-menu">
                                <li><a href="#"><i class="icofont-thin-double-right"></i> Home</a></li>
                                <li><a href="#"><i class="icofont-thin-double-right"></i> About</a></li>
                                <li><a href="#"><i class="icofont-thin-double-right"></i> Blog</a></li>
                                <li><a href="#"><i class="icofont-thin-double-right"></i> Event</a></li>
                                <li><a href="#"><i class="icofont-thin-double-right"></i> Shop</a></li>
                                <li><a href="#"><i class="icofont-thin-double-right"></i> Contact</a></li>
                            </ul>
                        </div>
                    </div>
                    
                    <div class="col-sm-6 col-md-6 col-lg-3">
                        <div class="single-footer-widget">
                            <h3>Instagram Feed</h3>
                            <ul class="instagram-feed">
                                <li><a href="#"><img src="assets/img/instagram-feed/1.jpg" alt="Instagram image"></a></li>
                                <li><a href="#"><img src="assets/img/instagram-feed/2.jpg" alt="Instagram image"></a></li>
                                <li><a href="#"><img src="assets/img/instagram-feed/3.jpg" alt="Instagram image"></a></li>
                                <li><a href="#"><img src="assets/img/instagram-feed/4.jpg" alt="Instagram image"></a></li>
                                <li><a href="#"><img src="assets/img/instagram-feed/5.jpg" alt="Instagram image"></a></li>
                                <li><a href="#"><img src="assets/img/instagram-feed/6.jpg" alt="Instagram image"></a></li>
                                <li><a href="#"><img src="assets/img/instagram-feed/5.jpg" alt="Instagram image"></a></li>
                                <li><a href="#"><img src="assets/img/instagram-feed/2.jpg" alt="Instagram image"></a></li>
                                <li><a href="#"><img src="assets/img/instagram-feed/1.jpg" alt="Instagram image"></a></li>
                            </ul>
                        </div>
                    </div>
                    
                    <div class="col-sm-6 col-md-6 col-lg-3">
                        <div class="single-footer-widget">
                            <h3>Newsletter</h3>
                            
                            <div class="newsletter">
                                <p>Lorem ipsum dolor, consectetur adipisicing sed do eiusmod tempor.</p>
                                <p>Ut enim ad minim veniam, quis nostrud Svoluptatem.</p>
                                <form>
                                    <input type="text" placeholder="Enter Your Email" class="form-control">
                                    <button type="submit" class="submit-btn"><i class="icofont-paper-plane"></i></button>
                                </form>
                            </div>
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
                        <p>Copyright &copy; 2019.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
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
     	<script src="statics/js/teacher.js"></script>
     	<script src="statics/js/until.js"></script>
    </body>
   
</html>
