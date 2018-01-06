package old.ch02.step02.daemon;

import java.util.concurrent.TimeUnit;

public class HelloMyDaemon {
	//
	public static void main(String[] args) {
		// 
		HelloMyDaemon hello = new HelloMyDaemon(); 
		hello.startDemo(); 
	}
	
	public void startDemo() {
		//
		System.out.println(Thread.currentThread().getName() + ": Started...\n");
		
		DaemonMultiplier multiplier = new DaemonMultiplier("JoinMultiplier");
		
		//--------------------------------
		multiplier.setDaemon(true); 
		//--------------------------------
		
		multiplier.start();
		sleepInSeconds(3);
		
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