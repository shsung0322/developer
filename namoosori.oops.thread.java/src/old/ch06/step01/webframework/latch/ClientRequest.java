package old.ch06.step01.webframework.latch;

import java.util.concurrent.CountDownLatch;

public class ClientRequest {
	//
	public static void main(String[] args) {
		doMvc();
	}
	
	public static void doMvc() {
		LoginController controller = new LoginController();
		final int count = 1000;
		
		CountDownLatch latch = new CountDownLatch(count);
		
		for (int i = 0; i < count; i++) {
			RequestHandler handler = new RequestHandler(controller, String.valueOf(i), latch);
			Thread thread = new Thread(handler, "Handler-" + i);
			thread.start();
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("doMvc 종료");
	}
	
	
	
	
	
	
}
