package namoosori.oops.thread.java.step03.interference3;

import java.util.concurrent.TimeUnit;

public class CounterHandler extends Thread {
	//
	private AtomicCounter counter; 
	
	public CounterHandler(AtomicCounter counter) {
		// 
		this.counter = counter; 
	}
	
	public void run() {
		// 
		while(true) {
			// 
			int preAmount = counter.getAmount();
			counter.increase();
			int postAmount = counter.getAmount(); 
			
			if ((preAmount+1) != postAmount){
				System.out.println("org amount: " + preAmount);
				System.out.println("after increasing amount: " + postAmount);
				throw new RuntimeException(); 
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				break; 
			}
		}
		
		throw new RuntimeException(getName()); 
	}
}