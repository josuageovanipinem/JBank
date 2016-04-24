import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.io.Console;

/**
 * Untuk Update Informasi BANK
 * 
 * @author Josua Geovani Pinem
 * @version 27/03/2016
 */
public class Bank
{
    //variable instance 
    private static double creditInterestRate;
    private static double investmentInterestRate;
    private static double premiumInterestRate;
    private static int lastCustID;
    private static int nextCustID;
    private static int numOfCurrentCustomers; 
    private static int nextID;
    private static int MAX_NUM_OF_CUSTOMERS ;
    private static Date closeTime ;
    private static String phone;
    private static Date startTime ;
    public static String website;
    public static final String BANK_NAME= "JBANK";
    public static final String BANK_ADDRESS = "1234 JavaStreet, AnyCity, ThisState, 34567";
    private static Customer[] customer = new Customer[MAX_NUM_OF_CUSTOMERS]; 
    
    static
    {   
        Scanner scan = new Scanner(System.in);
        System.out.print("Jumlah Maks:");
        //String input = System.console().readLine();
        int input = scan.nextInt();
        MAX_NUM_OF_CUSTOMERS = input;        
    }
    
   /**
    * Method addCustomer
    * Menambahkan Costumer dengan batasan dari static
    */
   public static boolean addCustomer(Customer customer)
   {    
       for (int i = 0; i < Bank.customer.length; i++)
       {    
           if(Bank.customer[i]==null)
           {    
               Bank.customer[i] = customer;
               return true;
           }
       }
       return false;
   }
   
   public static Customer getCustomer(int custID)
   {    
       for (int i = 0; i <customer.length; i++ )
       {    
           if(customer[i].getCustID()==custID)
           return customer[i];
       }
       return null;
   }
   
   public static int getMaxNumOfCustomers()
   {    
       return MAX_NUM_OF_CUSTOMERS;
   }
   
       /**
    * Accessor getCreditRate 
    * @return      belum dideklarasikan
    */
    private static double getCreditRate() 
    {
         return 0;
    }
       
    /**
     * Accessor get InvestmentRate
     * @return      masih default
     */
    private static double getInvestmentRate() 
    {
        return 0;
    }
    
    /**
     * Accessor getHoursOfOperation
     * @return      masih default
     */
    public static String getHoursOfOperation() 
    {
        SimpleDateFormat startTimeFormat = new SimpleDateFormat ("hh:mm a");
        SimpleDateFormat closeTimeFormat = new SimpleDateFormat ("hh:mm a");
        //return startTimeFormat.format(Bank.getStartTime()) + " TO " + closeTimeFormat.format(Bank.getCloseTime());
        return "";
    }
    
    /**
    * Accessor getLastID
    * @return      masih default
    */
    private static int getLastID() 
    {
        return 0;
    }
    
    /*public static int getMaxCustomers() {//membuat fungsi getMaxCustomers
        return 0;
    }
    /*public static String getName() {//membuat fungsi getName
        return "";
    }
    */
    /**
    * Accessor getWebsite
    * @return      masih default
    */
    private static String getWebsite() 
    {
        return "";
    }
    
    /**
    * Accessor getPremiumRate
    * @return       masih default
    */ 
    private static double getPremiumRate() 
    {
        return 0;
    }
    
    /**
     * Accessor getPhone
     * @return      masih default
     */
    private static String getPhone() {
        return "";
    }
    
    /**
     * Accessor getnumOfCurerntCustomers untuk memanggil jumlah customer
     * return       memanggil banyak kostumer
     */
    private static int getnumOfCurrentCustomers(){
        return numOfCurrentCustomers;
    }
    
    public static int getNextID()
    {
        int nextID;
        if (numOfCurrentCustomers == MAX_NUM_OF_CUSTOMERS) {
            nextID = 0;
            nextCustID = nextID;
        } else {
            if (nextCustID == 0)  {
                lastCustID = 1000;
                nextID = 1000;
                nextCustID = nextID;
            }else {
                lastCustID = nextCustID;
                nextID = lastCustID + 1;
                nextCustID = nextID;
            }
            numOfCurrentCustomers++;
        }
        return nextID;
    }
                  
    
    
    /**
     * Method Accessor untuk waktu buka
     * @return      mengembalikan nilai dari date buka 
     */
    private static Date getStartTime() {
        return startTime;
    }
    
    /**
     * Method Accessor untuk waktu buka
     * @return      mengembalikan nilai dari date buka 
     */
    private static Date getCloseTime() {
        return closeTime;
    }
    
        /**
     * Method Mutator untuk waktu buka
     * @return      mengembalikan nilai dari date buka 
     */
    public static void setStartTime(int jam, int menit) {
        startTime = new GregorianCalendar(1970,0,0, jam,menit).getTime() ;
    }
    
    /**
     * Method Mutator untuk waktu tutup
     * @return      mengembalikan nilai dari date buka 
     */
    public static void  setCloseTime(int jam, int menit) {
        closeTime = new GregorianCalendar(1970,0,0, jam,menit).getTime() ;
          
    }
    
    public static void setCreditRate(double rate) {
        rate = 0.18;
        creditInterestRate = rate;
    }
    private static void setInvestmentRate(double rate) {//membuat fungsi setInvestmentRate
    }
    private static void setPremium(double rate) {//membuat fungsi setPremium
    }
  
    public void printAll() {
        for (Customer c : customer) {
            if (c!=null)
                System.out.println(c);
        }
    }
}
