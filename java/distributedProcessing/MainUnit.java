import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

public class MainUnit {
	private ArrayList<SubUnit> workerList;
	private ArrayList<Job> completedJobs;
	private final int INIT_WORKER_COUNT = 3;
	private String jobID;
	private long jobCount;
	private long workerCount = 1;
	private int rand;
	
	public MainUnit(){
		workerList = new ArrayList<>();
		completedJobs = new ArrayList<>();
		for(int i = 0; i < INIT_WORKER_COUNT; i++){
			System.out.println("Starting worker: "+i);
			workerList.add(new SubUnit(workerCount, this));
			workerCount++;
		}
	}
	
	public void processJobs(ArrayList<String> jobs){
		while(!jobs.isEmpty()){
			//check if everyone has a full load
			if(fullLoad()){
				System.out.println("Full load");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				jobCount++;
				//find who has the smallest load
				String s = jobs.remove(0);
				System.out.println("Processing: "+s);
				SubUnit lowest = workerList.get(0);
				for(int i = 1; i < workerList.size();i++){
					if(workerList.get(i).getJobsSize() < lowest.getJobsSize()){
						lowest = workerList.get(i);
					}
				}
				//set duration
				rand = new Random().nextInt(10)*1000;
				//create the job
				Job j = new Job(s,rand);
				//assign job to subunit with smallest load
				Work w = new Work(lowest, j);
				lowest.newJob(j);
				w.start();
				//for display purposes only
				//viewSubUnitWorkLoad();
			}
		}
	}
	
	public boolean fullLoad(){
		for(SubUnit su : workerList){
			if(su.getJobsSize()<5){
				return false;
			}
		}
		return true;
	}
	
	public void viewSubUnitWorkLoad(){
		for(SubUnit su : workerList){
			System.out.println(su.getID() +": "+su.getJobsSize());
		}
	}
	
	public void addFinishedJob(Job j){
		completedJobs.add(j);
	}
	
	//This isn't implemented in this version
	public static String getMd5HashString(long l){
		String result = "Error";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] numAsBytes = String.valueOf(l).getBytes();
			byte[] md5Hash = md.digest(numAsBytes);
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < md5Hash.length; i++){
				sb.append(Integer.toString((md5Hash[i] & 0xff)+0x100,16).substring(1));
			}
			result = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.getMessage();
		}
		return result;
	}
}
