package Exercise1;

import java.util.Random;

public class Account implements Runnable {
	private int balance;
	private Thread t;
	private String accountName;
	private Random rand;
	private final int MAX_VALUE = 500;

	public int getBalance() {
		return balance;
	}
	
	public Account(int balance, String accountName) {
		// TODO Auto-generated constructor stub
		this.balance = balance;
		this.accountName = accountName;
		rand = new Random();
	}
	

	@Override
	public void run() {

		// TODO Auto-generated method stub
		int temp = (Math.random() <= 0.5) ? 1 : 2;
		int randAmount = rand.nextInt(MAX_VALUE);

		if (temp == 1) {
			withdraw(randAmount);	
			System.out.println("Withdraw of: $" + randAmount + " on " + accountName);
		}

		else if (temp == 2) {
			deposit(randAmount);
			System.out.println("Deposit of: $" + randAmount + " on " + accountName);
		}
		
		System.out.println("The balance in " + accountName + " is: $" +  + this.getBalance());
		
	}

	public synchronized void withdraw(int amount) {
		if (balance <= 0) {
			System.out.println("There is no money in the " + accountName);
		} else if (amount > balance) {
			System.out.println("There is no enough money to withdraw $" + amount + ". Your current balance in " + accountName + " is: $" + balance);
		} else {
			balance -= amount;
		}
	}

	public synchronized void deposit(int amount) {
		balance += amount;
	}

	
	public void threadStart() {
		// TODO Auto-generated method stub
		if (t == null) {
			t = new Thread(this, accountName);
			t.start();
		}
	}
}
