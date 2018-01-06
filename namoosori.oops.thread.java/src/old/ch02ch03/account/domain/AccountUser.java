package old.ch02ch03.account.domain;

public class AccountUser {
	//
	private String name;
	
	public AccountUser(String name) {
		//
		this.name = name;
	}
	
	public void withdraw(BankAccount bankAccount, int amount) {
		//
		if (bankAccount.withdraw(amount)) {
			System.out.println("정상 출금");
		}
		// 안내 메시지
		else {
			System.out.println(name + " 잔액부족 -> " + bankAccount.getName() + " : " + bankAccount.getBalance());
		}
	}
}
