package namoosori.oops.thread.java.step01.anonymous;

public class AnonymousThread {
	//
	public void startThreads() {
		//
		new Thread(new Runnable() {
			public void run() {
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + ", I'm an anonymous thread.");
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + ", I'm another anonymous thread.");
			}
		}).start();
	}
}