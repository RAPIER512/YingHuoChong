<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'stockRecord.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  <table border="5px">
  	 <tr><th>备件编号</th><th>备件名称</th><th>型号</th><th>单价</th><th>数量</th><th>警戒数量</th><th>库存状态</th><td></td></tr>
     <c:forEach items="${list}" var="part">
     <form action="">
     <tr><td>${part.part_id}</td><td>${part.part_name}</td><td>${part.part_model}</td><td>${part.priece}</td><td>${part.quantity}</td><td>${part.wq}</td><td>${part.kcstate}</td><td><input type="button" value="编辑"><input type="submit" value="确认"></td></tr>
     </form>
     </c:forEach>
  </table>
  </body>
</html>
