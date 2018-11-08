package com.zdy.school.service;

import com.zdy.school.dao.ClassInfoDao;
import com.zdy.school.dao.ClassInfoDaoImpl;
import com.zdy.school.vo.ClassInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/8
 */


public class ClassInfoServiceImpl implements ClassInfoService{
    ClassInfoDao classInfoDao = new ClassInfoDaoImpl();
    //教师查询全部学生信息
    @Override
    public List<ClassInfo> findAllClassInfo(ClassInfo classInfo) {
        return classInfoDao.findAllClassInfo(classInfo);
    }
}
