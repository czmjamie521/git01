<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<section class="register-section pt-100 pb-180">
            <div class="container">
                <div class="register-form box-content">
                    <h3 class="title">账户充值</h3>
                    <form id="form">
                        <div class="form-group">
                            <h3>用户余额:</h3><input type="text" class="form-control" id="balance" name="money" value="${user.balance }" readonly="readonly">
                        </div>
               
                        <div class="form-group">
                            <h3>充值额度:</h3><input type="text" class="form-control" id="money" placeholder="请输入充值金额">
                        </div>
                        
                        <br>
                  
                        <div class="form-foot"> 
                            <button type="button" class="btn default-btn" id="paymoney" onclick="pay()">充 值</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="button" class="btn default-btn" id="userregister" onclick="Deselect()">取 消</button>
                             <span style="font-size:12px ; color:red" id="msg"></span>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <!-- End Login --> 
        <script src="statics/js/pay.js"></script>
        <script src="statics/js/utils.js"></script>
</body>

</html>