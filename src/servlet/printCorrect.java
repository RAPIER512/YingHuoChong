package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
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

public class printCorrect extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 doPost(request,response);
	}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset=utf-8");
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
		//String client_id1=(String) request.getSession().getAttribute("client_id");
		//int client_id1=  (Integer) request.getSession().getAttribute("client_id");
		String client_id1 =request.getParameter("client_id");
		BxManageboimpl bmi=new  BxManageboimpl(conn);
		Bx bx=new Bx();
		//bx.setClient_id(Integer.parseInt());
		bx.setClient_id(Integer.parseInt(client_id1));
		ArrayList<Bx> al1=new ArrayList<Bx>();
		al1=bmi.Print_form(bx);
		HttpSession session =request.getSession(true);
		session.setAttribute("al1", al1);
		
		//缺一个客户信息查询方法
		
		Date nowDate = new Date(); // 获取系统时间样式 Wed Apr 08 15:28:12 CST 2009      
	    DateFormat dFormat = DateFormat.getInstance();   
	    String string = dFormat.format(nowDate);				
		session.setAttribute("print_time",string);
		
		response.sendRedirect("../printCorrect.jsp");
		out.flush();
		out.close();
	}

}
