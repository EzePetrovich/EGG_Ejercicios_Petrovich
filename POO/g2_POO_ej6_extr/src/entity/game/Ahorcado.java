
package entity.game;

public class Ahorcado {
    private String [] palabra_vect;
    private String [] palabra_adv;
    private int n_letr_acert, intentos;
    
    public Ahorcado() {
    }
    
    public Ahorcado(String [] palabra_vect, String [] palabra_adv, int intentos) {
        this.palabra_vect = palabra_vect;
        this.palabra_adv = palabra_adv;
        this.intentos = intentos;
        n_letr_acert = 0;
    }
    
    public String [] getPalabra() {
        return palabra_vect;
    }
    
    public void setPalabra(String [] palabra_vect) {
        this.palabra_vect = palabra_vect;
    }
    
    public String [] getPalabraAdv() {
        return palabra_adv;
    }
    
    public void setPalabraAdv(String [] palabra_adv) {
        this.palabra_adv = palabra_adv;
    }
    
    public int getLetrsAcert() {
        return n_letr_acert;
    }
    
    public void setLetrsAcert(int n_letr_acert) {
        this.n_letr_acert = n_letr_acert;
    }
    
    public int getIntentos() {
        return intentos;
    }
    
    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
}
