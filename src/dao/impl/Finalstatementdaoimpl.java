package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javabean.Finalstatement;
import dao.IFianlstatementdao;

public class Finalstatementdaoimpl implements IFianlstatementdao 
{
	Connection conn=null;
	//查询结算记录信息
	/**
	 * a==1 查询记录表的所有的结算单记录
	 * a==2按维修单号查询结算单记录
	 */
	@Override
	public ArrayList<Finalstatement> finalstatement_select(Finalstatement finalstatement,int a)
	{
		PreparedStatement psmt=null;
		ResultSet rs=null;
		ArrayList<Finalstatement> list=new ArrayList<Finalstatement>();
		if(a==1)
		{
			
			try 
			{
				String sql="selecet * from t_finalstatement";
				psmt=conn.prepareStatement(sql);
				rs=psmt.executeQuery();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}	
		}
		if(a==2)
		{
			try
			{
				String sql="select * from t_finalstatement where fix_id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1,finalstatement.getFix_id());
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
				Finalstatement fs=new Finalstatement();
				fs.setFinalprice_id(rs.getInt(1));
				fs.setFix_id(rs.getInt(2));
				fs.setClient_id(rs.getInt(3));
				fs.setPrefixed_date(rs.getString(4));
				fs.setFixed_date(rs.getString(5));
				fs.setProduct_type(rs.getString(6));
				fs.setMachine_board(rs.getString(7));
				fs.setMachine_typeNub(rs.getString(8));
				fs.setSerial_number(rs.getString(9));
				fs.setUnitName(rs.getString(10));
				list.add(fs);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return list;	
	}
	
	@Override
	public int finalstatenet_update(Finalstatement finalstatement) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 插入结算单记录
	 * b=1 操作成功
	 * b<0 操作失败
	 */
	@Override
	public int fianlstatement_insert(Finalstatement finalstatement) 
	{
		PreparedStatement psmt=null;
		int b=0;
		
		try 
		{
			String sql="insert into t_finalstatement values(null,?,?,to_date(?,'YYYY-MM-DD HH24:MI:SS'),to_date(?,'YYYY-MM-DD HH24:MI:SS'),?,?,?,?,?)";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,finalstatement.getFix_id());
			psmt.setInt(2, finalstatement.getClient_id());
			psmt.setString(3,finalstatement.getPrefixed_date());
			psmt.setString(4,finalstatement.getFixed_date());
			psmt.setString(5, finalstatement.getProduct_type());
			psmt.setString(6,finalstatement.getMachine_board());
			psmt.setString(7,finalstatement.getMachine_typeNub());
			psmt.setString(8, finalstatement.getSerial_number());
			psmt.setString(9, finalstatement.getUnitName());
			b=psmt.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public int finalstatement_delete(Finalstatement finalstatement) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
