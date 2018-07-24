/**
 * 
 */
package com.tina.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author 何悟隆
 * @datetime 2018年5月1日 下午2:00:07
 *
 */
public class LoginFilter implements Filter {

	/**
	 * 
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) rep;
		HttpSession session = request.getSession();
		String URL = request.getContextPath();
		String URI = request.getRequestURI();
		String URR = request.getRequestedSessionId();
		URL += "/index.jsp";
		System.out.println("当前访问路径：" + URI);
		long startTime = System.currentTimeMillis();
		System.out.println("执行LoginFilter开始时间(PSI)：" + startTime);
		if (session.getAttribute("account") != null || URI.indexOf("login") != -1 || URI.indexOf("logout") != -1 || URI.indexOf(".jpg") != -1 || URI.indexOf(".png") != -1 || URI.indexOf(".css") != -1 || URI.indexOf(".js") != -1) {
			chain.doFilter(request, response);
		} else {
			PrintWriter pw = response.getWriter();
			pw.print("<html><head></head><body>");
			pw.print("<script type='text/javascript'>window.open('" + URL + "','_top')</script>");
			pw.print("</body></html>");
			pw.flush();
			pw.close();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("执行LoginFilter结束时间(PSI)：" + endTime);
		System.out.println("执行时间为：" + (endTime - startTime) + "毫秒！");
		System.out.println("指向地址：[URL-->" + URL + "; URI-->" + URI + "; URR-->" + URR + "]");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConf) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("初始化Filter-->LoginFilter");
	}

}
