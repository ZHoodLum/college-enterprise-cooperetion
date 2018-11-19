package com.zdy.school.service;

import com.zdy.school.vo.TeacherInfo;

import java.util.ArrayList;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/13
 */


public interface TeacherService {
    //查询全部教师
    ArrayList<TeacherInfo> queryAllTeacherInfo(TeacherInfo teacherInfo) throws Exception;

    //修改教师信息
    boolean updateTeacherInfo(TeacherInfo teacherInfo);

    // 注册教师信息
    int insertTeacherInfo(TeacherInfo teacherInfo);
}
