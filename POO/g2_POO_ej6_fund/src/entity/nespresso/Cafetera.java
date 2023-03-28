
package entity.nespresso;

public class Cafetera {
    
    private int capMax;
    private int cantAct;
    
    public Cafetera() {
    }
    
    public Cafetera(int capMax, int capAct) {
        this.capMax = capMax;
        this.cantAct = capAct;
    }

    public int getCapMax() {
        return capMax;
    }

    public void setCapMax(int capMax) {
        this.capMax = capMax;
    }

    public int getCantAct() {
        return cantAct;
    }

    public void setCantAct(int capAct) {
        this.cantAct = capAct;
    }
    
}
