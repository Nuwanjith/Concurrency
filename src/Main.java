import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        while (true) {
            // Prompt for and read account number
            System.out.print("Enter account number: ");
            int accountNumber = scanner.nextInt();
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            // Display menu and get user's choice
            // ... (your menu code here)

            int choice = scanner.nextInt(); // Read choice within the loop

            switch (choice) {
                case 1:
                    double depositAmount = scanner.nextDouble();
                    executor.submit(() -> bank.deposit(accountNumber, depositAmount));
                    break;
                case 2:
                    double withdrawalAmount = scanner.nextDouble();
                    executor.submit(() -> bank.withdraw(accountNumber, withdrawalAmount));
                    break;
                // ... (other cases)
                case 0: // Exit option
                System.out.println("Exiting application...");
                scanner.close();
                executor.shutdown(); // Properly terminate the executor
                return; // Exit the main method
            }
        }
    }
}
