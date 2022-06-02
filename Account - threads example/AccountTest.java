package Exercise1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Account> bankAccounts = new ArrayList<>();

		ExecutorService executor = Executors.newFixedThreadPool(4);

		// starting Account 1
		Account acc1 = new Account(500, "Account 1");
		// starting balance Account 2
		Account acc2 = new Account(200, "Account 2");
		// starting balance Account 3
		Account acc3 = new Account(500, "Account 3");
		// starting balance Account 4
		Account acc4 = new Account(0, "Account 4");
		// starting balance Account 5
		Account acc5 = new Account(300, "Account 5");
		// starting balance Account 6
		Account acc6 = new Account(0, "Account 6");
		// starting balance Account 7
		Account acc7 = new Account(300, "Account 7");
		// starting balance Account 8
		Account acc8 = new Account(300, "Account 8");

		bankAccounts.add(acc1);
		bankAccounts.add(acc2);
		bankAccounts.add(acc3);
		bankAccounts.add(acc4);
		bankAccounts.add(acc5);
		bankAccounts.add(acc6);
		bankAccounts.add(acc7);
		bankAccounts.add(acc8);

		for (int a = 0; a < bankAccounts.size(); a++) {
			executor.execute(bankAccounts.get(a));
		}

		executor.shutdown();

//		executor.execute(acc1);
//		executor.execute(acc1);
//		executor.execute(acc1);
//		executor.execute(acc1);
//		executor.execute(acc1);
//		executor.execute(acc1);
//		executor.execute(acc1);
//		executor.execute(acc1);
//		executor.execute(acc1);
//		executor.execute(acc1);
//		executor.execute(acc1);
//		executor.execute(acc2);
//		executor.execute(acc3);
//		executor.execute(acc4);
//		executor.execute(acc4);
//		executor.execute(acc4);
//		executor.execute(acc4);
//		executor.execute(acc4);
//		executor.execute(acc5);
//		executor.execute(acc1);
//		executor.execute(acc6);
//		executor.execute(acc7);
//		executor.execute(acc7);
//		executor.execute(acc7);
//		executor.execute(acc7);
//		executor.execute(acc8);

	}
}
