
/**
 * OverDraftProtect menggunakan class checking sebagai referensi super
 * 
 * @Josua Geovani Pinem
 * @version 16/04/2016
 */
public class OverDraftProtect extends Checking
{
    // instance variables - replace the example below with your own
    private Savings savingsAccount;    
    
    /**
     * Constructor for objects of class OverDraftProtection
     * @param cust      Customer objek
     * @param amount    Saldo Awal
     * @param save      Savings objek
     */
    public OverDraftProtect(Customer cust, double amount, Savings save)
    {
        super();
        ID = Integer.toString(cust.getCustID());
        balance = amount;
        savingsAccount = save;        
    }

    /**
     * Method feeAssessment biaya proteksi Overdraft
     */    
    @Override
    public void feeAssessment()
    {
        monthlyFee += 3;
        balance -=3;
    }
    
    /**
     * Metode withdraw yang overriding metode withdraw pada kelas super
     * @param amount    jumlah saldo
     */   
    @Override
    public void withdraw (double amount) throws AmountOverDrawnException
    {
        if (amount > balance + savingsAccount.getBalance()-10)
        {   
             throw new AmountOverDrawnException(this);
        }
        else if(amount > balance)
        {
             balance = 0;
             savingsAccount.withdraw(amount-balance);
             feeAssessment();
                
            }
        else 
        {
             balance = balance-amount;
        }
        
    }
}
    
    
