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
import com.zrj.utils.UUIDGeter;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = new UUIDGeter().getUUID();
		String sname = request.getParameter("sname");
		String ssex = request.getParameter("ssex");
		String sphone = request.getParameter("sphone");
		String smajor = request.getParameter("smajor");
		System.out.println("smajor:"+smajor);
		new StudentServiceImp().insert(sid,sname,ssex,sphone,smajor);
		
		List<Student> stu = new StudentServiceImp().selectByPage(1);
		HttpSession session = request.getSession();
		session.setAttribute("stu", stu);
		request.getRequestDispatcher("Right.jsp").forward(request, response);;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
