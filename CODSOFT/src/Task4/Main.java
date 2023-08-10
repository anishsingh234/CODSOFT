package Task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.accountnumber();
            while (!atm.hee) {
                System.out.print("Enter your corrected pin: ");
                atm.accountnumber();
            }
            
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                atm.performTransaction(choice, 0);
            } else if (choice != 1) {
                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();
                atm.performTransaction(choice, amount);
            } else {
                atm.performTransaction(choice, 0);
            }
        }
    }
}
