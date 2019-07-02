package com.aixuetang.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.aixuetang.po.Teacher;
import com.aixuetang.po.vo.ResultInfo;
import com.aixuetang.service.Instructorservice;
import com.aixuetang.until.Page;
import com.aixuetang.until.StringUtil;

/**
 * Servlet implementation class Instructor
 */   
@WebServlet("/instructorservlet")
public class Instructorservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	Instructorservice instructorservice=new Instructorservice();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String actionName=request.getParameter("actionName");
		/**
		 * @author dss
		 * 1.查询主页
		 * 
		 */
		if("query".equals(actionName)){
			query(request,response);
		
		}
		/**
		 * 加载图片
		 * 
		 */
		if("pictory".equals(actionName)){
			//执行教师风采
			pictory(request,response);
		
		}
		/**
		 * 
		 * 加载所有的教师信息
		 * 且得到所有教师的评论
		 * 
		 */
		if("teacher".equals(actionName)){
			//执行根据教师id查询教师详情主页
			teacher(request,response);
		
		}
		
		
		
		
	}

	private void teacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接受前台参数
		String teacheid=request.getParameter("teacherid");
		System.out.println(teacheid);
		ResultInfo<Teacher> resultInfo=instructorservice.fingteacherbyid(teacheid);
		//查询失败
		//将教师信息存于域对象中
		request.setAttribute("teacherinf",resultInfo);
		//请求转发到教师页面
		request.getSession().setAttribute("changePage", "teacher.jsp");
		request.getRequestDispatcher("mainweb.jsp").forward(request, response);
	}

	private void pictory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//获取图片的地址
		String path=request.getParameter("file");
		//判断地址是否为空--为空直接停止加载
		if(StringUtil.isEmpty(path)){
			return;
		}
		String realpath=request.getServletContext().getRealPath("assets/img/blog/"+path);
		
		File file=new File(realpath);
		//判断是否是文件和是否是标准文件
		if(file.exists()&&file.isFile()){
			//获取图片格式后缀
			String pic =realpath.substring(realpath.lastIndexOf(".") + 1);
			//根据不同的后缀设置不同的响应格式
			if ("png".equalsIgnoreCase(pic)) {
				response.setContentType("image/png");
			} else if ("gif".equalsIgnoreCase(pic)) {
				response.setContentType("image/gif");
			} else if ("jpg".equalsIgnoreCase(pic) || "jpeg".equalsIgnoreCase(pic)) {
				response.setContentType("image/jpeg");
			}
			
			FileUtils.copyFile(file,response.getOutputStream());
				

		}
		
		
		
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接受前台传入相关信息
		String pageNumStr = request.getParameter("pageNamu");
		String pageSizeStr = request.getParameter("pageSize");
		String teachername=request.getParameter("teachername");
		//将分页信息传入ser层
        Page<Teacher> page=instructorservice.fingteacherall(pageNumStr, pageSizeStr,teachername);
		//存到域对象中
		request.setAttribute("title",teachername);
		//将page存域对象中
		
		request.setAttribute("page", page);
		request.getSession().setAttribute("changePage", "instructor.jsp");
		request.getRequestDispatcher("mainweb.jsp").forward(request, response);
			
}
}