package dao;

import java.util.ArrayList;

import javabean.Bx;

public interface IBxdao 
{
	//查询报修记录信息
	public ArrayList<Bx> bx_selsect(Bx bx,int a);
	//修改报修记录信息
	public int  bx_update(Bx bx,int a);
	//删除报修记录信息
	public int  bx_delete(Bx bx,int a);
	//增加报修记录信息
	public int bx_insert(Bx bx,int a);
}
