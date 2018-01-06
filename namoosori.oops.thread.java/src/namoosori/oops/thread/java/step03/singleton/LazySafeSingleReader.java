package namoosori.oops.thread.java.step03.singleton;

public class LazySafeSingleReader {
	//
	private static LazySafeSingleReader singleReader; 
	
	private LazySafeSingleReader() {
		// 
	}
	
	public static synchronized LazySafeSingleReader getInstance() {
		// 
		if (singleReader == null) {
			singleReader = new LazySafeSingleReader(); 
		}
		
		return singleReader; 
	}
}