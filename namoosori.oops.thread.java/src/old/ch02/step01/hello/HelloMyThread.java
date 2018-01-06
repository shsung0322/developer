package old.ch02.step01.hello;

import java.util.concurrent.TimeUnit;

public class HelloMyThread {
	//
	public static void main(String[] args) {
		// 
		HelloMyThread hello = new HelloMyThread(); 
		hello.startDemo(); 
	}
	
	public void startDemo() {
		//
		System.out.println(Thread.currentThread().getName() + ": Started...\n");
		
		Summarizer summerizer = new Summarizer("Summerizer"); 
		Multiplier multiplierImpl = new Multiplier("JoinMultiplier");
		Thread multiplier = new Thread(multiplierImpl, multiplierImpl.getName());
		
		summerizer.start();
		multiplier.start();
	
		while (true) {
			//
			if (summerizer.isAlive() && multiplier.isAlive()) {
				sleepInSeconds(1);
				continue; 
			} 
			break; 
		}
		
		System.out.println("\n" + Thread.currentThread().getName() + ": End...\n");
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