<<<<<<< HEAD
/**
 * @author Ezequiel
 */

package operAritmetic;

import java.util.*;
import service.DivisionNumero;

public class Main implements Tools {
    public static void main(String[] args) {
        DivisionNumero dN = new DivisionNumero();
        try {
            System.out.println(" DIVISION DE CARACTERES NUMERICOS. [a / b]\n");
            System.out.print("» Ingrese a: ");
            Integer a = dN.stringToInt(read.next());
            System.out.print("» Ingrese b: ");
            Integer b = dN.stringToInt(read.next());
            System.out.println("\nLa division es: " + dN.divNums(a, b));
        }
        catch(InputMismatchException iE) {System.err.println("\nERROR: debe ingresar un caracter numerico.");}
        catch(NumberFormatException nE) {System.err.println("\nERROR: el caracter ingresado debe ser del tipo numerico.");}
        catch(ArithmeticException aE) {System.err.println("\nERROR: no puede realizarse una division entre 0.");}
    }
}
=======
/**
 * @author Ezequiel
 */

package operAritmetic;

import java.util.*;
import service.DivisionNumero;

public class Main implements Tools {
    public static void main(String[] args) {
        DivisionNumero dN = new DivisionNumero();
        try {
            System.out.println(" DIVISION DE CARACTERES NUMERICOS. [a / b]\n");
            System.out.print("» Ingrese a: ");
            Integer a = dN.stringToInt(read.next());
            System.out.print("» Ingrese b: ");
            Integer b = dN.stringToInt(read.next());
            System.out.println("\nLa division es: " + dN.divNums(a, b));
        }
        catch(InputMismatchException iE) {System.err.println("\nERROR: debe ingresar un caracter numerico.");}
        catch(NumberFormatException nE) {System.err.println("\nERROR: el caracter ingresado debe ser del tipo numerico.");}
        catch(ArithmeticException aE) {System.err.println("\nERROR: no puede realizarse una division entre 0.");}
    }
}
>>>>>>> 9744b90784dd0a6f5c2cb2dc20ab7ea4ca4b0d5e
