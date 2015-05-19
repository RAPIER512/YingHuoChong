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
    
    <title>My JSP 'printCorrect.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 
	<link rel="stylesheet" type="text/css" href="css/table.css">
 

  </head>
  
  <body>
     <div>
     	<c:forEach items="${al1}" var="bx">
     	<table border="2px">
     	<tr>
     		<td colspan="4" align="center">***沈阳市计算机服务有限公司取机凭证***</td>
     	</tr>
     	<tr><td>接修日期</td>
     		<td>${bx.fix_time}</td>
     		<td>维修编号</td>
     		<td>${bx.fix_id}</td>
     	</tr>
     	<tr>
     		<td>产品类型</td>
     		<td>${bx.product_type}</td>
     		<td>机器品牌</td>
     		<td>${bx.machine_board}</td>
     	</tr>
     	<tr>
     		<td>机器型号</td>
     		<td>${bx.machine_typeNub}</td>
     		<td>系类号</td>
     		<td>${bx.serial_number}</td>
     	</tr>
     	<tr>
     		<td>单位名称</td>
     		<td>${client.unitName}</td>
     		<td>联系人</td>
     		<td>&{client.Linkman}</td>
     	</tr>
     	<tr>
     		<td colspan="4" align="center">机器故障现象</td>
     	</tr>
     	<tr>
     		<td colspan="4">${bx.stop_pho}</td>
     	</tr>
     	<tr>
     		<td colspan="2">缺少零件</td>
     		<td colspan="2">随机附件</td>
     	</tr>
     	<tr>
     		<td colspan="2">${bx.lack_part}</td>
     		<td colspan="2">${bx.hdd}&nbsp;${bx.ram}&nbsp;${bx.pc_card}&nbsp;${bx.ac_adapter}&nbsp;${bx.battery}&nbsp;${bx.cd_rom}</td>
     	</tr>
     	<tr>
     		<td>接机签字:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
     		<td>机主签字:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
     		<td colspan="2">打印时间:${print_time}</td>
     	</tr> 
     	</table>
     	</c:forEach>   
     </div>
  </body>
</html>
