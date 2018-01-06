package old.ch06.step02.webframework.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ClientRequest {
	//
	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		doMvc();
		System.out.println(new LoginController());
	}
	
	public static void doMvc() throws InterruptedException, ExecutionException {
		LoginController controller = new LoginController();
		final int count = 1000;
		
		
		List<LoginController> controllers = new ArrayList<>(1000);
		
		for (int i = 0; i < count; i++) {
//			RequestHandler handler = new RequestHandler(controller, String.valueOf(i), latch);
//			Thread thread = new Thread(handler, "Handler-" + i);
//			thread.start();
			RequestHandler handler = new RequestHandler(controller, String.valueOf(i));
			FutureTask<LoginController> task = new FutureTask<>(handler);
			Thread thread = new Thread(task);
			thread.start();
			
			LoginController resultController = task.get();
			controllers.add(resultController);
		}
		System.out.println("doMvc 종료");
	}
	
	
	
	
	
	
}
