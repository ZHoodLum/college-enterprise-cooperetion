package com.zdy.school.dao;

import com.zdy.school.vo.TeacherInfo;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/13
 */


public interface TeacherDao {
    //修改教师信息
    boolean updateTeacherInfo(TeacherInfo teacherInfo);
}
