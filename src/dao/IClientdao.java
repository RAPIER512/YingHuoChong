package dao;

import javabean.Client;

public interface IClientdao 
{
	//��ѯ�ͻ���Ϣ
	public Client client_select(Client client,int n);
	//ɾ���ͻ���Ϣ
	public int  client_delet(Client client,int n);
	//����ͻ���Ϣ
	public int  client_insert(Client client);
	//�޸Ŀͻ���Ϣ
	public int  client_update(Client client);
}
