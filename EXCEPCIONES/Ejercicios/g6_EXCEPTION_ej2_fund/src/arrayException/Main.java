<<<<<<< HEAD
/**
 * @author Ezequiel
 */

package arrayException;

import service.ArrayService;

public class Main {

    public static void main(String[] args) {
        ArrayService arr = new ArrayService();
        arr.crearArray();
        arr.mostrarArray();
        try {arr.modifArray();}
        catch(ArrayIndexOutOfBoundsException out) {System.err.println("\nERROR: posicion ingresada fuera de rango.");}
    }
    
}
=======
/**
 * @author Ezequiel
 */

package arrayException;

import service.ArrayService;

public class Main {

    public static void main(String[] args) {
        ArrayService arr = new ArrayService();
        arr.crearArray();
        arr.mostrarArray();
        try {arr.modifArray();}
        catch(ArrayIndexOutOfBoundsException out) {System.err.println("\nERROR: posicion ingresada fuera de rango.");}
    }
    
}
>>>>>>> 9744b90784dd0a6f5c2cb2dc20ab7ea4ca4b0d5e
