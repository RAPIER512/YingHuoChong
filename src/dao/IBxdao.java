package dao;

import java.util.ArrayList;

import javabean.Bx;

public interface IBxdao 
{
	//��ѯ���޼�¼��Ϣ
	public ArrayList<Bx> bx_selsect(Bx bx,int a);
	//�޸ı��޼�¼��Ϣ
	public int  bx_update(Bx bx,int a);
	//ɾ�����޼�¼��Ϣ
	public int  bx_delete(Bx bx,int a);
	//���ӱ��޼�¼��Ϣ
	public int bx_insert(Bx bx,int a);
}
