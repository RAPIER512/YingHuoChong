package dao;

import java.util.ArrayList;

import javabean.Partdirect;

public interface IPartdirectdao 
{
	//增加备件流水信息
	public int partdirect_insert(Partdirect p);
	//查询备件流水信息
	public ArrayList<Partdirect> partdirect_selsect(Partdirect p,int a);
	
	
	//删除备件流水信息
	public int prtdirect_delete(Partdirect p);
	//修改备件流水信息
	public int prtdirect_update(Partdirect P);

}
