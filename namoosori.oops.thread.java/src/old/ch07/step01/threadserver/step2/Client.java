package old.ch07.step01.threadserver.step2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;

public class Client implements Runnable {

	private static final int SERVER_PORT = 9001;
	private static final int REQUEST_COUNT = 10;
	
	private CountDownLatch latch;
	
	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		CountDownLatch latch = new CountDownLatch(REQUEST_COUNT);
		
		for (int i = 0; i < REQUEST_COUNT; i++) {
			new Thread(new Client(latch)).start();
			Thread.sleep(1);
		}
		latch.await();
		long endTime = System.currentTimeMillis();
		System.out.println("시간: " + (endTime - startTime));
	}
	
	public Client(CountDownLatch latch) {
		this.latch = latch;
	}
	
	public void run() {
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;
		
		try {
			socket = new Socket("localhost", SERVER_PORT);
			os = socket.getOutputStream();
			String request = "Hello Server!!";
			os.write(request.getBytes());
			os.flush();
			
			is = socket.getInputStream();
			byte[] resByte = new byte[1024];
			is.read(resByte);
			System.out.println("Res: " + Thread.currentThread().getName() + " : " + new String(resByte));
			os.flush();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) socket.close();
				if (os != null) os.close();
				if (is != null) is.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.latch.countDown();
		}
	}
}








