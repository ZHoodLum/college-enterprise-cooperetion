package com.zdy.school.dao;

import com.zdy.school.vo.ClassInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/8
 */


public interface ClassInfoDao {
    List<ClassInfo> findAllClassInfo(ClassInfo classInfo);
}
