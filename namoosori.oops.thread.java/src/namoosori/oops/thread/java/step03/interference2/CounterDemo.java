package namoosori.oops.thread.java.step03.interference2;

import java.util.concurrent.TimeUnit;

public class CounterDemo {
	//
	public static void main(String[] args) {
		// 
		try {
			startDemo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	private static void startDemo() throws InterruptedException {
		// 
		SyncCounter syncCounter = new SyncCounter(); 
		
		for (int i=0; i<2; i++) {
			CounterHandler handler = new CounterHandler(syncCounter); 
			handler.start();
		}
		
		TimeUnit.SECONDS.sleep(10);
	}
}
