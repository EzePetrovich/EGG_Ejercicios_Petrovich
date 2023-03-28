
package distancia.puntos;

import service.entity.PuntosService;
import entity.distancia.puntos.Puntos;

public class Main {

    public static void main(String[] args) {
        PuntosService pserv = new PuntosService();
        Puntos p = pserv.crearPuntos();
        System.out.println("La distancia entre los puntos es: " + pserv.calcularDistancia(p));
    }
    
}
