package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

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

public class clientEquipMessage extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 doPost(request, response);
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
		int client_id1=  (Integer) request.getSession().getAttribute("client_id");
		BxManageboimpl bmi=new  BxManageboimpl(conn);
		Bx bx=new Bx();
		//bx.setClient_id(Integer.parseInt(client_id1));
		bx.setClient_id(client_id1);
		ArrayList<Bx> al=new ArrayList<Bx>();
		al=bmi.Query_bx(bx);
		HttpSession session =request.getSession(true);
		session.setAttribute("al", al);
		response.sendRedirect("../clientEquipMessage.jsp");
		out.flush();
		out.close();
		
	}

}
