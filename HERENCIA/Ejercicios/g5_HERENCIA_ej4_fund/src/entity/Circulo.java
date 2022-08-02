
package entity;

public class Circulo extends FormaGeometrica implements calculosFormas {
    
    // Attributes
    
    private int radio;
    private int diametro = radio * 2;
    
    // Constructors
    
    
    public Circulo(int radio, String unidadMedida) {
        super(unidadMedida);
        this.radio = radio;
        this.diametro = radio * 2;
    }
    
    // Getters

    public int getRadio() {return radio;}
    public int getDiametro() {return diametro;}
    
    // Setters

    public void setRadio(int radio) {this.radio = radio;}
    public void setDiametro(int diametro) {this.diametro = diametro;}
    
    // Methods of the class
    
    @Override
    public double calcularArea() {return PI * Math.pow(radio, 2);}
    
    @Override
    public double calcularPerimetro() {return PI * diametro;}
}
