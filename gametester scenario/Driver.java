package exercise2;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the game tester name: ");
		String testerName = scanner.nextLine();

		// prompts users to choose their current Job Status
		System.out.print("Please type the number that fits your current position as a tester:\n"
				+ "1. Full Time Tester\n" + "2. Part Time Tester\n");
		String userInput = scanner.nextLine();

		double testerSalary;
		GameTester Tester; // creates an object of GameTester class

		// depending on selected option, instance of FullTimeGameTester class is created
		if (Integer.parseInt(userInput) == 1) {
			Tester = new FullTimeGameTester();
			Tester.name = testerName;
			Tester.fullStatus = true;
			testerSalary = Tester.salary();

			// displays tester info
			System.out.println("---------------");
			System.out.println("Name: " + testerName + 
					"\nStatus: Full Time Tester" + "\nSalary : $" + testerSalary + " per month");
		} else if (Integer.parseInt(userInput) == 2) {
			System.out.print("Please Type the amount of hours you have worked : "); // if status is part time, prompt
																					// user to input hours worked
			Tester = new PartTimeGameTester(); // creation of instance of PartTimeGameTester class
			Tester.hoursWorked = scanner.nextInt();
			Tester.name = testerName;
			Tester.fullStatus = false;
			testerSalary = Tester.salary();

			// displays tester info as part time tester
			System.out.println("---------------");
			System.out.println("Tester Name: " + testerName + 
					"\nStatus: Part Time Tester" + "\nSalary : $" + testerSalary);

			scanner.close();
		}

	}

}
