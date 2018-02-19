import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadSingletonMain {
	private static ExecutorService pool = Executors.newFixedThreadPool(100);
	public static void main(String[] args){
		System.out.println("Start");
		ArrayList<TestSingleton> list = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			TestSingleton t = TestSingleton.getInstance();
			t.buildTracker();
			list.add(t);
			pool.execute(new Automaton(i,t));
		}
		pool.shutdown();
		try {
			pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished");
		System.out.println("Final count: "+TestSingleton.getCount());
		for(Entry<Integer, Integer> entry : list.get(0).getTracker().entrySet()){
			System.out.println("Key: "+entry.getKey() + " - Value: "+entry.getValue());
		}
	}
}
