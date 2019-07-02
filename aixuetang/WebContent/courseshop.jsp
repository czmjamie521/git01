<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


 <c:if test="${empty courseList}">
<div align="center"><h2><span id="wanr">${warn }</span></h2></div>
<br>
<br><br><br><br>
</c:if>
 <!-- 课程列表 -->
      <c:if test="${!empty page.dataList}">
        <section class="shop-section pt-100 pb-180 white-bg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-9"> 
                        <div class="row">
                   
                        <c:forEach items="${page.dataList }" var="item">
                        
                            <div class="col-sm-6 col-lg-6  col-xl-4" >
                                <div class="single-publication">
                                    <figure>
                                    <input type="hidden" name="searchTagid" value=${item.tagid }/>
                                      <a href="courseservlet?actionName=singleCourse&limit=3&searchTagid=${item.tagid }&courseid=${item.courseid }">
                                            <img src="statics/img/course/${item.picture }" alt="Publication Image">
                                        </a>
											
                                        <ul>
                                            <li><a href="#" title="感兴趣"><i class="icofont-heart"></i></a></li>
                                            
                                        </ul>
                                    </figure>

                                    <div class="publication-content">
                                    
                                         
                                        <h3><a href="#"> ${item.coursename }</a></h3>
                                        <ul>
                                            <li><i class="icofont-star"></i></li>
                                            <li><i class="icofont-star"></i></li>
                                            <li><i class="icofont-star"></i></li>
                                            <li><i class="icofont-star"></i></li>
                                            <li><i class="icofont-star"></i></li>
                                        </ul>
                                       
                                         <h4 class="price">$ ${item.price } </h4>
                                                             
                                        
                                   </div>

									<!-- 添加到购物车 -->
                                    <div class="add-to-cart">
                                        <a href="javascript:void(0);" onclick="addCart('${item.courseid}')" class="default-btn">买进包袱</a>
                                        
                                        <%
										/* 设置token 防止重复提交 */
											session.setAttribute("token", "token");
										%>
                                    </div>
                                </div>
                             
                            </div>
                          </c:forEach>
						 <!-- Pagination -->
						  <div class="col-lg-12 col-lg-offset-5" >
                        <nav class="pagination-outer" aria-label="Page navigation" >
                            <ul class="pagination">
                            <c:if test="${page.pageNum!=1 }">
                                <li class="page-item">
                                    <a href="courseservlet?actionName=loadcourse&pageNum=${page.prePage }&searchTag=${searchTag}" class="page-link" aria-label="Previous">
                                        <i class="icofont-swoosh-left"></i>
                                    </a>
                                </li>
                               </c:if>
                               <c:forEach begin="${page.startNavPage }"  end="${page.endNavPage }" var="p">
                                <li class="page-item active">
                                    <a class="page-link" href="courseservlet?actionName=loadcourse&pageNum=${p }&searchTag=${searchTag}"><span>${p }</span></a>
                                </li>
                               	</c:forEach>
                                 <c:if test="${page.pageNum!=page.totalPages}">
                                <li class="page-item">
                                    <a href="courseservlet?actionName=loadcourse&pageNum=${page.nextPage }&searchTag=${searchTag}" class="page-link" aria-label="Next">
                                        <i class="icofont-swoosh-right"></i>
                                    </a>
                                </li>
                                </c:if>
                            </ul>
                        </nav>
                         </div>
                        <!-- End Pagination -->
                           
                       
                       
                    </div>
                    <br>
           
                </div>
                         <div class="col-lg-3" style="float:right"> 
                        <div class="search-widget">
                            <form action="courseservlet">
                            <input type="hidden" name="actionName" value="searchTag"/>
                                <input type="text" class="form-control" name="searchTag" placeholder="Search post..." value="">
                                
                                <button type="submit" class="btn search-btn">
                                    <i class="icofont-search"></i>
                                </button>
                            </form>
                        </div>
                        
                        <div class="widget categories-widget mt-30">
                            <h3 class="title">Categories</h3>
                            <ul>
                            <c:forEach items="${showTag }" var="item">
                                <li><a href="courseservlet?actionName=loadcourse&pageNum=1&searchTag=${item.tagname}">${item.tagname } <span>${item.count }</span></a></li>
                              </c:forEach>
                            </ul>
                        </div>
                        
                        <div class="widget tags-widget mt-30">
                            <h3 class="title">Tags</h3>
                            <ul>
                               <c:forEach items="${showTag }" var="item">
                                <li><a href="courseservlet?actionName=loadcourse&pageNum=1&searchTag=${item.tagname}">${item.tagname }</a></li>
                                 </c:forEach>
                               
                            </ul>
                        </div>
                    </div>
            </div>
               </div>
        </section>
        </c:if>
        <!-- End Shop section -->
<script type="text/javascript">
function addCart(courseid){
	$.ajax({
		url:"cart",
		data:{
			actionName:"add",
			courseid: courseid,
		},
		type:"post",
		dataType:"json",
		cache:false,
		success: function(result){
			if(result =="添加成功"){
				alert(result);
			}else{
				location ="Login.jsp";
				alert(result);
			}
		}
	})
	
}

</script>
   