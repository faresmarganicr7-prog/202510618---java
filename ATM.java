
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ATM information
        int correctPIN = 1234;
        int attempts = 0;
        int maxAttempts = 3;
        double balance = 1000.0;

        // Transaction history
        String[] transactions = new String[100];
        int transactionCount = 0;

        // PIN Authentication
        while (attempts < maxAttempts) {

            System.out.print("Enter your PIN: ");
            int pin = input.nextInt();

            if (pin == correctPIN) {
                System.out.println("Login successful!");
                break;
            } else {
                attempts++;
                System.out.println("Incorrect PIN!");

                if (attempts == maxAttempts) {
                    System.out.println("Your account is locked.");
                    input.close();
                    return;
                }
            }
        }

        int choice;

        // ATM Main Menu
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Your balance is: " + balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double deposit = input.nextDouble();

                    if (deposit > 0) {
                        balance += deposit;

                        transactions[transactionCount] =
                            "Deposited: " + deposit;
                        transactionCount++;

                        System.out.println("Deposit successful!");
                    } else {
                        System.out.println("Invalid amount!");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawal = input.nextDouble();

                    if (withdrawal > 0 && withdrawal <= balance) {
                        balance -= withdrawal;

                        transactions[transactionCount] =
                            "Withdrawn: " + withdrawal;
                        transactionCount++;

                        System.out.println("Withdrawal successful!");
                    } else {
                        System.out.println("Insufficient balance or invalid amount!");
                    }
                    break;

                case 4:
                    System.out.println("\nTransaction History:");

                    if (transactionCount == 0) {
                        System.out.println("No transactions yet.");
                    }

                    for (int i = 0; i < transactionCount; i++) {
                        System.out.println(transactions[i]);
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using our ATM!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        input.close();
    }
}
