package exercise3;

import java.util.Scanner;

public class ProcessMortgage {

	public static void main(String[] args) {

		Mortgage BankMortgages[] = new Mortgage[3]; // array of only 3 mortgages

		double rateOfInterest;
		double amountOfMortgage;
		int mortgageNumber;
		int mortgageTerm;
		String clientName;
		String typeofMortgage;

		Scanner userInput = new Scanner(System.in);

		
		System.out.print(" Please insert the rate of interest: ");
		rateOfInterest = userInput.nextDouble(); // prompts user to input interest rate
		userInput.nextLine();
		System.out.println("");

		for (int i = 0; i < BankMortgages.length; i++) {
			System.out.println("> Mortgage Plan " + (i + 1));
			System.out.println("");
			System.out.print(" Client Name: ");
			clientName = userInput.nextLine();

			System.out.print(" Mortgage Type (Personal or Business) : ");
			typeofMortgage = userInput.nextLine();

			// loop until proper type of mortgage is selected
			while (!typeofMortgage.equalsIgnoreCase("Personal") && !typeofMortgage.equalsIgnoreCase("Business")) {
				System.out.print(" --- ERROR --- Please select a correct option\n The Mortgage could only be 'Personal' or 'Business'. Try Again. ");
				typeofMortgage = userInput.nextLine();
			}

			System.out.print(" Mortgage Number : ");
			mortgageNumber = userInput.nextInt();
			userInput.nextLine();

			System.out.print(" Mortgage Amount : ");
			amountOfMortgage = userInput.nextDouble();

			System.out.print(" Mortgage Term : ");
			mortgageTerm = userInput.nextInt();
			userInput.nextLine();

			System.out.println();

			// personalMortgage or businessMortgage object created based on user input
			
			if (typeofMortgage.equalsIgnoreCase("Personal"))
				BankMortgages[i] = new PersonalMortgage(mortgageNumber, clientName, amountOfMortgage, rateOfInterest,
						mortgageTerm);
			else
				BankMortgages[i] = new BusinessMortgage(mortgageNumber, clientName, amountOfMortgage, rateOfInterest,
						mortgageTerm);
		}

		System.out.println("< List of Mortgages Available >");
		for (int i = 0; i < BankMortgages.length; i++) {
			BankMortgages[i].getMortgageInfo(); // display list of available Mortgages (3)
			System.out.println();
		}
		userInput.close();

	}

}


