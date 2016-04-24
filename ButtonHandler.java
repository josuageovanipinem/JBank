import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Class ButtonHandler
 * 
 * 
 * @author Josua Geovani Pinem
 * @version 10/4/2016
 */
public class ButtonHandler implements ActionListener
{
   private ATMGUI atmgui;
   
   /**
    * Konstruktor Button Handler
    * 
    * @param gui 
    */
   public ButtonHandler(ATMGUI atmgui){
       this.atmgui=atmgui;
   }
   
   /**
    * Method event Handler
    * 
    * @param e event
    */
   public void actionPerformed(ActionEvent e){
       if(e.getActionCommand().equals("Deposit"))
       {
           atmgui.setTextArea("Customer: " +atmgui.getIDcust() +" saves an amount of money: Rp " + atmgui.getNominal());
       }
       else if(e.getActionCommand().equals("Withdraw"))
       {
           atmgui.setTextArea("Customer: " + atmgui.getIDcust() +" withdraws an amount of money: Rp " + atmgui.getNominal());                      
       }                   
       else if(e.getActionCommand().equals("Exit"))
       {
           WindowHandler.quitMessage();
           System.exit(0);
       }                          
       else{
           atmgui.setTextArea("");
       }
   }
}
