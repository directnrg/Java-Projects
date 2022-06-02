package exercise3;

public class PersonalMortgage extends Mortgage{
    
	public PersonalMortgage(int mortgageNumber, String customerName, double mortgageAmount, double interestRate, int mortgageTerm)
    {
		//interest rate is 2% over the current prime rate.  
		super(mortgageNumber, customerName, mortgageAmount, (interestRate + 2), mortgageTerm);
        
    }
}
