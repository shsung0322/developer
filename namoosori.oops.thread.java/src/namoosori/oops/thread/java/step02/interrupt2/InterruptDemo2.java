package namoosori.oops.thread.java.step02.interrupt2;

import java.util.concurrent.TimeUnit;

public class InterruptDemo2 {

	public static void main(String[] args) throws InterruptedException {
		// 
		InterruptDemo2 demo2 = new InterruptDemo2(); 
		demo2.show();  
	}
	
	public void show() throws InterruptedException {
		// 
		String threadName = Thread.currentThread().getName(); 
		System.out.println(threadName + ": Started... \n"); 

		NumberAccumulator message = new NumberAccumulator(); 
		message.start(); 

		TimeUnit.SECONDS.sleep(4);

		System.out.println("\n" + threadName + ": Interrupting... "); 
		message.interrupt(); 
		
		System.out.println("\n" + threadName + ": End... "); 
	}
}