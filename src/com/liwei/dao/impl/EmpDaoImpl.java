package com.liwei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liwei.dao.EmpDao;
import com.liwei.db.DbConn;
import com.liwei.model.Emp;

public class EmpDaoImpl implements EmpDao{

    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;
    DbConn db= DbConn.getInstance();
	
	@Override
	public Emp getEmpByEname(String ename) throws SQLException {
		conn = db.getConn();
		Emp emp = null;
		String sql = "select empno,ename,password,job from emp t where t.ename = ?";
		pst = conn.prepareStatement(sql);
		pst.setString(1, ename);
		System.out.print(sql);
		rs = pst.executeQuery();     
		while(rs.next()){
			emp = new Emp();
			emp.setId(rs.getInt("empno"));
			emp.setEname(rs.getString("ename"));
			emp.setPassword(rs.getString("password"));
			emp.setJob(rs.getString("job"));
		}
		return emp;
	}

	@Override
	public void addEmp(Emp emp) throws SQLException {
		conn = db.getConn();
		String sql = "insert into emp (empno,ename,password)"+
				" values (empno_seq.nextval,?,?)";
		pst = conn.prepareStatement(sql);
		System.out.println(sql);
		pst.setString(1, emp.getEname());
		pst.setString(2, emp.getPassword());
		pst.executeUpdate();
	}

	@Override
	public List<Emp> findAllEmp() throws SQLException {
		conn = db.getConn();
		String sql = "select empno,ename,password,job from emp";
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();  
		List<Emp> emps = new ArrayList<Emp>();
		Emp emp = null;
		while(rs.next()){
			emp = new Emp();
			emp.setId(rs.getInt("empno"));
			emp.setEname(rs.getString("ename"));
			emp.setPassword(rs.getString("password"));
			emp.setJob(rs.getString("job"));
			emps.add(emp);
		}
		return emps;
	}

	@Override
	public void deleteEmp(String id) throws SQLException {
		conn = db.getConn();
		String sql = "delete from emp t where t.empno = ?";
		pst = conn.prepareStatement(sql);
		pst.setInt(1, Integer.parseInt(id));
		rs = pst.executeQuery();  
	}

	@Override
	public Emp findEmpById(String id) throws SQLException {
		conn = db.getConn();
		Emp emp = null;
		String sql = "select empno,ename,password,job from emp t where t.empno = ?";
		pst = conn.prepareStatement(sql);
		pst.setString(1, id);
		System.out.print(sql);
		rs = pst.executeQuery();     
		while(rs.next()){
			emp = new Emp();
			emp.setId(rs.getInt("empno"));
			emp.setEname(rs.getString("ename"));
			emp.setPassword(rs.getString("password"));
			emp.setJob(rs.getString("job"));
		}
		return emp;
	}

	@Override
	public void updateEmp(Emp emp1) throws SQLException {
		conn = db.getConn();
		String sql = "update emp t set t.ename = ?,t.password = ? where t.empno = ?";
		pst = conn.prepareStatement(sql);
		pst.setString(1, emp1.getEname());
		pst.setString(2, emp1.getPassword());
		pst.setInt(3, emp1.getId());
		rs = pst.executeQuery();  
	}


}
