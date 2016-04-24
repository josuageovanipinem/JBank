import java.util.*;
import java.math.*;

/**
 * Penggunaan oleh Teller -Pendaftaran Customer- 
 * Update Sistem Keuangan Akun
 * @author Josua Geovani Pinem
 * @version 24/04/2016
 */
public class Teller
{     
    private SortedSet<Customer> customers1 = new TreeSet<>(Comparator.comparing(Customer::getCustID));
    private ArrayList<Customer> customers = new ArrayList<Customer>();
   
    public Teller()        
    {
    }
   
    public static void main (String[]args)
    {           
        CustomerFileWriter custWriter = new CustomerFileWriter();
        CustomerFileReader custReader = new CustomerFileReader();
        Teller teller = new Teller();
        teller.createNewCustomer("a","b");
        teller.createNewCustomer("c","d");
        try {
            teller.customers1 = new TreeSet<>(custReader.readCustomer());}
        catch (Exception e) {
            System.out.println(e.getMessage());
        }       
    }
    
    public Customer createNewCustomer(String fname, String lname) {
        Customer customer = new Customer(fname, lname);
        customers.add(customer);
        return customer;
    }    
    
    public Customer getCustomer(int customerID) {
        Customer customer = null;
        Iterator<Customer> ittr = customers1.iterator();
        while (ittr.hasNext()) {
            customer = ittr.next();
            if (customer.getCustID() == customerID) {
                break;
            }
        }
        return customer;
    }    

  
}
