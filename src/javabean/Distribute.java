package javabean;

import java.util.Date;

public class Distribute 
{
	private int distribute_id;
	private int yardman_id;
	private int repairs_id;
	private int engineer_id;
	private String distribute_time;
	private int state;
	
	public Distribute(){
		
	}
	
	public int getDistribute_id() {
		return distribute_id;
	}
	public void setDistribute_id(int distribute_id) {
		this.distribute_id = distribute_id;
	}
	public int getYardman_id() {
		return yardman_id;
	}
	public void setYardman_id(int yardman_id) {
		this.yardman_id = yardman_id;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
