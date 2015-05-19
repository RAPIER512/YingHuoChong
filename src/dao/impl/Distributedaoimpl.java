package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javabean.Distribute;
import dao.IDistributedao;

public class Distributedaoimpl implements IDistributedao 
{
	Connection conn=null;
	
	public Distributedaoimpl(Connection conn)
	{
		this.conn=conn;
	}
	
	public Connection getConn() {
		return conn;
	}



	public void setConn(Connection conn) {
		this.conn = conn;
	}

	
	//��ѯ��������б� �Ͳ�ѯ�������״̬
	//a:1������Ա��Ų�ѯ�������
	//	2������ʦ��Ų�ѯ��������¼
	//	3�����ޱ�Ų�ѯ��������¼
	//	4��״̬��ѯ��������¼
	@Override
	public ArrayList<Distribute> Distribute_select(Distribute distribute, int a)
	{
		ArrayList<Distribute> list =new ArrayList<Distribute>();
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		try 
		{
			if(a==1)
			{
				sql="select * from t_distribute where yardman_id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1,distribute.getYardman_id());
				rs=psmt.executeQuery();
			}
			else if(a==2)
			{
				sql="select * from t_distribute where engineer_id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1,distribute.getEngineer_id());
				rs=psmt.executeQuery();	
			}
			else if(a==3)
			{
				sql="select * from t_distribute where repairs_id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1,distribute.getRepairs_id());
				rs=psmt.executeQuery();	
			}
			else if(a==4)
			{
				sql="select * from t_distribute where state=?";
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1,distribute.getState());
				rs=psmt.executeQuery();	
			}
					
			while(rs.next())
			{
				Distribute distribute1=new Distribute();
				distribute1.setDistribute_id(rs.getInt(1));
				distribute1.setYardman_id(rs.getInt(2));
				distribute1.setRepairs_id(rs.getInt(3));
				distribute1.setEngineer_id(rs.getInt(4));
				distribute1.setDistribute_time(rs.getDate(5).toString());
				distribute1.setState(rs.getInt(6));
				list.add(distribute1);
			}			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null)
					rs.close();
				if(psmt!=null)
					psmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return list;
	}
	//������������״̬  ���� a=1
	//���ص�ֵ b:0����sql���û��ִ��  1:����ɹ��޸���״̬    -1:�����޸�״̬ʧ��
	@Override
	public int Distribute_update(Distribute distribute, int a) 
	{		
		PreparedStatement psmt=null;
		int b=0;
		try 
		{
			String sql="update t_distribute set state=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,distribute.getState());
			b=psmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(psmt!=null)
					psmt.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return b;
	}
	//ɾ�� ����������Ϣ��¼
	//���ص�ֵ b:0����sql���û��ִ��  1:����ɹ��޸���״̬    -1:�����޸�״̬ʧ��
	//a: 1 ������Ա���ɾ�� ��������¼��Ϣ  
	//	 2:������ʦ���ɾ�� ��������¼��Ϣ
	//	 3:�����ޱ��ɾ�� ��������¼��Ϣ
	@Override
	public int Distribute_delete(Distribute distribute, int a) 
	{
		PreparedStatement psmt=null;
		int b=0;
		try 
		{
			if(a==1)
			{
				String sql="delete from t_distribute where yardman_id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1,distribute.getYardman_id());
				b=psmt.executeUpdate();
			}
			else if(a==2)
			{
				String sql="delete from t_distribute where engineer_id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1,distribute.getEngineer_id());
				psmt.executeUpdate();
			}
			else if(a==3)
			{
				String sql="delete from t_distribute where repairs_id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1,distribute.getRepairs_id());
				psmt.executeUpdate();
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(psmt!=null)
					psmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return b;
	}
	//������������¼��Ϣ
	@Override
	public int Distribute_insert(Distribute distribute, int a) 
	{
		PreparedStatement psmt=null;
		int b=0;
		try 
		{
			String sql="insert into t_distribute(yardman_id,repares_id,engineer_id,distribute_time,state) values(?,?,?,to_date(?,'YYYY-MM-DD HH24:MI:SS'),?)";
			psmt=conn.prepareStatement(sql);	 
			psmt.setInt(1,distribute.getYardman_id());
			psmt.setInt(2,distribute.getRepairs_id());
			psmt.setInt(3,distribute.getEngineer_id());
			psmt.setString(4, distribute.getDistribute_time()); 
			psmt.setInt(5, distribute.getState());			 		
			b=psmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(psmt!=null)
					psmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return b;
	}	
}
