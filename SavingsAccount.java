/** This class works as a part of the BankAccount class.
* The SavingsAccount allows for accumulation of interest
* to occur.
* This version is made by Dayan Jayasuriya, Nicki Lindstrom,
* and Riley Schaaf.
*/

public class SavingsAccount extends BankAccount {

  private double annualInterestRate;
  public static final double MONTHLY_FEE = 5.0;
  public static final double MINIMUM_BALANCE = 1000.0;
  public static final double MONTHS = 12;

  /**
  * Default constructor
  */
  public SavingsAccount(){};

  /**
  * Constructs a new saving account. Requires an account holder of the Customer
  class, starting balance, and an annual interest rate to be passed to it to use.
  */
  public SavingsAccount(Customer accountHolder, double startBalance, double annualInterestRate){
    super(accountHolder, startBalance);
    setAnnualInterestRate(annualInterestRate);
  }

  /**
  * Method that gets the annual interest rate for the account.
  * @return: the annual interest rate as a double. Value is a perecent.
  */
  public double getAnnualInterestRate(){
    return annualInterestRate;
  }

  /**
  * Method that sets the annual interest rate for the account.
  * @param: the annual interest rate for the account as a double. Given as a percent value.
  */
  public void setAnnualInterestRate(double rate){
    annualInterestRate = rate / 100;
  }

  /**
  * Calculates the monthly bank fees and interest and returns it as a value.
  * @return: the monthly interest for the account, plus a fee if its balance is below a minimum value.
  */
  protected double getMonthlyFeesAndInterest(){
    double monthlyFeesAndInterest = 0.0;
    if (getBalance() < MINIMUM_BALANCE){
      monthlyFeesAndInterest = getBalance() * (annualInterestRate/MONTHS) - MONTHLY_FEE;
    }else{
      monthlyFeesAndInterest = getBalance()  * (annualInterestRate/MONTHS);
    }
    return monthlyFeesAndInterest;
  }

}
