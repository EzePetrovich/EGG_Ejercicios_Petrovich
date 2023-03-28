
package aparatos;

import entity.Electrodomestico;
import entity.Lavadora;
import entity.Televisor;
import java.util.ArrayList;



public class Main {

    public static void main(String[] args) {
        int precLavs = 0, precTvs = 0, precTot = 0;
        ArrayList<Electrodomestico> electrodomesticos = new ArrayList();
        Lavadora lv = new Lavadora();
        Lavadora lv1 = new Lavadora(85, "gris", 'B', 25);
        Lavadora lv2 = new Lavadora(85, "blanco", 'A', 35);
        Televisor tv1 = new Televisor(true, 55, "negro", 'A', 20);
        Televisor tv2 = new Televisor(false, 60, "gris", 'A', 25);
        electrodomesticos.add(lv1);
        electrodomesticos.add(lv2);
        electrodomesticos.add(tv1);
        electrodomesticos.add(tv2);
        for(Electrodomestico e: electrodomesticos) {
            e.precioFinal();
            precTot += e.getPrecio();
            if(e.getClass().equals(lv.getClass())) {precLavs += e.getPrecio();}
            else {precTvs += e.getPrecio();}
        }
        System.out.println("\nPrecio de lavadoras: $" + precLavs);
        System.out.println("\nPrecio de televisores: $" + precTvs);
        System.out.println("\nPrecio total de electrodomesticos: $" + precTot);
    }
    
}
