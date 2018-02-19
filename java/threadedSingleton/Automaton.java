import java.util.Random;

public class Automaton extends Thread{
	private static final int MAX_COUNT = 10;
	
	private int id;
	private TestSingleton singleton;
	
	public Automaton(){}
		
	public Automaton(int i, TestSingleton t){
		id = i;
		singleton = t;
	}
	
	@Override
	public void run(){
		for(int i = 0; i < MAX_COUNT; i++){
			try {
				Thread.sleep(1000 + (id*i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Random rand = new Random();
			int v = rand.nextInt(100)+1;
			singleton.addEntry(i, v);
			TestSingleton.increaseCount();
			System.out.println("Automaton ID: " + id + " Added: k:" + i +" - v: "+v);
			System.out.println("Automaton ID: " + id + " - TestSingleton Count: " + TestSingleton.getCount());
		}
		System.out.println("Final TestSingleton Count: " + TestSingleton.getCount());
	}
}
