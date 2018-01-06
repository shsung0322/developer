package namoosori.oops.thread.java.step05.executor3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {
	//
	ExecutorService fixedExecutorService = Executors.newFixedThreadPool(10);

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
		List<Future<Long>> futures = new ArrayList<>(); 
		
		for(Multiplier multiplier : multipliers) {
			Future<Long> future = fixedExecutorService.submit(multiplier);
			futures.add(future);  
		}
		
		for(int i=0; i<futures.size(); i++) {
			// 
			if (futures.get(i).get() == null) { 
				System.out.println("Something wrong with : " + i); 
			} else {
				System.out.format("%d future has a value : %d%n", i, futures.get(i).get()); 
			}
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
		fixedExecutorService.shutdown();
		System.out.println("\nEnd...");
	}
}