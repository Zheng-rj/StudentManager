package com.zrj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrj.Entity.Student;
import com.zrj.service.imp.StudentServiceImp;

/**
 * Servlet implementation class Page
 */
@WebServlet("/Page")
public class Page extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PageServlet!");
		
		int rows = new StudentServiceImp().selectAll().size();
		System.out.println("总行数:"+rows);
		int AllPage = rows/6;
		if(rows%6!=0) {
			AllPage++;
		}
		System.out.println("总页数:"+AllPage);
		
		String control = request.getParameter("page");
		System.out.println("操作:"+control);
		
		HttpSession session = request.getSession();
		int pa = (int)session.getAttribute("page");
		System.out.println("当前页:"+pa);
		if("F".equals(control)) {
			List<Student> list = new StudentServiceImp().selectByPage(1);
			session.setAttribute("Allpage", AllPage);
			session.setAttribute("page", 1);
			session.setAttribute("stu", list);
			request.getRequestDispatcher("Right.jsp?page=1").forward(request, response);
		}else if("L".equals(control)) {
			List<Student> list = new StudentServiceImp().selectByPage(AllPage);
			session.setAttribute("Allpage", AllPage);
			session.setAttribute("page", AllPage);
			session.setAttribute("stu", list);
			request.getRequestDispatcher("Right.jsp?page="+AllPage).forward(request, response);
		}else {
			pa += Integer.parseInt(control);
			if(pa==0) {
				
				pa=1;
			}
			System.out.println("点击后页码:"+pa);
			List<Student> list = new StudentServiceImp().selectByPage(pa);
			if(null == list || list.size() ==0) {
				list = new StudentServiceImp().selectByPage(--pa);
			}
			session.setAttribute("Allpage", AllPage);
			session.setAttribute("page", pa);
			session.setAttribute("stu", list);
			request.getRequestDispatcher("Right.jsp?page="+pa).forward(request, response);
		}
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
