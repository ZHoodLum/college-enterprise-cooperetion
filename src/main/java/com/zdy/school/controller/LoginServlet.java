package com.zdy.school.controller;

import com.zdy.school.service.LoginService;
import com.zdy.school.service.LoginServiceImpl;
import com.zdy.school.vo.AdminInfo;
import com.zdy.school.vo.EnterpriseInfo;
import com.zdy.school.vo.StudentInfo;
import com.zdy.school.vo.TeacherInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/9
 * 用户登陆功能的实现
 * 可以根据学生、教师、企业、管理员不同权限进行登陆，管理属于自己权限的信息
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
//		LoginDao loginDao = new LoginDao();
		LoginService loginDao = new LoginServiceImpl();
		StudentInfo studentInfo = new StudentInfo();
		TeacherInfo teacherInfo = new TeacherInfo();
		EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
		AdminInfo adminInfo = new AdminInfo();
		//判断验证码
		//获得用户输入的验证码
		String code= request.getParameter("code").toLowerCase();
		String servercode=(String)request.getSession().getAttribute("code");
		servercode=servercode.toLowerCase();
		if(code!=null&&servercode.equals(code)){
			System.out.println("验证码正确！");
			
			//获取权限
			String[] limits = request.getParameterValues("limits");
			int x;
			for(x=0;x<limits.length;x++) {
				System.out.println("登陆者身份是："+limits[x]);
				//学生登陆
				if(limits[x].equals("学生")) {
					studentInfo.setStudentTel(request.getParameter("useraccount") );
					System.out.println("学生表单信息"+request.getParameter("useraccount") );
					studentInfo.setStudentPassword(request.getParameter("userpassword") );
					System.out.println("学生表单信息"+request.getParameter("userpassword") );

					System.out.println("************************************************");
					try {
						if (loginDao.studentlogin(studentInfo)) {
							request.getSession().setAttribute("student_id",studentInfo.getStudentId());
							request.getSession().setAttribute("student_account",studentInfo.getStudentAccount());
							request.getSession().setAttribute("student_name", studentInfo.getStudentName());
							request.getSession().setAttribute("student_tel", studentInfo.getStudentTel());
							request.getSession().setAttribute("student_password", studentInfo.getStudentPassword());
							request.getSession().setAttribute("student_sex",studentInfo.getStudentSex());
							request.getSession().setAttribute("major",studentInfo.getMajor());
							request.getSession().setAttribute("city",studentInfo.getCity());
							request.getSession().setAttribute("email",studentInfo.getEmail());
							request.getSession().setAttribute("student_college",studentInfo.getStudentCollege());
							request.getSession().setAttribute("student_internship",studentInfo.getStudentInternship());
							request.getSession().setAttribute("student_grade",studentInfo.getStudentGrade());
							request.getSession().setAttribute("class_name",studentInfo.getClassName());
							request.getSession().setAttribute("class_id",studentInfo.getClassId());
							request.getSession().setAttribute("teacher_id",studentInfo.getTeacherId());
							request.getSession().setAttribute("teacher_name",studentInfo.getTeacherName());

							request.getSession().setAttribute("StudentInfo", studentInfo);

							request.getRequestDispatcher("/JobInfoQueryAllServlet").forward(request,response);
						} else {
							response.sendRedirect("/college-enterprise-cooperetion/jsp/login.jsp");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				//教师登陆
				else if(limits[x].equals("教师")) {
					teacherInfo.setTeacherTel(request.getParameter("useraccount"));
					System.out.println("教师表单信息"+request.getParameter("useraccount") );
					teacherInfo.setTeacherPassword(request.getParameter("userpassword") );
					System.out.println("教师表单信息"+request.getParameter("userpassword") );
					
					System.out.println(limits[x].equals("教师"));
					System.out.println("************************************************");
					try {
						if (loginDao.teacherlogin(teacherInfo)) {
						    request.getSession().setAttribute("teacher_id",teacherInfo.getTeacherId());
						    request.getSession().setAttribute("teacher_account",teacherInfo.getTeacherAccount());
						    request.getSession().setAttribute("teacher_name",teacherInfo.getTeacherName());
							request.getSession().setAttribute("teacher_tel", teacherInfo.getTeacherTel());
							request.getSession().setAttribute("teacher_password", teacherInfo.getTeacherPassword());
							request.getSession().setAttribute("email",teacherInfo.getEmail());
							request.getSession().setAttribute("teacher_college",teacherInfo.getTeacherCollege());
							request.getSession().setAttribute("teacher_sex",teacherInfo.getTeacherSex());
							request.getSession().setAttribute("teacher_job",teacherInfo.getTeacherJob());
							request.getSession().setAttribute("TeacherInfo", teacherInfo);
                            response.sendRedirect("/college-enterprise-cooperetion/jsp/teacher-main.jsp");
						} else {
							response.sendRedirect("/college-enterprise-cooperetion/jsp/login.jsp");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				//企业登陆
				else if(limits[x].equals("企业")) {
					enterpriseInfo.setEnterpriseId(Integer.parseInt(request.getParameter("useraccount")));
					System.out.println("企业表单信息"+request.getParameter("useraccount") );

					enterpriseInfo.setEnterprisePassword(request.getParameter("userpassword") );
					System.out.println("企业表单信息"+request.getParameter("userpassword") );
					
					System.out.println(limits[x].equals("企业"));
					System.out.println("************************************************");
					try {
						if (loginDao.enterpriselogin(enterpriseInfo)) {
							request.getSession().setAttribute("enterprise_id", enterpriseInfo.getEnterpriseId());
							request.getSession().setAttribute("enterprise_name", enterpriseInfo.getEnterpriseName());
							request.getSession().setAttribute("enterprise_password", enterpriseInfo.getEnterprisePassword());
							request.getSession().setAttribute("enterprise_introduce", enterpriseInfo.getEnterpriseIntroduce());
							request.getSession().setAttribute("enterprise_address", enterpriseInfo.getEnterpriseAddress());
							request.getSession().setAttribute("enterprise_tel", enterpriseInfo.getEnterpriseTel());
							request.getSession().setAttribute("email", enterpriseInfo.getEmail());
							request.getSession().setAttribute("enterprise_manager", enterpriseInfo.getEnterpriseManager());
							System.out.println("登录的公司是："+ enterpriseInfo.getEnterpriseName());
							request.getSession().setAttribute("EnterpriseInfo", enterpriseInfo);
							response.sendRedirect("/college-enterprise-cooperetion/jsp/company-main.jsp");
//							request.getRequestDispatcher("/jsp/company-main.jsp").forward(request,response);
						} else {
							response.sendRedirect("/college-enterprise-cooperetion/jsp/login.jsp");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				//管理员
				else if(limits[x].equals("管理员")) {
					adminInfo.setAdminId(Integer.parseInt(request.getParameter("useraccount")));
					System.out.println("管理员表单信息"+request.getParameter("useraccount") );
					
					adminInfo.setAdminPassword(request.getParameter("userpassword"));
					System.out.println("管理员表单信息"+request.getParameter("userpassword") );
					
					System.out.println(limits[x].equals("管理员"));
					System.out.println("************************************************");
					try {
						if (loginDao.adminlogin(adminInfo)) {
							request.getSession().setAttribute("AdminInfo", adminInfo);

							response.sendRedirect("/college-enterprise-cooperetion/jsp/manger-main.jsp");
//							request.getRequestDispatcher("/index.jsp").forward(request,response);
						} else {
							response.sendRedirect("/college-enterprise-cooperetion/jsp/login.jsp");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else {
					System.out.println("出错啦！");
				}	
			}
			//for循环停止
		//验证码结束
		}else {			
			PrintWriter out = response.getWriter();
		    out.flush();
		    out.println("<script>");
		    out.println("alert('验证码不正确,请重新输入！');");
		    out.println("history.go(-1);");
		    out.println("</script>");
			System.out.println("验证码不正确！");

			System.out.println("输入的验证码是：code="+code+";机器产生验证码是：servercode="+servercode);
		}
		
	}

}
