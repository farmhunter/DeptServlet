package com.liwei.service;

import java.util.List;

import com.liwei.model.Dept;


public interface DeptService {
	void initDept(Dept dept);
	
	List<Dept> findAllDept();
	
	void deleteDept(String id);
	
	Dept findDeptById(String id);

	void updateDept(Dept dept1);

	List<Dept> initDept1();

}
