package old.ch04.step01.singleton;

public class Client implements Runnable {

	public static void main(String[] args) {
		doThread();
	}
	
	public static void doThread() {
		final int count = 1000;
		
		for (int i = 0; i < count; i++) {
			new Thread(new Client(), "Client-" + i).start();;
		}
	}

	@Override
	public void run() {
		DataBaseInfo dbInfo = DataBaseInfo.getInstance();
		System.out.println(dbInfo.toString() + ", " + dbInfo.getDbUrl());
	}
}










