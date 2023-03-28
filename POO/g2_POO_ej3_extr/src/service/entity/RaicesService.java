
package service.entity;

import entity.ecuacion.Raices;
import java.util.Scanner;

public class RaicesService {
    
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    public Raices crearEcuacion() {
        System.out.println("ECUACIÓN DE SEGUNDO GRADO");
        System.out.println();
        System.out.println("aX² + bX + c");
        System.out.println();
        System.out.print("» Ingrese a: ");
        double a = read.nextDouble();
        System.out.print("» Ingrese b: ");
        double b = read.nextDouble();
        System.out.print("» Ingrese c: ");
        double c = read.nextDouble();
        System.out.println();
        return new Raices(a, b, c);
    }
    
    public double getDiscriminante(Raices eq) {
        return (Math.pow(eq.getB(), 2)) - 4 * eq.getA() * eq.getC();
    }
    
    public boolean tieneRaices(Raices eq) {
        return getDiscriminante(eq) > 0;
    }
    
    public boolean tieneRaiz(Raices eq) {
        return getDiscriminante(eq) == 0;
    }
    
    public boolean sinSolucion(Raices eq) {
        return getDiscriminante(eq) < 0;
    }
    
    public void obtenerRaices(Raices eq) {
        if(tieneRaices(eq)) {
            System.out.println("RAÍCES");
            System.out.println();
            double x1 = (-eq.getB() + Math.sqrt(getDiscriminante(eq)))/(2*eq.getA());
            System.out.println("x1 = " + x1);
            double x2 = (-eq.getB() - Math.sqrt(getDiscriminante(eq)))/(2*eq.getA());
            System.out.println("x2 = " + x2);
            System.out.println();
        }
    }
    
    public void obtenerRaiz(Raices eq) {
        if(tieneRaiz(eq)) {
            System.out.println("RAÍZ");
            System.out.println();
            double x1 = (-eq.getB() + Math.sqrt(getDiscriminante(eq)))/(2*eq.getA());
            System.out.println("x = " + x1);
            System.out.println();
        }
    }
    
    public void calcular(Raices eq) {
        if(!sinSolucion(eq)) {
            obtenerRaices(eq);
            obtenerRaiz(eq);
        } else {
            System.out.println("La ecuación ingresada no tiene solución dentro de los números reales.");
        }
    }
}
