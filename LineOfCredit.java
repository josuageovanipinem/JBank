import java.util.*;
import java.text.*;
import java.math.*;

/**
 * Class LineOfCredit menggunakan Checking sebagai superclass
 * Digunakan untuk metode credit card
 * @author Josua Geovani Pinem
 * @version 16/04/2016
 */
public class LineOfCredit extends Checking {
    private double creditBalance, creditLimit;
    
    /**
     * Method Constructor LineOfCredit 
     * @param cust              objek customer
     * @param amount            jumlah
     * @param creditAmount      batasan kredit
     */
    public LineOfCredit (Customer cust, double amount, double creditAmount) {
        super();
        ID = Integer.toString(cust.getCustID());
        balance = amount;
        creditBalance = creditAmount;
        creditLimit = creditAmount;
    }                
           
    /**
     * Accessor getCreditBalance, getter saldo kredit
     * @return creditBalance
     */
    public double getCreditBalance () {
        return creditBalance;
    }
    
    /**
     * Accessor getCreditLimit, getter limit kredit
     * @return creditLimit       limit kredit
     */
    public double getCreditLimit () {
        return creditLimit;
    }
    
    /**
     * Mutator setCreditBalance, setter nilai saldo kredit
     * @param amount     nilai saldo
     */
    public void setCreditBalance (double amount) {
        creditBalance = amount;
    }
    
    /**
     * Mutator setCreditLimit, setter limit kredit
     * @param amount    nilai limit
     */
    public void setCreditLimit (double amount) {
        creditLimit = amount;
    }    
    
     /**
     * Method withdraw, override withdraw
     * @param amount Jumlah Saldo
     */
    @Override
    public void withdraw (double amount) throws AmountOverDrawnException {
        if (amount > balance + creditBalance)
        {
            throw new AmountOverDrawnException(this);
        }
       else if (amount > balance)
        {
           creditBalance = balance+creditBalance-amount ;               
           balance = 0;                
        }
       else{
            balance =balance-amount;
       }     
    }
    
    /**
     * Method feeAssessment override feeassessment, Perhitungan biaya kredit
     */
    @Override
     public void feeAssessment()
     { 
        int days = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
        double deficit = creditLimit - creditBalance;
        double period = (double) days/365;
        double f;
        MathContext mc = new MathContext(3);
        BigDecimal bal = new BigDecimal(balance);
        BigDecimal r = new BigDecimal (.21);
        BigDecimal n = new BigDecimal (360);
        BigDecimal t = new BigDecimal (period);
        BigDecimal f1 = r.divide(n, mc.DECIMAL32).add(new BigDecimal(1));
        BigDecimal f2 = n.multiply(t, mc.DECIMAL32);
        BigDecimal f3 = new BigDecimal (Math.pow(f1.doubleValue(), f2.doubleValue()),mc.DECIMAL32);
        BigDecimal f4 = f3.multiply(bal, mc.DECIMAL32);
        f = f4.doubleValue();
        monthlyFee = new BigDecimal(f).subtract(new BigDecimal(deficit),mc.DECIMAL32).doubleValue(); 
    }    
   
}
