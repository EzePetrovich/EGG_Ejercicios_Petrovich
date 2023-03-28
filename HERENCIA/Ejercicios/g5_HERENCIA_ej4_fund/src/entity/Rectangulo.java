<<<<<<< HEAD

package entity;

public final class Rectangulo extends FormaGeometrica {
    
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
=======

package entity;

public final class Rectangulo extends FormaGeometrica {
    
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
>>>>>>> 9744b90784dd0a6f5c2cb2dc20ab7ea4ca4b0d5e
