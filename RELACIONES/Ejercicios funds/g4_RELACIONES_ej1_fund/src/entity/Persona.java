
package entity;

public class Persona {
    private String name, surname;
    private Integer dni, edad;
    private Perro perro;
    
    public Persona() {}
    
    public Persona(String name, String surname, Integer dni, Integer edad) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.edad = edad;
        this.perro = new Perro();
    }
    
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    
    public String getSurname() {return surname;}
    public void setSurname(String surname) {this.surname = surname;}
    
    public Integer getDNI() {return dni;}
    public void setDNI(Integer dni) {this.dni = dni;}
    
    public Integer getEdad() {return edad;}
    public void setEdad(Integer edad) {this.edad = edad;}
    
    public Perro getPerro() {return perro;}
    public void setPerro(Perro perro) {this.perro = perro;}
    
    @Override
    public String toString() {return "{Nombre / apellido: " + name + " / " + surname + " | DNI: " + dni + " | Edad: "+ edad + " | Perro: " + perro.getName() + "}";}
}
