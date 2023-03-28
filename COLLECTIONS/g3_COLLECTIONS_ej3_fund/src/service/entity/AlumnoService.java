
package service.entity;

import java.util.Scanner;
import entity.Alumno;
import java.util.ArrayList;
import java.util.Iterator;

public class AlumnoService {
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    public Alumno crearAlumno() {
        ArrayList <Integer> notas = new ArrayList(); int not;
        System.out.print("» Ingrese el nombre: "); String nombre = read.next();
        System.out.println();
        for(int i = 0; i < 3; i++) {
            System.out.print("• Nota " + (i + 1) + ": ");
            not = read.nextInt();
            notas.add(not);
        }
        return new Alumno(nombre, notas);
    }
    public void notaFinal(ArrayList <Alumno> alumnos) {
        int sumat = 0, not_fin = 0;
        boolean find = false;
        Iterator <Alumno> it1 = alumnos.iterator();
        System.out.println();
        System.out.print("» Ingrese el nombre de un alumno: "); String nombre = read.next();
	while(it1.hasNext()) {
            Alumno al = it1.next();
            if(al.getNombre().equals(nombre)) {
                find = true;
                Iterator <Integer> it2 = al.getNotas().iterator();
                while(it2.hasNext()) {sumat = sumat + it2.next();}
                not_fin = (int) (sumat / 3);
            }
	}
        System.out.println();
        if(find) {System.out.println("La nota final del alumno es: " + not_fin);} 
        else {System.out.println("No se encontró el alumno ingresado.");}
    }
}
