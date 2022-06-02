package exercise1;

import java.util.Scanner;

public class Driver {
	private final static int MAX_AMOUNT_OF_INSURANCES = 2; // Only 2 insurances available

	public static void main(String[] args) {

		int i = 0; // counter
		Insurance ArrayOfInsurances[] = new Insurance[MAX_AMOUNT_OF_INSURANCES];
		Scanner userInput = new Scanner(System.in);

		// Only 2 insurances available - loop 2 times
		while (i < MAX_AMOUNT_OF_INSURANCES) {

			System.out.println(
					"Please enter the type of insurance you want: \na. Life \nb. Health \n\nor type 'exit' to end the program");
			String userInsurance = userInput.nextLine();

			if (userInsurance.toLowerCase().equalsIgnoreCase("exit")) {
				System.out.println("----------------------\n");
				System.out.println("You can safely close the program.");
				System.exit(0);
			}


			if (userInsurance.equalsIgnoreCase("a") || userInsurance.equalsIgnoreCase("life")) {

				Life lifeUser = new Life();
				lifeUser.setInsuranceCost();
				System.out.println("----------------------\n");
				lifeUser.displayInfo();
				System.out.println("----------------------\n");
				ArrayOfInsurances[i] = lifeUser;

			}

			else if (userInsurance.equalsIgnoreCase("b") || userInsurance.equalsIgnoreCase("health")) {

				Health healthUser = new Health();
				healthUser.setInsuranceCost();
				System.out.println("----------------------\n");
				healthUser.displayInfo();
				System.out.println("----------------------\n");
				ArrayOfInsurances[i] = healthUser;

			}

			else {
				System.out.println("Please select a correct option.\n");
				i -= 1;
			}

			i++;

		}
		/*
		 * if (i == 3) {
		 * 
		 * System.out.println(ArrayOfInsurances[i].displayInfo()); /*attempt to iterate
		 * over objects with no success. details of user's insurances are displayed
		 * 
		 * }
		 */

		userInput.close();
	}
}
