


package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javabean.Bx;
import dao.IBxdao;

public class Bxdaoimpl implements IBxdao 
{
	private Connection conn;
	
	public Bxdaoimpl()
	{
		
	}
	
	public Bxdaoimpl(Connection conn)
	{
		this.conn=conn;
	}
	
	public Connection getConn() 
	{
		return conn;
	}

	public void setConn(Connection conn)
	{
		this.conn = conn;
	}
	
	
	//查询报修记录表的相关信息
	// 1 按客户ID查找维修记录信息
	// 2按设备编号查找维修记录信息
	// 3按报修编号查找维修记录信息
	@Override
	public ArrayList<Bx> bx_selsect(Bx bx,int a) 
	{
		ArrayList<Bx> list=new ArrayList<Bx>();
		PreparedStatement psmt=null;
		ResultSet rs=null;		
		try
		{
			if(a==1)
			{
				String sql="select * from t_bx where client_id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1,bx.getClient_id());
				rs=psmt.executeQuery();
			}
			else if(a==2)
			{
				String sql="select * from t_bx where machine_id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1,bx.getMachine_id());
				rs=psmt.executeQuery();
			}
			else if(a==3)
			{
				String sql="select * from t_bx where repairs_id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1,bx.getRepairs_id());
				rs=psmt.executeQuery();
			}
			while(rs.next())
			{
				Bx bx1=new Bx();
				bx1.setRepairs_id(rs.getInt(1));
				bx1.setClient_id(rs.getInt(2));
				bx1.setFix_id(rs.getInt(3));
				bx1.setMachine_id(rs.getString(4));
				bx1.setFix_time(rs.getDate(5).toString());
				bx1.setPreprice(rs.getDouble(6));
				bx1.setPrefixed_date(rs.getDate(7).toString());
				bx1.setFix_state(rs.getInt(8));
				bx1.setProduct_type(rs.getString(9));
				bx1.setMachine_board(rs.getString(10));
				bx1.setMachine_typeNub(rs.getString(11));
				bx1.setSerial_number(rs.getString(12));
				bx1.setLack_part(rs.getString(13));
				bx1.setStop_pho(rs.getString(14));
				bx1.setStop_type(rs.getString(15));
				bx1.setAppearance_check(rs.getString(16));
				bx1.setStart_command(rs.getString(17));
				bx1.setImport_data(rs.getString(18));
				bx1.setHdd(rs.getString(19));
				bx1.setRam(rs.getString(20));
				bx1.setPc_card(rs.getString(21));
				bx1.setAc_adapter(rs.getString(22));
				bx1.setBattery(rs.getString(23));
				bx1.setCd_rom(rs.getString(24));
				bx1.setOhters(rs.getString(25));
				list.add(bx1);
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
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}				
		return list;
	}
	//更新报修记录表相关信息
	//0:没有执行sql语句  >0:执行正确  -1：执行无结果
	//a==1 更新所有的信息  a==2 更新报修状态
	@Override
	public int bx_update(Bx bx,int a) 
	{
		PreparedStatement psmt=null;		 
		int b = 0;
		try 
		{
			if(a==1)
			{
				String sql="update t_bx set machine_id = ? , fix_tiem = to_date(?,'YYYY-MM-DD HH24:MI:SS') , preprice= ? ,prefixed_date = to_date(?,'YYYY-MM-DD HH24:MI:SS'),fix_state= ? ,product_type= ? ,machine_board=?,machine_typeNub=?,serial_number=?,lack_part=?,stop_pho=?,stop_type=?,appearance_check=?,start_command=?,import_data=?,hdd=?,ram=?,pc_card=?,ac_adppter=?,battery=?, cd_rom= ?, othres=?";
				psmt=conn.prepareStatement(sql);
				 
				psmt.setString(1,bx.getMachine_id());
				psmt.setString(2,bx.getFix_time());
				psmt.setDouble(3,bx.getPreprice());
				psmt.setString(4,bx.getPrefixed_date());
				psmt.setInt(5,bx.getFix_state());
				psmt.setString(6,bx.getProduct_type());
				psmt.setString(7, bx.getMachine_board());
				psmt.setString(8,bx.getMachine_typeNub());
				psmt.setString(9,bx.getSerial_number());
				psmt.setString(10,bx.getLack_part());
				psmt.setString(11,bx.getStop_pho());
				psmt.setString(12,bx.getStop_type());
				psmt.setString(13,bx.getAppearance_check());
				psmt.setString(14,bx.getStart_command());
				psmt.setString(15,bx.getImport_data());
				psmt.setString(16,bx.getHdd());
				psmt.setString(17,bx.getRam());
				psmt.setString(18,bx.getPc_card());
				psmt.setString(19,bx.getAc_adapter());
				psmt.setString(20,bx.getBattery());
				psmt.setString(21,bx.getCd_rom());
				psmt.setString(22,bx.getOhters());
				b=psmt.executeUpdate();
			}
			else if(a==2)
			{
				String sql="update t_bx set fix_state=? where client_id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1,bx.getFix_state());
				psmt.setInt(2,bx.getClient_id());
				b=psmt.executeUpdate();				
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
	//删除报修记录信息
	//0:没有哦执行sql语句 >0:执行完成  -1:执行无结果
	//b:1按客户id删除报修记录信
	@Override
	public int bx_delete(Bx bx,int a) 
	{
		PreparedStatement psmt=null;		 
		int b=0;		
		try 
		{
			String sql="delete from t_bx where clint_id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,bx.getClient_id());
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
	//插入报修记录信息
	//0:表示没有执行数据语句 >0:已经执行成功  -1:咨询错误；
	@Override
	public int bx_insert(Bx bx,int a) 
	{
		PreparedStatement psmt=null;
		int b=0;
		
		try 
		{
			String sql="insert into t_bx(client_id,machine_id,fix_time,preprice,prefixed_date,fix_state,product_type,machine_board,machine_typeNub,Serial_numbe,lack_part,stop_pho,stop_type,appearance_check,start_command,import_data,hdd,ram,pc_card,ac_adapter,battery,cd_rom,ohters) values(?,?,to_date(?,'YYYY-MM-DD HH24:MI:SS'),?,to_date(?,'YYYY-MM-DD HH24:MI:SS'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1,bx.getClient_id());
			psmt.setString(2,bx.getMachine_id());
			psmt.setString(3,bx.getFix_time());
			psmt.setDouble(4,bx.getPreprice());
			psmt.setString(5,bx.getPrefixed_date());
			psmt.setInt(6,bx.getFix_state());
			psmt.setString(7,bx.getProduct_type());
			psmt.setString(8, bx.getMachine_board());
			psmt.setString(9,bx.getMachine_typeNub());
			psmt.setString(10,bx.getSerial_number());
			psmt.setString(11,bx.getLack_part());
			psmt.setString(12,bx.getStop_pho());
			psmt.setString(13,bx.getStop_type());
			psmt.setString(14,bx.getAppearance_check());
			psmt.setString(15,bx.getStart_command());
			psmt.setString(16,bx.getImport_data());
			psmt.setString(17,bx.getHdd());
			psmt.setString(18,bx.getRam());
			psmt.setString(19,bx.getPc_card());
			psmt.setString(20,bx.getAc_adapter());
			psmt.setString(21,bx.getBattery());
			psmt.setString(22,bx.getCd_rom());
			psmt.setString(23,bx.getOhters());
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
