
package service.entity;

import java.util.Date;
import java.util.Scanner;
import entity.personas.Persona;

public class PersonaService {
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    public Persona creaPersona() {
        System.out.println("PERSONA.");
        System.out.println();
        System.out.print("» Ingrese el nombre: ");
        String nombre = read.next();
        System.out.println();
        System.out.println("FECHA DE NACIMIENTO.");
        System.out.println();
        System.out.print("» Ingrese dia: ");
        int dia = read.nextInt();
        System.out.print("» Ingrese mes: ");
        int mes = read.nextInt() - 1;
        System.out.print("» Ingrese anio: ");
        int anio = read.nextInt() - 1900;
        System.out.println();
        Date fechaNac = new Date(anio, mes, dia);
        return new Persona(nombre, fechaNac);
    }
    
    public int calcularEdad(Persona p) {
        Date fechaAct = new Date();
        int edad = (fechaAct.getYear() - p.getFechaNac().getYear()) - 1;
        if(fechaAct.getMonth() >= p.getFechaNac().getMonth()) {
            if(fechaAct.getDate() >= p.getFechaNac().getDate()) {
                edad++;
            }
        } 
        return edad;
    }
    
    public int menorQue(Persona p, int edad) {
        int es;
        if(calcularEdad(p) < edad) {
            es = -1;
        } else if (calcularEdad(p) == edad) {
            es = 0;
        } else {
            es = 1;
        }
        return es;
    }
    
    public void mostrarPersona(Persona p) {
        System.out.println();
        System.out.println("PERSONA.");
        System.out.println();
        System.out.println("Nombre: " + p.getNombre());
        System.out.println("Fecha de nacimiento: " + p.getFechaNac());
        System.out.println();
    }

}
