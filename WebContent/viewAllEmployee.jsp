<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>所有雇员信息</title>
</head>
<body>
	<center>
		<h1>所有雇员信息：</h1>
		<table align="center" bgcolor="#008800" border="0" cellspacing="2"
			cellpadding="5">
			<tr bgcolor="#cccccc">
				<td>id</td>
				<td>ename</td>
				<td>password</td>
				<td>job</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${empList}" var="emp">
				<tr bgcolor=#FFFF88>
					<td>${emp.id}</td>
					<td>${emp.ename}</td>
					<td>${emp.password }</td>
					<td>${emp.job }</td>
					<td>
					<a href="EmpServlet?method=update&empno=${emp.id}">修改</a>
					<a href="EmpServlet?method=delete&empno=${emp.id}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>
