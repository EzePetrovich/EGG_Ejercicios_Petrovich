
package personas;

import java.util.Scanner;
import service.entity.PersonaService;
import entity.personas.Persona;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        PersonaService serv = new PersonaService();
        Persona p1 = serv.creaPersona();
        Persona p2 = serv.creaPersona();
        System.out.println("La edad de " + p1.getNombre() + " es: " + serv.calcularEdad(p1) + "anios");
        System.out.println("La edad de " + p2.getNombre() + " es: " + serv.calcularEdad(p2) + "anios");
        switch(serv.menorQue(p1, serv.calcularEdad(p2))) {
            case -1:
                System.out.println(p1.getNombre() + " es menor que " + p2.getNombre() + ".");
                break;
            case 0:
                System.out.println(p1.getNombre() + " tiene la misma edad que " + p2.getNombre() + ".");
                break;
            case 1:
                System.out.println(p1.getNombre() + " es mayor que " + p2.getNombre() + ".");
                break;
        }
        serv.mostrarPersona(p1);
        serv.mostrarPersona(p2);
    }
    
}
