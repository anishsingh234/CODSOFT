package Task1;
import javax.swing.JOptionPane;
import java.util.Random;
public class GuessingNumber_Game {
	public static void main(String args[]) {
		Play_Game();
	}
	public static int Gen_RandomNumbers(int startRange, int endRange) {
		Random random = new Random();
		return random.nextInt(endRange - startRange+1)+startRange;
	}
	public static int getTheGuess() {
        String userInput = JOptionPane.showInputDialog(null, "Guess the number:");
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
            return getTheGuess();
        }
    }

    public static void Play_Game() {
        int startRange = 1;
        int endRange = 100;
        int maxAttempts = 10;
        int score = 0;

        while (true) {
            int targetNumber = Gen_RandomNumbers(startRange, endRange);
            String welcomeMessage = "Welcome to the guessing game of numbers ! Guess the number between " +
                    startRange + " and " + endRange + ".\nYou have " + maxAttempts + " attempts.";
            JOptionPane.showMessageDialog(null, welcomeMessage);

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                int userGuess = getTheGuess();

                if (userGuess == targetNumber) {
                    score++;
                    String successMessage = "Congratulations! You guessed the correct number " +
                            targetNumber + " in " + attempt + " attempts.";
                    JOptionPane.showMessageDialog(null, successMessage);
                    break;
                } else if (userGuess < targetNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }

                if (attempt == maxAttempts) {
                    String failureMessage = "Sorry, you've used all your attempts. The correct number was " +
                            targetNumber + ".";
                    JOptionPane.showMessageDialog(null, failureMessage);
                }
            }

            String playAgain = JOptionPane.showInputDialog(null, "Do you want to play again? (yes/no)");
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        JOptionPane.showMessageDialog(null, "Your final score is: " + score + ".");
    }
}







