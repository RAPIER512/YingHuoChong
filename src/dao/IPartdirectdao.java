package dao;

import java.util.ArrayList;

import javabean.Partdirect;

public interface IPartdirectdao 
{
	//���ӱ�����ˮ��Ϣ
	public int partdirect_insert(Partdirect p);
	//��ѯ������ˮ��Ϣ
	public ArrayList<Partdirect> partdirect_selsect(Partdirect p,int a);
	
	
	//ɾ��������ˮ��Ϣ
	public int prtdirect_delete(Partdirect p);
	//�޸ı�����ˮ��Ϣ
	public int prtdirect_update(Partdirect P);

}
