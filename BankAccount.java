import java.util.InputMismatchException;

/** This class works as a banking account with balances that can be checked, deposited
* into, and withdrawn from. This version is made by Dayan Jayasuriya, Nicki Lindstrom,
* and Riley Schaaf.
* Used for Assignment 6
* Last updated 28/FEB/2018 18:49 by Dayan - Changed for privacy leaks
* removed the unused sections
*/

public abstract class BankAccount {
  private Customer accountHolder;
  private double balance = 0.00;
  //private double overdraftAmount = 100.0;


  /**
  * Adding constructors to and for no entry of new BankAccount as well as
  * a new customer and a new balance
  */
  public BankAccount() {
  }
  public BankAccount(Customer accountHolder, double startBalance) {
    setBalance(startBalance);
    setCustomer(accountHolder);
  }


  /**
  * Check the current balance of the bank account.
  */
  public double getBalance() {
    return balance;
  }

  /**
  * Set the balance of the bank account
  */
  protected void setBalance(double newBalance) {
    balance = newBalance;
  }

  public Customer getCustomer() {
    return new Customer(accountHolder);
  }
  public void setCustomer(Customer newCustomer) {
    accountHolder = new Customer(newCustomer);
  }

  /**
  * Make a deposit to the bank account.
  */
  public void deposit (double amount) {
    //This try block catches an Exception caused by the user not entering an integer.
    try {
      //This if statement makes sure the user only deposits a positive amount of money.
      if (amount >= 0.0) {
        balance += amount;
      }

      else {
        System.out.println("You cannot deposit a negative number.");
      }
    }

    catch (InputMismatchException e) {
      System.out.println("You did not enter a number to deposit.");
    }
  }

  /**
  * Withraw from the bank account.
  */
  public void withdraw(double amount) {
    double minimumBalance = 0;
      // if statement to check the withdrawl does not put the account into overdraft.
    if ((getBalance() - amount) >= (minimumBalance)) {
      setBalance(getBalance() - amount);
    }
  }

  /**
  * Transfer money to another BankAccount
  */
  public void transfer(double amount, BankAccount toAccount) {
    double currentBalance = getBalance();
    withdraw(amount);
    if (currentBalance != getBalance()) {
      toAccount.deposit(amount);
    }
  }

  /**
  * Gets the monthly bank fees and interest
  */
  protected abstract double getMonthlyFeesAndInterest();

  /**
  * Update bank account balance taking into account monthly bank fees and intrest.
  */
  public void monthEndUpdate(){
    balance += getMonthlyFeesAndInterest() ;
  }
}
