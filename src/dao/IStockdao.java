package dao;

import java.util.ArrayList;

import javabean.Stock;

public interface IStockdao 
{
	//���ӿ��ı�����Ϣ
	public int stock_insert(Stock s);
	//��ѯ����ı�����Ϣ
	public ArrayList<Stock> stock_select(Stock s,int a);
	//ɾ����������Ϣ
	public int stock_delet (Stock s);
	//���¿�����Ϣ
	public int stock_update(Stock s);

}
