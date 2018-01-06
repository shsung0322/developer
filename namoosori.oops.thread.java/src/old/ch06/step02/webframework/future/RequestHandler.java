package old.ch06.step02.webframework.future;

import java.util.concurrent.Callable;

public class RequestHandler implements Callable<LoginController> {

	private LoginController controller;
	private String request;
	
	public RequestHandler(LoginController controller, String request) {
		this.controller = controller;
		this.request = request;
	}
	

	@Override
	public LoginController call() throws Exception {
		this.controller.login(request);
		return this.controller;
	}

}
