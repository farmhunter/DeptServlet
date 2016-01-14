<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>查看所有的部门</title>
</head>
<body>
	<center>
		<h1>以下是系统的所有部门：</h1>

		<table align="center" bgcolor="#008800" border="0" cellspacing="2"
			cellpadding="5">
			<tr bgcolor="#cccccc">
				<td><b>序号</b></td>
				<td><b>雇员姓名</b></td>
				<td><b>工作</b></td>
				<td><b>上级员工编号</b></td>
				<td><b>入职日期 </b></td>
				<td><b>薪水 </b></td>
				<td><b>奖金</b></td>
				<td><b>部门编号</b></td>
				<td><b>部门名称 </b></td>
				<td><b>部门所在地</b></td>
			</tr>

			<c:forEach items="${deptList}" var="dept">
				<tr bgcolor="#FFFF88">
					<td>${dept.id}</td>
					<td>${dept.ename}</td>
					<td>${dept.job}</td>
					<td>${dept.mgr}</td>
					<td>${dept.hiredate}</td>
					<td>${dept.sal}</td>
					<td>${dept.comm}</td>
					<td>${dept.deptno}</td>
					<td>${dept.dname}</td>
					<td>${dept.description}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>
