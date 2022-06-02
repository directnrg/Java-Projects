package exercise1;

import javax.swing.JOptionPane;
import java.util.Random;

public class Test {

	public static void main(String[] args) {

		Test test = new Test();
		test.inputAnswer();
	}

	Random randomQuestion = new Random();

	String[] questions = { "What is a correct syntax to output 'Hello World' in Java?",
			"Which data type is used to create a variable that should store text?",
			"Which method can be used to find the length of a string?",
			"What is the default value for an instance variable of type String?",
			"How do you create a method in Java?" };

	String[][] optionsDisplay = { {
			" (a) echo('Hello World'); \n (b) Console.WriteLine('Hello World'); \n (c) System.out.println('Hello World'); \n (d) print ('Hello World');" },
			{ " (a) myString \n (b) string \n (c) String \n (d) Txt" },
			{ " (a) getSize() \n (b) getLength() \n (c) length() \n (d) len()" },
			{ " (a) methodName() \n (b) (methodName) \n (c) methodNAme[] \n (d) methodName" },
			{ " (a) MyClass \n (b) class() \n (c) class \n (d) className" } };

	String[][] options = {
			{ "echo('Hello World')", "Console.WriteLine('Hello World');", "System.out.println('Hello World');",
					"print ('Hello World');" },
			{ "myString", "string", "String", "Txt" }, { "getSize()", "getLength()", "length()", "len()" },
			{ "methodName()", "(methodName)", "methodNAme[]", "methodName" },
			{ "MyClass", "class()", "class", "className" } };

	String correctAnswers[] = { "System.out.println('Hello World');", "String", "length()", "methodName()", "MyClass" };

	public void inputAnswer() {

		int correctAnswers = 0;
		int IncorrectAnswers = 0;
		for (int i = 0; i < questions.length; i++) {

			String answer = simulateQuestion(i);

			if (checkAnswer(answer, i)) {
				JOptionPane.showMessageDialog(null, generateMessage(true));
				correctAnswers++;
			} else {
				JOptionPane.showMessageDialog(null, generateMessage(false));
				IncorrectAnswers++;
			}
		}

		double percentCorrect = (double) correctAnswers * 100 / (correctAnswers + IncorrectAnswers);
		
		String message = "Correct answers: " + correctAnswers 
				+ "\nIncorrect answers: " + IncorrectAnswers
				+ "\nPercentage of Right Answers: " + percentCorrect + "%";
		JOptionPane.showMessageDialog(null, message);
	}

	public String simulateQuestion(int question) {
		String message = null;

		message = JOptionPane.showInputDialog((question + 1) + ". " 
		+ questions[question] + "\n" + optionsDisplay[question][0]);

		return message;
	}

	public boolean checkAnswer(String userAnswer, int questionNumber) {

		if (userAnswer.length() != 1) {
			return false;
		}

		int optionsLen = options[questionNumber].length;
		String charDisplay;
		String selectedOption = "";
		boolean isCorrectOrNot = false;

		for (int i = 0; i < optionsLen; i++) {
			charDisplay = "" + (char) ('a' + i);

			if (userAnswer.equals(charDisplay)) {
				selectedOption = options[questionNumber][i];
				isCorrectOrNot = true;
				break;
			}
		}

		if (!isCorrectOrNot) {
			return false;
		} else {
			return correctAnswers[questionNumber].equals(selectedOption);
		}

	}

	public String generateMessage(boolean positiveAnswer) {

		if (positiveAnswer) {
			switch (randomQuestion.nextInt(4)) {
			case 0:
				return "Excellent!";
			case 1:
				return "Good!";
			case 2:
				return "Keep up the good work!";
			case 3:
				return "Nice work!";
			}
		} else {
			switch (randomQuestion.nextInt(4)) {
			case 0:
				return "No. Please try again";
			case 1:
				return "Wrong. Try once more";
			case 2:
				return "Don't give up!";
			case 3:
				return "No. Keep trying";
			}
		}

		return "";
	}
}
