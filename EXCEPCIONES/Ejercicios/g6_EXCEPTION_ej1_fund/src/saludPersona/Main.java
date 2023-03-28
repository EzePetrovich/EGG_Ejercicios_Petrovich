<<<<<<< HEAD
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
=======
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
>>>>>>> 9744b90784dd0a6f5c2cb2dc20ab7ea4ca4b0d5e
