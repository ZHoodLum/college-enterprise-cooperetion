package com.zdy.school.dao;
import com.zdy.school.vo.AdminInfo;
import com.zdy.school.vo.EnterpriseInfo;
import com.zdy.school.vo.StudentInfo;
import com.zdy.school.vo.TeacherInfo;

import java.util.ArrayList;


public interface LoginDao {

	//学生登陆
	public boolean studentlogin(StudentInfo studentinfo) throws Exception;
	//教师登陆
	public boolean teacherlogin(TeacherInfo teacherinfo) throws Exception;
	//企业登陆
	public boolean enterpriselogin(EnterpriseInfo enterpriseinfo) throws Exception;
	//管理员登陆
	public boolean adminlogin(AdminInfo admininfo) throws Exception;
	
	
	
}
