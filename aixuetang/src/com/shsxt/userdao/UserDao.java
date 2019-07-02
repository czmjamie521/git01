package com.shsxt.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.sxt.model.BaseDao;
import com.sxt.util.DBUtil;
import com.sxt.util.User;


public class UserDao {
	private QueryRunner qr =new QueryRunner();
	private Connection conn =DBUtil.getConnection();
	
	public static void main(String[] args) {
		UserDao userdao=new UserDao();
		
		System.out.println(userdao.checkUname("lisi"));
	}
	public User checkUname(String uname) {
		
		User user=null;
		Connection connection=null;
		PreparedStatement preparaedstatement=null;
		ResultSet resultset=null;
		//锟斤拷锟斤拷锟斤拷锟捷匡拷
		connection=DBUtil.getConnection();
		//准锟斤拷sql锟斤拷锟�
		String sql="select*from t_user where uname=? ";
		//执锟斤拷sql锟斤拷锟�
		try {
			preparaedstatement=connection.prepareStatement(sql);
			//锟斤拷锟矫讹拷锟斤拷
			preparaedstatement.setString(1, uname);
			//锟斤拷取锟斤拷锟斤拷锟�
			resultset=preparaedstatement.executeQuery();
			if(resultset.next()){
				user=new User();
				user.setUid(resultset.getInt("uid"));
				user.setUname(resultset.getString("uname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 鍏抽棴璧勬簮
			DBUtil.close(connection, preparaedstatement, resultset);
		}
		
		return user;
	}
	public User loginunameandupwd(String uname, String upwd) {
		
			User user=null;
			Connection connection=null;
			PreparedStatement preparaedstatement=null;
			ResultSet resultset=null;
			//锟斤拷锟斤拷锟斤拷锟捷匡拷
			connection=DBUtil.getConnection();
			//准锟斤拷sql锟斤拷锟�
			String sql="select*from t_user where uname=?and upwd=? ";
			//执锟斤拷sql锟斤拷锟�
			try {
				preparaedstatement=connection.prepareStatement(sql);
				//锟斤拷锟矫讹拷锟斤拷
				preparaedstatement.setString(1, uname);
				preparaedstatement.setString(2, upwd);
				//锟斤拷取锟斤拷锟斤拷锟�
				resultset=preparaedstatement.executeQuery();
				if(resultset.next()){
					user=new User();
					user.setUid(resultset.getInt("uid"));
					user.setUname(resultset.getString("uname"));
					user.setUpwd(resultset.getString("upwd"));
					user.setPhone(resultset.getString("phone"));
					user.setBalance(resultset.getDouble("balance"));
					
					user.setEmail(resultset.getString("email"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				// 鍏抽棴璧勬簮
				DBUtil.close(connection, preparaedstatement, resultset);
			}
			
			return user;
		
	}
	public int registerUser(String uname, String email, String phone, String upwd, String head) {
		//准锟斤拷sql锟斤拷锟�
		String sql="insert into t_user (uname,upwd,email,phone,head) values (?,?,?,?,?)";
		//锟斤拷锟斤拷锟矫讹拷锟斤拷
		List<Object> params=new ArrayList();
		params.add(uname);
		params.add(upwd);
		params.add(email);
		params.add(phone);
		params.add(head);
		int row=BaseDao.executeUpdate(sql, params);
		return row;
		
	}
	//
	public User uniqueByName(String uname) {
		User user=null;
		Connection connection=null;
		PreparedStatement preparaedstatement=null;
		ResultSet resultset=null;
		//锟斤拷锟斤拷锟斤拷锟捷匡拷
		connection=DBUtil.getConnection();
		//准锟斤拷sql锟斤拷锟�
		String sql="select*from t_user where uname=? ";
		//执锟斤拷sql锟斤拷锟�
		try {
			preparaedstatement=connection.prepareStatement(sql);
			//锟斤拷锟矫讹拷锟斤拷
			preparaedstatement.setString(1, uname);
			//锟斤拷取锟斤拷锟斤拷锟�
			resultset=preparaedstatement.executeQuery();
			if(resultset.next()){
				user=new User();
				user.setUid(resultset.getInt("uid"));
				user.setUname(resultset.getString("uname"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 鍏抽棴璧勬簮
			DBUtil.close(connection, preparaedstatement, resultset);
		}
		
		return user;
		
	}
	public int payBalance(double balance, Integer uid) {
		
		//准锟斤拷sql锟斤拷锟�
		String sql="update t_user set balance=balance+? where uid=?";
		//锟斤拷锟矫讹拷锟斤拷
		List<Object> params=new ArrayList();
		params.add(balance);
		params.add(uid);
		int row=BaseDao.executeUpdate(sql, params);
		return row;
	}
	public User checkBalance(Integer uid) {
		User user=null;
		Connection connection=null;
		PreparedStatement preparaedstatement=null;
		ResultSet resultset=null;
		//锟斤拷锟斤拷锟斤拷锟捷匡拷
		connection=DBUtil.getConnection();
		//准锟斤拷sql锟斤拷锟�
		String sql="select*from t_user where uid=? ";
		//执锟斤拷sql锟斤拷锟�
		try {
			preparaedstatement=connection.prepareStatement(sql);
			//锟斤拷锟矫讹拷锟斤拷
			preparaedstatement.setObject(1, uid);
			//锟斤拷取锟斤拷锟斤拷锟�
			resultset=preparaedstatement.executeQuery();
			if(resultset.next()){
				user=new User();
				user.setUid(resultset.getInt("uid"));
				user.setUname(resultset.getString("uname"));
				user.setUpwd(resultset.getString("upwd"));
				user.setPhone(resultset.getString("phone"));
				user.setBalance(resultset.getDouble("balance"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 鍏抽棴璧勬簮
			DBUtil.close(connection, preparaedstatement, resultset);
		}
		return user;
	}
	
	//璁㈠崟纭鐣岄潰, 鐢ㄦ埛淇敼鎵嬫満鍙�, 璋冪敤姝ゆ柟娉�
	public void updatePhone(Integer uid, String phone) throws SQLException {
		String sql ="update t_user set phone=? where uid=?";
		qr.update(conn, sql, phone, uid);
		
	}
	public int updateUser(String userphone, String useremail, String sex, String age, int uid) {
		
		String sql="update t_user set phone=?,sex=?,email=?,age=? where uid=?";
		List<Object> params=new ArrayList();
		params.add(userphone);
		params.add(sex);
		params.add(useremail);
		params.add(Integer.parseInt(age));
		params.add(uid);
		int row=BaseDao.executeUpdate(sql, params);
		return row;
	}
	

}
