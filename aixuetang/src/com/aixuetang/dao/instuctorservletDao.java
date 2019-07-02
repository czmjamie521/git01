package com.aixuetang.dao;

import java.util.ArrayList;
import java.util.List;

import com.aixuetang.po.Teacher;
import com.aixuetang.until.Page;
import com.aixuetang.until.StringUtil;

public class instuctorservletDao {

	public long fingteacher(String teachername) {
		
		
		
		//为空表示正常查询
		if(StringUtil.isEmpty(teachername)){
			String sql="select COUNT(*) FROM t_teacher";
			long row=(long) BaseDao.findSingleVlaue(sql, null);
			return row;
		
		}
		//不为空执行条件查询
		
		 String sql="select  COUNT(*) FROM t_teacher where teachername like concat('%',?,'%');";
		 List<Object> parms=new ArrayList<>();
		 parms.add(teachername);
		 long row=(long) BaseDao.findSingleVlaue(sql, parms);
		 return row;
	}

	public List<Teacher> fingteacherAll(Integer pagenum, Integer pagesize, Integer index, String teachername) {
		//定义sql语句
		String sql="select * from t_teacher";
			
		List<Object> params = new ArrayList<>();
		//判断是否为空
		//为空为正常分页功能，否则为按条件查询功能
		if(StringUtil.isEmpty(teachername)){
			sql+=" limit ?,?";
			params.add(index);
			params.add(pagesize);
			List<Teacher> list=BaseDao.queryRows(sql, params,Teacher.class);
			return list;
			
		}
		sql+=" where teachername like concat('%',?,'%') limit ?,? ;";
		
		params.add(teachername);
		params.add(index);
		params.add(pagesize);
	 
		List<Teacher> list=BaseDao.queryRows(sql, params,Teacher.class);
		return list;
	
	}

	public Teacher fingteachderbyid(String teacheid) {
		Integer num=Integer.parseInt(teacheid);
		String sql="select * FROM t_teacher where teacherid=?;";
		List<Object> params = new ArrayList<>();
		params.add(num);
		Teacher t=(Teacher) BaseDao.queryRow(sql, params, Teacher.class);
		
		return t;
		
	}

	
	

}
