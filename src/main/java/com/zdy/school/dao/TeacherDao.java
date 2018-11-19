package com.zdy.school.dao;

import com.zdy.school.vo.StudentInfo;
import com.zdy.school.vo.TeacherInfo;

import java.util.ArrayList;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/13
 */


public interface TeacherDao {
    //查询全部教师
    ArrayList<TeacherInfo> queryAllTeacherInfo(TeacherInfo teacherInfo) throws Exception;

    //修改教师信息
    boolean updateTeacherInfo(TeacherInfo teacherInfo);

    //教师信息的注册
    int insertTeacherIno(TeacherInfo teacherInfo);
}
