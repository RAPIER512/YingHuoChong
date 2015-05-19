package dao;

import java.util.ArrayList;

import javabean.Distribute;

public interface IDistributedao 
{
	//查询任务分配的说有信息
	public ArrayList<Distribute> Distribute_select(Distribute distribute,int a);
	//修改任务分配的状态
	public int Distribute_update(Distribute distribute,int a);
	//删除任务分配的信息
	public int Distribute_delete(Distribute distribute,int a);
	//增加任务分配的信息
	public int Distribute_insert(Distribute distribue,int a);
	
	
	//还缺一个按时间和状态删除任务分配信息的功能：
}
