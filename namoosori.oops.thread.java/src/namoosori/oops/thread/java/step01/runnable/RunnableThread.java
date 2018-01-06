package namoosori.oops.thread.java.step01.runnable;

public class RunnableThread implements Runnable {
	//
	public void run() {
		//
		String name = Thread.currentThread().getName(); 
		System.out.println(this.getClass().getSimpleName() + ": My thread name is " + name); 
	}
}