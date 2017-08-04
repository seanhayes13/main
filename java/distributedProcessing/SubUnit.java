import java.util.ArrayList;

public class SubUnit {
	private ArrayList<Job> jobs;
	private long subUnitID;
	private MainUnit mu;
	
	public SubUnit(){}
	
	public SubUnit(long id, MainUnit m){
		jobs = new ArrayList<>();
		subUnitID = id;
		mu = m;
	}
	
	public void newJob(Job j){
		jobs.add(j);
	}
	
	public void executeJob(Job j){
		System.out.println("Worker "+subUnitID + " starting work on " + j.getJobID());
		try {
			System.out.println("Sleeping for "+ j.getDuration());
			Thread.sleep(j.getDuration());
			System.out.println("Job complete");
			mu.addFinishedJob(j);
			jobs.remove(j);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void finishJob(Job j){
		mu.addFinishedJob(j);
		jobs.remove(j);		
	}
	
	public int getJobsSize(){
		return jobs.size();
	}
	
	public long getID(){
		return subUnitID;
	}
}
