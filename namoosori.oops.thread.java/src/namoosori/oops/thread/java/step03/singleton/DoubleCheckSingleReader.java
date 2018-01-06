package namoosori.oops.thread.java.step03.singleton;

public class DoubleCheckSingleReader {
	//
	private static DoubleCheckSingleReader singleReader;

	private static String name;

	private DoubleCheckSingleReader() {
		//
	}

	public static DoubleCheckSingleReader getInstance() {
		//
		if (singleReader == null) {
			synchronized (DoubleCheckSingleReader.class) {
				if (singleReader == null) {
					singleReader = new DoubleCheckSingleReader();
				}
			}
		}

		return singleReader;
	}

	public static String getName() {
		//
		if (name == null) {
			synchronized (DoubleCheckSingleReader.class) {
				name = "Hello";
			}
		}

		return name;
	}

}