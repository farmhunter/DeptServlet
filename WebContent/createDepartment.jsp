<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>增加部门</title>

</head>
<body bgcolor="#ffffff">
	<center>
		<h1>增加部门：</h1>
	</center>
	<form action="DeptServlet?method=saveDept" method="Post" name="myform">
		<table align="center" bgcolor="#008800" border="0" cellspacing="2"
			cellpadding="5">
			<input type="text" hidden="hidden" name="id" size="20" id="id" value=${dept.deptno}></input>
			<tr bgcolor="#FFFF88">
				<td>部门名称</td>
				<td><input type="text" name="dname" size="20" id="dname" value=${dept.dname}>
				</td>
			</tr>

			<tr bgcolor="#FFFF88">
				<td>部门描述</td>
				<td><input type="text" name="description" size="20" value=${dept.description}
					></td>
			</tr>
			<tr bgcolor="#FFFF88">
				<td>部门领导</td>

				<td><select name="leader">

						<option value="0">----请选择领导----</option>

						<c:forEach items="${empList}" var="emp">
							<option value="${emp.empno}">${emp.ename}</option>
						</c:forEach>

				</select></td>
			</tr>

			<tr bgcolor="#FFFF88">
				<td colspan="2" align="center"><input type="submit" value="保存">
				</td>
			</tr>
		</table>

	</form>
</body>
</html>
