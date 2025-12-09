package java_interfaces;

public class CurrentAccount implements Account {
 private double balance;
 private double overdraftLimit = 500.00;
 private int accountNumber;

 public CurrentAccount(int accNum, double initialDeposit) {
     this.accountNumber = accNum;
     this.balance = initialDeposit;
     System.out.println("Current Account " + accNum + " created with balance $" + balance);
 }
 
 
 public void checkOverdraftStatus() {
     if (balance < 0) {
         System.out.println("Current Account " + accountNumber + " is currently using the overdraft facility.");
     } else {
         System.out.println("Current Account " + accountNumber + " is not using overdraft.");
     }
 }

 @Override
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposited $" + amount + " to Current Account " + accountNumber);
     }
 }

 @Override
 public void withdraw(double amount) {
     // Allows withdrawal into overdraft up to the limit
     if (balance + overdraftLimit >= amount) {
         balance -= amount;
         System.out.println("Withdrew $" + amount + " from Current Account " + accountNumber);
     } else {
         System.out.println("Withdrawal failed: Exceeds overdraft limit in Current Account " + accountNumber);
     }
 }

 @Override
 public void calculateInterest() {
     // Current accounts usually don't earn positive interest, or they charge fees if negative.
     if (balance < 0) {
         double fee = balance * 0.05; // 5% fee on negative balance
         balance += fee; 
         System.out.printf("Overdraft fee applied to Current Account %d: $%.2f. New balance: $%.2f%n", accountNumber, fee, balance);
     } else {
         System.out.println("Current Account " + accountNumber + " does not earn interest.");
     }
 }

 @Override
 public void viewBalance() {
     System.out.printf("Current Account %d balance: $%.2f%n", accountNumber, balance);
 }
}
