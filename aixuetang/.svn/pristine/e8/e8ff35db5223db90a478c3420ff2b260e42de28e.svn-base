<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <script src="statics/js/course.js"></script>  
  <!-- Checkout -->
        <section class="checkout-section pt-100 pb-180">
            <div class="container">
                <!-- Click Here To Login -->
               

            
                <!-- End Click Here To Login -->
                
                <!-- Checkout form -->
               
                    <div class="row"> 
                        <div class="col-lg-6"> 
                            <div class="billing-form">
                                <h3 class="title">个人信息</h3>
                     
                                <div class="row"> 
                                    <div class="col-lg-6"> 
                                        <div class="form-group">
                                            <label>昵称<sup>*</sup></label>
                                            <input type="text" readonly="readonly" class="form-control" id="first_name" placeholder="First name" value="${user.uname }">
                                        </div>
                                    </div>
                                    <div class="col-lg-6"> 
                                        <div class="form-group">
                                            <label>邮箱 <sup>*</sup></label>
                                            <input type="text" class="form-control" id="Useremail" placeholder="email" value="${user.email}" />
                                        </div>
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                    <label>账户余额</label>
                                    <input type="text" readonly="readonly" class="form-control" id="balance" placeholder="balance" value="${user.balance}">
                                </div>

                                <div class="row"> 
                                    <div class="col-lg-12"> 
                                        <div class="form-group">
                                            <label>电话</label>
                                            <input type="text" class="form-control" id="phone_number" placeholder="phone_number" value="${user.phone}">
                                        </div>   
                                    </div>
                                  
                                </div>
                       
                                <div class="form-group" >
                                    <label>性别 <sup>*</sup></label>
                                    <select class="form-control" id="exampleFormControlSelect1">                   
                                        <option>男</option>
                                          <option>女</option>
                                   
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label>年龄 <sup>*</sup></label>
                                    <input type="text" class="form-control" id="Street_address" placeholder="" value="${user.age}">
                                </div>
        
                         
                               

                              
                            </div>
                            <br>
                            
                              <button onclick="updateuser()" class="btn default-btn">完善个人信息</button>
                               <span id="warnmsg" style="color:red; font-size:12px" > </span>
                        </div>
                   			
                        <div class="col-lg-6"> 
                            <div class="your-order">
                                <h3 class="title">我的订单</h3>
                         
                                <div class="table-responsive">
                                    <table class="table table-bordered cart-table">
                                        <thead>
                                            <tr>
                                                 <th> <a class="nav-link " href="cart?actionName=showCart" >
                          	          				购物车
                            						</a> </th>   
                                          
                                                <th> <a class="nav-link " href="/aixuetang/order?actionName=showOrder&pageNum=1" >
                          	          				历史订单
                            						</a> </th>   
                                            </tr>
                                        </thead>

                                    </table>
                                </div>
                                 
                      
                                
                             
                           <div class="col-lg-3"> 
                             <table>
                         		<tr>  <th>
                                <a href="courseservlet?actionName=loadcourse" >去下单</a>
                                </th>
                          	 <th>
                          	 &nbsp;
                          	 </th>
                          	 
                                <th>
                                 <a href="cart?actionName=showCart" >去支付</a>
                                 </th>	</tr> 
                                 </table>
                            </div>
                             </div>
                        </div>
                    </div>
                
                <!-- End Checkout form -->
            </div>
        </section>
        <!-- End Checkout -->