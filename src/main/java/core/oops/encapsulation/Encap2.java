package core.oops.encapsulation;

abstract class Account {
    private final long accountNumber;
    private final String accountHolderName;
    private double balance;

    Account(long accountNumber, String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }


    public String getAccountHolderName() {
        return accountHolderName;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    abstract void displayAccountDetails();

    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("After Deposit :");
            System.out.println("Account Balance :" + getBalance());
            System.out.println();
        } else System.out.println("Enter valid amount");
    }
}

class BankAccount extends Account {
    BankAccount(long accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    void displayAccountDetails() {

        System.out.println("Account Details :");
        System.out.println("Account Number :" + getAccountNumber());
        System.out.println("Account Holder Name :" + getAccountHolderName());
        System.out.println("Account Balance :" + getBalance());
        System.out.println();
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("After withdrawal :");
            System.out.println("Account Balance :" + getBalance());
            System.out.println();

        } else if (amount > getBalance()) {
            System.out.println("Insufficient balance!!");
        } else System.out.println("Enter valid Amount");

    }
}


public class Encap2 {
    public static void main(String[] args) {
        BankAccount obj = new BankAccount(8732877632L, "Xavier", 72363.23);
        obj.displayAccountDetails();
        obj.deposit(7000);
        obj.withdraw(4000);
        obj.displayAccountDetails();
    }
}
