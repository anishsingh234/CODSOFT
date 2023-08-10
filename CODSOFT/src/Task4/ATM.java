package Task4;

import java.util.Scanner;

class ATM {
    private BankAccount account;
    private int correctPin = 4034;  
    public boolean hee = false;
    private int enteredPin;

    public ATM(BankAccount userAccount) {
        account = userAccount;
    }
    
    public void accountnumber() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Enter your PIN: ");
        enteredPin = scanner.nextInt();
        if (enteredPin == correctPin) {
        	hee = true;
            System.out.println("PIN Correct. Access granted.");
        } else {
            System.out.println("Incorrect PIN. Access denied.");
        }
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice, double amount) {
        switch (choice) {
            case 1:
                System.out.println("Balance: $" + account.getBalance());
                break;
            case 2:
                account.deposit(amount);
                break;
            case 3:
                account.withdraw(amount);
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}

