package javabean;

public class Limits 
{
	private int limits_id;
	private String job;
	
	private Limits(){
		
	}
	
	public int getLimits_id() {
		return limits_id;
	}
	public void setLimits_id(int limits_id) {
		this.limits_id = limits_id;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
}
