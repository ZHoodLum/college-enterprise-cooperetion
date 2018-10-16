package com.zdy.school.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/SchoolFilter")
//@WebFilter(filterName="/TestFilter1",urlPatterns="/*")
public class SchoolFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("服务器关闭，Filter1的销毁！");
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//编码格式
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

//		System.out.println("进入Filter1之前");
		// 通过请求   将请求转发给过滤器链下一个filter , 如果没有filter那就是你请求的资源
		chain.doFilter(request,response);
//		System.out.println("进入Filter1之后");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filter1的初始化！");
	}

}
