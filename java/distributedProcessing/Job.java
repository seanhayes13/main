
public class Job {
	private String jobID;
	private int duration;
	
	public Job(){}
	
	public Job(String id, int d){
		jobID = id;
		duration = d;
	}
	
	public int getDuration(){
		return duration;
	}
	
	public String getJobID(){
		return jobID;
	}
}
