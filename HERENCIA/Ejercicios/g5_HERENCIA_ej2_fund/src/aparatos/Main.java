
package aparatos;

import entity.Lavadora;
import entity.Televisor;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Lavadora lav = new Lavadora();
        lav.crearLavadora();
        lav.precioFinal();
        System.out.println("\nPresione intro para seguir...");
        try{System.in.read();}
        catch(IOException e)  {}
        Televisor tv = new Televisor();
        tv.crearTelevisor();
        tv.precioFinal();
    }
}
