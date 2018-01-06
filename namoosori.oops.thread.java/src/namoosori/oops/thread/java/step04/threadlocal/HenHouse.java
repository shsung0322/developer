package namoosori.oops.thread.java.step04.threadlocal;

public class HenHouse {
	//
	public static void main(String[] args) {
		// 
		try {
			startDemo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	private static void startDemo() throws InterruptedException {
		// 
		String name = "chick"; 
		Hen sharedHen = new Hen(name); 
		
		Thread henThread1 = new Thread(sharedHen); 
		Thread henThread2 = new Thread(sharedHen); 
	
		henThread1.start(); 
		henThread2.start(); 
		
		henThread1.join();
		henThread2.join(); 
	}
}