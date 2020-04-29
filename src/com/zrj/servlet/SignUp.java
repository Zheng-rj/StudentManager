package com.zrj.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zrj.Entity.User;
import com.zrj.service.imp.UserServiceImp;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SignUpServlet!");
		request.setCharacterEncoding("utf-8");
		User user = new User();

		DiskFileItemFactory factory = new DiskFileItemFactory();// 创建工厂类
		ServletFileUpload upload = new ServletFileUpload(factory);
		System.out.println(request.getParameter("uname"));
//		String uimg = "abc.PNG";
		try {
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (item.isFormField()) {
					System.out.println(item.getFieldName() + "===>" + item.getString());
					BeanUtils.setProperty(user, item.getFieldName(), item.getString());
					System.out.println("User:" + user);
				} else {
					InputStream input = item.getInputStream();
//				    	String str[] = user.getUimg().split(".");
//				    	for(String x:str) {
//					    	System.out.println("数组:"+x);
//				    	}
//				    	String type = str[str.length-1];
//				    	System.out.println("后缀名:"+type);
					OutputStream os = new FileOutputStream(new File("E:\\Work\\UserImg\\" + user.getUname() + ".png"));
					byte bytes[] = new byte[1024];

					int len = 0;
					while ((len = input.read(bytes)) != -1) {
						os.write(bytes, 0, len);
					}
					BeanUtils.setProperty(user, item.getFieldName(), "..\\..\\UserImg\\" + user.getUname() + ".png");
					os.close();
				}
			}
			new UserServiceImp().addUser(user);
			request.getRequestDispatcher("Login.html").forward(request, response);
		} catch (FileUploadException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
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
