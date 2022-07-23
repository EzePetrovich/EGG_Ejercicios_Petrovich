
package adopcion;

import entity.Persona;
import entity.Perro;

public class Main {

    public static void main(String[] args) {
        
        Persona eze = new Persona("Julio Ezequiel", "Petrovich", 41575465, 23);
        Persona lau = new Persona("Lautaro", "Sanchez Rios", 40342645, 23);
        Perro lula = new Perro("Lula", "Calle", "Mediana", 7);
        Perro tizon = new Perro("Tizón", "Weimaraner", "Grande", 4);
        eze.setPerro(lula); // Eze adopta a Lula
        System.out.println("Primer persona: ");
        System.out.println(eze);
        System.out.println("Perro adoptado: ");
        System.out.println(eze.getPerro());
        System.out.println();
        lau.setPerro(tizon); // Lau adopta a Tizón
        System.out.println("Segunda persona: ");
        System.out.println(lau);
        System.out.println("Perro adoptado: ");
        System.out.println(lau.getPerro());
    }
    
}
