<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>所有部门信息</title>
</head>
<body>
	<center>
		<h1>所有部门信息:</h1>
		<table align="center" bgcolor="#008800" border="0" cellspacing="2"
			cellpadding="5">
			<tr bgcolor="#cccccc">
				<td>序号</td>
				<td>部门名称</td>
				<td>部门描述</td>
				<td>操作</td>
			</tr>

			<c:forEach items="${deptList}" var="dept">
				<tr bgcolor="#FFFF88">
					<td>${dept.deptno}</td>
					<td>${dept.dname}</td>
					<td>${dept.description}</td>
					<td><a href="DeptServlet?method=update&deptno=${dept.deptno}">修改</a></td>
					<td><a href="DeptServlet?method=delete&deptno=${dept.deptno}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>
