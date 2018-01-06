package namoosori.oops.thread.java.step03.interference1;

class Counter {
	//
	private int amount;

	public Counter() {
		//
		this.amount = 0;
	}

	public int increase() {
		//
		return ++amount;
	}

	public int decrease() {
		//
		return --amount;
	}

	public int getAmount() {
		//
		return amount;
	}
}