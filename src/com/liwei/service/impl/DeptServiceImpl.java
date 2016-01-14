package com.liwei.service.impl;


import java.sql.SQLException;
import java.util.List;

import com.liwei.dao.DeptDao;
import com.liwei.dao.impl.DeptDaoImpl;
import com.liwei.model.Dept;
import com.liwei.service.DeptService;

public class DeptServiceImpl implements DeptService {
	private	DeptDao deptDao = new DeptDaoImpl();

	@Override
	public void initDept(Dept dept) {
		try {
			deptDao.initDept(dept);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Dept> findAllDept() {
		try{
			return deptDao.findAllDept();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void deleteDept(String id) {
		try {
			deptDao.deleteDept(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public Dept findDeptById(String id) {
		try {
			return deptDao.findDeptById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateDept(Dept dept1) {
		try{
			deptDao.updateDept(dept1);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Dept> initDept1() {
		try {
			return deptDao.initDept1();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}



}
