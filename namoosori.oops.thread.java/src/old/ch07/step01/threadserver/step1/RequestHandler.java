package old.ch07.step01.threadserver.step1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RequestHandler implements Runnable {

	private Socket socket;
	
	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		handle();
	}

	public void handle() {
		
		InputStream is = null;
		OutputStream os = null;

		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
			// 요청처리
			byte[] buffer = new byte[1024];
			is.read(buffer);
			String requestMessage = new String(buffer);
			System.out.println("Request: " + Thread.currentThread().getName() + " : " + requestMessage);
			
			// 로직 처리...
			
			// 응답처리
			String response = "Hello client";
			os.write(response.getBytes());
			os.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {
			try {
				if (socket != null) socket.close();
				if (is != null) is.close();
				if (os != null) os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}























