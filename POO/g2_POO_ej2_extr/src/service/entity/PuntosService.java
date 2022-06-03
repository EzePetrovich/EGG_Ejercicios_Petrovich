
package service.entity;

import java.util.Scanner;
import entity.distancia.puntos.Puntos;

public class PuntosService {
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    public Puntos crearPuntos() {
        Puntos p = new Puntos();
        int x, y;
        for(int i = 1; i <= 2; i++) {
            System.out.println("COORDENADAS DEL PUNTO " + i + ".");
            System.out.println();
            System.out.print("» Ingrese x" + i + ": ");
            x = read.nextInt();
            System.out.print("» Ingrese y" + i + ": ");
            y = read.nextInt();
            System.out.println();
            if(i == 1) {
                p.setX1(x);
                p.setY1(y);
            } else {
                p.setX2(x);
                p.setY2(y);
            }
        }
        return p;
    }
    
    public double calcularDistancia(Puntos p) {
       return Math.sqrt(Math.pow((double) (p.getX2() - p.getX1()),2) + Math.pow((double) (p.getY2() - p.getY1()),2));
    }
}
