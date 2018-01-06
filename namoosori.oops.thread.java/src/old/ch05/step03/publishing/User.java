package old.ch05.step03.publishing;

public class User implements Cloneable {
	
	volatile private String id;
	volatile private String name;
	volatile private String lastName;
	volatile private String firstName;

	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	protected User clone()  {
		return new User(id, name);
	}

	// lastName과 firstName 두개가 한번에 처리되어야 유효한 값이기 때문에, volatile이나 atomic만으로는 동기화 힘듦
	public synchronized void setName(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
