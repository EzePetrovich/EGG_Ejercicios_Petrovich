
package entity;

public class Perro {
    private String name, raza, tamaño;
    private Integer edad;
    
    public Perro() {}
    
    public Perro(String name, String raza, String tamaño, Integer edad) {
        this.name = name;
        this.raza = raza;
        this.tamaño = tamaño;
        this.edad = edad;
    }
    
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    
    public String getRaza() {return raza;}
    public void setRaza(String raza) {this.raza = raza;}
    
    public String getTamaño() {return tamaño;}
    public void setTamaño(String raza) {this.raza = raza;}
    
    public Integer getEdad() {return edad;}
    public void setEdad(Integer edad) {this.edad = edad;}
    
    
    @Override
    public String toString() {return "(Nombre: " + name + " | Raza: " + raza + " | Edad: " + edad + " | Tamaño: " + tamaño + ");";}
}
