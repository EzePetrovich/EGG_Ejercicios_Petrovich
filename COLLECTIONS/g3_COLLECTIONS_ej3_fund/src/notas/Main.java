
package notas;

import entity.Alumno;
import java.util.ArrayList;
import java.util.Scanner;
import service.entity.AlumnoService;

public class Main {
    public static void main(String[] args) {
        AlumnoService serv = new AlumnoService();
        ArrayList <Alumno> alumnos = new ArrayList(); String resp = ""; 
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        while(!resp.equalsIgnoreCase("n")) {
            System.out.print("» ¿Desea ingresar un alumno nuevo? [S/N]: "); resp = read.next();
            if(!resp.equalsIgnoreCase("n")) {
                alumnos.add(serv.crearAlumno());
                System.out.println();
            }
        }
        serv.notaFinal(alumnos);
    }
}
