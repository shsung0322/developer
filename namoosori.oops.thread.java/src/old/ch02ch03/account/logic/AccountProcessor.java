package old.ch02ch03.account.logic;

import old.ch02ch03.account.domain.AccountUser;
import old.ch02ch03.account.domain.BankAccount;

public class AccountProcessor extends Thread {
	//
	private String userName;
	private BankAccount account;
	private int amount;
	
	public AccountProcessor(String userName, BankAccount account, int amount) {
		//
		this.userName = userName;
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void run() {
		//
		AccountUser user = new AccountUser(this.userName);
		
		for (int i = 0; i < 30; i++) {
			user.withdraw(this.account, this.amount);
		}
	}
}