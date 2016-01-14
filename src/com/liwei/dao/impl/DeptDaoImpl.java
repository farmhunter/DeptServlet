package com.liwei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liwei.dao.DeptDao;
import com.liwei.db.DbConn;
import com.liwei.model.Dept;

public class DeptDaoImpl implements DeptDao {

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	DbConn db = DbConn.getInstance();

	@Override
	public void initDept(Dept dept) throws SQLException {
		conn = db.getConn();
		String sql = "insert into dept (deptno,dname,loc)"
				+ " values (deptno_seq.nextval,?,?)";
		pst = conn.prepareStatement(sql);
		System.out.println(sql);

		pst.setString(1, dept.getDname());
		pst.setString(2, dept.getDescription());
		pst.executeUpdate();
	}

	@Override
	public Dept getdeptByDeptno(String deptno) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> findAllDept() throws SQLException {
		conn = db.getConn();
		String sql = "select deptno,dname,loc from dept";
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		List<Dept> depts = new ArrayList<Dept>();
		Dept dept = null;
		while (rs.next()) {
			dept = new Dept();
			dept.setDeptno(rs.getInt("deptno"));
			dept.setDname(rs.getString("dname"));
			dept.setDescription(rs.getString("loc"));

			depts.add(dept);
		}
		return depts;
	}

	@Override
	public void deleteDept(String id) throws SQLException {
		conn = db.getConn();
		String sql = "delete from dept t where t.deptno = ?";
		pst = conn.prepareStatement(sql);
		pst.setInt(1, Integer.parseInt(id));
		rs = pst.executeQuery();

	}

	@Override
	public Dept findDeptById(String id) throws SQLException {
		conn = db.getConn();
		Dept dept = null;
		String sql = "select deptno,dname,loc from dept t where t.deptno = ?";
		pst = conn.prepareStatement(sql);
		pst.setString(1, id);
		System.out.print(sql);
		rs = pst.executeQuery();
		while (rs.next()) {
			dept = new Dept();
			dept.setDeptno(rs.getInt("deptno"));
			dept.setDname(rs.getString("dname"));
			dept.setDescription(rs.getString("loc"));

		}
		return dept;
	}

	@Override
	public void updateDept(Dept dept1) throws SQLException {
		conn = db.getConn();
		String sql = "update dept t set t.dname = ?,t.loc = ? where t.deptno = ?";
		pst = conn.prepareStatement(sql);
		pst.setString(1, dept1.getDname());
		pst.setString(2, dept1.getDescription());
		pst.setInt(3, dept1.getDeptno());
		rs = pst.executeQuery();
	}

	@Override
	public List<Dept> initDept1() throws SQLException {
		conn = db.getConn();
		String sql = "select * from emp e left join dept d  on e.deptno=d.deptno order by d.deptno";
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		List<Dept> depts = new ArrayList<Dept>();
		Dept dept = null;
		while (rs.next()) {
			dept = new Dept();
			dept.setId(rs.getInt("empno"));
			dept.setEname(rs.getString("ename"));
			dept.setPassword(rs.getString("password"));
			dept.setJob(rs.getString("job"));
			dept.setComm(rs.getInt("comm"));
			dept.setSal(rs.getInt("sal"));
			dept.setMgr(rs.getInt("mgr"));
			dept.setHiredate(rs.getString("hiredate"));
			dept.setDeptno(rs.getInt("deptno"));
			dept.setDname(rs.getString("dname"));
			dept.setDescription(rs.getString("loc"));
			depts.add(dept);
		}
		return depts;
	}

}
