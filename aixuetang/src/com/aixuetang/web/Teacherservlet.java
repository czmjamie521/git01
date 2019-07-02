package com.aixuetang.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSpinnerUI;

import com.aixuetang.dao.TeacherDao;
import com.aixuetang.po.Course;
import com.aixuetang.po.Teacher;
import com.aixuetang.po.Teacher_Comment;
import com.aixuetang.po.User;
import com.aixuetang.po.vo.ResultInfo;
import com.aixuetang.service.Teacherservcice;
import com.aixuetang.until.JsonUtil;

/**
 *
 */
@WebServlet("/teacherservlet")
public class Teacherservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	Teacherservcice teacherservcice=new Teacherservcice();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String actionName=request.getParameter("actionName");
	//执行添加评价操作
	System.out.println(actionName);
	if("addrevier".equals(actionName)){
		addreview(request,response);	
	}
	//搜索教师课程功能
	if("seach".equals(actionName)){
		seach(request,response);	
	}	
	//检验用户是否购买过该教师的课程
	if("cheakuser".equals(actionName)){
		ckeakuser(request,response);	
	}
	//添加用户评论教师功能
	if("addteachercomment".equals(actionName)){
		addteachercomment(request,response);	
	}
	/**
	 * 加载指定教师页面的所有评论
	 */
	if("loadcomment".equals(actionName)){
		loadcomment(request,response);	
	}	
		
	}
   private void loadcomment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String teacherid=request.getParameter("teacherid");
		//
		
		ResultInfo<List<Teacher_Comment>> info=teacherservcice.findcomment(teacherid);
		
		JsonUtil.toJson(response,info);
	}
/**
    * 
    * 增加评论方法
    * 
    * @param request
    * @param response
 * @throws IOException 
    */
	private void addteachercomment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//接受ajax提交的相关参数
		String teacherid=request.getParameter("teacherid");
		String comment=request.getParameter("comment");
		String time=request.getParameter("currentdate");
		System.out.println(time);
		//传入ser层进行相关处理   用户缺失会话，暂时定为用户1
		/*User u=(User) request.getSession().getAttribute("user");
		Integer	uid=u.getUid();*/
		int uid=1;
		
	ResultInfo<Teacher_Comment> info=teacherservcice.adcomment(teacherid,comment,uid,time);
	JsonUtil.toJson(response,info);
		
	}
	/**
	 * 检验用户是否购买课程方法
	 * @param 丁胜
	 * @param response
	 * @throws IOException
	 */
	private void ckeakuser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String teacherid=request.getParameter("teacherid");
		//获取会话用户对象   按时缺失会话，id以1代替
		/*User u=(User) request.getSession().getAttribute("user");
		Integer	uid=u.getUid();*/
		int uid=1;
		//将用户id调成1进行测试使用
		//调用ser层
		ResultInfo info=teacherservcice.cheakuser(teacherid,uid);
		//以流的形式结果反馈给Ajax回调函数
	
		JsonUtil.toJson(response,info);
		
		
	}

	private void seach(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String teacherid=request.getParameter("teacherid");
		System.out.println(teacherid);
		//调dao层返回教师课程的结果集
		ResultInfo<List<Course>> resultInfo=teacherservcice.findcourse(teacherid);
		//通过json工具将结果集返回给回调函数
		JsonUtil.toJson(response,resultInfo);
		 
	}

	

	private void addreview(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		User u=(User) request.getSession().getAttribute("user");
		//获取会话中的用户id
		Integer	uid=u.getUid();
		String teacherid=request.getParameter("teacherid");
		
		
		
		
	}

	
}
