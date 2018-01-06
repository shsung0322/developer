
package namoosori.oops.thread.java.step02.daemon1;

import java.util.concurrent.TimeUnit;

public class HelloDaemon {
	//
	public static void main(String[] args) {
		// 
		HelloDaemon helloDemon = new HelloDaemon(); 
		helloDemon.show(); 
	}
	
	public void show() {
		//
		System.out.println(Thread.currentThread().getName() + ": Started...\n");
		
		DaemonMultiplier multiplier = new DaemonMultiplier("JoinMultiplier");
		
		//--------------------------------
		// main 스레드가 종료되면 자동/강제 종료
		// 예, 자동저장 기능 
		multiplier.setDaemon(true); 
		//--------------------------------
		
		multiplier.start();
		sleepInSeconds(5);
		
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