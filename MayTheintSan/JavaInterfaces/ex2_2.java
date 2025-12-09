package java_interfaces;

public class SavingsAccount implements Account {
 private double balance;
 private double interestRate = 0.02; // 2% fixed interest rate
 private int accountNumber;

 public SavingsAccount(int accNum, double initialDeposit) {
     this.accountNumber = accNum;
     this.balance = initialDeposit;
     System.out.println("Savings Account " + accNum + " created with balance $" + balance);
 }
 
 public void applyLoyaltyBonus() {
     System.out.println("Savings Account " + accountNumber + ": Applying loyalty bonus.");
 }

 @Override
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposited $" + amount + " to Savings Account " + accountNumber);
     }
 }

 @Override
 public void withdraw(double amount) {
     // Basic check for withdrawal
     if (balance >= amount) {
         balance -= amount;
         System.out.println("Withdrew $" + amount + " from Savings Account " + accountNumber);
     } else {
         System.out.println("Withdrawal failed: Insufficient funds in Savings Account " + accountNumber);
     }
 }

 @Override
 public void calculateInterest() {
     double interest = balance * interestRate;
     balance += interest;
     System.out.printf("Interest calculated for Savings Account %d: $%.2f. New balance: $%.2f%n", accountNumber, interest, balance);
 }

 @Override
 public void viewBalance() {
     System.out.printf("Savings Account %d balance: $%.2f%n", accountNumber, balance);
 }
}
