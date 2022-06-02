package exercise3;

public abstract class Mortgage implements MortgageConstants{
    
    private int mortgageNumber;
    private String customerName;
    private double amountOfMortgage;
    private double interestRate;
    private int mortgageTerm;
    
    public Mortgage(int mortgageNumber, String customerName, double amountOfMortgage, double interestRate, int mortgageTerm)
    {
          this.mortgageNumber = mortgageNumber;
          this.customerName = customerName;
          this.interestRate = interestRate;
          
          if(amountOfMortgage > maxMortgageAmount)
                 this.amountOfMortgage = maxMortgageAmount;       
          else
                 this.amountOfMortgage = amountOfMortgage;
          
        //if mortgage term doesn't fit criteria or not chosen, the default value will change to the closest one, descending.
          if(mortgageTerm == 0) {
              this.mortgageTerm = shortTerm;     
          }
          else if (mortgageTerm == 2) {
        	  this.mortgageTerm = shortTerm;
          }
          else if (mortgageTerm == 4) {
        	  this.mortgageTerm = medTerm;
          }
          else if (mortgageTerm > 5 ) {
        	  this.mortgageTerm = longTerm;
          }
          else
             this.mortgageTerm = mortgageTerm;
    }
    
    public void getMortgageInfo()
    {
    	  System.out.printf(" Customer Name: %s \n", customerName);
    	  System.out.printf(" Mortgage Number: %s \n", mortgageNumber);
          System.out.printf(" Bank Name: %s \n", bankName);
          System.out.printf(" Mortgage Amount: $%.2f \n", amountOfMortgage);
          System.out.printf(" Interest rate: %% %.0f \n", interestRate  );
          System.out.printf(" Mortgage Term: %d years \n", mortgageTerm );
          double deptBalance = amountOfMortgage + (amountOfMortgage * interestRate * mortgageTerm)/100;
          
          System.out.printf(" Total debt after %d years: $%.2f \n", mortgageTerm, deptBalance);
          System.out.println("----------------------");
    }
}

