package old.ch07.step01.threadserver.step1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {
	
	private static final int SERVER_PORT = 9001;

	public static void main(String[] args) {
		
		ServerSocket server = null;
		System.out.println("Starting server");
		
		try {
			server = new ServerSocket(SERVER_PORT);
			
			while (true) {
				System.out.println("Waiting client..");
				Socket socket = server.accept();
				new Thread(new RequestHandler(socket)).start();
			}
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
}
