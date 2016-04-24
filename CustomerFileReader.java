import java.io.*;
import java.util.ArrayList;

/**
 * @Author Josua Geovani Pinem
 * @version 21/04/2016
 */
public class CustomerFileReader implements Serializable {
    private File objectFile;
    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;

    public void CustomerFileReader () {
    }

    public ArrayList<Customer> readCustomer()  
    {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {
            objectFile = new File("file.txt");
            fileInputStream = new FileInputStream(objectFile);
            objectInputStream = new ObjectInputStream(fileInputStream);
            customers = (ArrayList) objectInputStream.readObject();
            objectInputStream.close();}
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return customers;
    }

}
