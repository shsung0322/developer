package old.ch05.step03.publishing;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		
		final int roopCount = 10;
		UserManager manager = new UserManager();
		
		for (int i = 0; i < roopCount; i++) {
			int userId = i;
			Thread thread = new Thread(new Runnable() {
				public void run() {
					manager.addUser(new User(String.valueOf(userId), "user-" + userId));
				}
			});
			thread.start();
		}
		
		Thread.sleep(500);
		manager.getUser(0);

		
		
	}
}
