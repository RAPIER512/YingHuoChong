package bo;

import java.util.ArrayList;

import javabean.Partdirect;
import javabean.Stock;

public interface IStockManagebo 
{
	//新备件入库
	public int Addpartmessage(Stock st);
	//删除旧备件信息
	public int Delpartmessage(Stock st);
	//查找所有的备件信息
	public ArrayList<Stock> Selectpartmessage(Stock st);
	//更新备件信息
	public int Updatepartmssage(Stock st);
	//查询所有备件流水信息
	public ArrayList<Partdirect> Selectpartdirect(Partdirect pd);
	//插入备件流水信息
	public int Addpartdirect(Partdirect pd);
}
