import java.util.*;
import java.text.*;
import java.math.*;
/**
 * Class Investment extend dari Savings
 * 
 * @author Josua Geovani Pinem
 * @version 16/04/2016
 */
public final class Investment extends Savings
{
    // instance variables - replace the example below with your own   
    private Date endDate;
    private double interestRate;
    private Date startDate;
    private int term;

    /**
     * Constructor dari Investment
     * @param Customer      dari class Customer
     * @param amount        tipe double banyaknya jumlah
     * @param months        tipe int, banyaknya bulan
     */
    public Investment(Customer cust, double amount, int months)
    {
        // initialise instance variables
        super(cust,amount);                
        if (balance >= 100)
        {

            if (term < 6)
            {   term = 6;
            }
            else {term=this.term;}
            
            Calendar s = new GregorianCalendar();
            startDate = s.getTime();
            s.add(Calendar.MONTH, term);
            endDate = s.getTime();
            
            if (months <= 6)
            {   
                interestRate = .05;
            }
                else if (months > 6 & months <=12)
                {
                    interestRate = .06;
                }
                else
                {
                    interestRate = 0.7;
                }                             
        }
        
    }
    
    /**
     * Method untuk menambahkan bunga harian
     * @param days      hari yang digunakan
     */
    @Override
    public void addDailyInterest(int days)
    {
        super.addDailyInterest(days);
        double f, period;
        period = (double)days / 365;
        MathContext mc = new MathContext(3);
        BigDecimal bal = new BigDecimal(balance);
        BigDecimal r = new BigDecimal (interestRate);
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
   
    /**
     * Method withdraw Withdraw berbayar 
     * @param amount    Banyaknya yang diambil berbanding tanggal penentuan ambil
     */    
    public void withdraw(double amount) throws AmountOverDrawnException
    {   
        super.withdraw(amount);
        if (amount > balance)
        { throw new AmountOverDrawnException(this);}
        if (Calendar.getInstance().before(endDate) == false)
        {
            throw new AmountOverDrawnException(this);
        }
        else if (Calendar.getInstance().before(endDate) == true)
        {   
            
            if (amount > balance-(balance*0.2))
            {
                throw new AmountOverDrawnException(this);
            }            
            else 
            {
                balance = balance -(amount + (balance*0.2));
            }
        }        
    }
 
} 

