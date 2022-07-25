
package adopcion;

import entity.Perro;
import java.util.ArrayList;
import entity.Persona;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String resp;
        String name, surname; Integer edad, dni;
        String raza, tamaño;
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        
        ArrayList<Persona> personas = new ArrayList();
        
        do {
            System.out.print("¿Ingresar una persona? [S/N]: "); resp = read.next();
            System.out.println();
            if(!resp.equalsIgnoreCase("n")) {
                System.out.println("PERSONA.");
                System.out.println();
                System.out.print("Nombre: "); name = read.next();
                System.out.print("Apellido: "); surname = read.next();
                System.out.print("DNI: "); dni = read.nextInt();
                System.out.print("Edad: "); edad = read.nextInt();
                personas.add(new Persona(name, surname, dni, edad));
                System.out.println();
            }
        } while(!resp.equalsIgnoreCase("n"));
        
        ArrayList<Perro> perros = new ArrayList();
        
        do {
            System.out.print("¿Ingresar un perro? [S/N]: "); resp = read.next();
            System.out.println();
            if(!resp.equalsIgnoreCase("n")) {
                System.out.println("PERRO.");
                System.out.println();
                System.out.print("Nombre: "); name = read.next();
                System.out.print("Raza: "); raza = read.next();
                System.out.print("Tamaño: "); tamaño = read.next();
                System.out.print("Edad: "); edad = read.nextInt();
                perros.add(new Perro(name, raza, tamaño, edad));
                System.out.println();
            }
        } while(!resp.equalsIgnoreCase("n"));
        
        ArrayList<Perro> adoptados = new ArrayList();
        boolean adopt;
        
        for(Persona person: personas) {
            adopt = perros.isEmpty();
            while(adopt != true && adoptados.size() != perros.size()) {
                System.out.println("¡Hola " + person.getName() + "!");
                System.out.println();
                System.out.println("1) Ver perros.");
                System.out.println("2) Adoptar un perro.");
                System.out.println();
                System.out.print("» Ingrese una opción [1 | 2]: "); resp = read.next();
                System.out.println();
                switch(resp) {
                    case "1":
                        System.out.println("PERROS.");
                        System.out.println();
                        perros.forEach((dog) -> {System.out.println(dog);});
                        System.out.print("Presione intro para seguir...");
                        read.next();
                        break;
                    case "2":
                        System.out.print("» Ingrese el nombre del perro: "); resp = read.next();
                        System.out.println();
                        Iterator<Perro> it = perros.iterator();
                        Perro dog; boolean findPerro = false;
                        while(it.hasNext()) {
                            dog = it.next();
                            if(dog.getName().equals(resp)) {
                                findPerro = true;
                                boolean findAdopt = false;
                                Iterator<Perro> it2 = adoptados.iterator();
                                Perro dogAdopt;
                                while(it2.hasNext()) {
                                    dogAdopt = it2.next();
                                    if(dogAdopt.getName().equals(resp)) {findAdopt = true;}
                                }
                                if(!findAdopt) {
                                    person.setPerro(dog);
                                    adoptados.add(dog);
                                    adopt = true;
                                    System.out.println("¡Felicidades adoptaste un perro!. ¡Hasta luego!.");
                                    System.out.println();
                                    System.out.print("Presione intro para seguir...");
                                    read.next();
                                } else {
                                    System.out.println("El perro ingresado ya fue adoptado.");
                                    System.out.println();
                                    System.out.print("Presione intro para seguir...");
                                    read.next();
                                }
                                break;
                            }
                        }
                        if(!findPerro) {
                            System.out.println("No existe el perro ingresado.");
                            System.out.println();
                            System.out.print("Presione intro para seguir...");
                            read.next();
                        }
                        break;
                    default:
                        System.out.println("ERROR: opción ingresada no válida.");
                        System.out.println();
                        System.out.print("Presione intro para seguir...");
                        read.next();
                }
            }
        }
        System.out.println();
        if(adoptados.size() == perros.size()) {System.out.println("Ya no quedan perros por adoptar.");}
        System.out.println();
        System.out.println("PERSONAS.");
        System.out.println();
        personas.forEach((person) -> {System.out.println(person);});
    }
}
