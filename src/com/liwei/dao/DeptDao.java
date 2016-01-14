package com.liwei.dao;

import java.sql.SQLException;
import java.util.List;

import com.liwei.model.Dept;


public interface DeptDao {
	
	Dept getdeptByDeptno(String deptno) throws SQLException;


	void initDept(Dept dept) throws SQLException;
	List<Dept> findAllDept() throws SQLException;


	void deleteDept(String id) throws SQLException;


	Dept findDeptById(String id) throws SQLException;


	void updateDept(Dept dept1) throws SQLException;


	List<Dept> initDept1() throws SQLException;

}
