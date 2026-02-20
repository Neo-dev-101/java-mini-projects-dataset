import java.util.Scanner;

public class BankAccountManagementSystem {

    // ===== Bank Account Class =====
    static class BankAccount {

        // Fields
        int accountNumber;
        String accountHolder;
        double balance;
        boolean isCreated;

        // Default Constructor
        BankAccount() {
            this.isCreated = false;
        }

        // ===== Method 1: Create Account =====
        void createAccount(int accountNumber, String accountHolder, double initialBalance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = initialBalance;
            this.isCreated = true;
            System.out.println("Account created successfully!");
        }

        // ===== Method 2: Deposit =====
        void deposit(double amount) {
            if (!isCreated) {
                System.out.println("No account found! Please create an account first.");
                return;
            }
            if (amount <= 0) {
                System.out.println("Invalid deposit amount!");
                return;
            }
            this.balance += amount;
            System.out.println("Deposit successful. Updated Balance: " + (int) this.balance);
        }

        // ===== Method 3: Withdraw =====
        void withdraw(double amount) {
            if (!isCreated) {
                System.out.println("No account found! Please create an account first.");
                return;
            }
            if (amount <= 0) {
                System.out.println("Invalid withdrawal amount!");
                return;
            }
            if (amount > this.balance) {
                System.out.println("Insufficient balance!");
            } else {
                this.balance -= amount;
                System.out.println("Withdrawal successful. Updated Balance: " + (int) this.balance);
            }
        }

        // ===== Method 4: Check Balance =====
        void checkBalance() {
            if (!isCreated) {
                System.out.println("No account found! Please create an account first.");
                return;
            }
            System.out.println("Current Balance: " + (int) this.balance);
        }

        // ===== Method 5: Display Account Details =====
        void displayDetails() {
            if (!isCreated) {
                System.out.println("No account found! Please create an account first.");
                return;
            }
            System.out.println("----- ACCOUNT DETAILS -----");
            System.out.println("Account Number : " + this.accountNumber);
            System.out.println("Account Holder : " + this.accountHolder);
            System.out.println("Balance        : " + (int) this.balance);
            System.out.println("---------------------------");
        }
    }

    // ===== Display Menu =====
    static void displayMenu() {
        System.out.println("\n===== BANK ACCOUNT MANAGEMENT SYSTEM =====");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        System.out.println("5. Display Account Details");
        System.out.println("6. Exit");
        System.out.println("==========================================");
        System.out.print("Enter your choice: ");
    }

    // ===== Main Method =====
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();
        int choice;

        do {
            displayMenu();
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double initialBalance = sc.nextDouble();
                    account.createAccount(accNo, name, initialBalance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    account.checkBalance();
                    break;

                case 5:
                    account.displayDetails();
                    break;

                case 6:
                    System.out.println("Thank you for using Bank Account Management System");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter between 1 and 6.");
            }

        } while (choice != 6);

        sc.close();
    }
}