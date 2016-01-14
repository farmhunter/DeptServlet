package com.liwei.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liwei.model.Dept;
import com.liwei.model.Emp;
import com.liwei.service.DeptService;
import com.liwei.service.impl.DeptServiceImpl;

/**
 * Servlet implementation class DeptServlet
 */
@WebServlet("/DeptServlet")
public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptService deptService = new DeptServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeptServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DeptService deptService = new DeptServiceImpl();
		String method = request.getParameter("method").trim();
		String path = null;
		if (method.equals("initDept")) {
			path = "createDepartment.jsp";
		} else if (method.equals("initDept1")) {
			path = this.initDept1(request);
		} else if (method.equals("delete")) {
			String id = request.getParameter("deptno");
			deptService.deleteDept(id);
			path = this.getAllDept(request);
		} else if (method.equals("initDept2")) {
			path = this.getAllDept(request);
		} else if (method.equals("saveDept")) {
			String deptno = request.getParameter("id");
			String dname = request.getParameter("dname").trim();
			String loc = request.getParameter("description").trim();
			Dept dept = new Dept();
			if(deptno != null && !deptno.equals("")){
				dept.setDeptno(Integer.parseInt(deptno));
			}
			dept.setDname(dname);
			dept.setDescription(loc);
			if(deptno == null || deptno.equals("")){
				deptService.initDept(dept);
			}else{
				deptService.updateDept(dept);
			}
			path = this.getAllDept(request);
		}else if(method.equals("update")){
			String id = request.getParameter("deptno");
			Dept updateDept = deptService.findDeptById(id);
			request.setAttribute("dept", updateDept);
			path = "createDepartment.jsp";
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

	private String getAllDept(HttpServletRequest request) {
		List<Dept> list = new ArrayList<Dept>();
		list = deptService.findAllDept();
		request.setAttribute("deptList", list);
		return "viewAllDepartment.jsp";
	}
	
	private String initDept1(HttpServletRequest request) {
		List<Dept> list = new ArrayList<Dept>();
		list = deptService.initDept1();
		request.setAttribute("deptList", list);
		return "departmentManage.jsp";
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
