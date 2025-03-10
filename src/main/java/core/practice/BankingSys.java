package core.practice;

import java.util.Random;
import java.util.Scanner;

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

    public static BaseBank createAccount() {
        Random rdm = new Random();
        Scanner scanner = new Scanner(System.in);
        int accountNo = rdm.nextInt(1000000, 999999999);
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.println("Initial amount to deposit");
        int initialBalance = scanner.nextInt();

        return new BaseBank(accountNo, initialBalance, name);
    }

    public static void banking(BankAccount obj) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------------");
            System.out.println("""
                    0 - Exit\s
                    1 - Get details\s
                    2- Check balance\s
                    3- Deposit\s
                    4- Withdraw\s
                    """
            );
            System.out.print("Select option from above: ");
            try {

                int digit = scanner.nextInt();

                switch (digit) {
                    case 1 -> obj.getDetails();
                    case 2 -> obj.checkBalance();
                    case 3 -> {
                        System.out.print("Enter amount to deposit:");
                        int amount = scanner.nextInt();
                        obj.deposit(amount);
                    }
                    case 4 -> {
                        System.out.print("Enter amount to withdraw:");
                        int amount = scanner.nextInt();
                        obj.withdraw(amount);
                    }
                    case 0 -> {
                        return;
                    }
                    default -> System.out.println("Please select from the given options");
                }
            } catch (Exception e) {
                System.err.println("Error! " + e.getMessage());
            }
        }

    }

    @Override
    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("----------------");
            System.out.println("Can't withdraw insufficient balance! \n");
            return;
        }
        System.out.println("----------------");
        System.out.println("Successfully withdrawn");
        System.out.println("Remaining balance: " + (balance -= amount) + "\n");


    }

    @Override
    public void checkBalance() {
        System.out.println("----------------");
        System.out.println("Current Balance: " + balance + "\n");
    }

    @Override
    public void deposit(int amount) {
        System.out.println("----------------");
        System.out.println("Successfully deposited");
        System.out.println("Current Balance " + (balance += amount) + "\n");
    }

    @Override
    public void getDetails() {
        System.out.println("----------------");
        System.out.println("Account holder name: " + holderName);
        System.out.println("Account number: " + accountNumber);
        System.out.println("Current balance: " + balance + "\n");
    }

}


public class BankingSys {
    public static void main(String[] args) {
        BankAccount account1 = BaseBank.createAccount();
        BaseBank.banking(account1);

    }
}