package old.ch02.step02.yield;

import java.util.concurrent.TimeUnit;

public class Summarizer extends Thread {
	//
	public Summarizer(String name) {
		//
		super(name);
	}
	
	@Override
	public void run() {
		//
		System.out.println(getName() + ": Started...");
		
		while(true) {
			printOutSum();
			break; 
		}
		
		System.out.println(getName() + ": End...");
	}
	
	private void printOutSum() {
		//
		int sum = 0; 
		for (int i=1; i<5; i++) {
			this.sleepInSeconds(1);  
			sum += i; 
			System.out.println(getName() + ": sum -> " + sum);
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