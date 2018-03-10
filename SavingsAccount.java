/** This class works as a part of the BankAccount class.
* The SavingsAccount allows for accumulation of interest
* to occur.
* This version is made by Dayan Jayasuriya, Nicki Lindstrom,
* and Riley Schaaf.
*/

public class SavingsAccount extends BankAccount {

  private double annualInterestRate;
  private final double MONTHLY_FEE = -5.0;
  private final double MINIMUM_BALANCE = 1000.00;
  private final double PENALTY = 1/12;

  /**
  * Default constructors
  */
  public SavingsAccount(){};

  /**
  * Constructs a new saving account. Requires an account holder of the Customer
  class, starting balance, and an annual interest rate to be passed to it to use.
  */
  public SavingsAccount(Customer accountHolder, double startBalance, double annualInterestRate){
    Customer newAccountHolder = new Customer(accountHolder);
    setBalance(startBalance);
    setAnnualInterestRate(annualInterestRate);
  }

  /**
  * Method gets the annual interest rate for the account.
  */
  public double getAnnualInterestRate(){
    return annualInterestRate;
  }

  /**
  * Method sets the annual interest rate for the account.
  */
  public void setAnnualInterestRate(double rate){
    annualInterestRate = rate;
  }

  /**
  * Gets the monthly bank fees and interest
  */
  protected double getMonthlyFeesAndInterest(){
    double monthlyFeesAndInterest = 0.0;
    if (getBalance() < MINIMUM_BALANCE){
      double penaltyRate = getAnnualInterestRate() * PENALTY;
      monthlyFeesAndInterest = (penaltyRate * getBalance());
    }
    return monthlyFeesAndInterest;
  }

}
