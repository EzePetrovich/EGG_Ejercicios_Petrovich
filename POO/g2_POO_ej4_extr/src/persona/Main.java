
package persona;

import service.entity.NIFService;
import entity.persona.NIF;

public class Main {

    public static void main(String[] args) {
        NIFService serv = new NIFService();
        NIF persona = serv.crearNIF();
        serv.mostrarNIF(persona);
    }
    
}
