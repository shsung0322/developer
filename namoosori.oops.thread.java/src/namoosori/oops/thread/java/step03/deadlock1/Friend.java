package namoosori.oops.thread.java.step03.deadlock1;

public class Friend {
	//
	private final String name;

	public Friend(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public synchronized void sayHello(Friend friend) {
		//
		System.out.format("%s: %s has said hello to me!%n", this.name, friend.getName());
		System.out.format("     : I have to say hello back to %s!%n", this.name, friend.getName());
		friend.sayHelloBack(this);
	}

	public synchronized void sayHelloBack(Friend bower) {
		//
		System.out.format("%s: %s has said hello back to me!%n", this.name, bower.getName());
	}
}