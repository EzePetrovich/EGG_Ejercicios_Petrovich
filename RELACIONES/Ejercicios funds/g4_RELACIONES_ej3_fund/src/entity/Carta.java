
package entity;

public class Carta {
    private final int num;
    private final String palo;
    
    public Carta() {
        int nCar;
        if ((int) (Math.random() * 10 + 1) % 2 == 0) {
            nCar = (int) Math.round((Math.random() * 10) * 0.6) + (int) Math.round((Math.random() * 10 + 1) * 0.55);
        } else {
            nCar = (int) Math.round((Math.random() * 10) * 0.6);
        }
        while(nCar == 8 || nCar == 9 || nCar == 0) {
            if ((int) (Math.random() * 10 + 1) % 2 == 0) {
            nCar = (int) Math.round((Math.random() * 10) * 0.6) + (int) Math.round((Math.random() * 10 + 1) * 0.55);
        } else {
            nCar = (int) Math.round((Math.random() * 10) * 0.6);
        }
        }
        num = nCar;
        if ((int) (Math.random() * 10 + 1) % 2 == 0) {
            if ((int) (Math.random() * 10 + 1) % 2 == 0) {palo = "espadas";} else {palo = "oros";}
        } else {
            if ((int) (Math.random() * 10 + 1) % 2 == 0) {palo = "bastos";} else {palo = "copas";}}
    }
    
    @Override
    public String toString() {return "(Número: " + num + " | Palo: " + palo + ")";}
}
