import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TestSingleton {
	private static TestSingleton singleton;
	private static AtomicInteger countTracker;
	private HashMap<Integer,Integer> singletonTracker;
	
	private TestSingleton(){
		countTracker = new AtomicInteger(0);
	}
	
	public static TestSingleton getInstance(){
		if(singleton==null){
			singleton = new TestSingleton();
		}
		return singleton;
	}
	
	public void buildTracker(){
		singletonTracker = new HashMap<>();
	}
	
	public void addEntry(int k, int v){
		singletonTracker.put(k, v);
	}
	
	public HashMap<Integer,Integer> getTracker(){
		return singletonTracker;
	}
	
	public static void increaseCount(){
		countTracker.incrementAndGet();
	}
	
	public static int getCount(){
		return countTracker.get();
	}
}
