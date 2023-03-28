
package entity;

public class Jugador {
    private final int id;
    private final String name;
    private boolean mojado;
    
    public boolean getMojado() {return mojado;}    
    
    public Jugador(int id) {
        this.id = id;
        this.name = "Jugador " + id;
    }
    
    public void disparo(RevolverDeAgua r) {
        mojado = r.mojar();
        if(!mojado) {
            r.siguienteChorro();
        }
    }
    
    @Override
    public String toString() {return name;}
    
}
