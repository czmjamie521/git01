package com.sxt.order.domain;

import java.util.Date;
import java.util.List;

import com.address.po.Address;
import com.sxt.util.User;

public class Order {
	private String orderid;		//主键, 订单号    直接
	private Date ordertime;		//下单时间    直接映射
	private Integer status;		//订单状态, 1表示未支付, 2表示已支付   直接
	private Double total;	//订单总价		直接
	private User user;			//对应的用户
	private Address addr;	//收货地址		连表(t_address), 间接拼接
	private List<OrderItem> orderitemlist;	//含有的所有订单条目
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public List<OrderItem> getOrderitemlist() {
		return orderitemlist;
	}
	public void setOrderitemlist(List<OrderItem> orderitemlist) {
		this.orderitemlist = orderitemlist;
	}
	
	
}
