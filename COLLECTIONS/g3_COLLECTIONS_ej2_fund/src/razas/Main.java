
package razas;

import service.entity.PerroService;
import entity.Perro;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        PerroService serv = new PerroService();
        ArrayList <Perro> perritos = serv.listarRazas();
        serv.buscarPerro(perritos);
    }
    
}
