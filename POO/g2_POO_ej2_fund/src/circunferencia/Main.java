<<<<<<< HEAD

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
=======

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
>>>>>>> 9744b90784dd0a6f5c2cb2dc20ab7ea4ca4b0d5e
