package Task2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class WordCount {
	public static void main(String[] args) {
        System.out.println("Welcome to Word Count!");
        System.out.print("Enter 'T' to input text, or 'F' to provide a file: ");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("T")) {
            System.out.print("Enter your text: ");
            String inputText = scanner.nextLine();
            int wordCount = countWords(inputText);
            System.out.println("Total word count: " + wordCount);
        } else if (choice.equalsIgnoreCase("F")) {
            System.out.print("Enter the file name: ");
            String fileName = scanner.nextLine();
            int wordCount = countWordsFromFile(fileName);
            System.out.println("Total word count: " + wordCount);
        } else {
            System.out.println("Invalid choice. Please try again.");
        }

        scanner.close();
    }

    private static int countWords(String text) {
        
        String[] words = text.split("\\W+");

        
        return words.length;
    }

    private static int countWordsFromFile(String fileName) {
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordCount += countWords(line);
            }
        } catch (IOException e) {
            System.out.println("Error: File not found.");
        }

        return wordCount;
    }
}
