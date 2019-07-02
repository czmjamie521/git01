package com.sxt.cartitem.domain;

import com.sxt.model.Course;
import com.sxt.util.User;

/**
 * 购物车条目实体类
 * @author robbyzhan
 *
 */
public class CartItem {
	private String cartitemid;	//主键
	private Integer quantity;	//条目数量
	private Course course;		//与条目关联的课程对象
	private User user;		//条目所属的用户
	
	public Double getSubtotal() {		//价格小计 =课程价格* 数量
		return getCourse().getPrice()*quantity;
	}
	
	public String getCartitemid() {
		return cartitemid;
	}
	public void setCartitemid(String cartitemid) {
		this.cartitemid = cartitemid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
