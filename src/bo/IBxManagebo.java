package bo;

import java.util.ArrayList;

import javabean.Bx;
import javabean.Distribute;
import javabean.Emp;

public interface IBxManagebo 
{
	//ά�����޼�¼��Ϣ
	
	//��ѯ���޼�¼��Ϣ
	public ArrayList<Bx> Query_bx(Bx e);
	//�޸ı��޼�¼��Ϣ
	public int Change_bx(Bx e);
	//���ӱ��޼�¼��Ϣ
	public int Register_bx(Bx e);
	//ɾ�����޼�¼��Ϣ
	public int Drop_bx(Bx e);
	
	
	//��ӡ�ͻ�ȷ�ϵ�
	public ArrayList<Bx> Print_form(Bx e);
	
	//�ύ�ͻ�ȷ�ϵ�	
	public int Submit_form(Bx e);
	
	//�趨ά��������״̬
	public ArrayList<Distribute> set_state(Distribute e);
	
}
