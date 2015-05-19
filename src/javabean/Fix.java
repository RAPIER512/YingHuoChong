package javabean;

import java.util.Date;

public class Fix 
{
	private int fix_id;
	private int repairs_id;
	private int  engineer_id;
	private String distribute_time;
	private String check_record;
	private String fix_record;
	private String fixCheck_tiem;
	private int lable_quantity;
	private double label_fee;
	private double material_fee;
	private String fix_promise;
	private String attention;
	private int fix_state;
	private String fixed_date;
	private int delay_state;
	
	private Fix(){
		
	}
	
	
	public int getFix_id() {
		return fix_id;
	}
	public void setFix_id(int fix_id) {
		this.fix_id = fix_id;
	}
	public int getRepairs_id() {
		return repairs_id;
	}
	public void setRepairs_id(int repairs_id) {
		this.repairs_id = repairs_id;
	}
	public int getEngineer_id() {
		return engineer_id;
	}
	public void setEngineer_id(int engineer_id) {
		this.engineer_id = engineer_id;
	}
	public String getDistribute_time() {
		return distribute_time;
	}
	public void setDistribute_time(String distribute_time) {
		this.distribute_time = distribute_time;
	}
	public String getCheck_record() {
		return check_record;
	}
	public void setCheck_record(String check_record) {
		this.check_record = check_record;
	}
	public String getFix_record() {
		return fix_record;
	}
	public void setFix_record(String fix_record) {
		this.fix_record = fix_record;
	}
	public String getFixCheck_tiem() {
		return fixCheck_tiem;
	}
	public void setFixCheck_tiem(String fixCheck_tiem) {
		this.fixCheck_tiem = fixCheck_tiem;
	}
	public int getLable_quantity() {
		return lable_quantity;
	}
	public void setLable_quantity(int lable_quantity) {
		this.lable_quantity = lable_quantity;
	}
	public double getLabel_fee() {
		return label_fee;
	}
	public void setLabel_fee(double label_fee) {
		this.label_fee = label_fee;
	}
	public double getMaterial_fee() {
		return material_fee;
	}
	public void setMaterial_fee(double material_fee) {
		this.material_fee = material_fee;
	}
	public String getFix_promise() {
		return fix_promise;
	}
	public void setFix_promise(String fix_promise) {
		this.fix_promise = fix_promise;
	}
	public String getAttention() {
		return attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	public int getFix_state() {
		return fix_state;
	}
	public void setFix_state(int fix_state) {
		this.fix_state = fix_state;
	}
	public String getFixed_date() {
		return fixed_date;
	}
	public void setFixed_date(String fixed_date) {
		this.fixed_date = fixed_date;
	}
	public int getDelay_state() {
		return delay_state;
	}
	public void setDelay_state(int delay_state) {
		this.delay_state = delay_state;
	}
}
