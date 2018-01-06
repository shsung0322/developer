package namoosori.oops.thread.java.step05.executor1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {
	//
	ExecutorService fixedExecutorService = Executors.newFixedThreadPool(10);
	ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();

	public static void main(String[] args) {
		// 
		List<Multiplier> multipliers = new ArrayList<>(); 
		
		for (int i=1; i<=20; i++) {
			multipliers.add(new Multiplier(i)); 
		}

		ExecutorServiceDemo demo = new ExecutorServiceDemo(); 
		demo.startFixedExecutor(multipliers);
		demo.sleepInSeconds(1);
		System.out.println("\n...");
		
		demo.startSingleExecutor(multipliers); 
		demo.sleepInSeconds(2);
		demo.shutdown(); 
	}
	
	private void startFixedExecutor(List<Multiplier> multipliers) {
		// 
		for(Multiplier multiplier : multipliers) {
			fixedExecutorService.execute(multiplier);
		}
	}
	
	private void startSingleExecutor(List<Multiplier> multipliers) {
		// 
		for(Multiplier multiplier : multipliers) {
			singleExecutorService.execute(multiplier);
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
		singleExecutorService.shutdown();
		
		System.out.println("\nEnd...");
	}
}