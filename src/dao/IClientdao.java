package dao;

import javabean.Client;

public interface IClientdao 
{
	//查询客户信息
	public Client client_select(Client client,int n);
	//删除客户信息
	public int  client_delet(Client client,int n);
	//加入客户信息
	public int  client_insert(Client client);
	//修改客户信息
	public int  client_update(Client client);
}
