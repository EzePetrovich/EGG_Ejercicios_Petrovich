
package cine;

import entity.Sala;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        Sala s = new Sala();
        s.crearPelicula();
        System.out.print("» Número de espectadores: "); int nEsp = read.nextInt();
        System.out.println();
        s.crearEspectadores(nEsp);
        s.ubicarEspectadores();
        s.verSala();
    }
}
