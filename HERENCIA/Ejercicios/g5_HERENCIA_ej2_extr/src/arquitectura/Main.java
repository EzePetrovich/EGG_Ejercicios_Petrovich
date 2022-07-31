
package arquitectura;

import entity.Edificio;
import entity.EdificioDeOficinas;
import entity.Polideportivo;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        int polisTech = 0, polisNoTech = 0;
        
        ArrayList<Edificio> edificios = new ArrayList();
        
        Polideportivo p1 = new Polideportivo("RickySport", true, 50, 50, 30);
        edificios.add(p1);
        Polideportivo p2 = new Polideportivo("BobbyFit", false, 50, 50, 25);
        edificios.add(p2);
        EdificioDeOficinas o1 = new EdificioDeOficinas(15, 6, 9, 45, 50, 90);
        edificios.add(o1);
        EdificioDeOficinas o2 = new EdificioDeOficinas(20, 8, 11, 45, 50, 100);
        edificios.add(o2);
        
        for(Edificio e: edificios) {
            if(e instanceof Polideportivo) {
                if(((Polideportivo) e).isTechado()) {polisTech++;} else {polisNoTech++;}
                e.informarCalculos("POLIDEPORTIVO " + ((Polideportivo) e).getNombre() + ".");
            } else {
                e.informarCalculos("EDIFICIO DE OFICINAS.");
            }
        }
        
        System.out.println("\n• Polideportivos techados: " + polisTech);
        System.out.println("• Polideportivos no techados: " + polisNoTech);
        
        
    }
    
}
