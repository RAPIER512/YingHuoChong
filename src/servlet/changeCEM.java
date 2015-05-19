package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javabean.Bx;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import bo.impl.BxManageboimpl;

public class changeCEM extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 doPost(request,response);
	}

 
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
		//日期处理
		//String pattern = "yyy-MM-dd HH:mm:ss"; //首先定义时间格式
		String pattern = "yyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(pattern);//然后创建一个日期格式化类
        String fix_time = request.getParameter("fix_time");
        String prefixed_date= request.getParameter("prefixed_date");
        Date convertResult1 = null;
        Date convertResult2 = null;
        try 
        {
            convertResult1 = format.parse(fix_time);
            convertResult2 = format.parse(prefixed_date);
        } 
        catch (ParseException e) 
        {
            e.printStackTrace();
        }
		//
		
		
		
		
		BxManageboimpl bmi=new  BxManageboimpl(conn);
		Bx bx=new Bx();
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
		
		
		//System.out.println(request.getParameter("fix_state"));
		//System.out.println(request.getParameter("lack_part"));
		int b=bmi.Change_bx(bx);
		HttpSession session=request.getSession();
		session.setAttribute("pd", b);
		
		response.sendRedirect("../servlet/clientEquipMessage");
		out.flush();
		out.close();
	}

}
