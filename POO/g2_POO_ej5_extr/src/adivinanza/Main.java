
package adivinanza;

import service.entity.MesService;
import entity.adivinanza.Mes;

public class Main {

    public static void main(String[] args) {
        MesService mserv = new MesService();
        Mes adiv = mserv.nuevaAdivinanza();
        mserv.adivinarMes(adiv);
    }
    
}
