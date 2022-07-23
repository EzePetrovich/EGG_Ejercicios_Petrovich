
package cartas.españolas;

import entity.Baraja;

public class Main {

    public static void main(String[] args) {
        Baraja cartasEsp = new Baraja();
        cartasEsp.mostrarBaraja();
        cartasEsp.barajar();
        cartasEsp.mostrarBaraja();
        cartasEsp.cartasMonton();
    }
    
}
