
package Entity.Rectangulo;

public class Rectangulo {
    private int base;
    private int altura;
    
    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }
    
    public Rectangulo() {
    }
    
    public void setBase(int base) {
        this.base = base;
    }
    
    public int getBase() {
        return base;
    }
    
    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public int getAltura() {
        return altura;
    }
}
