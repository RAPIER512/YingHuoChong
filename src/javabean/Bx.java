package javabean;

import java.io.Serializable;
import java.util.Date;

public class Bx implements Serializable 
{
	private int repairs_id;
	private int client_id;
	private int fix_id;
	private String machine_id;
	private String fix_time;
	private double preprice;
	private String prefixed_date;
	private int fix_state;
	private String product_type;
	private String machine_board;
	private String machine_typeNub;
	private String serial_number;
	private String lack_part;
	private String stop_pho;
	private String stop_type;
	private String appearance_check;
	private String start_command;
	private String import_data;
	private String hdd;
	private String ram;
	private String pc_card;
	private String ac_adapter;
	private String battery;
	private String cd_rom;
	private String ohters;
	
	public Bx(){
		
	}
	
	public int getRepairs_id() {
		return repairs_id;
	}
	public void setRepairs_id(int repairs_id) {
		this.repairs_id = repairs_id;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public String getMachine_id() {
		return machine_id;
	}
	public void setMachine_id(String machine_id) {
		this.machine_id = machine_id;
	}
	public String getFix_time() {
		return fix_time;
	}
	public void setFix_time(String fix_time) {
		this.fix_time = fix_time;
	}
	public double getPreprice() {
		return preprice;
	}
	public void setPreprice(double preprice) {
		this.preprice = preprice;
	}
	public String getPrefixed_date() {
		return prefixed_date;
	}
	public void setPrefixed_date(String prefixed_date) {
		this.prefixed_date = prefixed_date;
	}
	public int getFix_state() {
		return fix_state;
	}
	public void setFix_state(int fix_state) {
		this.fix_state = fix_state;
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
	public String getLack_part() {
		return lack_part;
	}
	public void setLack_part(String lack_part) {
		this.lack_part = lack_part;
	}
	public String getStop_pho() {
		return stop_pho;
	}
	public void setStop_pho(String stop_pho) {
		this.stop_pho = stop_pho;
	}
	public String getStop_type() {
		return stop_type;
	}
	public void setStop_type(String stop_type) {
		this.stop_type = stop_type;
	}
	public String getAppearance_check() {
		return appearance_check;
	}
	public void setAppearance_check(String appearance_check) {
		this.appearance_check = appearance_check;
	}
	public String getStart_command() {
		return start_command;
	}
	public void setStart_command(String start_command) {
		this.start_command = start_command;
	}
	public String getImport_data() {
		return import_data;
	}
	public void setImport_data(String import_data) {
		this.import_data = import_data;
	}
	public String getHdd() {
		return hdd;
	}
	public void setHdd(String hdd) {
		this.hdd = hdd;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getPc_card() {
		return pc_card;
	}
	public void setPc_card(String pc_card) {
		this.pc_card = pc_card;
	}
	public String getAc_adapter() {
		return ac_adapter;
	}
	public void setAc_adapter(String ac_adapter) {
		this.ac_adapter = ac_adapter;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	public String getCd_rom() {
		return cd_rom;
	}
	public void setCd_rom(String cd_rom) {
		this.cd_rom = cd_rom;
	}
	public String getOhters() {
		return ohters;
	}
	public void setOhters(String ohters) {
		this.ohters = ohters;
	}

	public int getFix_id() {
		return fix_id;
	}

	public void setFix_id(int fix_id) {
		this.fix_id = fix_id;
	}
	
}
