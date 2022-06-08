
package circunferencia;

import entity.circunferencia.Circunferencia;
import service.entity.CircunferenceService;

public class Main {

    public static void main(String[] args) {
        CircunferenceService serv = new CircunferenceService();
        Circunferencia circ = serv.crearCircunferencia();
        
        System.out.println("Área: " + serv.areaCircunferencia(circ));
        System.out.println("Perímetro: " + serv.perimCircunferencia(circ));
                
    }
    
}
