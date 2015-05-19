package bo.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.IBxdao;
import dao.IDistributedao;
import dao.impl.Bxdaoimpl;
import dao.impl.Distributedaoimpl;
import javabean.Bx;
import javabean.Distribute;
import bo.IBxManagebo;

public class BxManageboimpl implements IBxManagebo 
{
	private Connection conn=null;
	IBxdao iBxdao=null;
	IDistributedao iDistributedao=null;
	public BxManageboimpl(Connection conn)
	{
		this.conn=conn;
		iBxdao=new Bxdaoimpl(conn);
		iDistributedao =new Distributedaoimpl(conn);
	}
	
	
	
	//查询客户的报修记录信息 
	@Override
	public ArrayList<Bx> Query_bx(Bx e) 
	{
		ArrayList list=new ArrayList();
		list=iBxdao.bx_selsect(e, 1); 
		return list;
	}
	//修改客户的保修记录信息
	@Override
	public int Change_bx(Bx e) 
	{
		int b=0;
		//打开事物
		startTransaction(conn);
		
		b=iBxdao.bx_update( e, 1);
		
		if(b>0)
			endTransaction(conn);
		else
			rollbackTransaction(conn);
		return b;
	}
	//注册客户的保修记录信息
	@Override
	public int Register_bx(Bx e) 
	{
		int b=0;
		startTransaction(conn);
		
		b=iBxdao.bx_insert(e, 1);
		
		if(b>0)
			endTransaction(conn);
		else
			rollbackTransaction(conn);
		return b;
	}
	//删除客户的保修记录信息
	@Override
	public int Drop_bx(Bx e)
	{
		int b=0;
		
		startTransaction(conn);
		b=iBxdao.bx_delete(e, 1);
		if(b>0)
			endTransaction(conn);
		else
			rollbackTransaction(conn);		
		return b;
	}
	//打印客户确认单
	@Override
	public ArrayList<Bx> Print_form(Bx e) 
	{
		ArrayList list=new ArrayList();
		list=iBxdao.bx_selsect(e, 1); 
		return list; 
	}
	//提交客户确认单。
	@Override
	public int Submit_form(Bx e) 
	{
		int a=0,b=0,c=0;
		startTransaction(conn);
		
		//修改保修记录表的状态
		e.setFix_state(1);
		a=iBxdao.bx_update(e,2);
		
		//生成任务分配记录
		Distribute distribute =new Distribute();
		distribute.setRepairs_id(e.getRepairs_id());
		distribute.setState(1);
		distribute.setDistribute_time("1994/3/23");
		
		c=iDistributedao.Distribute_insert(distribute, 1);
		
		
		//b=1操作失败    b=-1操作失败
		if(a>0&&c>0)
		{
			b=1;
			endTransaction(conn);
		}
		else
		{
			b=-1;
			rollbackTransaction(conn);
		}
		return b;
	}
	//设定维修任务监察状态
	@Override
	public ArrayList<Distribute> set_state(Distribute e) 
	{
		 
		return null;
	}
	
	
	
	//打开事务
	public void startTransaction(Connection conn)
	{
		try 
		{
			conn.setAutoCommit(false);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
		
	//结束事务
	public void endTransaction(Connection conn)
	{
		try 
		{
			conn.commit();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
		
	//回滚事务
	public void rollbackTransaction(Connection conn)
	{
		try 
		{
			conn.rollback();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}



