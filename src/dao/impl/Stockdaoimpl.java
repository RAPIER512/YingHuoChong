package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javabean.Stock;
import dao.IStockdao;

public class Stockdaoimpl implements IStockdao 
{
	Connection conn=null;
	
	public Stockdaoimpl(Connection conn)
	{
		this.conn=conn;
	}
	public Stockdaoimpl( )
	{
		 
	}

	//��ӱ�����¼��Ϣ 
	public int stock_insert(Stock s) 
	{
		PreparedStatement psmt=null;
		int b=0;
		try 
		{
			String sql="insert into t_stock value(?,?,?,?,?,?,?)";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,s.getPart_id());
			psmt.setString(2, s.getPart_name());
			psmt.setString(3, s.getPart_model());
			psmt.setDouble(4,s.getPriece());
			psmt.setInt(5, s.getQuantity());
			psmt.setInt(6, s.getWq());
			psmt.setInt(7, s.getKcstate());
			b=psmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			 
			e.printStackTrace();
		}
		
		return b;
	}

	//a==1 �������еĿ�������
	//a==2 ������ID���ұ�������Ϣ
	//a==3 �����������ֲ��ұ�����Ϣ
	public ArrayList<Stock> stock_select(Stock s, int a) 
	{
		ArrayList<Stock> list=new ArrayList<Stock>();
		PreparedStatement psmt=null;
		ResultSet rs=null;
		if(a==1)
		{			 
			String sql="select * from t_stock";
			try 
			{
				psmt=conn.prepareStatement(sql);
				rs=psmt.executeQuery();				
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		else if(a==2)
		{
			String sql="select * from t_stock where part_id=?";
			try 
			{
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, s.getPart_id());
				rs=psmt.executeQuery();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(a==3)
		{
			String sql="select * from t_stock where part_name=?";
			try
			{
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, s.getPart_name());
				psmt.executeQuery();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try 
		{
			while(rs.next())
			{
				Stock sk=new Stock();
				sk.setPart_id(rs.getString(1));
				sk.setPart_name(rs.getString(2));
				sk.setPart_model(rs.getString(3));
				sk.setPriece(rs.getDouble(4));
				sk.setQuantity(rs.getInt(5));
				sk.setWq(rs.getInt(6));
				sk.setKcstate(rs.getInt(7));
				list.add(sk);
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 
		return list;
	}
	//ɾ��������Ϣ��¼
	@Override
	public int stock_delet(Stock s) 
	{
		int b=0;
		PreparedStatement psmt=null;
		try
		{
			String sql="delete from t_stock where  part_id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,s.getPart_id());
			b=psmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return b;
	}
	//���±�����¼��Ϣ
	@Override
	public int stock_update(Stock s) 
	{
		PreparedStatement psmt=null;
		int b=0;
		String sql="update t_stock set part_id=?,part_name=?,part_model=?,priece=?,quantity=?,wq=?,kcstate=?";
		try
		{
			psmt=conn.prepareStatement(sql);
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
		return 0;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
