
package entity;

public class RevolverDeAgua {
    private int posAct, posAgua;
    private final int nPosTambor = 6;
    
    /**
     * Utilidad del atributo nPosTambor:
     * 
     * Supongamos el caso que posAgua sea 2 y posAct sea 3, al llamar al método siguienteChorro()
     * nunca va a llegar a la posición del agua, porque va a seguir incrementando hasta que posAct
     * sea igual a posAgua, nunca se va a terminar el juego. Por ello decidí determinar la cantidad
     * de posiciones del tambor del revolver.
     */
    public RevolverDeAgua() {}
    
    public void llenarRevolver() {
        posAct = (int) Math.round((Math.random() * 10 + 1) * 0.55); // Números aleatorios de 1 a 6
        posAgua = (int) Math.round((Math.random() * 10 + 1) * 0.55); // Números aleatorios de 1 a 6
    }
    
    public boolean mojar() {
        return posAct == posAgua;
    }
    
    public void siguienteChorro() {
        posAct++;
        if(posAct > nPosTambor) {
            posAct = 1;
        }
    }
    
    @Override
    public String toString() {return "(Gatillo en posición: " + posAct + " | Posición de agua: " + posAgua + ")";}
}
