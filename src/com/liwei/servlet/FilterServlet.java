package com.liwei.servlet;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName="FilterServlet",urlPatterns="/*")
public class FilterServlet implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("过滤器初始化");
	}	


	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		System.out.println("执行过滤操作");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String username = (String) req.getSession().getAttribute("username");
		if(username == null || username.equals("")){
			request.getRequestDispatcher("login.jsp"). forward(req,res);
		}

		filterChain.doFilter(request,response);
	}

	
	
	@Override
	public void destroy() {
		System.out.println("过滤器销毁");
	}

	

}
