
package entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Juego {
    
    private RevolverDeAgua revolver;
    private ArrayList<Jugador> jugadores;
    
    public static Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    public void llenarJuego() {
        
        revolver = new RevolverDeAgua();
        
        jugadores = new ArrayList();
        
        System.out.print("» Número de jugadores [2..6]: "); 
        int n_jug = read.nextInt();
        if(n_jug > 6 || n_jug < 2) {
            n_jug = 6;
        }
        revolver.llenarRevolver();
        for(int i = 1; i <= n_jug; i++) {
            jugadores.add(new Jugador(i));
        }
    }
    
    public void ronda(boolean fin) {
        Iterator<Jugador> it = jugadores.iterator();
        while(it.hasNext()) {
            Jugador player = it.next();
            System.out.println("Turno de: " + player);
            System.out.println();
            System.out.println("Presione intro para que dispare...");
            read.next();
            System.out.println("REVOLVER ANTES DE DISPARAR: " + revolver);
            player.disparo(revolver);
            if(player.getMojado()) {
                System.out.println("El jugador que se mojó fue: " + player);
                fin = true;
                System.out.println("REVOLVER: " + revolver);
                break;
            } else {System.out.println("REVOLVER DESPUÉS DE DISPARAR: " + revolver);}
            System.out.println();
        }
    }
    
    //Informar número de ronda, turno de jugador y resultado.
    
}
