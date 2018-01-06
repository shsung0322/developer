package old.ch02.step02.yield;

import java.util.concurrent.TimeUnit;

public class Multiplier extends Thread {
	//
	public Multiplier(String name) {
		//
		super(name); 
	}
	
	@Override
	public void run() {
		//
		System.out.println(getName() + ": Started...");
		
		while(true) {
			// 
			yield(); 
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
			yield(); 
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