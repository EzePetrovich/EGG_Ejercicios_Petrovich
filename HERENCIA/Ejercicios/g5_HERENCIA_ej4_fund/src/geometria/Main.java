
package geometria;

import entity.Circulo;
import entity.Rectangulo;

public class Main {

    public static void main(String[] args) {
        Circulo c = new Circulo(4, "cm");
        Rectangulo r = new Rectangulo(4, 2, "cm");
        c.mostrarCalculos("CIRCULO.");
        r.mostrarCalculos("RECTANGULO.");
    }
    
}
