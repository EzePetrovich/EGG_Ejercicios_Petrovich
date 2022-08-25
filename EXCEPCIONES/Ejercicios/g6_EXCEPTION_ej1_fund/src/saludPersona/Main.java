// @author J Ezequiel Petrovich

package saludPersona;

import entity.Persona;
import service.PersonaService;

public class Main {
    public static void main(String[] args) {
        Persona p = new Persona("Eze", null, "Hombre", 68, 1.75);
        PersonaService serv = new PersonaService();
        try{
            if(serv.esMayorEdad(p)) {System.out.println("La persona es mayor de edad.");} 
            else {System.out.println("La persona es menor de edad.");}
        } catch(Exception e) {System.err.println(e.getMessage());}
    }
}
