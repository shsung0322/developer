package namoosori.oops.thread.java.step02.daemon1;

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
		
		try {
			//----------------------------
			while(true) {
				printOutMultiplication();
				break; 
			}
			//-----------------------------
        } catch (InterruptedException e) {
            System.out.println("InterruptedException!!");
        } finally {
            System.out.println("DaemonThread's finlly block.");
        }

		
		System.out.println(getName() + ": End...");
	}
	
	private void printOutMultiplication() throws InterruptedException {
		//
		int sum = 1; 
		for (int i=1; i<10; i++) {
			// 
			sleepInSeconds(1); 
			sum *= i; 
			System.out.println(getName() + ": multiplication -> " + sum);
		}
	}
	
	private void sleepInSeconds(int seconds) throws InterruptedException {
		// 
		TimeUnit.SECONDS.sleep(seconds);
	}
}