package core.practice;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

interface BankAccount {
    void withdraw(int amount);

    void checkBalance();

    void deposit(int amount);

    void getDetails();
}

class BaseBank implements BankAccount {
    private final int accountNumber;
    private final String holderName;
    private int balance;

    public BaseBank(int accountNumber, int balance, String holderName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.holderName = holderName;
    }

    public static BaseBank createAccount(Scanner scanner) {
        int accountNo = ThreadLocalRandom.current().nextInt(1000000, 999999999);
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();

        int initialBalance;
        while (true) {
            System.out.print("Enter initial deposit amount: ");
            try {
                initialBalance = scanner.nextInt();
                if (initialBalance < 0) {
                    System.out.println("Initial balance cannot be negative. Try again.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next();
            }
        }
        scanner.nextLine();
        return new BaseBank(accountNo, initialBalance, name);
    }

    @Override
    public synchronized void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount! Withdrawal amount must be greater than zero.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds! Available balance: " + balance);
            return;
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }

    @Override
    public synchronized void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    @Override
    public synchronized void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount. Please enter a positive number.");
            return;
        }
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    @Override
    public void getDetails() {
        System.out.println("Account Holder: " + holderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
}

class BankService {
    private static final int EXIT = 0;
    private static final int DETAILS = 1;
    private static final int BALANCE = 2;
    private static final int DEPOSIT = 3;
    private static final int WITHDRAW = 4;

    public static void banking(BankAccount account, Scanner scanner) {
        while (true) {
            System.out.println("----------------------------");
            System.out.println("0 - Exit");
            System.out.println("1 - Get Account Details");
            System.out.println("2 - Check Balance");
            System.out.println("3 - Deposit Money");
            System.out.println("4 - Withdraw Money");
            System.out.println("----------------------------");
            System.out.print("Select an option: ");

            try {
                int option = scanner.nextInt();
                switch (option) {
                    case DETAILS -> account.getDetails();
                    case BALANCE -> account.checkBalance();
                    case DEPOSIT -> {
                        System.out.print("Enter deposit amount: ");
                        int amount = scanner.nextInt();
                        account.deposit(amount);
                    }
                    case WITHDRAW -> {
                        System.out.print("Enter withdrawal amount: ");
                        int amount = scanner.nextInt();
                        account.withdraw(amount);
                    }
                    case EXIT -> {
                        System.out.println("Thank you for banking with us!");
                        return;
                    }
                    default -> System.out.println("Invalid option! Please choose a valid menu option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
        }
    }
}

public class BankingSys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account1 = BaseBank.createAccount(scanner);
        BankService.banking(account1, scanner);
        scanner.close();
    }
}
