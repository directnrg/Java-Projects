package exercise2;

public class PartTimeGameTester extends GameTester{
	
	PartTimeGameTester()
    {
		hoursWorked = 0; 
    }

	
	public double salary()
    {
        int hourlyRate = 30;
		return hourlyRate * hoursWorked;     //calculates salary of a part time tester
    }
}