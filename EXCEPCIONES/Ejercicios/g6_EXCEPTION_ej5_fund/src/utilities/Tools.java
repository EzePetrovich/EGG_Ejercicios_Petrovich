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
