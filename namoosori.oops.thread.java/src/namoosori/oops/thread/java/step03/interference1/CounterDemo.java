package namoosori.oops.thread.java.step03.interference1;

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
		Counter singleCounter = new Counter(); 
		
		for (int i=0; i<2; i++) {
			CounterHandler handler = new CounterHandler(singleCounter); 
			handler.start();
		}
		
		TimeUnit.SECONDS.sleep(10);
	}
}
