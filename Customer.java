import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.text.*;

/**
 * Pengaturan Identitas Customer
 * 
 * @author Josua Geovani Pinem
 * @version 27/03/2016
 */
public class Customer
{
    private static Account[] accounts = new Account[4];
    private String cityAddress;
    private String email;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String phoneNumber;
    private String zipOrPostalCode;
    private  Date DOB; 
    private int custID;
    private int numOfAccounts;
    public int arrayIndex = 0;
    
    /**
     * Constructor customer
     */
    
    public Customer()
    {
    }
    
    /**
     * Constructor customer dengan 2 atribut
     * @param fname     nama depan user
     * @param lname     nama belakang user
     */
    public Customer(String fname,String lname)
    {
        this(fname,lname, null);
    }
    
    /**
     * Constructor customer dengan 3 atribut
     * @param fname     nama depan user
     * @param lname     nama belakang user
     * @param DOB       tanggal lahir user
     */
    public Customer(String fname,String lname, Date DOB)
    {
       this.firstName = fname;
       this.lastName = lname;
       this.DOB = DOB; 
       custID = Bank.getNextID();
    } 
   
    /**
     * Method removeAccount
     * Hapus Account
     */
    public boolean removeAccount (char type)
    {   
       boolean removed = false;
       for (int i=0;i<4;i++)
        {      
            switch(type)
            {
                case 'S':
                    if (accounts[i] instanceof Savings)
                    {
                        accounts[i]= null;
                        arrayIndex--;
                        numOfAccounts--;
                        removed=true;
                    }
                break;  
                case 'L':
                    if (accounts[i] instanceof LineOfCredit)
                    {
                        accounts[i]= null;
                        arrayIndex--;
                        numOfAccounts--;
                        removed=true;
                    }
                break; 
                case 'O':
                    if (accounts[i] instanceof OverDraftProtect)
                    {
                        accounts[i]= null;
                        arrayIndex--;
                        numOfAccounts--;
                        removed=true;
                    }
                break; 
                case 'I':
                    if (accounts[i] instanceof Investment)
                    {
                        accounts[i]= null;
                        arrayIndex--;
                        numOfAccounts--;
                        removed=true;
                    }
                break;                 
            }

        }
        return removed;
    }        
    
    /**
     * Accessor untuk memperoleh data alamat
     * @return          mengembalikan alamat, kota dan kode pos
     */
     private String getAddress()
    {
         return streetAddress + cityAddress + zipOrPostalCode;
    }
    
    /**
     * Accessor untuk memperoleh akun
     * @return      mengembalikan account
    */
    public Account getAccount(char type) throws AccountTypeNotFoundException
    {
        Account acct = null;
        for (Account a: accounts)
        { switch(type){  
            case 'S':
                if ((a instanceof Savings) && !(a instanceof Investment))
                {
                    acct = a;
                    return acct;
                }
            break;
            case 'L' :
                if(a instanceof LineOfCredit) {
                    acct = a;
                    return acct;
                }
            break;
            case 'O' : 
                if(a instanceof OverDraftProtect) {
                    acct = a;
                    return acct;                    
                }
                break;
            case 'I' :
                if(a instanceof Investment) {
                    acct = a;
                    return acct;                    
                }
            break;
          }             
            } 
        throw  new AccountTypeNotFoundException(type);
        }
       
    /**
     * Accessor untuk memperoleh ID pelanggan
     * @return       menegmbalikan ID customer
     */
    public int getCustID()
    {//pembuatan fungsi getCustomerId untuk menerima id pelanggan
        return custID;
    
    }

    /**
     * Accessor untuk memperoleh email pelanggan
     * @return       mengembalikan email
     */ 
    private String getEmail()
    {//membuat fungsi getEmail untuk menerima input email
        return email;
    }  
    
    /**
     * Accessor untuk memperoleh nama 
     * @return      mengembalikan lastname, firstname
     */
    public String getName()
    {//membuat fungsi getEmail untuk menerima input email
        return lastName +","+ firstName ;
    } 
    
    /**
    * Accessor untuk memperoleh banyak akun
    * @return       mengembalikan jumlah banyak akun yang ada
    */
    public int getNumOfCurrentAccounts()
    {//membuat fungsi getNumAccounts untuk menerima input nomer akun
        return numOfAccounts;
    }
    
    /**
     * Accessor untuk memperoleh nomor telepon
     * @return      mengembalikan nomor telepon yang dipanggil
     */
    public String getPhoneNumber(){//membuat fungsi getPhoneNumber, untuk menerima input nomer telepon
        return phoneNumber;
    }
        
    /**
     * Accessir untuk memperoleh tanggal lahir
     * @return     memanggil value date dari DOB 
     * 
     */
    public Date getDateOfBirth(){
        return DOB;
    }
    
    /**
     * Mutator untuk memasukkan data jalan, kota dan kode pos
     * @param street        nama jalan 
     * @param city          nama kota
     * @param code          kode pos
     */
    private void setAddress(String street, String city, String code) 
    {//membuat fungsi setaddress dengan variabel street,city dan code
        streetAddress= street ;
        cityAddress= city ;
        zipOrPostalCode= code ;
    }
    
    /**
     * Mutator untuk memasukkan email dengan regex
     * @param emailAddress      alamat email dari account
     */
    private boolean setEmail(String emailAddress) 
    {//pemasukkan dan pengecekan email
        String email_regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(email_regex);
        Matcher matcher = pattern.matcher(emailAddress);
        if (matcher.matches()){
            email = emailAddress;
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Mutator setName untuk memasukkan nama 
     * @param lname     nama belakang dari pengguna
     * @param fname     nama depan dari pengguna
     */
    public void setName(String lname, String fname) 
    {//memasukkan nama user
        firstName = fname ;
        lastName = lname;
    }
    
    /**
     * Mutator untuk memasukkan nomor telepon
     * @param phoneNum      nomor telepon user
     */
    public void setPhoneNumber(String phoneNum)
    {//membuat fungsi sePhoneNumber 
        phoneNumber = phoneNum;
    }
    
    /**
     * Mutator untuk membuat akun baru
     * @param akunBaru      akun yang baru
     */
    public void addAccount(Account acct) throws AccountTypeAlreadyExistException 
    {        
        int index = -1, i= 0;
        if ( numOfAccounts < 5 ) {
            for (Account a: accounts) {
                if (accounts[i] == null && index == -1) {
                    index = i;
                } else if (accounts[i] != null ) {
                    if (accounts[i].getClass().equals( acct.getClass() )){
                        throw new AccountTypeAlreadyExistException(acct);
                    }
                }
                i++;
            }
            if (index != -1){
                accounts[index] = acct;                
                numOfAccounts++;
                arrayIndex++;
            }
        }
    }
           
    /**
     * Mutator untuk membuat nomor ID
     * @param ID        nomor ID
     */
    public void setCustID (int ID)
    {          
        ID = Bank.getNextID();         
        custID = ID;

    }
    
      public void printAll()
   {    
       for (Account acc:accounts)
       {
           if (acc!=null)
                System.out.println(acc);
        }
   } 
    
}
