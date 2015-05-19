package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javabean.Bx;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bo.impl.BxManageboimpl;

public class regist_bx extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 doPost(request,response);
	}

 
	@SuppressWarnings("deprecation")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Context context=null;
		Connection conn =null;
		try 
		{
			context = new InitialContext();
			DataSource ds;
			ds = (DataSource) context.lookup("java:comp/env/jdbc/ums");
			conn = ds.getConnection();			
		} 
		catch (NamingException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BxManageboimpl bmi=new  BxManageboimpl(conn);
		Bx bx=new Bx();
		bx.setClient_id(Integer.parseInt(request.getParameter("client_id")));
		bx.setMachine_id(request.getParameter("machine_id"));
		bx.setFix_time(request.getParameter("fix_time"));
		bx.setPreprice(Double.parseDouble(request.getParameter("preprice")));
		bx.setPrefixed_date(request.getParameter("prefixed_date"));
		bx.setFix_state(Integer.parseInt(request.getParameter("fix_state")));
		bx.setProduct_type(request.getParameter("product_type"));
		bx.setMachine_board(request.getParameter("machine_board"));
		bx.setMachine_typeNub(request.getParameter("machine_typeNub"));
		bx.setSerial_number(request.getParameter("serial_number"));
		bx.setLack_part(request.getParameter("lack_part"));
		bx.setStop_pho(request.getParameter("stop_pho"));
		bx.setStop_type(request.getParameter("stop_type"));
		bx.setAppearance_check(request.getParameter("appearance_check"));
		bx.setStart_command(request.getParameter("start_command"));
		bx.setImport_data(request.getParameter("import_data"));
		bx.setHdd(request.getParameter("hdd"));
		bx.setRam(request.getParameter("ram"));
		bx.setPc_card(request.getParameter("pc_card"));
		bx.setAc_adapter(request.getParameter("ac_adapter"));
		bx.setBattery(request.getParameter("battery"));
		bx.setCd_rom(request.getParameter("cd_rom"));
		bx.setOhters(request.getParameter("others"));
		
		int b=bmi.Register_bx(bx);
		
		response.sendRedirect("../equipRecord.jsp?b="+b);
		out.flush();
		out.close();
	}

}
