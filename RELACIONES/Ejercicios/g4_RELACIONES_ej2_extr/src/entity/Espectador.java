
package entity;

public class Espectador {
    
    // Attributes
    
    private String name, asiento;
    private int edad, dinero;
    
    // Constructores
    
    public Espectador() {}
    
    public Espectador(String name, int edad, int dinero) {
        this.name = name;
        this.edad = edad;
        this.dinero = dinero;
    }
    
    // Getters and setters
    
    public String getNombre() {return name;}
    public void setNombre(String name) {this.name =name;}
    
    public String getAsiento() {return asiento;}
    public void setAsiento(String asiento) {this.asiento = asiento;}
    
    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}
    
    public int getDinero() {return dinero;}
    public void setDinero(int dinero) {this.dinero = dinero;}
    
    // toString()
    
    @Override
    public String toString() {return "[Nombre: " + name + " | Edad: " + edad + " | Dinero: $" + dinero + " | Asiento: " + asiento + "]";}
}
