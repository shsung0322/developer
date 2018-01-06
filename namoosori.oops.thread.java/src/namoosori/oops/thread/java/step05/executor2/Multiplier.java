package namoosori.oops.thread.java.step05.executor2;

public class Multiplier implements Runnable {
	//
	private int baseValue; 
	
	public Multiplier(int baseValue) {
		// 
		this.baseValue = baseValue; 
	}
	
	public void run() {
		// 
		long result = 1; 
		for (int i=1; i<=baseValue; i++) {
			result *= i; 
		}
		
		String threadName = Thread.currentThread().getName(); 
		System.out.format(" [%s]-> Result : %d%n ", threadName, result);
	}
}