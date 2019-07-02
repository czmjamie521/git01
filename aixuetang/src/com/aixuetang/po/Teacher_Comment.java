package com.aixuetang.po;

public class Teacher_Comment {
	private Integer t_commentid;
	private String comment;
	private Integer uid;    //用户Id    外键：是用户表的主键
	private String public_time;
	private Integer tid; 
	private String teachername;
	private String head;
	private String uname;
	public String getTeachername() {
		return teachername;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	
	
	public Integer getUid() {
		return uid;
	}
	
	public Integer getT_commentid() {
		return t_commentid;
	}

	public void setT_commentid(Integer t_commentid) {
		this.t_commentid = t_commentid;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getPublic_time() {
		return public_time;
	}
	public void setPublic_time(String public_time) {
		this.public_time = public_time;
	}
	
	
	
}
