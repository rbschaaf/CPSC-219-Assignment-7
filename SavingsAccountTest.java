import static org.junit.Assert.*;

import org.junit.Test;

public class SavingsAccountTest
{

    @Test
    public void test_getMonthlyFeesAndInterestLowBalance()
    {
        SavingsAccount s = new SavingsAccount();
        s.setAnnualInterestRate(5.8);
        s.deposit(100);
        assertEquals(-5.0, s.getMonthlyFeesAndInterest(), 0.00001);
		assertEquals("Balance should not have changed after calling getMonthlyFeesAndInterest", 100.0,s.getBalance(),0.00001);
		s.monthEndUpdate();
		assertEquals("Balance should have changed after calling monthEndUpdate", 95.0,s.getBalance(), 0.00001);
    }
    
    @Test
    public void test_getMonthlyFeesAndInterestHighBalance()
    {
        SavingsAccount s = new SavingsAccount();
        s.setAnnualInterestRate(5.8);
        s.deposit(1001);
        assertEquals(0.48333, s.getMonthlyFeesAndInterest(), 0.00001);
		assertEquals("Balance should not have changed after calling getMonthlyFeesAndInterest", 1001.0,s.getBalance(),0.00001);
		s.monthEndUpdate();
		assertEquals("Balance should have changed after calling monthEndUpdate", 1001.483333333, s.getBalance(),0.00001);
    }

}
