package namoosori.oops.thread.java.step04.waitnotify1;

import java.util.concurrent.TimeUnit;

public class CounterHandler extends Thread {
	//
	private Counter counter; 
	private int maxTrial = 10; 
	
	public CounterHandler(Counter counter) {
		// 
		this.counter = counter; 
	}
	
	public void run() {
		// 
		int trial = 0; 
		while(true) {
			// 
			try {
				counter.increase();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} 
			
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				break; 
			}
			
			if(trial++ == maxTrial) {
				break; 
			}
		}
	}
}