package com.zdy.school.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtil {
	/**
	 * 数据库连接池中有多个连接
	 * 所以将con改变为DataSource
	 */
//	数据源获得数据连接源con
	private static DruidDataSource datasource;
	public static DataSource getDatasource() {
		return datasource;
	}
//	静态块   减少代码量 优化代码
	static{
		try {
			Properties pro = readproperties();
			System.out.println("Druid"+pro);
			datasource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pro);
			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
	}
//	读方法 读取硬盘中的ojdbc.properties文件信息
	public static Properties readproperties() {
//		通过类加载器
		InputStream inputstream = DruidUtil.class.getClassLoader().getResourceAsStream("DruidPool.properties");
//		数据类型
		Properties pro = new Properties();
		try {
			pro.load(inputstream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}
//	获取连接  datasource获得connection
	public static Connection getCon() {
		try {
			return datasource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e+"datasource获得connection出现问题");
		}
		return null;
	}
//	关闭数据库相关连接
	public static void closeConnection(ResultSet rs,Connection conn,Statement state) throws Exception {
		if(rs!=null) {
			rs.close();
//			System.out.println("数据库rs关闭成功！");
		}
		
		if(state!=null) {
			state.close();
//			System.out.println("数据库pstate关闭成功！");
		}
		
		if(conn!=null) {
			conn.close();
//			System.out.println("数据库con关闭成功！");
		}
		System.out.println("数据库关闭成功！");
	}
}
