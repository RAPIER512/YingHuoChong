package bo.impl;

import java.sql.Connection;
import java.util.ArrayList;

import dao.IPartdirectdao;
import dao.IStockdao;
import dao.impl.Partdirectdaoimpl;
import dao.impl.Stockdaoimpl;
import javabean.Partdirect;
import javabean.Stock;
import bo.IStockManagebo;

public class StockManageboimpl implements IStockManagebo 
{
	Connection conn;
	
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public StockManageboimpl()
	{
		
	}
	
	public StockManageboimpl(Connection conn)
	{
		this.conn=conn;
	}
	
	//新备件入库
	@Override
	public int Addpartmessage(Stock st) 
	{
		IStockdao stockdao =new Stockdaoimpl(conn);
		int b=stockdao.stock_insert(st);
		return b;
	}
	//删除旧备件信息
	@Override
	public int Delpartmessage(Stock st) 
	{
		IStockdao stockdao =new Stockdaoimpl(conn);
		int b= stockdao.stock_delet(st); 
		return b;
	}
	//查找所有的备件信息
	@Override
	public ArrayList<Stock> Selectpartmessage(Stock st)
	{
		ArrayList<Stock> list=new ArrayList<Stock>();	 
		IStockdao stockdao =new Stockdaoimpl(conn);	 
		list=stockdao.stock_select(st, 1);
		return list;
		
	}
	//更新备件信息
	@Override
	public int Updatepartmssage(Stock st) 
	{
		IStockdao stockdao =new Stockdaoimpl(conn);
		int b=stockdao.stock_update(st) ;
		return b;
	}
	//查询所有备件流水信息
	@Override
	public ArrayList<Partdirect> Selectpartdirect(Partdirect pd) 
	{
		ArrayList<Partdirect> list =new ArrayList<Partdirect>();
		IPartdirectdao  partdirect=new Partdirectdaoimpl(conn);
		list=partdirect.partdirect_selsect(pd, 1);
		return list;
	}
	//插入备件流水信息
	@Override
	public int Addpartdirect(Partdirect pd) 
	{
		IPartdirectdao  partdirect=new Partdirectdaoimpl(conn);
		int b=partdirect.partdirect_insert(pd); 
		return b;
	}

	

}
