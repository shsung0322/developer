package namoosori.oops.thread.java.step03.interference1;

import java.util.concurrent.TimeUnit;

public class CounterHandler extends Thread {
	//
	private Counter counter; 
	
	public CounterHandler(Counter counter) {
		// 
		this.counter = counter; 
	}
	
	public void run() {
		// 
		while(true) {
			// 
			int preAmount = counter.getAmount(); 
			int postAmount = counter.increase(); 
			
			if ((preAmount+1) != postAmount){
				System.out.println(String.format("%s: org amount: %d \n", getName(), preAmount));
				System.out.println(String.format("%s: after increasing amount: %d \n",getName(), postAmount));
				break; 
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