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
    
    <title>My JSP 'clientEquipMessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	  
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	  
	
	<script type="text/javascript">
		function disableOcx()
            {
            	
                var form = document.forms[0];
                for (var i = 0; i < form.length; ++i) 
                {
                    var element = form.elements[i];
                    if (element.name) 
                    {
                        if (element.nodeName == "INPUT") 
                        {
                              if(element.type != 'button')
                              {
                                  element.disabled="true";
                                element.readOnly = true;
                              }
                        }
                        else if (element.nodeName == "SELECT") 
                        {
                              element.disabled = true;
                        }
                        else if (element.nodeName == "TEXTAREA")
                        {
                              element.disabled = true;
                        }                                                                                                     
                    }
                }
                 
                  
            }
             
	
		 
		function print(x)
		{
			window.location.href="servlet/printCorrect?client_id="+x;
		}
		function sbmit(a,b)
		{
			window.location.href="servlet/submitCorrect?repairs_id="+a+"&client_id="+b;
		}
		
		function correct(x)
		{
			document.getElementById(x).submit();
		}
		
		function rechange()
		{
			var form = document.forms[0];
            for (var i = 0; i < form.length; ++i) 
            {
                var element = form.elements[i];
                if (element.name) 
                {
                    if (element.nodeName == "INPUT") 
                    {  
                        element.disabled=false;
                        element.readOnly = false; 
                    }
                    else if (element.nodeName == "SELECT") 
                    {
                        element.disabled = false;
                    }
                    else if (element.nodeName == "TEXTAREA")
                    {
                        element.disabled = false;
                    }                                                                                                     
                }
            }
        }
		
		
		function recall()
		{
			window.location.href="";
		}
		window.onload=disableOcx;
	</script>

  </head>
  
  <body>
  	<div class="heading"></div>
  	<div class="container">
  		<div class="left">
  		 	   		 		  		
  		</div>
  		<div class="main"> 
	  	  <c:forEach items="${al}" var="bx">
	      <form action="servlet/changeCEM" id="${bx.repairs_id}">
	      <table border="2px">     
	      <tr><td>报修记录编号</td><td><input type="text" name="repairs_id" value="${bx.repairs_id}"></td><td>客户ID</td><td><input type="text" name="client_id" value="${bx.client_id}"></td></tr>
	      <tr><td>维修编号</td><td><input type="text" name="fix_id" value="${bx.fix_id}"></td><td>设备编号</td><td><input type="text" name="machine_id" value="${bx.machine_id}"></td></tr>
	      <tr><td>报修时间</td><td><input type="date" name="fix_time" value="${bx.fix_time}"></td><td>预估价格</td><td><input type="text"name="preprice" value="${bx.preprice}"></td></tr>
	      <tr><td>预估完成时间</td><td><input type="date" name="prefixed_date" value="${bx.prefixed_date}"></td><td>产品类型</td><td><input name="product_type" value="${bx.product_type}"></td></tr>
	      <tr><td>报修状态</td>
	      	  <td>
	      	  	  <select name="fix_state">
	      	  	  <c:if test="${bx.fix_state ==0}">
	      	  	  <option value="0" selected="selected" >未分配</option>
	      	  	  <option value="1">进行中</option>
	      	  	  <option value="2">结束</option>
	      	  	  <option value="3" >撤销</option>
	      	  	  </c:if>
	      	  	  <c:if test="${bx.fix_state ==1}">
	      	  	  <option value="0">未分配</option>
	      	  	  <option value="1"selected="selected">进行中</option>
	      	  	  <option value="2">结束</option>
	      	  	  <option value="3" >撤销</option>
	      	  	  </c:if>
	      	  	  <c:if test="${bx.fix_state ==2}">
	      	  	  <option value="0">未分配</option>
	      	  	  <option value="1">进行中</option>
	      	  	  <option value="2"selected="selected">结束</option>
	      	  	  <option value="3" >撤销</option>
	      	  	  </c:if>
	      	  	  <c:if test="${bx.fix_state ==3}">
	      	  	  <option value="0">未分配</option>
	      	  	  <option value="1">进行中</option>
	      	  	  <option value="2">结束</option>
	      	  	  <option value="3" selected="selected">撤销</option>
	      	  	  </c:if>
	      	  	  </select>
	      	  </td>
	      	  <td colspan="2">
	      	  	  <input type="button" value="撤销" name="cx" onclick="recall()">
	      	  </td>
	      </tr>
	      <tr><td>机器品牌</td><td><input type="text" name="machine_board" value="${bx.machine_board}"></td><td>机器型号</td><td><input type="text" name="machine_typeNub" value="${bx.machine_typeNub}"></td></tr>
	      <tr><td>系列号</td><td><input type="text" name="serial_number" value="${bx.serial_number}"></td><td>开机口令</td><td><input type="text" name="start_command" value="${bx.start_command}"></td></tr>
	      <tr><td colspan="4" align="center">缺少零件</td></tr>
	      <tr><td colspan="4"><textarea rows="3" cols="50" name="lack_part">${bx.lack_part}</textarea></td></tr>
	      <tr><td colspan="4" align="center">机器故障及现象</td></tr>
	      <tr><td colspan="4"><textarea rows="3" cols="50" name="stop_pho">${bx.stop_pho}</textarea></td></tr>
	      <tr><td colspan="4" align="center">故障类型</td></tr>
	      <tr><td colspan="4"><textarea rows="3" cols="50" name="stop_type">${bx.stop_type}</textarea></td></tr>
	      <tr><td colspan="4" align="center">机器外观检查</td></tr>
	      <tr><td colspan="4"><textarea rows="3" cols="50" name="appearance_check">${bx.appearance_check}</textarea></td></tr>
	      <tr><td colspan="4" align="center">重要资料</td></tr>
	      <tr><td colspan="4"><textarea rows="3" cols="50" name="import_data">${bx.import_data}</textarea></td></tr>
	      <tr><td>HDD</td><td><input type="text" name="hdd" value="${bx.hdd}"></td><td>RAM</td><td><input type="text" name="ram" value="${bx.ram}"></td></tr>
	      <tr><td>外置pc卡</td><td><input type="text" name="pc_card" value="${bx.pc_card}"></td><td>AC适配器</td><td><input type="text" name="ac_adapter" value="${bx.ac_adapter}"></td></tr>
	      <tr><td>电池</td><td><input type="text" name="battery" value="${bx.battery}"></td><td>外接光驱</td><td><input type="text" name="cd_rom" value="${bx.cd_rom}"></td></tr>
	      <tr><td colspan="4" align="center">其他</td></tr>
	      <tr><td colspan="4"><textarea rows="3" cols="50" name="others">${bx.ohters}</textarea></td></tr>
	      <tr><td><input type="button" value="修改" name="xg" onclick="rechange(${bx.repairs_id})"></td>
      	  <td><input type="button" value="确定" name="qd" onclick="correct(${bx.repairs_id})" disabled="disabled"></td>
      	  <td><input type="button" value="打印客户确认单" name="dy" onclick="print(${bx.client_id})"></td>
      	  <td><input type="button" value="提交客户确认单" name="tj" onclick="sbmit(${bx.repairs_id},${bx.client_id})"></td>
      	  </tr>      
     	  </table>
     	  </form>
          <hr>
     	  </c:forEach>
     </div>
     <div class="right"></div>
     </div>
     <div class="footing"></div>
  </body>
</html>
