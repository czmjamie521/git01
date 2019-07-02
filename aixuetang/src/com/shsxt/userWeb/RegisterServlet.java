package com.shsxt.userWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shsxt.userservice.UserService;
import com.sxt.util.JsonUtil;
import com.sxt.util.ResultInfo;
import com.sxt.util.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerservlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userservice=new UserService();
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到前台传来的actionname
		String actionName=request.getParameter("actionName");
		//判断actionname
		if("register".equals(actionName)){
			userRegister(request,response);
		}else if("unique".equals(actionName)){
			userUnique(request,response);
		}else if("registering".equals(actionName)){
			registering(request,response);
		}
	}

	private void registering(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//给页面存一个域对象
		request.setAttribute("changePage", "register.jsp");
		//请求转发到主页
		request.getRequestDispatcher("mainweb.jsp").forward(request, response);;
		
	}

	private void userUnique(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//接收前台传来的参数
		String uname=request.getParameter("uname");
		
		//接收service层传来的值
		ResultInfo<User> resultinfo=userservice.uniqueUser(uname);
		//用json传送对象
		JsonUtil.toJson(response, resultinfo);
	}

	private void userRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//接收后台传来的值
		ResultInfo<User> resultinfo=new ResultInfo();
		resultinfo=userservice.registerUser(request);
		//网前台传输json对象
		JsonUtil.toJson(response, resultinfo);	
	}

}
