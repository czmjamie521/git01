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
 * Servlet implementation class Userservlet
 */
@WebServlet("/userservlet")
public class Userservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userservice = new UserService();
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ajax���ķ�����actionname
		String actionName=request.getParameter("actionName");
		if("checkuname".equals(actionName)){
			userCheck(request,response);
		}else if("login".equals(actionName)){
			userLogin(request,response);
		}else if("logining".equals(actionName)){
			userLogining(request,response);
		}else if("logout".equals(actionName)){
			logouting(request,response);
		}else if("Pay".equals(actionName)){
			Paying(request,response);
		}else if("paying".equals(actionName)){
			paymoney(request,response);
		}else if("updateuser".equals(actionName)){
			updateuser(request,response);
		}
	}
	private void updateuser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userphone=request.getParameter("userphone");
		String useremail=request.getParameter("useremail");
		String sex=request.getParameter("sex");
		String age=request.getParameter("age");
		User user =(User) request.getSession().getAttribute("user");
		int uid=user.getUid();
		ResultInfo<User> resultinfo=new ResultInfo();
		resultinfo=userservice.updateUser(userphone,useremail,sex,age,uid);
		if(resultinfo.getCode()==1){
			user.setAge(Integer.parseInt(age));
			user.setEmail(useremail);
			user.setPhone(userphone);
			user.setSex(sex);
			request.getSession().setAttribute("user", user);
		}
		JsonUtil.toJson(response, resultinfo);
	}
	private void paymoney(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//����ǰ̨�����Ĳ���money
		String money =request.getParameter("money");
		double balance=Double.parseDouble(money);
		//�õ�session�Ķ����userId
		User user=(User) request.getSession().getAttribute("user");
		Integer uid=user.getUid();
		//�õ���̨�����Ľ��
		ResultInfo<User> resultinfo=new ResultInfo();
		resultinfo=userservice.payByUserId(balance,uid);
		request.getSession().setAttribute("user", resultinfo.getResult());
		//��ǰ̨����Json����
		JsonUtil.toJson(response, resultinfo);
		
		
	}
	private void Paying(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ҳ���һ�������
		request.setAttribute("changePage", "Pay.jsp");
		//����ת������ҳ
		request.getRequestDispatcher("mainweb.jsp").forward(request, response);;
		
	}
	private void logouting(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1������session����
		request.getSession().invalidate();
				
		// 2��ɾ��cookie����
		
	    // �õ�Ҫɾ����cookie����
		//Cookie cookie = new Cookie("user",null);
		// ����cookie��MaxAge����Ϊ0����ʾɾ��cookie����
		//cookie.setMaxAge(0);
		// ��Ӧcookie����
		//response.addCookie(cookie);
				
		// 3����ת����¼ҳ��
		response.sendRedirect("mainweb.jsp");
		
	}
	private void userLogining(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ҳ���һ�������
		request.setAttribute("changePage", "Login.jsp");
		//����ת������ҳ
		request.getRequestDispatcher("mainweb.jsp").forward(request, response);;
		
	}
	private void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//���ղ���ajax������uname����
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		//����service���resultinfo
		ResultInfo<User> resultinfo=userservice.loginByName(uname,upwd);
		request.getSession().setAttribute("user", resultinfo.getResult());
		//��json�����ύ
		JsonUtil.toJson(response, resultinfo);
		
	}
	private void userCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//���ղ���ajax������uname����
		String uname=request.getParameter("uname");
		//����service��resultinfo
		ResultInfo<User> resultinfo=userservice.checkByUname(uname);
		System.out.println(resultinfo);
		//��ǰ̨���;��Ͷ���
		JsonUtil.toJson(response, resultinfo);
	}
}
