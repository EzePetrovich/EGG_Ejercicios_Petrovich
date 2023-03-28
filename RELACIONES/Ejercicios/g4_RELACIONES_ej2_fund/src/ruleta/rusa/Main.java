
package ruleta.rusa;

import entity.Juego;

public class Main {

    public static void main(String[] args) {
        int n_ronds = 1;
        boolean fin = false;
        Juego ruletaRusa = new Juego();
        ruletaRusa.llenarJuego();
        System.out.println();
        do {
            System.out.println("RONDA " + n_ronds);
            ruletaRusa.ronda(fin);
            n_ronds++;
        } while(fin);
    }
    
}
