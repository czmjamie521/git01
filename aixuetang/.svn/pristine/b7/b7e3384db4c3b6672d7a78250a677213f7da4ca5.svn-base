package com.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * 数据库工具类
 * 	1、打�?数据库连�?
 * 	2、关闭资�?
 * 
 * 	常见的报错情况：
 * 		1、数据库的jar包未拷贝到lib目录�?
 * 			java.lang.ClassNotFoundException: com.mysql.jdbc.Driver
 * 		2、数据库的密码可能不正确�?
 * 			java.sql.SQLException: Access denied for user 'root'@'localhost' (using password: YES)
 * 		3、数据库名称不正�?
 * 			com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown database 'java29'
 * 
 * 
 * @author Lisa Li
 *
 */
public class DBUtil {

	// 得到配置文件对象
	private static Properties properties = new Properties();
	
	static {
		try {
			// 得到db.properties的输入流对象
			InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
			// 通过properties的load()方法，加载配置文件的输入�?
			properties.load(inputStream);
		} catch (Exception e) {
			// 打印异常
			e.printStackTrace();
		}
	}
	
	/**
	 * 得到数据库连�?
	 * 	1、加载驱�?
	 * 	2、�?�过地址、账号�?�密码得到数据库连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection connection = null;
		
		// 从配置对象中获取参数   getProperty()
		String jdbcName = properties.getProperty("jdbcName");
		String dbUrl = properties.getProperty("dbUrl");
		String dbName = properties.getProperty("dbName");
		String dbPwd = properties.getProperty("dbPwd");
		
		try {
			//	1、加载驱�?
			Class.forName(jdbcName);
			// 2、�?�过地址、账号�?�密码得到数据库连接
			connection = DriverManager.getConnection(dbUrl, dbName, dbPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * 关闭资源
	 * @param connection
	 * @param preparedStatement
	 * @param resultSet
	 */
	public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		// 关闭资源
		try {
			// 先判断不为空，再关闭
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	
	
}
