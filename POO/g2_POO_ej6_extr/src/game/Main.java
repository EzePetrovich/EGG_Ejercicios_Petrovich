
package game;

import service.entity.AhorcadoService;
import entity.game.Ahorcado;

public class Main {


    public static void main(String[] args) {
        AhorcadoService serv = new AhorcadoService();
        Ahorcado game = serv.crearJuego();
        serv.juego(game);
    }
    
    public static void clearScreen() {
        for(int i = 0; i < 3; i++) {
            System.out.println();
        }
    }
    
}
