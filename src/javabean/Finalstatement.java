package javabean;

import java.util.Date;

public class Finalstatement 
{
	private int finalprice_id;
	private int fix_id;
	private int client_id;
	private String prefixed_date;
	private String fixed_date;
	private String product_type;
	private String machine_board;
	private String machine_typeNub;
	private String serial_number;
	private String unitName;
	private String client_name;
	private double sum_fee;
	private double repare_fee;
	private double material_fee;
	
	public Finalstatement(){
		
	}
	
	
	public int getFinalprice_id() {
		return finalprice_id;
	}
	public void setFinalprice_id(int d) {
		this.finalprice_id = d;
	}
	public int getFix_id() {
		return fix_id;
	}
	public void setFix_id(int fix_id) {
		this.fix_id = fix_id;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public String getPrefixed_date() {
		return prefixed_date;
	}
	public void setPrefixed_date(String prefixed_date) {
		this.prefixed_date = prefixed_date;
	}
	public String getFixed_date() {
		return fixed_date;
	}
	public void setFixed_date(String fixed_date) {
		this.fixed_date = fixed_date;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getMachine_board() {
		return machine_board;
	}
	public void setMachine_board(String machine_board) {
		this.machine_board = machine_board;
	}
	public String getMachine_typeNub() {
		return machine_typeNub;
	}
	public void setMachine_typeNub(String machine_typeNub) {
		this.machine_typeNub = machine_typeNub;
	}
	public String getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public double getSum_fee() {
		return sum_fee;
	}
	public void setSum_fee(double sum_fee) {
		this.sum_fee = sum_fee;
	}
	public double getRepare_fee() {
		return repare_fee;
	}
	public void setRepare_fee(double repare_fee) {
		this.repare_fee = repare_fee;
	}
	public double getMaterial_fee() {
		return material_fee;
	}
	public void setMaterial_fee(double material_fee) {
		this.material_fee = material_fee;
	} 
}
