package dao;

import java.util.ArrayList;

import javabean.Finalstatement;

public interface IFianlstatementdao 
{
	//��ѯ������Ϣ
	public ArrayList<Finalstatement> finalstatement_select(Finalstatement finalstatement,int a);
	//�޸Ľ�����Ϣ
	public int finalstatenet_update(Finalstatement finalstatement);
	//���ӽ�����Ϣ
	public int fianlstatement_insert(Finalstatement finalstatement);
	//ɾ��������Ϣ
	public int finalstatement_delete(Finalstatement finalstatement);
}
