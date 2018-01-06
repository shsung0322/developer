package namoosori.oops.thread.java.step03.singleton;

public class LazySingleReader {
	//
	private static LazySingleReader singleReader; 
	
	private LazySingleReader() {
		// 
	}
	
	public static LazySingleReader getInstance() {
		// 
		if (singleReader == null) {
			singleReader = new LazySingleReader(); 
		}
		
		return singleReader; 
	}
}