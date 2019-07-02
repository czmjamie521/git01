package com.sxt.Dao;

import java.util.ArrayList;
import java.util.List;

import com.sxt.comment.CourseComment;
import com.sxt.model.BaseDao;
import com.sxt.model.Course;
import com.sxt.model.ShowTag;
import com.sxt.util.User;

public class Dao {

	public List<Course> listCourse( Integer pageSize, Integer index, String searchTag) {
		String sql="select * from t_course ";
		List<Object> params=new ArrayList<>();
		
		if(searchTag!=null){
			sql+="  m INNER JOIN t_tag n on m.tagid=n.tagid where tagname like concat('%',?,'%')";
			params.add(searchTag);
		}
		sql+="limit ?,?";
		params.add(index);
		params.add(pageSize);
		List<Course> list=(List<Course>) BaseDao.queryRows(sql, params, Course.class);
		return list;
	}
//查询课程的总数量
	public long findNoteCountByUserId(String searchTag) {
		
		String sql="select count(1) from t_tag n INNER JOIN t_course m on m.tagid=n.tagid";
		List<Object> params=new ArrayList<>();
		if(searchTag!=null){
			sql+=" where tagname like concat('%',?,'%')";
		
			params.add(searchTag);
		}
		Object obj=BaseDao.findSingleVlaue(sql, params);
		if(obj!=null){
			long row =(long)obj;
			return row;
		}else{
			return 0;
		}
		
		
	}

	@SuppressWarnings("unchecked")
	public List<ShowTag> listTag() {
		String sql="select m.tagid,tagname,count(1) count from t_tag n INNER JOIN t_course m on m.tagid=n.tagid GROUP BY tagid order by count desc";
		List<ShowTag> list=BaseDao.queryRows(sql, null, ShowTag.class);
		return list;
	}
	public String findTagNameBytagId(Integer tagId) {
		String sql="select tagname from t_tag where tagid=?";
		List<Object> params=new ArrayList<>();
		params.add(tagId);
		String tagName=(String) BaseDao.findSingleVlaue(sql, params);
		return tagName;
		
	}
	public Course findSingleCourseBycourseid(String courseid) {
		String sql="select * from t_course where courseid=?";
		List<Object> params=new ArrayList<>();
		params.add(Integer.parseInt(courseid));
		Course singleCourse=(Course) BaseDao.queryRow(sql, params, Course.class);
		return singleCourse;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<CourseComment> listCourseComment(String courseid) {
	if(courseid==null){
		return null;
	} 
	Integer newCourseId=Integer.parseInt(courseid);
	String sql="select commentid,parentcomment,reply,m.uid,courseid,head,content, uname,publishtime from t_comment m inner join t_user n on n.uid=m.uid where  courseid=?";
	List<Object> params=new ArrayList<>();

	params.add(newCourseId);
	List<CourseComment> list=(List<CourseComment>) BaseDao.queryRows(sql, params, CourseComment.class);
	return list;
	}
	

}
