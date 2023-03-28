
package entity;

public class Polideportivo extends Edificio {
    
    // Attributes
    
    private String nombre;
    private boolean esTechado;
    
    // Constructors
    
    public Polideportivo() {}
    
    public Polideportivo(double ancho, double largo, double alto) {super(ancho, largo, alto);}

    public Polideportivo(String nombre, boolean esTechado, double ancho, double largo, double alto) {
        super(ancho, largo, alto);
        this.nombre = nombre;
        this.esTechado = esTechado;
    }
    
    // Getters

    public String getNombre() {return nombre;}
    public boolean isTechado() {return esTechado;}
    
    // Setters

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setEsTechado(boolean esTechado) {this.esTechado = esTechado;}

    // Methods of the class
    
    @Override
    public double calcularSuperficie() {return ancho * largo;}
    
    @Override
    public double calcularVolumen() {return ancho * largo * alto;}
    
    /*public void crearPolideportivo() {
        System.out.print("\n» Nombre del polideportivo: ");
        nombre = super.read.next();
        System.out.println("» Es techado [s/n]: ");
        esTechado = super.read.next().equalsIgnoreCase("s");
    }*/
    
}
