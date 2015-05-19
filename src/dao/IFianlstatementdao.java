package dao;

import java.util.ArrayList;

import javabean.Finalstatement;

public interface IFianlstatementdao 
{
	//查询结算信息
	public ArrayList<Finalstatement> finalstatement_select(Finalstatement finalstatement,int a);
	//修改结算信息
	public int finalstatenet_update(Finalstatement finalstatement);
	//增加结算信息
	public int fianlstatement_insert(Finalstatement finalstatement);
	//删除结算信息
	public int finalstatement_delete(Finalstatement finalstatement);
}
