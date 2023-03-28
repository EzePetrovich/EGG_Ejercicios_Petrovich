
package ecuacion;

import service.entity.RaicesService;
import entity.ecuacion.Raices;


public class Main {

    public static void main(String[] args) {
        RaicesService raiz = new RaicesService();
        Raices ecuacion = raiz.crearEcuacion();
        limpiarPantalla();
        System.out.println("ECUACION DE SEGUNDO GRADO");
        System.out.println();
        System.out.println(ecuacion.getA() + "X² + " + ecuacion.getB() + "X + " + ecuacion.getC());
        System.out.println();
        raiz.calcular(ecuacion);
    }
    
    public static void limpiarPantalla() {
        for(int i = 0; i < 5; i++) {
            System.out.println();
        }
    }
}
