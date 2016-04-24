
/**
 * Class AccountTypeAlreadyExistException subclass dari Class Exception
 * 
 * @author Josua Geovani Pinem
 * @version 14/04/2016
 */
public class AccountTypeAlreadyExistException extends Exception
{
    // instance variables - replace the example below with your own
    private Account account;

    /**
     * Constructor for objects of class AccountTypeAlreadyExistException
     */
    public AccountTypeAlreadyExistException(Account account)
    {
        // initialise instance variables
        super("Unable to create duplicate account type");
        this.account = account;
    }

    /**
     * Method untuk override getter getMethod pada java.lang.Exception    
     * @return message  string yang akan menggantikan
     */
    public String getMessage()
    {
        // put your code here
        if (this.account instanceof Savings && !(this.account instanceof Investment) ){
            return super.getMessage() + " in Savings Account";
        } else if (this.account instanceof Investment){
            return super.getMessage() + " in Investments Account";
        } else if (this.account instanceof OverDraftProtect){
            return super.getMessage() + " in OverDraft Protection Account";
        } else if (this.account instanceof LineOfCredit){
            return super.getMessage() + " in LineOfCredit Account";
        } else {
            return "";
        }  
    }
}
