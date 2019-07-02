package com.sxt.Dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sxt.comment.CourseComment;
import com.sxt.model.BaseDao;
import com.sxt.util.User;

import cn.itcast.commons.CommonUtils;

public class CommentDao {

	public int addComment(String comment, String commentid, User user, String courseid, String commentid1) {
		String sql="";
		List<Object> params=new ArrayList<>();
		if(commentid==null){
		sql="insert into t_comment(commentid,content,uid,parentcomment,courseid) values (?,?,?,?,?) ";
		}else{
		 sql="insert into t_comment(reply,commentid,content,uid,parentcomment,courseid) values (?,?,?,?,?,?) ";
		 params.add(commentid1);
		}
		
		
		if(commentid==null){
			params.add(CommonUtils.uuid()+"");
		}else{
			params.add(CommonUtils.uuid()+"");
		}
		
		params.add(comment);
		params.add(user.getUid());
		if(commentid!=null){
			params.add(commentid);
		}else{
			params.add(null);
		}
		params.add(courseid);
		
		int row=BaseDao.executeUpdate(sql, params);
		
		return row;
	}

	public CourseComment searchComment(String comment, String commentid, User user, String courseid, String commentid1) {
		String sql="select commentid,content,m.uid,uname,head,publishtime,parentcomment,courseid from t_comment n inner join t_user m on m.uid=n.uid where courseid=?";
		List<Object> params=new ArrayList<>();
		params.add(courseid);
		sql+=" order by publishtime desc";
		List<CourseComment> list=(List<CourseComment>) BaseDao.queryRows(sql,params , CourseComment.class);
		CourseComment CourseComment=list.get(0);
		System.out.println(CourseComment);
		return CourseComment;
	}

}
