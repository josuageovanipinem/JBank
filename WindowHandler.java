import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * WindowHandler Class sub dari WindowAdapter
 * 
 * @author Josua Geovani Pinem
 * @version 10/04/2016
 */
public class WindowHandler extends WindowAdapter
{
    /**
     * Method ketika ingin keluar
     * 
     * @param w, event Handler
     */
   public void windowClosing(WindowEvent w){
       quitMessage();
       System.exit(0);
   }
   
   /**
    * Method untuk notifikasi 
    */
   public static void quitMessage(){
       JOptionPane.showMessageDialog(null,"You are exiting, goodbye!");
   }
}
