package java_interfaces;

import java.util.ArrayList;

public class Bank {
 // List of accounts (Aggregation)
 private ArrayList<Account> accounts;

 public Bank() {
     this.accounts = new ArrayList<>();
     System.out.println("Bank system initialized.");
 }

 // Method for adding accounts
 public void addAccount(Account newAccount) {
     accounts.add(newAccount);
     System.out.println("Account successfully added to the bank's system.");
 }

 public static void main(String[] args) {
     Bank myBank = new Bank();

     // Create and add accounts
     SavingsAccount sa = new SavingsAccount(1001, 5000.00);
     CurrentAccount ca = new CurrentAccount(2001, 1000.00);
     
     myBank.addAccount(sa);
     myBank.addAccount(ca);
     
     System.out.println("\nPerforming Transactions");
     
     // Use interface methods
     sa.deposit(200.00);
     ca.withdraw(1500.00); 
     
     // Calculate interest/fees
     sa.calculateInterest();
     ca.calculateInterest();
     
     System.out.println("\nViewing Balances");
     sa.viewBalance();
     ca.viewBalance();
     
     // Use unique methods
     sa.applyLoyaltyBonus();
     ca.checkOverdraftStatus();
 }
}
