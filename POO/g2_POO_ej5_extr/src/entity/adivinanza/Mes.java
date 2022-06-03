
package entity.adivinanza;

public class Mes {
    private String [] meses = new String [12];
    private String mesSecreto;
    
    public Mes() {
    }
    
    public Mes(String [] meses, String mesSecreto) {
        this.meses = meses;
        this.mesSecreto = mesSecreto;
    }
    
    public String [] getMeses() {
        return meses;
    }
    
    public void setMeses(String [] meses) {
        this.meses = meses;
    }
    
    public String getMesSecreto() {
        return mesSecreto;
    }
    
    public void setMesSecreto(String mesSecreto) {
        this.mesSecreto = mesSecreto;
    }
}
