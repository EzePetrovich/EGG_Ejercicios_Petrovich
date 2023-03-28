<<<<<<< HEAD

package service.entity;
import entity.circunferencia.Circunferencia;
import java.util.Scanner;

public class CircunferenceService {
    Scanner read = new Scanner(System.in);
    
    
    
    public Circunferencia crearCircunferencia() {
        System.out.print("» Ingrese el radio de la circunferencia: ");
        double rad = read.nextDouble();
        return new Circunferencia(rad);
    }
    
    
    public double areaCircunferencia(Circunferencia circ) {
        double area, rad, pi = 3.141592654;
        rad = circ.getRad();
        area = pi * Math.pow(rad, 2);
        return area;
    }
    public double perimCircunferencia(Circunferencia circ) {
        double perim, rad, pi = 3.141592654;
        rad = circ.getRad();
        perim = 2*pi*rad;
        return perim;
    }
}
=======

package service.entity;
import entity.circunferencia.Circunferencia;
import java.util.Scanner;

public class CircunferenceService {
    Scanner read = new Scanner(System.in);
    
    
    
    public Circunferencia crearCircunferencia() {
        System.out.print("» Ingrese el radio de la circunferencia: ");
        double rad = read.nextDouble();
        return new Circunferencia(rad);
    }
    
    
    public double areaCircunferencia(Circunferencia circ) {
        double area, rad, pi = 3.141592654;
        rad = circ.getRad();
        area = pi * Math.pow(rad, 2);
        return area;
    }
    public double perimCircunferencia(Circunferencia circ) {
        double perim, rad, pi = 3.141592654;
        rad = circ.getRad();
        perim = 2*pi*rad;
        return perim;
    }
}
>>>>>>> 9744b90784dd0a6f5c2cb2dc20ab7ea4ca4b0d5e
