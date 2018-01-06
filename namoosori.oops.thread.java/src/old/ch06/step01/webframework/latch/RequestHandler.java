package old.ch06.step01.webframework.latch;

import java.util.concurrent.CountDownLatch;

public class RequestHandler implements Runnable {

	private LoginController controller;
	private String request;
	private CountDownLatch latch;
	
	public RequestHandler(LoginController controller, String request, CountDownLatch latch) {
		this.controller = controller;
		this.request = request;
		this.latch = latch;
	}
	
	@Override
	public void run() {
		this.controller.login(request);
		latch.countDown();
	}

}
