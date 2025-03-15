package lr2;

public class BankTask {
	public static void main(String[] args) {
		SberbankAccount account = new SberbankAccount(100);
		account.printInfo();
		account.deposit(500);
		account.withdraw(120.17);
		account.withdraw(2000);
		System.out.println();
		account.printInfo();
	}
}

interface BankAccount {
	void printInfo();
	void deposit(double amount);
	void withdraw(double amount);
	double getBalance();
}

class SberbankAccount implements BankAccount {
	private double balance;
	
	public SberbankAccount() { }
	
	public SberbankAccount(double initialAmount) {
		balance = initialAmount;
	}
	
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Пополнение счета на сумму: " + amount);
		System.out.println("Баланс счета составляет: " + getBalance());
	}

	public void withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
			System.out.println("Снятие со счета на сумму: " + amount);
			System.out.println("Баланс счета составляет: " + getBalance());
		} else if (amount < 0) {
			System.out.println("Введите корректную сумму для снятия");
		} else {
			System.out.println("Недостаточно средств на счете");
			System.out.println("Доступно для снятия: " + getBalance());
		}
	}

	public double getBalance() {
		return balance;
	}
	
	public void printInfo() {
		System.out.println("Добрый день!");
		System.out.println("На текущий момент ваш баланс составляет: " + getBalance() + "\n");
	}
	
}