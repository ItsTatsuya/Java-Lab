/*Write a program to create an abstract base class Account with 3 members account holder 
name, account number and balance amount. Provide constructor to initialize data 
members, function to deposit cash to account and an abstract function, withdrawal.
Create two child classes Saving Account and Current Account of Account class. Override 
abstract function withdrawal in child classes as per the criteria, for savings maintain a 
minimum balance 1000 and for current account, one can withdraw 5% of current balance as 
overdraft amount. Illustrate the above as a menu driven program. */

import java.util.Scanner;

abstract class Account {
    String accountHolderName;
    int accountNumber;
    double balanceAmount;

    Account(String name, int number, double amount) {
        accountHolderName = name;
        accountNumber = number;
        balanceAmount = amount;
    }

    void deposit(double amount) {
        balanceAmount += amount;
    }

    abstract void withdrawal(double amount);

    void display() {
        System.out.println("Account holder name: " + accountHolderName);
        System.out.println("Account number: " + accountNumber);
        System.out.println("Balance amount: " + balanceAmount);
    }
}

class SavingsAccount extends Account {
    SavingsAccount(String name, int number, double amount) {
        super(name, number, amount);
    }

    void withdrawal(double amount) {
        if (balanceAmount - amount >= 1000) {
            balanceAmount -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class CurrentAccount extends Account {
    CurrentAccount(String name, int number, double amount) {
        super(name, number, amount);
    }

    void withdrawal(double amount) {
        double overdraftAmount = balanceAmount * 0.05;

        if (amount <= balanceAmount + overdraftAmount) {
            balanceAmount -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balanceAmount);
        } else {
            System.out.println("Insufficient funds. Cannot withdraw.");
        }
    }
}

public class Abstract {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Savings account");
            System.out.println("2. Current account");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the account holder name: ");
                    String name = sc.next();
                    System.out.print("Enter the account number: ");
                    int number = sc.nextInt();
                    System.out.print("Enter the balance amount: ");
                    double amount = sc.nextDouble();
                    SavingsAccount savingsAccount = new SavingsAccount(name, number, amount);
                    while (true) {
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Display");
                        System.out.println("4. Exit");
                        System.out.print("Enter your choice: ");
                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.print("Enter the amount to deposit: ");
                                amount = sc.nextDouble();
                                savingsAccount.deposit(amount);
                                break;
                            case 2:
                                System.out.print("Enter the amount to withdraw: ");
                                amount = sc.nextDouble();
                                savingsAccount.withdrawal(amount);
                                break;
                            case 3:
                                savingsAccount.display();
                                break;
                            case 4:
                                System.exit(0);
                            default:
                                System.out.println("Invalid choice");
                        }
                    }
                case 2:
                    System.out.print("Enter the account holder name: ");
                    name = sc.next();
                    System.out.print("Enter the account number: ");
                    number = sc.nextInt();
                    System.out.print("Enter the balance amount: ");
                    amount = sc.nextDouble();
                    CurrentAccount currentAccount = new CurrentAccount(name, number, amount);
                    while (true) {
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Display");
                        System.out.println("4. Exit");
                        System.out.print("Enter your choice: ");
                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.print("Enter the amount to deposit: ");
                                amount = sc.nextDouble();
                                currentAccount.deposit(amount);
                                break;
                            case 2:
                                System.out.print("Enter the amount to withdraw: ");
                                amount = sc.nextDouble();
                                currentAccount.withdrawal(amount);
                                break;
                            case 3:
                                currentAccount.display();
                                break;
                            case 4:
                                System.exit(0);
                            default:
                                System.out.println("Invalid choice");
                            
                    }
                }
            }
            sc.close();
        }
      
    }
}

