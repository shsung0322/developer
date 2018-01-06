package old.ch06.step03.webframework.future2;

import java.util.concurrent.Callable;

public class RequestHandler implements Callable<String> {

	private LoginController controller;
	private String request;
	
	public RequestHandler(LoginController controller, String request) {
		this.controller = controller;
		this.request = request;
	}
	

	@Override
	public String call() throws Exception {
		this.controller.login(request);
		return "Call result: " + Thread.currentThread().getName();
	}

}
