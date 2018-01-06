package old.ch02.step02.daemon;

import java.util.concurrent.TimeUnit;

public class DaemonMultiplier extends Thread {
	//
	public DaemonMultiplier(String name) {
		//
		super(name); 
	}
	
	@Override
	public void run() {
		//
		System.out.println(getName() + ": Started...");
		
		while(true) {
			printOutMultiplication();
			break; 
		}
		
		System.out.println(getName() + ": End...");
	}
	
	private void printOutMultiplication() {
		//
		int sum = 1; 
		for (int i=1; i<5; i++) {
			// 
			this.sleepInSeconds(1); 
			sum *= i; 
			System.out.println(getName() + ": multiplication -> " + sum);
		}
	}
	
	private void sleepInSeconds(int seconds) {
		// 
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
}