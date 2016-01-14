<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>将雇员添加到部门</title>
</head>
<body>
<center>
    <h1>在部门${deptno}中选择要添加的雇员：</h1>
 
         <form action="" method="Post">
    <table align="center" bgcolor="#008800" border="0" cellspacing="2" cellpadding="5">
         <tr bgcolor="#cccccc">
        <td>ID</td><td>姓名</td><td>添加</td>
      </tr>
          <c:forEach items="${empList}" var="emp">
	     <tr bgcolor="#FFFF88">
	          <td>
               ${emp.empno}
              </td>
              <td>
               ${emp.ename}
              </td>

              <td><a href="EmpServlet?method=updateDeptnoAdd&empno=${emp.empno}&deptno=${deptno}">确定</a></td>
          </tr>
          </c:forEach>
     </table>
         </form>
  </center>
  </body>
</html>
