package namoosori.oops.thread.java.step05.semaphore;

import java.util.HashMap;
import java.util.Map;

public class CounterDemo {
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
		Counter singleCounter = new Counter();
		Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>(400);

		CounterHandler handler1 = new CounterHandler(singleCounter, resultMap);
		CounterHandler handler2 = new CounterHandler(singleCounter, resultMap);

		handler1.start();
		handler2.start();

		handler1.join();
		handler2.join();
	}
}