package bo;

import java.util.ArrayList;

import javabean.Bx;
import javabean.Distribute;
import javabean.Emp;

public interface IBxManagebo 
{
	//维护保修记录信息
	
	//查询报修记录信息
	public ArrayList<Bx> Query_bx(Bx e);
	//修改保修记录信息
	public int Change_bx(Bx e);
	//增加报修记录信息
	public int Register_bx(Bx e);
	//删除报修记录信息
	public int Drop_bx(Bx e);
	
	
	//打印客户确认单
	public ArrayList<Bx> Print_form(Bx e);
	
	//提交客户确认单	
	public int Submit_form(Bx e);
	
	//设定维修任务监察状态
	public ArrayList<Distribute> set_state(Distribute e);
	
}
