
/**
 * Class AmoountOverDrawnException subclass dari class Exception
 * 
 * @author Josua Geovani Pinem
 * @version 14/04/2016
 */
public class AmountOverDrawnException extends Exception
{
    private Account account;
    /**
     * Constructor for objects of class AmoountOverDrawnException
     */
    public AmountOverDrawnException(Account account)
    {
        super("Insufficient Funds");
        this.account = account;
    }
       
    /**
     * Method untuk override accessor getMessage pada java.lang.Exception
     */
    @Override 
    public String getMessage()
    {
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
