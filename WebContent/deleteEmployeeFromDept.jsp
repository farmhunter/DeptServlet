<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>ѡ��Ҫɾ����Ա��</title>
</head>
<body>
<center>
<h1>�ڲ�����ѡ��Ҫɾ���Ĺ�Ա��</h1>

	   <form action="" method="get">
  <table align="center" bgcolor="#008800" border="0" cellspacing="2" cellpadding="5">
         <tr bgcolor="#cccccc">
         <td><b>ID</b></td>
         <td><b>���� </b></td>
          <td>ɾ��</td>
         </tr>
       <c:forEach items="${empList}" var="emp">
	  <tr bgcolor="#FFFF88">
	     <td>
         ${emp.empno}
         </td>
         <td>
         ${emp.ename}
         </td>
          <td><a href="EmpServlet?method=updateDeptnoDelete&empno=${emp.empno}&deptno=${deptno}">ɾ��</a></td>
        </tr>
        </c:forEach>
     </table>
         </form>
</center>
</body>
</html>
