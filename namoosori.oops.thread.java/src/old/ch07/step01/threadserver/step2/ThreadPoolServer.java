package old.ch07.step01.threadserver.step2;

import java.util.Scanner;

public class ThreadPoolServer {
	
	private RequestListener listener;
	private Console console;
	
//	private boolean listenerRunning;
//	private boolean consoleRunning;
	
	private Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		new ThreadPoolServer().startServer();
	}
	
	public ThreadPoolServer() {
		this.listener = new RequestListener();
		this.console = new Console(this, this.scanner);
	}
	
	
	private void startServer() {
		System.out.println("[Server] Starting server");
		initailize();
	}
	
	private void initailize() {
		
		startListener();
		
		while (true) {
			
			if (!console.isRunning()) {
				System.out.println("[Server] command 입력: ");
				String command = scanner.nextLine();
				if ("start console".equals(command)) {
					startConsole();
				}
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void startConsole() {
		System.out.println("[Server] Starting console");
		
		this.console.initialize();
		Thread thread = new Thread(console, "Console-1");
		thread.start();
	}
	
	public void startListener() {
		if (!listener.isRunning()) {
			listener.initialize();
			Thread listenerThread = new Thread(this.listener, "Listener-1");
			listenerThread.start();
			System.out.println("[Server] Starting listen for request");
		}
		else {
			System.out.println("[Server] 리스너가 이미 실행중입니다.");
		}
	}
	
	public void stopListener() {
		if (this.listener.isRunning()) {
			this.listener.setRunning(false);
			this.listener.setRunning(false);
			
			System.out.println("[Server] 리스너를 종료합니다.");
		}
		else {
			System.out.println("[Server] 리스너가 실행중이 아닙니다.");
		}
	}
	
	public boolean isListenerRunning() {
		return listener.isRunning();
	}
	
	
	
}
