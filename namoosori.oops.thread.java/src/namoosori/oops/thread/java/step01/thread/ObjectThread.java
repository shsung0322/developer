package namoosori.oops.thread.java.step01.thread;

public class ObjectThread extends Thread {
	//
	private boolean endFlag; 
	
	public ObjectThread(String name) {
		// 
		super(name); 
		this.endFlag = false; 
	}
	
	public void finish() {
		// 
		this.endFlag = true; 
	}

	public void run() {
		//
		String name = Thread.currentThread().getName(); 
		int seconds = 0; 
		
		while(true) {
			//
			if (endFlag) {
				break; 
			}
			
			sleepInSeconds(1); 
			
			System.out.println("[" + name + "] I'm still alive..." + "[" + seconds++ + "]" );  
		}

		System.out.println("[" + name + "] Good bye..." );  
	}
	
	private void sleepInSeconds(int seconds) {
		// 
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}