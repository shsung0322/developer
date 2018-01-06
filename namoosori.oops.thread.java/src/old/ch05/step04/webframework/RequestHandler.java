package old.ch05.step04.webframework;

public class RequestHandler implements Runnable {

	private LoginController controller;
	private String request;
	
	public RequestHandler(LoginController controller, String request) {
		this.controller = controller;
		this.request = request;
	}
	
	@Override
	public void run() {
		this.controller.login(request);
	}

}
