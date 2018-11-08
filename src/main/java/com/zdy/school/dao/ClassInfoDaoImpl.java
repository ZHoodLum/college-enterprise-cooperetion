package com.zdy.school.dao;

import com.zdy.school.util.DruidUtil;
import com.zdy.school.vo.ClassInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/11/8
 */


public class ClassInfoDaoImpl implements ClassInfoDao {
    ResultSet rs;
    PreparedStatement pstate;
    boolean flag = false;
    Connection con = DruidUtil.getCon();
    //查询全部的班级
    @Override
    public List<ClassInfo> findAllClassInfo(ClassInfo classInfo) {
        List<ClassInfo> allClassInfo = new ArrayList<ClassInfo>();
        try {
            String sql = "select * from classinfo;";
            pstate = con.prepareStatement(sql);
            rs = pstate.executeQuery();
            while (rs.next()){
                classInfo = new ClassInfo();
                classInfo.setClassId(rs.getInt("class_id"));
                classInfo.setClassName(rs.getString("class_name"));
                allClassInfo.add(classInfo);
                for (ClassInfo s:allClassInfo){
                    System.out.println(s);
                }
            }
            DruidUtil.closeConnection(rs,con,pstate);
        }catch (SQLException s){
            s.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return allClassInfo;
    }
}
