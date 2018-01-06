package namoosori.oops.thread.java.step01.thread;

public class ObjectThreadDemo {
	//
	public static void main(String args[]) {
		//
		ObjectThreadDemo demo = new ObjectThreadDemo();
		demo.show(); 
	}
	
	public void show() {
		// 
		String threadName = "ObjectThread"; 
		ObjectThread objectThread = new ObjectThread(threadName); 
		objectThread.start(); 
		
		try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		objectThread.finish(); 
		
		String name = Thread.currentThread().getName(); 
		System.out.println("ObjectThreadDemo: My thread name is " + name); 
	}
	
	
}