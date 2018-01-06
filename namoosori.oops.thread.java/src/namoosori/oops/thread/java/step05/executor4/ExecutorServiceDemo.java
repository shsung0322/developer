package namoosori.oops.thread.java.step05.executor4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {
	//
	ExecutorService executorService;

	public ExecutorServiceDemo() {
		// 
		int  corePoolSize = 10;
		int  maxPoolSize = 30;
		long keepAliveTime = 5000;

		this.executorService =
		        new ThreadPoolExecutor(
		                corePoolSize,
		                maxPoolSize,
		                keepAliveTime,
		                TimeUnit.MILLISECONDS,
		                new LinkedBlockingQueue<Runnable>()
		                );
	}
	
	public static void main(String[] args) throws Exception {
		// 
		List<Multiplier> multipliers = new ArrayList<>(); 
		
		for (int i=1; i<=10; i++) {
			multipliers.add(new Multiplier(i)); 
		}

		ExecutorServiceDemo demo = new ExecutorServiceDemo(); 
		demo.startFixedExecutor(multipliers);
		demo.sleepInSeconds(2);
		demo.shutdown(); 
	}
	
	private void startFixedExecutor(List<Multiplier> multipliers) throws Exception {
		// 
		for(Multiplier multiplier : multipliers) {
			executorService.submit(multiplier);
		}
	}
	
	private void sleepInSeconds(int seconds) {
		//
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	private void shutdown() {
		//
		executorService.shutdown();
		System.out.println("\nEnd...");
	}
}