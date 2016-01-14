package com.liwei.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.liwei.dao.EmpDao;
import com.liwei.dao.impl.EmpDaoImpl;
import com.liwei.model.Emp;
import com.liwei.service.EmpService;

public class EmpServiceImpl implements EmpService {
	private EmpDao empDao = new EmpDaoImpl();
	@Override
	public Emp checkUser(Emp emp) {
		boolean flag = true;
		Emp empDb =new  Emp();
		try {
			empDb = empDao.getEmpByEname(emp.getEname());
			if (empDb == null || 
					(empDb != null && !empDb.getPassword().equals(emp.getPassword()))) {
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empDb;
	}

	@Override
	public void addEmp(Emp emp) {
		EmpDao empDao = new EmpDaoImpl();
		try {
			empDao.addEmp(emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public List<Emp> findAllEmp() {
		try {
			return empDao.findAllEmp();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteEmp(String id) {
		try {
			empDao.deleteEmp(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Emp findEmpById(String id) {
		try {
			return empDao.findEmpById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateEmp(Emp emp1) {
		try {
			empDao.updateEmp(emp1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
