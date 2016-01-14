package com.liwei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liwei.model.Emp;
import com.liwei.service.EmpService;
import com.liwei.service.impl.EmpServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		String path = null;
		EmpService empService = new EmpServiceImpl();
		
		Emp emp = new Emp();
		emp.setEname(username);
		emp.setPassword(password);
		Emp empDb2= empService.checkUser(emp);
		if(empDb2.getPassword().equals(password)){
			path = "index.jsp";
		}else{
			request.setAttribute("error", "µÇÂ½ÓÐÎó"+empDb2.getJob());
			path = "login.jsp";
			System.out.println(empDb2.getJob());
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
