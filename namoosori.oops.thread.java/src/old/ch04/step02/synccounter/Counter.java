package old.ch04.step02.synccounter;

import java.util.concurrent.atomic.AtomicInteger;

import old.ch04.step02.synccounter.integer.AsyncInteger;
import old.ch04.step02.synccounter.integer.AtomicIntegerExtender;
import old.ch04.step02.synccounter.integer.AtomicIntegerWrapper;
import old.ch04.step02.synccounter.integer.SyncInteger;


public class Counter {

	private int count;
	private SyncInteger syncCount = new SyncInteger(0);
	private AtomicInteger atomicCount = new AtomicInteger(0);
	private AtomicIntegerExtender atomicExtenderCount = new AtomicIntegerExtender();
	private AtomicIntegerWrapper atomicWrapperCount = new AtomicIntegerWrapper();
	private AsyncInteger asyncInteger = new AsyncInteger(0);
	
	private String str = "hello";
	
	
	public void increament() {
		System.out.println("Start " + Thread.currentThread().getName());
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 1. 기본연산, 동기화 안함
		this.count ++;
		
		// 2. 동기화, 메소드 혹은 블록 단위
		synchronized (this) {
			this.count++;
		}
		
		// 3. 동기화 객체를 분리 -> get에도 동기화가 필요하기 때문에 성능저하 큼
		this.syncCount.plusOne();
		
		// 4-1. 동기화 제공 객체 사용
		atomicCount.getAndIncrement();
		
		// 4-2. 기본 동기화 객체 확장1 - 상속
		atomicExtenderCount.getAndIncrement();	// 기본 기능
		atomicExtenderCount.plusOne();			// 확장 기능
		
		// 4-3. 기본 동기화 객체 확장2 - Wrapping(Aggregation)
		atomicWrapperCount.incrementAndGet();
		atomicWrapperCount.plusOne();
		
		// 3-2. 동기화 객체를 분리, 조회는 비동기로 처리
		this.asyncInteger.plusOne();
		
		System.out.println("End " + Thread.currentThread().getName());
	}
	public void increament(int value) {
		System.out.println("Start " + Thread.currentThread().getName());
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 1. 기본연산
		count += value;
		
		System.out.println("End " + Thread.currentThread().getName());
	}
	
	// 동기화가 필요한 변수에 접근하기 때문에 get 메소드에도 동기화 필요
	public synchronized int getCount() {
		return count;
	}
	
	// 객체로 분리하면서 동기화 필요 없어짐 (syncCount, atomicCount 등)
	public int getSyncCount() {
		return syncCount.get();
	}
	
	
	public static void main(String[] args) {
		
		Counter counter = new Counter();
		
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					counter.increament();
				}
			}, "increament()-" + i);
			thread.start();
		}
		
		for (int i = 0; i < 10; i++) {
			Thread thread2 = new Thread(new Runnable() {
				@Override
				public void run() {
					counter.increament(10);
				}
			}, "increament(int value)-" + i);
			thread2.start();
		}
		
		
		// -> 무조건 값이 바뀌는 Immutable 객체(String, PrimitiveWrapper)나 잠금의 기준이 되는 객체를 변경하면 동기화가 깨질 수 있음 
		synchronized (counter.str) {
			
			// 문자열 객체가 변경 되면서 정상적인 동기화 처리가 안됨.
			counter.str = "world";
			// 로직 수행..
			// 이 시점에 다른 쓰레드가 동기화 메소드를 호출하면 잠금객체의 기준이 다르기 때문에 동시에 수행 됨.
		}
	}
	

}
