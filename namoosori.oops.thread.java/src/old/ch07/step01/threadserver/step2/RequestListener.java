package old.ch07.step01.threadserver.step2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class RequestListener implements Runnable {

	private static final int SERVER_PORT = 9001;
	private final ExecutorService executor = Executors.newFixedThreadPool(30);
	
	private AtomicBoolean running = new AtomicBoolean(false);
	
	
	@Override
	public void run() {
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(SERVER_PORT);
			server.setSoTimeout(5000);
			
			System.out.println("[RequestListener] Listener를 시작합니다.");
			
			while (running.get()) {
				System.out.println("Waiting client..");
				try {
					Socket socket = server.accept();
					executor.execute(new RequestHandler(socket));
				} catch (SocketTimeoutException e) {
				}
			}
			System.out.println("[RequestListener] Listener를 종료합니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (server != null) server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void initialize() {
		this.running.set(true);
	}
	
	public boolean isRunning() {
		return running.get();
	}
	public void setRunning(boolean running) {
		this.running.set(running);
	}

}
