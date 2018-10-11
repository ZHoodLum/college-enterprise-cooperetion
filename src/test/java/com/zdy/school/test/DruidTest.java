package com.zdy.school.test;

import com.zdy.school.util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DruidTest {

	public static void main(String[] args) {
		PreparedStatement pstate;
		ResultSet rs = null;
		boolean flag = false;
		try {
			//获取连接信息
			Connection con = DruidUtil.getCon();
			//创建SQL语句平台 执行SQL语句
			String sql4 = "select * from jobinfo";
			pstate = con.prepareStatement(sql4);
			rs = pstate.executeQuery(); 
			while(rs.next()) {
				flag=true;
				System.out.println("员工编号："+rs.getInt("job_id")+"    员工姓名："+rs.getString("job_info")+"    员工工资："+rs.getString("job_position"));
			}
//			关闭数据库连接
			DruidUtil.closeConnection(rs, con, pstate);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
