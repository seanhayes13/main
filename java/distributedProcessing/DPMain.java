import java.util.ArrayList;
import java.util.Arrays;

public class DPMain {
	public static void main(String[] args){
		System.out.println("Distributed Processing - Proof of Concept");
		MainUnit mu = new MainUnit();
		mu.viewSubUnitWorkLoad();
		ArrayList<String> workload = new ArrayList<String>(Arrays.asList("Arizona","California","Utah",
				"New Mexico","Colorado","Oregon","Washington","Nevada","Idaho","Montana","Wyoming",
				"North Dakota","South Dakota","Kansas","Nebraska","Oklahoma","Texas","Minnesota",
				"Illinois","Missouri","Arkansas","Louisiana","Wisconsin","Iowa","Indiana","Michigan",
				"Ohio","Kentucky","Tennessee","Mississippi","Alabama","Georgia","Florida",
				"North Carolina","South Carolina","Virginia","West Virginia","Maryland","Pennsylvania",
				"Delaware","New Jersey","New York","Massachusetts","Connecticut","Rhode Island",
				"Vermont","New Hampshire","Maine","Alaska","Hawaii"));
		mu.processJobs(workload);
	}
}