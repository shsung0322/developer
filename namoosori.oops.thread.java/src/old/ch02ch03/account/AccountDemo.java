package old.ch02ch03.account;

import old.ch02ch03.account.domain.AccountUser;
import old.ch02ch03.account.domain.BankAccount;
import old.ch02ch03.account.logic.AccountProcessor;

public class AccountDemo {
	//
	public static void main(String[] args) {
		//
		AccountDemo demo = new AccountDemo(); 
		demo.start(); 
	}
	
	public void start() {
		//
		BankAccount account = new BankAccount(100, "KB");
		AccountUser kang = new AccountUser("kang");
		AccountUser kim = new AccountUser("kim");

		AccountProcessor thread1 = new AccountProcessor("kim", account, 30);
		thread1.setPriority(Thread.MAX_PRIORITY);
		AccountProcessor thread2 = new AccountProcessor("kang", account, 30);
		thread2.setPriority(Thread.MIN_PRIORITY);
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join(3000);
			thread2.join(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main process 종료");
	}
	
	
	// 시작
//	AccountUser[] users = new AccountUser[]{user1, user2};
//	Random random = new Random(System.currentTimeMillis());
//	
//	for (int i = 0; i < 10; i++) {
//		int randomResult = random.nextInt(2);
//		users[randomResult].withDraw(account, 30);
//	}
}