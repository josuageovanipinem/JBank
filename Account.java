/**
 * Untuk akses dan penambahan informasi akun
 * 
 * @author Josua Geovani Pinem
 * @version 16/04/2016
 */
public abstract class Account
{
    //deklarasi variabel
    public double balance;
    public String ID;
    
    public Account()
    {
    }
    
     /**
     * Constructor pada class Account untuk membuat objek
     * @param type     tipe dari akun yang dimasukkan
     * @param amount   jumlah dari balance yang dimasukkan
     */
    public Account(Customer cust, double amount,char type) 
    {//Membuat akun user 
        ID = cust.getCustID() + "" + type;
        //acctType = type;
        balance = amount;
    }
    
    /**
     * Method pada class account untuk pengecekan jumlah 
     * @param Amount  jumlah dari amount pada akun
     */
    public boolean deposit(double amount)
    {
        //check info saldo defisit
        if (amount>=0)
        {
            balance += amount;
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    
    /**
    * Method Accessor getBalance
    * @return   value dari balance akan dikembalikan
    */   
    public double getBalance() 
    {
        return balance;
    }
    
    /**
    * Method Accessor getId
    * @return    mengembalikan string dari ID 
    */
    public String getID() 
    {
        return ID;
    }
        
    /**
    * Method Mutator setBalance
    * @param amount    masukkan uang
    */
    public void setBalance(double amount) 
    {//membuat fungsi setBalance
        balance = amount ;
    }
    
    
    /**
     * Method withdraw
     * @param amount    banyak uang diambil
     */
    public void withdraw(double amount) throws AmountOverDrawnException
    {}
    
    public String toString()
    {
        if ( this instanceof Savings && !(this instanceof Investment)) {            
            System.out.println("Tipe SAVING");
            System.out.println("Balance       :"+ balance);            
        } else if ( this instanceof LineOfCredit) {
            LineOfCredit loc = (LineOfCredit)this;
            System.out.println("Tipe LOC");
            System.out.println("Credit Balance:"+ loc.getCreditBalance());
            System.out.println("Monthly Fee   :"+ loc.getMonthlyFee());
            System.out.println("Balance       :"+ balance);            
        } else if ( this instanceof OverDraftProtect) {
            OverDraftProtect over = (OverDraftProtect)this;
            System.out.println("Tipe Overdraft Protection");
            System.out.println("Monthly Fee   :"+ over.getMonthlyFee());
            System.out.println("Balance       :"+ balance);
        } else if ( this instanceof Investment) {
            System.out.println("Tipe Investment");
            System.out.println("Balance       :"+ balance);            
        }
        return "";
    }
    }

