package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javabean.Partdirect;
import dao.IPartdirectdao;

public class Partdirectdaoimpl implements IPartdirectdao 
{
	Connection conn=null;
	
	public Connection getConn() 
	{
		return conn;
	}
	public void setConn(Connection conn) 
	{
		this.conn = conn;
	}
	
	public Partdirectdaoimpl()
	{
		
	}
	public Partdirectdaoimpl(Connection conn)
	{
		this.conn=conn;
	}
	
	//添加备件流水记录
	@Override
	public int partdirect_insert(Partdirect p) 
	{
		PreparedStatement psmt=null;
		int b=0;
		try 
		{
			String sql="insert into t_partdirect values(null,?,?,?,?,?)";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,p.getFix_id());
			psmt.setString(2, p.getPart_name());
			psmt.setString( 3, p.getPart_model());
			psmt.setInt(4,p.getQuantity());
			psmt.setString(5, p.getPart_id());
			b=psmt.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return b;
	}
	//查找备件流水记录
	/**
	 * 1 查找所有的备件流水记录
	 * 2按维修编号查找备件流水记录
	 * 2按备件名字查找备件的总共用了多少
	 */
	@Override
	public ArrayList<Partdirect> partdirect_selsect(Partdirect p, int a)
	{
		ArrayList<Partdirect> list=new ArrayList<Partdirect>();
		PreparedStatement psmt=null;
		ResultSet rs=null;
		if(a==1)
		{
			try 
			{
				String sql="select * from t_partdirect";
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
			try 
			{
				String sql="select * from t_partdirect where fix_id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1,p.getFix_id());
				rs=psmt.executeQuery();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		else if(a==3)
		{
			try 
			{
				String sql="select sun(quatity) from t_partdirect where part_name=?";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1,p.getPart_name());
				rs=psmt.executeQuery();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		try 
		{
			while(rs.next())
			{
				Partdirect part=new Partdirect();
				part.setPartdirect_id(rs.getInt(1));
				part.setFix_id(rs.getInt(2));
				part.setPart_name(rs.getString(3));
				part.setPart_model(rs.getString(4));
				part.setQuantity(rs.getInt(5));
				part.setPart_id(rs.getString(6));
				list.add(part);					
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		 
		return list;
	}
	//删除备件流水记录
	@Override
	public int prtdirect_delete(Partdirect p)
	{
		PreparedStatement psmt=null;
		int b=0;
		try 
		{
			String sql="delete from t_partdirect where fix_id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,p.getFix_id());
			b=psmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return b;
	}
	//更新备件流水记录
	@Override
	public int prtdirect_update(Partdirect p) 
	{
		PreparedStatement psmt=null;
		int b=0;
		
		try 
		{
			String sql="update t_partdirecr set part_name=?,part_model=?,quantity=?,part_id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, p.getPart_name());
			psmt.setString(2,p.getPart_model());
			psmt.setInt(3,p.getQuantity());
			psmt.setString(4, p.getPart_id());
			b=psmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return b;
	}
	

}
