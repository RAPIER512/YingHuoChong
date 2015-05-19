package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javabean.Stock;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import bo.IStockManagebo;
import bo.impl.StockManageboimpl;

public class stockview extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 doPost(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
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
		ArrayList<Stock> list=new ArrayList<Stock>();
		IStockManagebo StockMangageboimpl =new StockManageboimpl(conn);
		try
		{
			list=StockMangageboimpl.Selectpartmessage(null);
		}
		catch(NullPointerException e)
		{
			list=null;
		}
		HttpSession session=request.getSession();
		
		session.setAttribute("list", list);
		
		response.sendRedirect("../stockRecord.jsp");
		
		out.flush();
		out.close();
	}

}
