package bo;

import java.util.ArrayList;

import javabean.Partdirect;
import javabean.Stock;

public interface IStockManagebo 
{
	//�±������
	public int Addpartmessage(Stock st);
	//ɾ���ɱ�����Ϣ
	public int Delpartmessage(Stock st);
	//�������еı�����Ϣ
	public ArrayList<Stock> Selectpartmessage(Stock st);
	//���±�����Ϣ
	public int Updatepartmssage(Stock st);
	//��ѯ���б�����ˮ��Ϣ
	public ArrayList<Partdirect> Selectpartdirect(Partdirect pd);
	//���뱸����ˮ��Ϣ
	public int Addpartdirect(Partdirect pd);
}
