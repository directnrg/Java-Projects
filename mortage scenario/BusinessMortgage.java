package exercise3;

public class BusinessMortgage extends Mortgage{
    
    public BusinessMortgage(int mortgageNumber, String customerName, double mortgageAmount, double interestRate, int mortgageTerm)
    {
    	//interest rate is 1% over the current prime rate
          super(mortgageNumber, customerName, mortgageAmount, (interestRate + 1), mortgageTerm);
          
    }
    
}
