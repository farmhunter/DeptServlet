package com.liwei.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liwei.model.Emp;
import com.liwei.service.EmpService;
import com.liwei.service.impl.EmpServiceImpl;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService empService = new EmpServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EmpService empService = new EmpServiceImpl();
		String method = request.getParameter("method").trim();
		String path = null;
		if (method.equals("addEmp")) {
			path = "createEmployee.jsp";
		} else if (method.equals("findAllEmp")) {
			path = this.getAllEmp(request);
		} else if (method.equals("saveEmp")) {
			String id = request.getParameter("id");
			String ename = request.getParameter("username").trim();
			String password = request.getParameter("password").trim();
			Emp emp1 = new Emp();
			if(id != null && !id.equals("")){
				emp1.setId(Integer.parseInt(id));
			}
			emp1.setEname(ename);
			emp1.setPassword(password);
			if (id == null || id.equals("")) {
				empService.addEmp(emp1);
			} else {
				empService.updateEmp(emp1);
			}
			path = this.getAllEmp(request);
		} else if (method.equals("delete")) {
			String id = request.getParameter("empno");
			empService.deleteEmp(id);
			path = this.getAllEmp(request);
		} else if (method.equals("update")) {
			String id = request.getParameter("empno");
			Emp updateEmp = empService.findEmpById(id);
			request.setAttribute("emp", updateEmp);
			path = "createEmployee.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	private String getAllEmp(HttpServletRequest request) {
		List<Emp> list = new ArrayList<Emp>();
		list = empService.findAllEmp();
		request.setAttribute("empList", list);
		return "viewAllEmployee.jsp";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
