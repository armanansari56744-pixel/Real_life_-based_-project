abstract class BankAccount {
    private String accountNumber;
    private String Owner;
    private double balance;

    BankAccount(String accountNumber, String Owner, double balance) {
        this.accountNumber = accountNumber;
        this.Owner = Owner;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return Owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public abstract void accounttype();

    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Owner: " + Owner);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    SavingsAccount(String accountNumber, String Owner, double balance, double interestRate) {
        super(accountNumber, Owner, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void addInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println("Interest added: " + interest);
    }

    @Override
    public void accounttype() {
        System.out.println("Account Type: Savings Account");
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    CurrentAccount(String accountNumber, String Owner, double balance, double overdraftLimit) {
        super(accountNumber, Owner, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public void accounttype() {
        System.out.println("Account Type: Current Account");
    }
}
public class Bank {
    public static void main(String[] args) {
        
         System.out.println("============");
        System.out.println("===World Bank===");
        System.out.println("============");


        SavingsAccount savingsAccount = new SavingsAccount("SA123", "John Doe", 1000.0, 0.05);
        CurrentAccount currentAccount = new CurrentAccount("CA456", "Jane Smith", 2000.0, 500.0);


       
        System.out.println("-------------");

        savingsAccount.deposit(56000);
        savingsAccount.withdraw(20000);
        savingsAccount.addInterest();
        savingsAccount.display();

        System.out.println("\n" + "=".repeat(25));

       
        System.out.println("-------------");

        currentAccount.deposit(450023);
        currentAccount.withdraw(230012);
        currentAccount.display();

    }
}