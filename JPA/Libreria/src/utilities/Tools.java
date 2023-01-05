
package utilities;

import java.io.IOException;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public interface Tools {
    
    // Attributes
    
    public static Scanner read = new Scanner(System.in).useDelimiter("\n");
    public static EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
    
    // Methods
    
    public static void pressIntro() {
        System.out.print("\nPresione intro para seguir...");
        try {
            System.in.read();
            System.out.println();
        }
        catch(IOException e) {}
    }
    
}
