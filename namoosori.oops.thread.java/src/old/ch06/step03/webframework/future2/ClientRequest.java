package old.ch06.step03.webframework.future2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ClientRequest {
	//
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		doMvc();
	}
	
	public static void doMvc() throws InterruptedException, ExecutionException {
		//
		final int count = 1000;
		
		List<FutureTask<String>> tasks = new ArrayList<>(1000);
		
		for (int i = 0; i < count; i++) {
			RequestHandler handler = new RequestHandler(new LoginController(), String.valueOf(i));
			FutureTask<String> task = new FutureTask<>(handler);
			Thread thread = new Thread(task);
			thread.start();
			
			tasks.add(task);
		}
		List<String> resultStrings = new ArrayList<>();
		
		for (FutureTask<String> task : tasks) {
			resultStrings.add(task.get());
		}
		System.out.println("모든 쓰레드 수행 종료, 결과값 출력 ==============================================");
		for (String result : resultStrings) {
			System.out.println(result);
		}
		
		System.out.println("doMvc 종료");
	}
	
	
	
	
	
	
}
