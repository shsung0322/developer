package namoosori.oops.thread.java.step01.anonymous;

public class AnonymousThreadDemo {
	//
	public static void main(String[] args) {
		//
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ", I'm a main thread.");

		AnonymousThread anonymousThread = new AnonymousThread();
		anonymousThread.startThreads();
	}
}