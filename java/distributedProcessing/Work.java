
public class Work implements Runnable{
	private Thread t;
	private Job job;
	private SubUnit su;
	
	public Work(SubUnit s, Job j){
		su = s;
		job = j;
	}
	
	public void run(){
		System.out.println("SubUnit: " + su.getID() + " is running work on job: "+job.getJobID());
		try {
			Thread.sleep(job.getDuration());
		} catch (InterruptedException e) {
			System.out.println("Job for "+job.getJobID() + " interrupted");
		}
		System.out.println("SubUnit "+ su.getID() + " finished job for " + job.getJobID() + ". Exiting...");
		su.finishJob(job);
	}
	
	public void start(){
		System.out.println("SubUnit: " + su.getID() + " is starting work for "+ job.getJobID());
		if(t == null){
			t = new Thread(this, job.getJobID());
			t.start();
		}
	}
}
