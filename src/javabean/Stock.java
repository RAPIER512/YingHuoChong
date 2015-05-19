package javabean;

public class Stock 
{
	private String part_name;
	private String part_model;
	private double priece;
	private int quantity;
	private int wq;
	private int kcstate;
	private String part_id;
	
	public Stock(){
		
	}
	
	public String getPart_name() {
		return part_name;
	}
	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}
	public String getPart_model() {
		return part_model;
	}
	public void setPart_model(String part_model) {
		this.part_model = part_model;
	}
	public double getPriece() {
		return priece;
	}
	public void setPriece(double priece) {
		this.priece = priece;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getWq() {
		return wq;
	}
	public void setWq(int wq) {
		this.wq = wq;
	}
	public int getKcstate() {
		return kcstate;
	}
	public void setKcstate(int kcstate) {
		this.kcstate = kcstate;
	}
	public String getPart_id() {
		return part_id;
	}
	public void setPart_id(String part_id) {
		this.part_id = part_id;
	}
	
}
