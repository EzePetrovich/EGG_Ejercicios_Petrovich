
package tienda.dominio.fabricante;

public class Fabricante {
    
    // Attributes
    
    private int cod_fab;
    private String nombre;
    
    // Constructors
    
    public Fabricante() {}
    
    public Fabricante(int cod_fab, String nombre) {
        this.cod_fab = cod_fab;
        this.nombre = nombre;
    }
    
    // Getters

    public int getCodFab() {return cod_fab;}
    public String getNombre() {return nombre;}
    
    // Setters
    
    public void setCodFab(int cod_fab) {this.cod_fab = cod_fab;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    
    // toString
    
    @Override
    public String toString() {return "{cod_fab: " + cod_fab + " | nombre: " + nombre + "}";}
    
}
