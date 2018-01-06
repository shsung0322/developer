package namoosori.oops.thread.java.step05.executor5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {
	//
	public static void main(String[] args) {
		// 
		ExecutorDemo demo = new ExecutorDemo(); 
		// demo.executeRunnableTask(); 
		try {
			demo.executeCallableTasks();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} 
		
		System.out.format("%s: Demo end...\n", Thread.currentThread().getName()); 
	}
	
	@SuppressWarnings("unused")
	private void executeRunnableTask() {
		// 
		ExecutorService excutorService = createExectors(); 
		Runnable runnableTask = getRunnableTask(); 
		excutorService.execute(runnableTask);
	}
	
	private void executeCallableTasks() throws InterruptedException, ExecutionException {
		// 
		ExecutorService executorService = createExectors(); 
		Future<String> future = executorService.submit(getCallableTask()); 
		System.out.format("%s: Future is %s \n", Thread.currentThread().getName(), future.get());
		
		sleepInSeconds(1);
		
		List<Callable<String>> callableTasks = new ArrayList<>(); 
		callableTasks.add(getCallableTask());
		callableTasks.add(getCallableTask());
		callableTasks.add(getCallableTask());
		callableTasks.add(getCallableTask());
		
		String resultStr = executorService.invokeAny(callableTasks); 
		System.out.format("%s: Any result is %s \n", Thread.currentThread().getName(), resultStr); 

		sleepInSeconds(1);

		List<Future<String>> futures = executorService.invokeAll(callableTasks); 
		for(Future<String> oneFuture : futures) {
			System.out.format("%s: One future is %s \n", Thread.currentThread().getName(), oneFuture.get());
		}
	}
	
	private Runnable getRunnableTask() {
		// 
		Runnable runnableTask = () -> {
			try {
				TimeUnit.MICROSECONDS.sleep(400);
				System.out.format("%s: Runned...\n", Thread.currentThread().getName()); 
			} catch (InterruptedException e) {
				e.printStackTrace(); 
			}
		}; 
		
		return runnableTask; 
	}
	
	private Callable<String> getCallableTask() {
		// 
		Callable<String> callableTask = () -> {
			TimeUnit.MILLISECONDS.sleep(400);
			System.out.format("%s: Called...\n ", Thread.currentThread().getName()); 
			return String.format("%s Task", Thread.currentThread().getName()); 
		}; 
		
		return callableTask; 
	}
	
	private ExecutorService createExectors() {
		// 
		return Executors.newFixedThreadPool(10); 
	}
	
	@SuppressWarnings("unused")
	private ExecutorService createExecutorsDirectly() {
		// 
		return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
	}
	
	private void sleepInSeconds(int seconds) {
		// 
		try {
			System.out.println("\n... Sleeping ....\n"); 
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}