import java.awt.*;
import javax.swing.*;

/**
 *  Kelas ATMGUI extend Jframe
 * 
 * @author Josua Geovani Pinem
 * @version 10/04/2016
 */
public class ATMGUI extends JFrame
{
    // instance variables - replace the example below with your own
    private JMenuBar menuBar;
    private JButton depositBut, withdrawBut, exitBut;
    private JLabel amountLab;
    private JLabel custIdLab;
    private JRadioButton savingRad;
    private JRadioButton investmentRad;
    private JRadioButton locRad;
    private JRadioButton overdraftRad;
    private JTextArea welcomeArea;
    private JTextField custTextField;
    private JTextField amountTextField;
    private Panel displayPanel, center;
    private Panel topPanel, buttonPanel, radioPanel, custPanel, amountPanel;
    private JScrollPane vertical, horizontal;
    private JPanel welcomePanel;
    
    /**
     * Constructor for objects of class ATMGUI
     */
    public ATMGUI()
    {             
        buildGUI();       
    }
    
   /**
    *buildGUI akan membuat ATMGUI  
   */
   public void buildGUI()
   {
       depositBut  = new JButton ("Deposit");
       withdrawBut = new JButton ("Withdraw");
       exitBut     = new JButton ("Exit");
       amountLab = new JLabel("Enter Amount Here:");
       custIdLab = new JLabel("Enter Customer ID");
       savingRad = new JRadioButton("Savings");
       investmentRad = new JRadioButton("Investment");
       locRad = new JRadioButton("Line of Credit");
       overdraftRad = new JRadioButton("Overdraft");
       welcomeArea = new JTextArea("Welcome");
       custTextField = new JTextField("",20);
       amountTextField = new JTextField("",20);       

       ButtonGroup group = new ButtonGroup();
       group.add(savingRad);
       group.add(investmentRad);
       group.add(locRad);
       group.add(overdraftRad);       
       
       radioPanel = new Panel();
       radioPanel.setLayout(new GridLayout(4,1));
       radioPanel.add(savingRad);
       radioPanel.add(investmentRad);
       radioPanel.add(locRad);
       radioPanel.add(overdraftRad);    

       center = new Panel();
       center.setLayout(new FlowLayout(FlowLayout.CENTER));
       center.add(radioPanel);
       
       custPanel = new Panel();
       custPanel.setLayout(new GridLayout(3,2));
       custPanel.add(custIdLab);
       custPanel.add(custTextField);

       amountPanel = new Panel();
       amountPanel.setLayout(new GridLayout(3,2));
       amountPanel.add(amountLab);
       amountPanel.add(amountTextField);       
                     
       topPanel = new Panel();
       topPanel.setLayout(new GridLayout(1,3));
       topPanel.add(custPanel);
       topPanel.add(center);
       topPanel.add(amountPanel);       
       
       buttonPanel = new Panel();      
       buttonPanel.setLayout(new GridLayout(3,1));
       buttonPanel.add(withdrawBut);
       buttonPanel.add(depositBut);
       buttonPanel.add(exitBut);
       
       welcomePanel = new JPanel();
       welcomePanel.setLayout(new BorderLayout());
       getContentPane().add(welcomePanel);
       vertical = new JScrollPane();
       vertical.getViewport().add(welcomeArea);
       welcomePanel.add(vertical, BorderLayout.CENTER);
              
       this.setLayout(new BorderLayout(3,3));
       this.add(topPanel,BorderLayout.NORTH);
       this.add(buttonPanel,BorderLayout.EAST);   
       this.add(welcomePanel,BorderLayout.CENTER);          
       this.setLocationRelativeTo(null);
       this.pack();
       this.setVisible(true);       
       this.setSize(800,500);
       addWindowListener(new WindowHandler());
       depositBut.addActionListener(new ButtonHandler(this));
       withdrawBut.addActionListener(new ButtonHandler(this));       
       exitBut.addActionListener(new ButtonHandler(this));       
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
   }

   public static void main (String[]args) 
   {
       ATMGUI build = new ATMGUI();

   }
   
    /**
     * Method aksesor dari id cust
     * 
     * @return ID kustomer
     */
    public int getIDcust(){
        return Integer.parseInt(custTextField.getText());
    }
    
     /**
     * Method aksesor nominal
     * 
     * @return Nominal yang ditulis
     */
    public double getNominal(){
        return Double.parseDouble(amountTextField.getText());
    }
    
     /**
     * Method aksesor textarea
     * 
     * @return ID 
     */
    public String getTextArea(){
        return welcomeArea.getText();
    }
    
    /**
     * Method mutator text input
     * 
     * @param input     Text input-an
     */
    public void setTextArea(String input){
        welcomeArea.setText(input);
    }
    
}
    
