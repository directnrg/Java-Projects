package exercise2;

import javax.swing.JOptionPane;
import java.util.Random;

public class Lotto {
	
	private int[] randomNumbers;
	private static final int MAX_RANGE_NUMBER = 27;
	private static final int MIN_RANGE_NUMBER = 3;
	
	public Lotto() {
		Random random = new Random();
		randomNumbers = new int[3];
		
		for(int i = 0; i < 3; i++)
		{			
			randomNumbers[i] = random.nextInt(9-1)+1;
		}
	}
	
	public int[] getRandomNumbers() {
		return randomNumbers;
	}
	
	public static void main(String[] args) {
		
		Lotto Lottery = new Lotto();
		int[] listOfNumbers = Lottery.getRandomNumbers();
		int sumTotalUser = 0;
		
		for(int i = 0; i < listOfNumbers.length; i++)
		{
			sumTotalUser += listOfNumbers[i];
		}
		
		int userNumberInput = 0;
		boolean userWins = false;
		System.out.print(sumTotalUser);
		
		for (int i = 0; i < 5; i++)
		{
			userNumberInput = Integer.parseInt(JOptionPane.showInputDialog("Insert a number between 3 and 27: "));
			
			if (userNumberInput < MIN_RANGE_NUMBER || userNumberInput > MAX_RANGE_NUMBER)
			{
				JOptionPane.showMessageDialog(null,"Number should be between 3-27");
				userNumberInput = Integer.parseInt(JOptionPane.showInputDialog("Please enter a number between 3 and 27"));
			}
			else if(userNumberInput == sumTotalUser)
			{
				JOptionPane.showMessageDialog(null,"Congratulations! You are a master.");;
				userWins = true;
				break;
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Good luck next time! Try again.");
			}
		}
		if(userWins == false)
		{
			JOptionPane.showMessageDialog(null,"You ran out of chances. GAME OVER. ");
		}
	}
}
