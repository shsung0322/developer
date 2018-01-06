package old.ch05.step03.publishing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager {
	
	private final List<User> users = new ArrayList<>();
	// 쓰레드 안전한 List
	private final List<User> syncUsers = Collections.synchronizedList(new ArrayList<>());
	
	private final Map<String, User> userConcurrentMap = new ConcurrentHashMap<>();	
	private final Map<String, User> userSyncMap = Collections.synchronizedMap(new ConcurrentHashMap<>());
	
	
	public synchronized void addUser(User user) {
		users.add(user);
	}
	public synchronized void modifyUser(int index, String id, String name) {
		User user = users.get(index);
		user.setId(id);
		user.setName(name);
	}
	public synchronized void removeUser(int index) {
		users.remove(index);
	}
	
	// 동기화와 관련 된 객체(users, user)는 공개하면 안됨. 밖에서 어떻게 사용하느냐에 따라 동기화 보장을 못함.
	public List<User> getUsers() {
		return users;
	}
	public User getUser(int index) {
		return users.get(index);
	}
	
	// 방안 1. users를 조회는 하되, 변경 못하도록 하여 동기화에 문제가 안생기도록 수정
	//        -> List를 수정할 수가 없음..
	// 방안 1. user 객체의 setter를 제거하여 변경 못하도록 한다.
	
	
	// 방안 2. users를 copy하여 준다. 수정 하더라도 객체가 다르기 때문에 동기화 문제 안생김
	//        -> 메모리 사용 주의. 요청이 몰릴수록 한번에 많은 메모리를 사용할 수가 있음.
	public List<User> getCopiedUsers() {

		List<User> copiedUsers = new ArrayList<>();

		
		for (User user: users) {
//			copiedUsers.add(new User(user.getId(), user.getName()));
			copiedUsers.add(user.clone());
		}
		return copiedUsers;
	}
	public User getCopiedUser(int index) {
		return users.get(index).clone();
	}
	
	// 방안 3. 동기화 처리를 users나 user에 위임한다. 
	public List<User> getSyncUsers() {
		return users;
	}
	public User getSyncUser(int index) {
		return users.get(index);
	}
	
	
	// 객체가 리턴값 뿐만 아니라 이런 상황으로도 유출될 수 있음.
	public void concatAt(List<User> list) {
		list.addAll(users);
	}
}
