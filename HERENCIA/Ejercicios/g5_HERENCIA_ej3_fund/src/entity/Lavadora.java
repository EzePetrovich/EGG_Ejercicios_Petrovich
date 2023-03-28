
package entity;

public final class Lavadora extends Electrodomestico {
    
    // Attributes
    
    private int carga;
    
    // Constructors
    
    public Lavadora() {}
    
    public Lavadora(int carga, String color, char consumEnerg, int peso) {
        super(color, consumEnerg, peso);
        this.carga = carga;
    }
    
    // Getter and setter
    
    public int getCarga() {return carga;}
    public void setCarga(int carga) {this.carga = carga;}
    
    // Methods of the class
    
    public void crearLavadora() {
        super.crearElectrodomestico("LAVADORA");
        System.out.print("» Carga: ");
        setCarga(super.read.nextInt());
    }
    
    @Override
    public void precioFinal() {
        if(carga > 30) {precio = round(precio + 500, 2);}
        System.out.println("\nPrecio final de la lavadora: $" + precio);
    }
}
