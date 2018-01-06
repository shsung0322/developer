package old.ch05.step04.webframework;

import java.util.ArrayList;
import java.util.List;

public class ClientRequest {
	//
	public static void main(String[] args) {
//		long startTime = System.currentTimeMillis();
		doMvc();
//		long endTime = System.currentTimeMillis();
//		System.out.println(LoginController.loginCount);
//		System.out.println("수행시간: " + (endTime - startTime));
	}
	
	public static void doMvc() {
		LoginController controller = new LoginController();
		final int count = 1000;
		
		List<Thread> threadPool = new ArrayList<>(count);
		
		for (int i = 0; i < count; i++) {
			RequestHandler handler = new RequestHandler(controller, String.valueOf(i));
			Thread thread = new Thread(handler, "Handler-" + i);
			thread.start();
			threadPool.add(thread);
		}
		for (Thread thread : threadPool) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("doMvc 종료");
	}
	
	public static void doStruts() {
		final int count = 10000;
		
		List<Thread> threadPool = new ArrayList<>(count);
		
		for (int i = 0; i < count; i++) {
			RequestHandler handler = new RequestHandler(new LoginController(), String.valueOf(i));
			Thread thread = new Thread(handler, "Handler-" + i);
			thread.start();
			threadPool.add(thread);
		}
		for (Thread thread : threadPool) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
