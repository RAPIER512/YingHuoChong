package dao;

import java.util.ArrayList;

import javabean.Distribute;

public interface IDistributedao 
{
	//��ѯ��������˵����Ϣ
	public ArrayList<Distribute> Distribute_select(Distribute distribute,int a);
	//�޸���������״̬
	public int Distribute_update(Distribute distribute,int a);
	//ɾ������������Ϣ
	public int Distribute_delete(Distribute distribute,int a);
	//��������������Ϣ
	public int Distribute_insert(Distribute distribue,int a);
	
	
	//��ȱһ����ʱ���״̬ɾ�����������Ϣ�Ĺ��ܣ�
}
