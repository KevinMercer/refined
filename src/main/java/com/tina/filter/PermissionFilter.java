/**
 * 
 */
package com.tina.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tina.entity.Permission;

/**
 * 
 * @author 何悟隆
 * @datetime 2018年5月1日 下午2:00:12
 *
 */
public class PermissionFilter implements Filter {

	private long startTime;
	private List<Permission> permissions;
	private PrintWriter pw;
	private String defaultPerURL, role;
	private boolean mark = false;

	/**
	 * 
	 */
	public PermissionFilter() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("初始化PermissionFilter" + new Date());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) rep;
		HttpSession session = request.getSession();
		String URL = request.getContextPath();
		String URI = request.getRequestURI();
		String URR = request.getRequestedSessionId();
		role = (String) session.getAttribute("role");
		URL += "/" + role + "/interface.do";
		System.out.println("当前访问路径：" + URI);
		startTime = System.currentTimeMillis();
		System.out.println("执行PermissionFilter开始时间(PSI)：" + startTime);
		permissions = (List<Permission>) session.getAttribute("permissions");
		System.out.println("permissionFilter --> permissions = " + permissions);
		defaultPerURL = (String) session.getAttribute("defaultPerURL");
		session.setAttribute("homePage", URL);
		if (URI.indexOf("/login.do") != -1 || URI.indexOf("/logout.do") != -1) {
			chain.doFilter(request, response);
		} else if (defaultPerURL.indexOf(URI) != -1) {
			chain.doFilter(request, response);
		} else if (permissions != null) {
			if (permissions.size() >= 0) {
				for (Permission permission : permissions) {
					if (permission != null) {
						if (permission.getAjaxPath() != null) {
							System.out.println("当前传入的访问地址参数：" + URI);
							System.out.println("当前所对比的权限URL参数：" + permission.getAjaxPath());
							if (permission.getAjaxPath().indexOf(URI) != -1) {
								System.err.println("拥有权限，可以进入！！！");
								chain.doFilter(request, response);
								mark = true;
								break;
							} else {
								System.err.println("未拥有权限，不可以进入！！！");
							}
						}
					}
				}
				if (!mark) {
					isFiltered(response, URL); 
				}
			} else {
				isFiltered(response, URL);
			}
		} else {
			isFiltered(response, URL);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("执行PermissionFilter结束时间(PSI)：" + endTime);
		System.out.println("执行时间为：" + (endTime - startTime) + "毫秒！");
		System.out.println("指向地址：[URL-->" + URL + "; URI-->" + URI + "; URR-->" + URR + "]");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("销毁PermissionFilter" + new Date());
	}

	public void isFiltered(HttpServletResponse response, String URL) throws IOException {
		pw = response.getWriter();
		pw.print("<html><head></head><body>");
		pw.print("<script type='text/javascript'>window.open('" + URL + "','_top')</script>");
		pw.print("</body></html>");
		pw.flush();
		pw.close();
	}

}
