package com.zdy.school.service;

import com.zdy.school.dao.AdminDao;
import com.zdy.school.dao.AdminDaoImpl;
import com.zdy.school.vo.AdminInfo;
import com.zdy.school.vo.EnterpriseInfo;
import com.zdy.school.vo.StudentInfo;
import com.zdy.school.vo.TeacherInfo;

import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/19
 */


public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();
    //注册管理员信息
    @Override
    public int insertAdminInfo(AdminInfo adminInfo) {
        int datavalues = 0;
        int rows = adminDao.insertAdminInfo(adminInfo);
        if (rows > 0 ){
            datavalues = 1;
        }else {
            datavalues = 0;
        }
        return datavalues;
    }

    //修改管理员信息
    @Override
    public boolean updateAdminInfo(AdminInfo adminInfo) {
        int succ = 0;
        boolean rows = adminDao.updateAdminInfo(adminInfo);
        if (rows == true){
            succ = 1;
        }else {
            succ = 0;
        }
        return rows;
    }

    //管理员进行分页查询
    @Override
    public List<EnterpriseInfo> findAllEnterpriseInfo(int pageNo, int pageSize) {
        List<EnterpriseInfo> list = adminDao.findAllEnterpriseInfo(pageNo, pageSize);
        return list;
    }
    //查询总数数据
    @Override
    public int getEnterpriseInfoTotal() {
        int n = adminDao.getEnterpriseInfoTotal();
        return n;
    }

    //教师分页查询
    @Override
    public List<TeacherInfo> findAllTeacherInfo(int pageNo, int pageSize) {
        List<TeacherInfo> list = adminDao.findAllTeacherInfo(pageNo, pageSize);
        return list;
    }
    @Override
    public int getTeacherInfoTotal() {
        int n = adminDao.getTeacherInfoTotal();
        return n;
    }

    //学生分页查询
    @Override
    public List<StudentInfo> findAllStudentInfo(int pageNo, int pageSize) {
        List<StudentInfo> list = adminDao.findAllStudentInfo(pageNo, pageSize);
        return list;
    }

    @Override
    public int getStudentInfoTotal() {
        int n = adminDao.getStudentInfoTotal();
        return n;
    }

    //根据ID进行查询修改
    @Override
    public StudentInfo queryGetByIdStudentInfo(int studentId) {
        return adminDao.queryGetByIdStudentInfo(studentId);
    }

    //修改学生信息
    @Override
    public boolean adminUpdateStudentInfo(StudentInfo studentInfo) {
        int succ = 0;
        boolean rows = adminDao.adminUpdateStudentInfo(studentInfo);
        if (rows == true){
            succ = 1;
        }else {
            succ = 0;
        }
        return rows;
    }

    //删除学生信息
    @Override
    public boolean deleteStudentInfo(int studentId) {
        int succ = 0;
        boolean rows = adminDao.deleteStudentInfo(studentId);
        if(rows == true) {
            succ=1;//
        }else {
            succ=0;
        }
        return rows;
    }

}
