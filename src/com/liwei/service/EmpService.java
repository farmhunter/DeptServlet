package com.liwei.service;

import java.util.List;

import com.liwei.model.Emp;

public interface EmpService {
	
	Emp checkUser(Emp emp);
	
	void addEmp(Emp emp);

	List<Emp> findAllEmp();

	void deleteEmp(String id);

	Emp findEmpById(String id);

	void updateEmp(Emp emp1);
}
