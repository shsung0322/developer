package old.ch06.step03.webframework.future2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LoginController {

	private static final boolean SAFE = true;
	public static AtomicInteger loginCount = new AtomicInteger(0);
	
	private ServiceLogic logic;
	private String unsafeName;
	private ThreadLocal<String> safeName = new ThreadLocal<>();
	
	public LoginController() {
		this.logic = new ServiceLogic();
	}
	
	public String login(String request) {
		//
		if (!isValid(request)) {
			return "400";
		}
//		User user = new User(request.get("userId"));
//		user.setUserId("..")
		
		String user = logic.getUser(request);
		String name = Thread.currentThread().getName();
		
		if (SAFE) {
			this.safeName.set(name);
		} else {
			this.unsafeName = name;
		}
		loggingName();
//		int loginCount = LoginController.loginCount;
		int loginCount = LoginController.loginCount.get();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		LoginController.loginCount = loginCount + 1;
		LoginController.loginCount.incrementAndGet();
		
		Map<String, String> model = new HashMap<>();
		model.put("user", user);
		
		return "200";	// JSP 경로 명시
	}
	
	private void loggingName() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (SAFE) {
			if (Thread.currentThread().getName().equals(this.safeName.get())) {
				System.out.println(this.safeName.get());
			}
			else {
				System.err.println(this.safeName.get());
			}
		}
		else {
			if (Thread.currentThread().getName().equals(this.unsafeName)) {
//				System.out.println(this.unsafeName);
			}
			else {
				System.err.println(this.unsafeName);
			}
		}
	}
	
	private boolean isValid(String request) {
		return request != null && !request.isEmpty();
	}
}

