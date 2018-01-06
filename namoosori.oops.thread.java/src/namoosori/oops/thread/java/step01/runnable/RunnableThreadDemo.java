package namoosori.oops.thread.java.step01.runnable;

public class RunnableThreadDemo {
	//
	public static void main(String args[]) {
		//
		RunnableThreadDemo demo = new RunnableThreadDemo(); 
		demo.show(); 
	}
	
	public void show() {
		// 
		(new Thread(new RunnableThread())).start();
		String name = Thread.currentThread().getName(); 
		System.out.println("RunnableThreadDemo: My thread name is " + name); 
	}
}