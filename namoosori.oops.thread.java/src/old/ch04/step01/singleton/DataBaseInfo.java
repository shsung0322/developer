package old.ch04.step01.singleton;

public class DataBaseInfo {
	//
	private static DataBaseInfo instance; // = new SingletonObject();

	private final String dbUrl;

	
	private DataBaseInfo() {
		this.dbUrl = "mysql://localhost:1521/test-db";
		System.out.println("객체 생성: " + Thread.currentThread().getName());
	}
	
	/**
	 * 1. 동기화 미적용
	 * - 단일쓰레드 환경에서만 정상 작동하며, 멀티 쓰레드에서는 여러개의 객체가 생성 될 수 있음 
	 */
	/*
	public static DataBaseInfo getInstance() {
		if (instance == null) {
			buildInstance();
		}
		return instance;
	}
	//*/
	
	/**
	 * 2. 메소드 전체 동기화
	 * - 객체를 조회 해 갈때마다 동기화가 발생하기 때문에, 성능 문제가 있음. 
	 */
	/*
	public synchronized static DataBaseInfo getInstance() {
		if (instance == null) {
			buildInstance();
		}
		return instance;
	}
	//*/
	
	/**
	 * 3. 객체 초기화 부분만 동기화
	 * - instance를 체크하는것과 객체를 초기화 하는 부분이 나뉘어져 있어서 1과 같은 문제가 생김
	 */
	/*
	public static DataBaseInfo getInstance() {
		if (instance == null) {
			synchronized (DataBaseInfo.class) {
				buildInstance();
			}
		}
		return instance;
	}
	//*/
	
	/**
	 * 4. 객체 초기화 부분에서 다시한번 체크 (Double checked locking)
	 * - 로직만 봤을 때는 멀티 쓰레드에서도 문제가 없어 보임. 그러나 instance에 메모리를 할당하고, 생성자를 실행 하는것이 JVM에서는 분리된 과정이기 때문에 극히 낮은 확률로 문제가 발생할 수 있음
	 */
	/*
	public static DataBaseInfo getInstance() {
		if (instance == null) {
			synchronized (DataBaseInfo.class) {
				if (instance == null) {
					buildInstance();
				}
			}
		}
		return instance;
	}
	//*/
	
	/**
	 * 5. Double checked locking에 instance의 메모리 할당과 생성자 실행을 구분하여 나눔.
	 * - JVM에서 컴파일 시 최적화 문제로 4 똑같은 코드로 변경 할 수도 있음
	 */
	public static DataBaseInfo getInstance() {
		if (instance == null) {
			synchronized (DataBaseInfo.class) {
				DataBaseInfo info = instance;
				if (instance == null) {
					synchronized (DataBaseInfo.class) {
						try {
							// 설정 파일로부터 정보 읽어와서 객체 생성..
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						info = new DataBaseInfo();
					}
					instance = info;	// JVM에서 컴파일 시 synchronized 안(라인88)으로 넣어버릴 수 있음(최적화)
				}
			}
		}
		return instance;
	}
	
	/**
	 * 결론: 사실상 완벽한 동기화는 불가능....포기하자
	 *      - 성능에서는 손해를 보더라도 2번과 같이 하던가..
	 *      - static field의 선언과 동시에 초기화를 해버리자... 
	 *        그렇게 되면 쓰레드에서 초기화 하는것이 아닌 JVM영역에서 클래스로딩 시 초기화 하기 때문에
	 *        동기화 문제가 생기지 않는다.
	 */
	
	
	
	
	private static void buildInstance() {
		try {
			// 설정 파일로부터 정보 읽어와서 객체 생성..
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		instance = new DataBaseInfo();
	}
	
	public String getDbUrl() {
		return this.dbUrl;
	}
}
