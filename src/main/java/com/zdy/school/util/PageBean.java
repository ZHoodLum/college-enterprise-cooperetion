package com.zdy.school.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：ZhoodLum
 * @ Date       ：Created in 2018/10/9
 */


public class PageBean<T> {
    //当前页
    private int currentPage;
    //总数据条数
    private int totalCount;
    //一页显示多少条
    private int currentCount;
    //共有多少页
    private int totalpage;
    //显示javabean 集合       List<JonInfo>
    private List<T> javabeanlist = new ArrayList<T>();

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public List<T> getJavabeanlist() {
        return javabeanlist;
    }

    public void setJavabeanlist(List<T> javabeanlist) {
        this.javabeanlist = javabeanlist;
    }
}
