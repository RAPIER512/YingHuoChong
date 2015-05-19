package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javabean.Bx;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.impl.Bxdaoimpl;

public class lianjie extends HttpServlet {
 
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
		Bxdaoimpl bi=new Bxdaoimpl(conn);
		Bx bx=new Bx();
		bx.setClient_id(1);
		out.println(bi.bx_selsect(bx, 1));
		
		
		out.flush();
		out.close();
	}

}
