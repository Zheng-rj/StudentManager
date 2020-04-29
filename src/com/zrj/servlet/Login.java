package com.zrj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrj.Entity.Student;
import com.zrj.Entity.User;
import com.zrj.service.imp.StudentServiceImp;
import com.zrj.service.imp.UserServiceImp;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uname = request.getParameter("name");
		String upwd = request.getParameter("password");

		// 查询用户
		User user = new UserServiceImp().selectUserByNamePwd(uname,upwd);

		System.out.println("LoginServlet!");
		System.out.println(user);
		if (user != null) { // 判断用户是否存在
			System.out.println("查询到用户");
			String remember = request.getParameter("remember");
			if ("remember".equals(remember)) {
				System.out.println("检测到记住密码!");
				Cookie name = new Cookie("name", uname);
				Cookie password = new Cookie("upwd", upwd);
				response.addCookie(name);
				response.addCookie(password);
			}

			// 获取学生列表,初始化页码
			List<Student> AllStu = new StudentServiceImp().selectAll();
			List<Student> stu = new StudentServiceImp().selectByPage(1);
			int rows = AllStu.size();
			int AllPage = rows / 6;
			if (rows % 6 != 0) {
				AllPage++;
			}
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("stu", stu);
			session.setAttribute("page", 1);
			session.setAttribute("rows", rows);
			session.setAttribute("Allpage", AllPage);
//			request.getRequestDispatcher("index.jsp").forward(request, response);
			response.sendRedirect("index.jsp");
			return;
		}else {
//			response.sendRedirect("Login.html");
			PrintWriter writer = response.getWriter();
			writer.print("<script>alert('账号或密码错误,请重试……'); window.location='userlogin.html' </script>");
			writer.flush();
//			request.getRequestDispatcher("Login.html").forward(request, response);
		}
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
