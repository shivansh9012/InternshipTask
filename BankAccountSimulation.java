import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BankAccount {
    String owner;
    double balance;
    List<String> transactionHistory = new ArrayList<>();

   
    BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        transactionHistory.add("Account created with balance: " + balance);
    }

    
    void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: " + amount + " | Balance: " + balance);
        System.out.println("Deposited: " + amount);
    }


    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount + " | Balance: " + balance);
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

   
    void showBalance() {
        System.out.println("Current Balance: " + balance);
    }

    
    void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}

public class BankAccountSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        BankAccount account = new BankAccount(name, 0);

        int choice;
        do {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Show Balance\n4. Show Transaction History\n5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double wd = sc.nextDouble();
                    account.withdraw(wd);
                    break;
                case 3:
                    account.showBalance();
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

       
    }
}
