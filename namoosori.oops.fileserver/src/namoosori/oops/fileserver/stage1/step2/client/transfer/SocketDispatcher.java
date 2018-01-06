package namoosori.oops.fileserver.stage1.step2.client.transfer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import namoosori.oops.fileserver.stage1.util.DispatchFailException;
import namoosori.oops.fileserver.stage1.util.RequestMessage;
import namoosori.oops.fileserver.stage1.util.ResponseMessage;
import namoosori.oops.fileserver.stage1.util.SocketWorker;

public class SocketDispatcher {
	//
	private static final int TIME_OUT_IN_SECONDS = 3; 
	
	private SocketWorker socketWorker;
	
	private SocketDispatcher(String serverIp, int listeningPort) {
		//
		this.socketWorker = createSocketWorker(serverIp, listeningPort);
	}

	public static SocketDispatcher getInstance(String ip, int port) {
		return (new SocketDispatcher(ip, port)); 
	}

	public void close() {
		this.socketWorker.closeSocket(); 
	}
	
	public ResponseMessage dispatchReturn(RequestMessage message) throws IOException {
		//
		socketWorker.writeMessage(message.toJson());
		String json = socketWorker.readMessage();
		
		return ResponseMessage.fromJson(json); 
	}

	public void dispatchVoid(RequestMessage message) throws IOException {
		//
		socketWorker.writeMessage(message.toJson());
	}

	private  SocketWorker createSocketWorker(String serverIp, int listeningPort) {
		//
		Socket socket = this.prepareSocket(serverIp, listeningPort);
		return (new SocketWorker(socket));
	}

	private Socket prepareSocket(String serverIp, int listeningPort) {
		//
		Socket socket = null; 
		try {
			socket = new Socket();			// Can't assign requested address
			socket.setSoLinger(true, 0); 	// Can't assign requested address
			socket.setReuseAddress(true);
			socket.connect(new InetSocketAddress(serverIp, listeningPort), TIME_OUT_IN_SECONDS*1000);
		} catch (UnknownHostException e) {
			throw new DispatchFailException(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new DispatchFailException(e.getMessage());
		} 
		
		return socket; 
	}
}
