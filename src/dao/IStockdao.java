package dao;

import java.util.ArrayList;

import javabean.Stock;

public interface IStockdao 
{
	//增加库表的备件信息
	public int stock_insert(Stock s);
	//查询库存表的备件信息
	public ArrayList<Stock> stock_select(Stock s,int a);
	//删除库存表备件信息
	public int stock_delet (Stock s);
	//更新库存表信息
	public int stock_update(Stock s);

}
