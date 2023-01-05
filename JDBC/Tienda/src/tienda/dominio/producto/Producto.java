
package tienda.dominio.producto;

public class Producto {
    
    // Attributes
    
    private int cod_prod;
    private String nombre;
    private double precio;
    private int cod_fab;
    
    
    // Constructors
    
    public Producto() {}
    
    public Producto(int cod_prod, String nombre, double precio, int cod_fab) {
        this.cod_prod = cod_prod;
        this.nombre = nombre;
        this.precio = precio;
        this.cod_fab = cod_fab;
    }
    
    // Getters
    
    public int getCodProd() {return cod_prod;}
    public String getNombre() {return nombre;}
    public double getPrecio() {return precio;}
    public int getCodFab() {return cod_fab;}
    
    // Setters
    
    public void setCodProd(int cod_prod) {this.cod_prod = cod_prod;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setPrecio(double precio) {this.precio = precio;}
    public void setCodFab(int cod_fab) {this.cod_fab = cod_fab;}
    
    
    // toString
    
    @Override
    public String toString() {return "{cod_prod: " + cod_prod + " | nombre: " + nombre + " | precio: " + precio + " | cod_fab: " + cod_fab + "}";}
    
}
