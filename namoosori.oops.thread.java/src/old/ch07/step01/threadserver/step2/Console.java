package old.ch07.step01.threadserver.step2;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Console implements Runnable {

	private ThreadPoolServer server;
	private AtomicBoolean running;
	private Scanner scanner;
	
	public Console(ThreadPoolServer server, Scanner scanner) {
		this.server = server;
		this.running = new AtomicBoolean(false);
		this.scanner = scanner;
	}
	
	@Override
	public void run() {
		System.out.println("[Console] Console을 실행합니다.");
		
		while (running.get()) {
			String menuNo = displayAndInputMenu();
			switch (menuNo) {
			case "1":
				System.out.println("[Console] Listener state: " + server.isListenerRunning());
				break;
			case "2":
				server.startListener();
				break;
			case "3":
				server.stopListener();
				break;
			case "4":
				System.out.println("[Console] Console을 종료합니다.");
				this.running.set(false);
				break;
			default :
				System.out.println("[Console] 입력을 잘못 하셨습니다.");
			}
		}
		// 마무리 작업
		System.out.println("[Console] Console이 종료 되었습니다.");
	}
	
	public String displayAndInputMenu() {
		System.out.println("Select menu ---------------------------------");
		System.out.println("1: show listener state");
		System.out.println("2: start listener");
		System.out.println("3: shutdown listener");
		System.out.println("4: Exit");
		System.out.println("[Console] select: ");
		System.out.println("---------------------------------------------");
		
		return scanner.nextLine();
	}

	public void initialize() {
		this.running.set(true);
	}
	public boolean isRunning() {
		return running.get();
	}

}
