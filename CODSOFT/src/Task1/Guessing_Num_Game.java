package Task1;

import java.util.Scanner;
import java.util.Random;

public class Guessing_Num_Game {
    public static void main(String[] args) {
        playTheGame();
    }

    public static int generateRandomNumber(int startRange, int endRange) {
        Random random = new Random();
        return random.nextInt(endRange - startRange + 1) + startRange;
    }

    public static int getUserGuess_Num(Scanner scanner) {
        System.out.print("Guess the number: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter the valid integer.");
            return getUserGuess_Num(scanner);
        }
    }

    public static void playTheGame() {
        Scanner sc = new Scanner(System.in);
        int startRange = 1;
        int endRange = 100;
        int maxAttempts = 10;
        int score = 0;

        while (true) {
            int targetNumber = generateRandomNumber(startRange, endRange);
            System.out.println("Welcome to the guessing game! Guess the number between " +
                    startRange + " and " + endRange + ".");
            System.out.println("You have " + maxAttempts + " attempts.");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                int userGuess = getUserGuess_Num(sc);

                if (userGuess == targetNumber) {
                    score++;
                    System.out.println("Congratulations! You guessed the correct number " +
                            targetNumber + " in " + attempt + " attempts.");
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempt == maxAttempts) {
                    System.out.println("Sorry, you've used all your attempts. The correct number was " +
                            targetNumber + ".");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Your final score is: " + score + ".");
    }
}
