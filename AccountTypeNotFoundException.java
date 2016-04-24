
/**
 * Class AccountTypeNotFoundException subclass dari class Extends
 * 
 * @author Josua Geovani Pinem
 * @version 14/04/2016
 */
public class AccountTypeNotFoundException extends Exception
{
    private char acctType ;

    /**
     * Constructor for objects of class AccountTypeNotFoundException
     */
    public AccountTypeNotFoundException(char acctType)
    {
        super("Account does not exist");
        this.acctType = acctType;
    }

    /**     
     * Method untuk override mutator getMessage() pada java.lang.Exception    
     * @return message      String yang dicetak 
     */
    @Override
    public String getMessage()
    {
        // put your code here
        String message = "";
            switch(this.acctType){
                case 'S':
                    {  
                        message = "Savings" + super.getMessage() ;
                        break;
                    }
                case 'I':
                    {
                        message =  "Investments" + super.getMessage();
                        break;
                    }
                case 'O':
                    {
                        message =  "OverDraft Protection" + super.getMessage();
                        break;
                    }    
                case 'L':
                    {    
                        message ="Line of Credits" + super.getMessage();
                        break;
                    }
                default:
                    {break;}
            }
        return message;                   
    }
}
