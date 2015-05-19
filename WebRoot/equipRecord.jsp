<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'equipRecord.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function tj()
	{
		var form=document.getElementById("form");
		form.submit();
	}
	
	</script>
  </head>
  
  <body>
     <form action="servlet/regist_bx" id="form" method="post">
     	<table border="2px">
	      <tr><td>设备编号</td><td><input type="text" name="machine_id" ></td><td>报修时间</td><td><input type="date" name="fix_time"></td></tr>
	      <tr><td>预估价格</td><td><input type="text"name="preprice" ></td><td>预估完成时间</td><td><input type="date" name="prefixed_date"></td></tr>
	      <tr><td>产品类型</td><td><input name="product_type" ></td><td>报修状态</td>
	      	  <td>
	      	  	  <select name="fix_state">
	      	  	  <option value="0">未分配</option>
	      	  	  <option value="1">进行中</option>
	      	  	  <option value="2">结束</option>
	      	  	  <option value="3" >撤销</option>   
	      	  	  </select>
	      	  </td>
	      </tr>
	      <tr><td>机器品牌</td><td><input type="text" name="machine_board" ></td><td>机器型号</td><td><input type="text" name="machine_typeNub"></td></tr>
	      <tr><td>系列号</td><td><input type="text" name="serial_number" ></td><td>开机口令</td><td><input type="text" name="start_command"></td></tr>
	      <tr><td colspan="4" align="center">缺少零件</td></tr>
	      <tr><td colspan="4"><textarea rows="3" cols="50" name="lack_part"></textarea></td></tr>
	      <tr><td colspan="4" align="center">机器故障及现象</td></tr>
	      <tr><td colspan="4"><textarea rows="3" cols="50" name="stop_pho"></textarea></td></tr>
	      <tr><td colspan="4" align="center">故障类型</td></tr>
	      <tr><td colspan="4"><textarea rows="3" cols="50" name="stop_type"></textarea></td></tr>
	      <tr><td colspan="4" align="center">机器外观检查</td></tr>
	      <tr><td colspan="4"><textarea rows="3" cols="50" name="appearance_check"></textarea></td></tr>
	      <tr><td colspan="4" align="center">重要资料</td></tr>
	      <tr><td colspan="4"><textarea rows="3" cols="50" name="import_data"></textarea></td></tr>
	      <tr><td>HDD</td><td><input type="text" name="hdd" ></td><td>RAM</td><td><input type="text" name="ram" ></td></tr>
	      <tr><td>外置pc卡</td><td><input type="text" name="pc_card" ></td><td>AC适配器</td><td><input type="text" name="ac_adapter" ></td></tr>
	      <tr><td>电池</td><td><input type="text" name="battery" ></td><td>外接光驱</td><td><input type="text" name="cd_rom"></td></tr>
	      <tr><td colspan="4" align="center">其他</td></tr>
	      <tr><td colspan="4"><textarea rows="3" cols="50" name="others"></textarea></td></tr>
	      <tr>
	      		<td colspan="2">
	      			<input type="button" value="提交" name="tj" onclick="tj()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	      			<input type="reset" value="重置">
	      		</td>
	      		<td colspan="2"><input type="button" value="取消返回" onclick=""></td>
      	  </tr>      
     	  </table>
     
     </form>
  </body>
</html>
