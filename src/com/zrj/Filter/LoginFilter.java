package com.zrj.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Login
 */
@WebFilter("/Login.html")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("拦截器检测!");
		HttpServletResponse hss = (HttpServletResponse) response;
		HttpServletRequest hsq = (HttpServletRequest) request;
		Cookie[] cookie = hsq.getCookies();
		String name="";
		String password="";
		System.out.println("Cookie:"+cookie);
		if(cookie!=null) {
			System.out.println("检测到Cookie!");
			for(Cookie c:cookie) {
				if(c.getName().equals("name")) {
					name = c.getValue();
					if(c.getName().equals("upwd")) {
						System.out.println("检测到Cookie带有密码");
						password = c.getValue();
					}
					System.out.println(name+"===>"+password);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
					chain.doFilter(request, response);
			}
		}
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
