
package main.cancion;

import service.cancion.CancionService;
import entity.cancion.Cancion;

public class Main {

    public static void main(String[] args) {
        CancionService serv = new CancionService();
        Cancion song = serv.crearCancion();
        serv.mostrarCancion(song);
    }
    
}
