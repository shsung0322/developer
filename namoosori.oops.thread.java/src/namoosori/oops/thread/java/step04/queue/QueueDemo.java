package namoosori.oops.thread.java.step04.queue;

public class QueueDemo {
	//
	public static void main(String[] args) {
		// 
		startDemo(); 
	}
	
	private static void startDemo() {
		// 
		MyBlockingQueue queue = new MyBlockingQueue(100); 
		
		Producer producer = new Producer(queue); 
		Consumer consumer1 = new Consumer(queue); 
		Consumer consumer2 = new Consumer(queue); 
	
		producer.start(); 
		consumer1.start(); 
		consumer2.start(); 
	}
}