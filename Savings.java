import java.util.*;
import java.math.*;
/**
 * Class Saving menggunakan class account sebagai super
 * 
 * @author Josua Geovani Pinem
 * @version 16/04/2016
 */
public class Savings extends Account
{
    protected double interestEarned;    

    /**
     * Constructor for objects of class Savings
     */
    public Savings(){}
    
    public Savings(Customer cust, double amount )
    {   
        super();   
        ID = Integer.toString(cust.getCustID());
        super.balance = amount;
    }
        
    public double getInterestEarned(){return interestEarned;}
    
    public void withdraw (double amount) throws AmountOverDrawnException
    {
        if (balance - amount >= 10) {
            balance -= amount;
        } else {
            throw new AmountOverDrawnException(this);
        }

    }
    
    public void addDailyInterest(int days)
    {
        double f, period;
        period = (double)days / 365;
        MathContext mc = new MathContext(3);
        BigDecimal bal = new BigDecimal(balance);
        BigDecimal r = new BigDecimal (.03);
        BigDecimal n = new BigDecimal (360);
        BigDecimal t = new BigDecimal (period);
        BigDecimal f1 = r.divide(n, mc.DECIMAL32).add(new BigDecimal(1));
        BigDecimal f2 = n.multiply(t, mc.DECIMAL32);
        BigDecimal f3 = new BigDecimal (Math.pow(f1.doubleValue(), f2.doubleValue()),mc.DECIMAL32);
        BigDecimal f4 = f3.multiply(bal, mc.DECIMAL32);
        f = f4.doubleValue();
        interestEarned = f - balance;
        balance = f;
    }

}
