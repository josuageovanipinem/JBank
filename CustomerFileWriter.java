import java.io.*;
import java.util.ArrayList;
import java.io.BufferedOutputStream;

/**
 * @Author Josua Geovani Pinem
 * @version 21/04/2016
 */
public class CustomerFileWriter implements Serializable {
    private File objectFile;
    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;

    public void CustomerFileWriter () 
    {
    }
    
    
    public void saveCustomer(ArrayList<Customer> customers ) {
        try {
            objectFile = new File("file.txt");
            objectFile.createNewFile();
            fileOutputStream = new FileOutputStream(objectFile);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(customers);                         
            objectOutputStream.close();
            fileOutputStream.close();                      
        }
        catch (Exception e) {
            e.getMessage();
        }
    }


}
