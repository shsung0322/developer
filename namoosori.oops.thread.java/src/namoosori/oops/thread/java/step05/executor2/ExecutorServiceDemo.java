package namoosori.oops.thread.java.step05.executor2;

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
	
	@SuppressWarnings("rawtypes")
	private void startFixedExecutor(List<Multiplier> multipliers) throws Exception {
		// 
		List<Future> futures = new ArrayList<>(); 
		
		for(Multiplier multiplier : multipliers) {
			Future future = fixedExecutorService.submit(multiplier);
			futures.add(future);  
		}
		
		for(Future future : futures) {
			// 
			if (future.get() != null) {
				System.out.println("Something wrong with : " + future.get().toString()); 
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