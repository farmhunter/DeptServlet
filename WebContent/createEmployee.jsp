<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>增加雇员</title>
</head>
<body bgcolor="#ffffff">
	<center>
		<h1>增加雇员：</h1>
		<br /> ${error}
		<form method="POST" action="EmpServlet?method=saveEmp" name="myform">
			<table align="center" bgcolor="#008800" border="0" cellspacing="2"
				cellpadding="5">
				<input type="text" hidden="hidden" name="id" size="20" id="id"
					value=${emp.id}></input>
				<tr bgcolor="#FFFF88">
					<td>用户名:</td>
					<td><input type="text" name="username" size="20" id="username"
						value=${emp.ename}></td>
				</tr>
				<tr bgcolor="#FFFF88">
					<td>密码</td>
					<td><input type="text" name="password" size="20" id="password"
						value=${emp.password}><br> <span id="ageId"></span></td>
				</tr>
				<tr bgcolor="#FFFF88">
					<td>部门:</td>
					<td><select name="organization_id" id="deptno">
							<option value="0">----请选择部门----</option>
							<c:forEach items="${deptList}" var="dept">
								<option value="${dept.deptno}">${dept.dname}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr bgcolor="#FFFF88">
					<td colspan="2" align="center"><input type="submit" value="保存">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
