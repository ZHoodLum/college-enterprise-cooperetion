package com.zdy.school.service;

import com.zdy.school.dao.TeacherDao;
import com.zdy.school.dao.TeacherDaoImpl;
import com.zdy.school.vo.StudentInfo;
import com.zdy.school.vo.TeacherInfo;

import java.util.ArrayList;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/13
 */


public class TeacherServiceImpl implements TeacherService {
    TeacherDao teacherDao = new TeacherDaoImpl();
//  查询全部教师
    @Override
    public ArrayList<TeacherInfo> queryAllTeacherInfo(TeacherInfo teacherInfo) throws Exception {
        ArrayList<TeacherInfo> list = teacherDao.queryAllTeacherInfo(teacherInfo);
        return list;
    }

    //修改教师信息
    @Override
    public boolean updateTeacherInfo(TeacherInfo teacherInfo) {

        int succ = 0;
        boolean rows = teacherDao.updateTeacherInfo(teacherInfo);
        if (rows == true){
            succ = 1;
        }else {
            succ = 0;
        }
        return rows;
    }
}
