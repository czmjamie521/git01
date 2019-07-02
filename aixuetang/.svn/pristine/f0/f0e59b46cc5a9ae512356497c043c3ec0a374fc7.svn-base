package com.aixuetang.service;

import java.util.ArrayList;
import java.util.List;

import com.aixuetang.dao.TeacherDao;
import com.aixuetang.po.Course;
import com.aixuetang.po.Teacher_Comment;
import com.aixuetang.po.User;
import com.aixuetang.po.vo.ResultInfo;
import com.aixuetang.until.StringUtil;

public class Teacherservcice {
	
	TeacherDao dao=new TeacherDao();
	public ResultInfo<List<Course>> findcourse(String teacherid) {
		//
		ResultInfo<List<Course>> info=new ResultInfo<>();
		List<Course> list=dao.findcoursebyid(teacherid);
		//该教师无课程信息
		if(list.size()==0){
			info.setCode(0);
			info.setMsg("无课程信息！");
			return info;
			
		}
		//查询到课程信息
		info.setResult(list);
		info.setCode(1);
		return info;
	}
	public ResultInfo cheakuser(String teacherid, Integer uid) {
		//非空判断
		ResultInfo info=new ResultInfo<>();
		if(StringUtil.isEmpty(teacherid)||StringUtil.isEmpty(uid+"")){
			//查询失败
			info.setCode(0);
			info.setMsg("评论失败请购买后评论");
			
		}
		long row= dao.cheak(teacherid,uid);
		//判断返回的数量数目
		System.out.println("====="+row);
		if(row>0){
			//传入ajax前台进行后续查询工作
			info.setCode(1);
			return info;
			
		}
		else{
			info.setCode(0);
			info.setMsg("请购买后进行评论");
			return info;
		}
	}
	public ResultInfo<Teacher_Comment> adcomment(String teacherid, String comment, int uid, String time) {
		//非空判断
		ResultInfo<Teacher_Comment> info=new ResultInfo<>();
		if(StringUtil.isEmpty(comment)||StringUtil.isEmpty(teacherid)||StringUtil.isEmpty(uid+"")){
			info.setCode(0);
			info.setMsg("评论失败请重试");
		}
		//不为空执行更行操作
		long row=dao.addcomment(teacherid,comment,uid,time);
		//更新行数大于0，表明更新成功
		if(row>0){
			/**
			 * 1.为简化流程，直接将用户的前台信息存于评论对象中，避免查询数据库
			 * 2.用户信息从会话中获取
			 */
			User u=new User();
			u.setHead("5.jpg");
			u.setUname("dss");
			Teacher_Comment comment2=new Teacher_Comment();
			comment2.setHead(u.getHead());
			comment2.setPublic_time(time);
			comment2.setComment(comment);
			comment2.setUname(u.getUname());
			info.setResult(comment2);
			info.setCode(1);
			info.setMsg("评论成功");
			//调用方法查询目前的评论条数，以方便更改前台数字
			List<Teacher_Comment> list=dao.findcomment(teacherid);
			int size=list.size();
			info.setSize(size);
			return info;
		}
		
		info.setCode(0);
		info.setMsg("评论失败");
		
		return info;
	}
	
	
	
	public ResultInfo<List<Teacher_Comment>> findcomment(String teacherid) {
		ResultInfo<List<Teacher_Comment>> info=new ResultInfo<>();
		if(StringUtil.isEmpty(teacherid)){
			info.setMsg("该教师暂无评论信息");
			info.setCode(0);
		}
		
		List<Teacher_Comment> list=dao.findcomment(teacherid);
		//该教师无相关评论
		System.out.println("该教师的评论条数为"+list.size());
		//未查询到该教师的评论信息
		
		
		if(list.size()==0){
			
			info.setMsg("该教师暂无评论信息");
			info.setCode(0);
			return info;
		}
		info.setCode(1);
		info.setResult(list);
		info.setSize(list.size());
		return info;
	}
	
}
