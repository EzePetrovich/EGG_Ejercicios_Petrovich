/**
 * @author J. Ezequiel Petrovich
 */

package entity;

import java.io.IOException;
import java.util.Scanner;

public interface Tools {
    
    // Scanner for user inputs
    
    public static Scanner read = new Scanner(System.in).useDelimiter("\n");
    
   // Void to read messages before to continue
    
    public static void presioneIntro() {
        System.out.print("\nPresione intro para seguir...");
        try{System.in.read();}
        catch(IOException e) {}        
    }
}
