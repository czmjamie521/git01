package com.sxt.order.service;

import java.sql.SQLException;
import java.util.List;

import com.address.po.Address;
import com.shsxt.userdao.UserDao;
import com.sxt.cartitem.dao.CartDao;
import com.sxt.cartitem.exception.CartDeleteException;
import com.sxt.order.dao.OrderDao;
import com.sxt.order.domain.Order;
import com.sxt.order.exception.PayException;

import cn.itcast.jdbc.JdbcUtils;

public class OrderService {
	private OrderDao orderDao =new OrderDao();
	private CartDao cartDao =new CartDao();
	private UserDao userDao =new UserDao();

	//查询当前用户总的订单数
	public long getTotalCount(Integer uid) {
		try {
			return orderDao.getTotalCount(uid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//查询出订单一览表, 不需要详细的 OrderItem, 但是需要和 t_address连表查地址
	public List<Order> showOrder(Integer uid, Integer pageNum, Integer pageSize) {
		try {
			List<Order> orderList;
			orderList = orderDao.showOrder(uid, pageNum, pageSize);
			return orderList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 使用事务, 完成
	 * 1. 在t_order 中创建新的order记录
	 * 2. 在t_OrderItem 中插入多条记录
	 * 3. 在t_cartitem中删除多条记录
	 * @param order		servlet封装的order 对象, 包含完整的 List<OrderItem>
	 * @param cartItemIds 	CartItem 主键数组, toString()得到
	 * @param uid 
	 * @throws CartDeleteException 
	 */
	public void addOrder(Order order, String cartItemIds, Integer uid) throws CartDeleteException {
		try {
			//开启事务
			JdbcUtils.beginTransaction();
			//创建Order记录, 暂时缺省 aid(地址id)
			orderDao.createOrder(order.getOrderid(), uid, order.getOrdertime(), null,
					order.getStatus(),order.getTotal());
			orderDao.addOrderItems(order);
			//删除响应的CartItem
			cartDao.cartdelete(cartItemIds);
			
			//关闭事务
			JdbcUtils.commitTransaction();
		} catch (SQLException e) {
			try {
				//回滚事务
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
			}
			throw new RuntimeException(e);
		}
		
	}

	//在订单详情页, 根据当前用户, 得到地址
	public List<Address> findAddress(Integer uid) {
		try {
			List<Address> aList = orderDao.findAddress(uid);
			//非空判断
			if(null ==aList || aList.size() ==0) return null;
			for(Address addr :aList){
				//遍历数组, 找到默认的地址, 加到数列头部
				if(addr.getIsdefault() ==1){
					aList.remove(addr);
					aList.add(0, addr);
					break;
				}
			}
			return aList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}

	//给定orderid  返回包含 List<OrderItem>的完整 order对象
	public Order getOrderById(String orderid) {
		try {
			return orderDao.getOrderById(orderid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//为订单设置地址信息
	public void updateAddr(String orderid, Integer aid, String addr) {
		try {
			orderDao.updateAddr(orderid, aid, addr);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//用户再次进入订单详情页, 查找当前用户的 地址信息
	public Address findSingleAddress(String orderid) {
		try {
			return orderDao.findSingleAddress(orderid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//前台点击删除订单, 调用此方法
	//先删除订单条目, 后删除订单
	public Integer deleteOrder(String orderid) {
		try {
			JdbcUtils.beginTransaction();
			orderDao.deleteOrderItem(orderid);
			Integer rows = orderDao.deleteOrder(orderid);
			JdbcUtils.commitTransaction();
			return rows;
		} catch (SQLException e) {
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
			}
			throw new RuntimeException(e);
		}
		
	}

	//用户结算订单时, 需要校验余额和订单总额, 调用此方法
	public Double getBalanceByUid(Integer uid) {
		try {
			Double balance =orderDao.getBalanceByUid(uid);
			return balance;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 用户结算订单, 使用此方法执行业务, 需要用事务
	 * 1 根据orderid改变订单状态
	 * 2 根据uid设置新的余额
	 * 3 把地址主键 aid 设置到订单中
	 * 4 把phone 信息更新到 t_user中
	 * 两者在同一事务中
	 * @param orderid
	 * @param uid
	 * @param balance 
	 * @param phone 
	 * @param aid 
	 * @throws PayException 
	 */
	public void payOrder(String orderid, Integer uid, Double balance, Integer aid, String phone) throws PayException {
		try {
			JdbcUtils.beginTransaction();
			//改订单状态
			orderDao.changeOrderStatus(orderid);
			//设置新余额
			orderDao.setUserBalance(uid, balance);
			//设置新地址
			orderDao.updateAddr(orderid, aid);
			//设置新电话
			userDao.updatePhone(uid, phone);
			JdbcUtils.commitTransaction();
		} catch (SQLException e) {
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		
	}
}
