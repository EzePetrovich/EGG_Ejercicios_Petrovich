
package entity;

public class Rectangulo extends FormaGeometrica implements calculosFormas {
    
    // Attributes
    
    private int base;
    private int altura;
    
    // Constructors
    
    public Rectangulo(int base, int altura, String unidadMedida) {
        super(unidadMedida);
        this.base = base;
        this.altura = altura;
    }
    
    // Getters

    public int getBase() {return base;}
    public int getAltura() {return altura;}
    
    // Setters

    public void setBase(int base) {this.base = base;}
    public void setAltura(int altura) {this.altura = altura;}
    
    // Methods of the class
    
    @Override
    public double calcularArea() {return base * altura;}
    
    @Override
    public double calcularPerimetro() {return (base + altura) * 2;}
}
