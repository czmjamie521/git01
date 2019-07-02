package com.sxt.course;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxt.comment.CourseComment;
import com.sxt.model.Course;
import com.sxt.model.ShowTag;
import com.sxt.service.CourseService;
import com.sxt.util.Page;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/courseservlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CourseService CourseService=new CourseService();
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName=request.getParameter("actionName");
		//加载商品的列表,分页
		if("loadcourse".equals(actionName)){
			loadCourse(request,response);
		//根据标签查询商品列表
		}if("searchTag".equals(actionName)){
			loadCourse(request,response);
		//返回主页
		}
		if("mainweb".equals(actionName)){
			turnMainWeb(request,response);
			//关于我们
					}
		if("courseintroduce".equals(actionName)){
		turncourseintroduce(request,response);
		//个人中心
		}
		if("singleperson".equals(actionName)){
			turnsingleperson(request,response);
			//查询单个商品信息
			}if("singleCourse".equals(actionName)){
			//查询单个商品信息
			loadSingleCourse(request,response);
			//查询相关商品的子产品
			loadMinCourse(request,response);
			
			request.getSession().setAttribute("changePage", "singleCourse.jsp");
		}
	
		request.getRequestDispatcher("mainweb.jsp").forward(request, response);
	}

	


	private void turnsingleperson(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("changePage", "singleperson.jsp");
		
	}




	private void turncourseintroduce(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("changePage", "courseintroduce.jsp");
	}




	private void turnMainWeb(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("changePage", "usercenter.jsp");
		
	}




	private void loadMinCourse(HttpServletRequest request, HttpServletResponse response) {
		 String pageNum=request.getParameter("pageNum");
	     String searchTag=request.getParameter("searchTag");
	     String limit=request.getParameter("limit");
	     String searchTagid=request.getParameter("searchTagid");
		 Page<Course> page=CourseService.findCourselist(pageNum,searchTag,limit,searchTagid);
		if(page==null){
			request.setAttribute("warn", "网络异常,请重试!");
			
		}else{
			List<ShowTag> showTag=(List<ShowTag>) CourseService.findCourseTaglistByTag();
			request.setAttribute("page", page);
		}
	
		
	}
		
	




	//打开单个商品链接
	private void loadSingleCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String courseid=request.getParameter("courseid");
		 Course singleCourse=CourseService.findCourseBycourseid(courseid);
		List <CourseComment> courseComment=CourseService.findCourseCommentBycourseid(courseid);
		if(singleCourse==null){
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}else{
			request.getSession().setAttribute("singleCourse", singleCourse);
			request.getSession().setAttribute("courseComment", courseComment);
		}
	}





	private void loadCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String pageNum=request.getParameter("pageNum");
	     String searchTag=request.getParameter("searchTag");
	     String limit=request.getParameter("limit");
	     String searchTagid=request.getParameter("searchTagid");
		 Page<Course> page=CourseService.findCourselist(pageNum,searchTag,limit,searchTagid);
		if(page==null){
			request.setAttribute("warn", "网络异常,请重试!");
			
		}else{
			List<ShowTag> showTag=(List<ShowTag>) CourseService.findCourseTaglistByTag();
			request.setAttribute("page", page);
			request.getSession().setAttribute("showTag", showTag);
			request.getSession().setAttribute("searchTag", searchTag);
		}
		request.setAttribute("changePage", "courseshop.jsp");
		
	}

}
