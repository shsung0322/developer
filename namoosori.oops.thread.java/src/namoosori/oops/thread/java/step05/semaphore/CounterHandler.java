package namoosori.oops.thread.java.step05.semaphore;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CounterHandler extends Thread {
	//
	private Counter counter;
	private Map<Integer, Integer> resultMap;

	public CounterHandler(Counter counter, Map<Integer, Integer> resultMap) {
		//
		this.counter = counter;
		this.resultMap = resultMap;
	}

	public void run() {
		//
		boolean duplicated = false;

		for (int i = 0; i < 200; i++) {
			//
			try {
				// int result = counter.nextNoGuard();
				int result = counter.next();

				if (resultMap.containsKey(Integer.valueOf(result))) {
					String threadName = Thread.currentThread().getName();
					System.out.format("Result is duplicated: %d at %s%n ", result, threadName);
					duplicated = true;
					break;
				} else {
					resultMap.put(result, result);
				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				break;
			}
		}

		if (!duplicated) {
			System.out.println("Not duplicated !!");
		}
	}
}