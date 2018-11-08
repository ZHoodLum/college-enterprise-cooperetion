package com.zdy.school.service;

import com.zdy.school.vo.ClassInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/8
 */


public interface ClassInfoService {
    //教师查询全部学生信息
    List<ClassInfo> findAllClassInfo(ClassInfo classInfo);
}
