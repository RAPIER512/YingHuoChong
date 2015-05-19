package javabean;

public class Partdirect 
{
	private int partdirect_id;
	private int fix_id;
	private String part_name;
	private String part_model;
	private int quantity;
	private String part_id;
	
	public Partdirect(){
		
	}
	
	public int getPartdirect_id() {
		return partdirect_id;
	}
	public void setPartdirect_id(int partdirect_id) {
		this.partdirect_id = partdirect_id;
	}
	public int getFix_id() {
		return fix_id;
	}
	public void setFix_id(int fix_id) {
		this.fix_id = fix_id;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPart_id() {
		return part_id;
	}
	public void setPart_id(String part_id) {
		this.part_id = part_id;
	}
}
