package com.sxt.comment;

import java.util.Date;

public class CourseComment {
	private String commentid;
	private String parentcomment;
	private String reply;
	private Integer uid;
	private Integer courseid;
	private String content;
	private String head;
	private String uname;
	private Date publishtime;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getCommentid() {
		return commentid;
	}
	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getCourseid() {
		return courseid;
	}
	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}
	public String getParentcomment() {
		return parentcomment;
	}
	public void setParentcomment(String parentcomment) {
		this.parentcomment = parentcomment;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	@Override
	public String toString() {
		return "CourseComment [commentid=" + commentid + ", parentcomment=" + parentcomment + ", reply=" + reply
				+ ", uid=" + uid + ", courseid=" + courseid + ", content=" + content + ", head=" + head + ", uname="
				+ uname + ", publishtime=" + publishtime + "]";
	}
	
	
}
