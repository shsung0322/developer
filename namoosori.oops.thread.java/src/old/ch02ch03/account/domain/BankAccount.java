package old.ch02ch03.account.domain;

import java.util.concurrent.TimeUnit;

public class BankAccount {
	//
	private Integer balance;
	private int defaultAmount;
	private String name;

	public BankAccount(int balance, String name) {
		//
		this.balance = balance;
		this.name = name;
		this.defaultAmount = 40;
	}
	
	public boolean withdraw(int amount) {
		// 출금과정..
		this.sleepInMillis(1);
		
		// 1. 단순계산
		if (this.balance >= amount) {
			int balance = this.balance;
			balance = balance - amount;
			this.balance = balance;
			
			return true;
		}
		else {
			return false;
		}
		
		// 2. 증감대입 연산자를 통한 계산
//		this.balance -= amount;
		
		// 3. 객체 동기화
		/*
		synchronized (this) {
			if (this.getBalance() >= amount) {
				balance -= amount;
				int balance = this.getBalance();
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				balance = balance - amount;
				this.balance = balance;
				return true;
			} else {
				return false;
			}
		}
		//*/
		
		// 4. 부분 동기화
		/*
		synchronized (balance) {
			if (this.getBalance() >= amount) {
				balance -= amount;
				int balance = this.getBalance();
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				balance = balance - amount;
				this.balance = balance;
				return true;
			}
			else {
				return false;
			}
		}
		*/
	}
	
	public boolean withdraw() {
		// 출금과정..
		this.sleepInMillis(1);
		
		synchronized (this) {
			if (this.getBalance() >= this.defaultAmount) {
				balance -= this.defaultAmount;
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public int getBalance() {
		return balance;
	}
	public String getName() {
		return name;
	}
	
	private void sleepInMillis(int millis) {
		// 
		try {
			TimeUnit.MILLISECONDS.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
}
