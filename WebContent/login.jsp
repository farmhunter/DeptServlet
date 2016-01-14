<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<base href="<%=basePath%>">
<link rel="stylesheet" href="assets/css/reset.css">
<link rel="stylesheet" href="assets/css/supersized.css">
<link rel="stylesheet" href="assets/css/style.css">
</head>

<body>
	<center>
		<font color="red">${error}</font>
	</center>
	<form action="LoginServlet" method="post">
		<table align="center" border="1" bgcolor="#FFFF88">
			<tr>
				<td>username：</td>
				<td><input type="text" name="username" value=""></td>
			</tr>
			<tr>
				<td>password：</td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="登陆">
				<input type="reset" id="but" value="重置"></td>
			</tr>
		</table>
	</form>



</body>
</html>
