package com.liwei.dao;

import java.sql.SQLException;
import java.util.List;

import com.liwei.model.Emp;

public interface EmpDao {
	Emp getEmpByEname(String ename) throws SQLException;
	
	void addEmp(Emp emp) throws SQLException;

	List<Emp> findAllEmp() throws SQLException;

	void deleteEmp(String id) throws SQLException;

	Emp findEmpById(String id) throws SQLException;

	void updateEmp(Emp emp1) throws SQLException;
	

	
}
