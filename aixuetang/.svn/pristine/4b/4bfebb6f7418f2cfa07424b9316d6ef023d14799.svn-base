package com.Dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.util.DBUtil;

/**
 * 公用的基�?的JDBC操作的工具类
 * 	
 * @author Lisa Li
 *
 */
public class BaseDao {
	
	/**
	 * BaseDao的更新操作：
		�?要参数：sql语句、sql语句�?�?的参数（参数集合�?
		1、得到数据库的链�?
		2、预编译
		3、如果有参数，则设置参数，下标标�?1�?�? （参数的数量与sql语句有关�?
		4、执行更新，返回受影响的函数
		5、关闭资�?
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int executeUpdate(String sql, List<Object> params) {
		int row = 0; // 受影响的行数
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			// 1、得到数据库链接
			connection = DBUtil.getConnection();
			// 2、预编译
			preparedStatement = connection.prepareStatement(sql);
			// 3、判断是否有参数
			if (params != null && params.size() > 0) {
				// 参数存在，则循环设置 （按sql语句中的顺序�?
				for(int i = 0; i < params.size(); i++) {
					// 设置参数，下标从1�?�?
					preparedStatement.setObject(i+1, params.get(i));
				}
			}
			// 4、执行更新，返回受影响的行数
			row = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5、关闭资�?
			DBUtil.close(connection, preparedStatement, null);
		}
		
		return row;
	}
	
	
	
	/**
	 * 查询�?个字段（�?条数据）  
	 * 	常用场景：查询�?�数�?
	 * @return
	 */
	public static Object findSingleVlaue(String sql, List<Object> params) {
		Object object = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			// 1、得到数据库链接
			connection = DBUtil.getConnection();
			// 2、预编译
			preparedStatement = connection.prepareStatement(sql);
			// 3、判断是否有参数
			if (params != null && params.size() > 0) {
				// 参数存在，则循环设置 （按sql语句中的顺序�?
				for(int i = 0; i < params.size(); i++) {
					// 设置参数，下标从1�?�?
					preparedStatement.setObject(i+1, params.get(i));
				}
			}
			// 4、执行查询，返回结果�?
			resultSet = preparedStatement.executeQuery();
			// 5、判断并分析结果�?
			if (resultSet.next()) {
				object = resultSet.getObject(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		return object;
	}
	
	
	/**
	 * 查询集合
	 * 	JavaBean的属性名�?好与数据库中表的列名保持�?下（区分大小写），如果不�?致，可�?�过设置查询的别�?
	 * @param sql
	 * @param params
	 * @param cls
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List queryRows(String sql, List<Object> params, Class cls) {
		List list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			// 1、得到数据库链接
			connection = DBUtil.getConnection();
			// 2、预编译
			preparedStatement = connection.prepareStatement(sql);
			// 3、判断是否有参数
			if (params != null && params.size() > 0) {
				// 参数存在，则循环设置 （按sql语句中的顺序�?
				for(int i = 0; i < params.size(); i++) {
					// 设置参数，下标从1�?�?
					preparedStatement.setObject(i+1, params.get(i));
				}
			}
			// 4、执行查询，返回结果�?
			resultSet = preparedStatement.executeQuery();
			
			// 5、得到结果集的元数据对象,可以得到字段的数量和字段�?
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			
			// 判断并分析结果集
			while(resultSet.next()) {
				// 得到对象
				Object object = cls.newInstance();
				// 5、得到查询的字段的数�?
				int fieldNum = resultSetMetaData.getColumnCount();
				// 循环字段的数量，可以得到查询到的每一个字段名
				for (int  i = 1; i <= fieldNum; i++) {
					// 得到查询到的字段�?  getColumnName()：获取到的是查询到的表的列名    getColumnLabel()：获取到的是查询到的表的列名设置的别�?
					String cName = resultSetMetaData.getColumnLabel(i);
					// 通过cls.getDeclaredField(name)得到field对象
					Field field = cls.getDeclaredField(cName);
					// 得到set方法，set字符串拼接上，字段名的首字母大写
					String setMethod = "set" + cName.substring(0,1).toUpperCase() + cName.substring(1);
					// 通过cls.getDeclaredMethod方法，得到指定set方法
					Method method = cls.getDeclaredMethod(setMethod, field.getType());
					// 调用方法
					method.invoke(object, resultSet.getObject(cName));
				}
				// 将对象设置到list�?
				list.add(object);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		
		return list;
	}
	
	
	
	/**
	 * 查询对象
	 * @param sql
	 * @param params
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Object queryRow(String sql, List<Object> params, Class cls) {
		Object object = null;
		
		List list = queryRows(sql, params, cls);
		// 判断是否为空
		if (list != null && list.size() >0) {
			object = list.get(0);
		}
		return object;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * BaseDao的更新操作：
		�?要参数：sql语句、sql语句�?�?的参数（参数集合�?
		1、得到数据库的链�?
		2、预编译
		3、如果有参数，则设置参数，下标标�?1�?�? （参数的数量与sql语句有关�?
		4、执行更新，返回受影响的函数
		5、关闭资�?
		
		try-with-resource语法
			1、try关键字后面有个小括号，括号中可以声明资源
			2、在try关键字中声明的资源会在try代码块执行完毕后自动关闭，不�?要手动close
			3、try关键字中可以声明多个资源，多个资源之间用分号隔开
			4、声明的变量会被隐式加上final关键字，无法重新赋�?�，�?以在声明时需要直接赋�?
	 * 		5、声明的资源�?要实现了Closeable接口
	 * 		这其实是个语法糖，编译时编译器会自动加上finally并执行close关闭资源
		
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int executeUpdate2(String sql, List<Object> params) {
		// 声明资源
		try(
			Connection connection = DBUtil.getConnection(); // 得到数据库链�?
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
		) {
			
			if (params != null && params.size() > 0) {
				// 参数存在，则循环设置 （按sql语句中的顺序�?
				for(int i = 0; i < params.size(); i++) {
					// 设置参数，下标从1�?�?
					preparedStatement.setObject(i+1, params.get(i));
				}
			}
			int row = preparedStatement.executeUpdate();
			return row;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	/**
	 * try-with-resource语法
			1、try关键字后面有个小括号，括号中可以声明资源
			2、在try关键字中声明的资源会在try代码块执行完毕后自动关闭，不�?要手动close
			3、try关键字中可以声明多个资源，多个资源之间用分号隔开
			4、声明的变量会被隐式加上final关键字，无法重新赋�?�，�?以在声明时需要直接赋�?
	 * 		5、声明的资源�?要实现了Closeable接口
	 * 		这其实是个语法糖，编译时编译器会自动加上finally并执行close关闭资源
	 * @param sql
	 * @param params
	 * @return
	 */
	public static Object find(String sql, List<Object> params) {
	
		try(
			Connection connection = DBUtil.getConnection(); // 得到数据库连�?
			PreparedStatement preparedStatement = getPreparedStatement(connection, sql, params); // 得到预编译对象，并设置参�?
			ResultSet resultSet = preparedStatement.executeQuery();	 // 执行插叙，返回结果集
		) {
			 if (resultSet.next()) {
				 
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 得到预编译对象，并设置参数，返回处理好的预编译对�?
	 * @param connection
	 * @param sql
	 * @param params
	 * @return
	 */
	public static PreparedStatement getPreparedStatement(Connection connection, String sql, List<Object> params) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql); // 预编译sql语句
			// 判断是否有参�?
			if (params != null && params.size() > 0) {
				// 参数存在，则循环设置 （按sql语句中的顺序�?
				for(int i = 0; i < params.size(); i++) {
					// 设置参数，下标从1�?�?
					preparedStatement.setObject(i+1, params.get(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回处理好的预编译对�?
		return preparedStatement;
	}

}