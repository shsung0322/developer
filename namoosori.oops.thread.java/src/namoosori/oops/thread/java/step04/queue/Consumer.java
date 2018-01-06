package namoosori.oops.thread.java.step04.queue;

import java.util.concurrent.TimeUnit;

public class Consumer extends Thread {
	// 
	private MyBlockingQueue queue; 
	
	public Consumer(MyBlockingQueue queue) {
		//
		this.queue = queue; 
	}
	
	public void run() {
		// 
		String threadName = Thread.currentThread().getName(); 
		
		while(true) {
			//
			try {
				String message = queue.take();
				System.out.format("Take|%s| %s%n", threadName, message); 
			} catch (InterruptedException e) {
				e.printStackTrace();
				break; 
			} 
			
			sleepInSeconds(2); 
		}
	}
	
	public void sleepInSeconds(int seconds) {
		// 
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}