<<<<<<< HEAD
/**
 * @author J Ezequiel Petrovich
 */

package utilities;

import java.io.IOException;
import java.util.Scanner;

public interface Tools {
    
    public Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    public static void pressIntro() {
        System.out.print("\nPresione intro para seguir...");
        try{System.in.read();}
        catch(IOException e) {}
    }
    
}
=======
/**
 * @author J Ezequiel Petrovich
 */

package utilities;

import java.io.IOException;
import java.util.Scanner;

public interface Tools {
    
    public Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    public static void pressIntro() {
        System.out.print("\nPresione intro para seguir...");
        try{System.in.read();}
        catch(IOException e) {}
    }
    
}
>>>>>>> 9744b90784dd0a6f5c2cb2dc20ab7ea4ca4b0d5e
