package namoosori.oops.fileserver.stage1.step3.server.handler;

import namoosori.oops.fileserver.stage1.util.RequestMessage;
import namoosori.oops.fileserver.stage1.util.ResponseMessage;

public interface FileHandler {
	//
	public ResponseMessage handle(RequestMessage request); 
}