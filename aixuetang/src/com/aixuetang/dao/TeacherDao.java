package com.aixuetang.dao;

import java.util.ArrayList;
import java.util.List;

import com.aixuetang.po.Course;
import com.aixuetang.po.Teacher;
import com.aixuetang.po.Teacher_Comment;
import com.aixuetang.po.vo.ResultInfo;

public class TeacherDao {

	public List<Course> findcoursebyid(String teacherid) {
	int num=Integer.parseInt(teacherid);
	System.out.println(num);
	String sql="select * from t_course where teacherid=?";
	List<Object> params = new ArrayList<>();
	params.add(num);

	List<Course> list=BaseDao.queryRows(sql, params,Course.class);
		return list;	
	}

	public ResultInfo<Course> cheakuser(String teacherid, Integer uid) {
	int num=Integer.parseInt(teacherid);
	//准备sql语句
	String sql="select count(*)";
		return null;
	}

	public long cheak(String teacherid, Integer uid) {
		//准备sql语句
		String sql=" select count(1) from t_order o" ;
		sql+=  " INNER JOIN t_orderitem oi on o.orderid = oi.orderid"  ; 
		sql+="  INNER JOIN t_course c on oi.courseid = c.courseid " ;	
		sql+=" INNER JOIN t_teacher t on c.teacherid = t.teacherid";
		sql+="  where uid = ? and t.teacherid = ?;"	;
		List<Object> parms=new ArrayList<>();
		parms.add(uid);
		parms.add(teacherid);
		
	long row=(long) BaseDao.findSingleVlaue(sql, parms);
		return row;
		
		
		
		
		
	}

	public long addcomment(String teacherid, String comment, int uid, String time) {
		// TODO Auto-generated method stub
		//准备语句
		String sql=" insert into teaher_comment (uid,tid,comment,public_time) values (?,?,?,?)";
		int tid=Integer.parseInt(teacherid);
		List<Object> parms=new ArrayList<>();
		parms.add(uid);
		parms.add(tid);
		parms.add(comment);
		parms.add(time);
		long row=BaseDao.executeUpdate2(sql, parms);
		System.out.println(row+"####");
		return row;
		
	}
		//查询该教师的所有评价
	public ResultInfo<Teacher_Comment> exect(String teacherid) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Teacher_Comment> findcomment(String teacherid) {
		System.out.println(teacherid);
		String sql=" SELECT e.teachername, public_time,u.head,u.uname,t.comment FROM  teaher_comment  t";
		sql+=" INNER JOIN t_teacher e ON  t.tid=e.teacherid  "  ;
		sql+="  INNER JOIN t_user u ON t.uid=u.uid WHERE e.teacherid=? "	;
		List<Object> parms=new ArrayList<>();
		Integer id=Integer.parseInt(teacherid);
		parms.add(id);
		List<Teacher_Comment> list=BaseDao.queryRows(sql, parms,Teacher_Comment.class);
		return list;

	}


}
