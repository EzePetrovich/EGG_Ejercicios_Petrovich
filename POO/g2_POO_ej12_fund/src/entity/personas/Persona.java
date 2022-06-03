
package entity.personas;

import java.util.Date;

public class Persona {
    private String nombre;
    private Date fechaNac;
    
    public Persona() {
    }
    
    public Persona(String nombre, Date fechaNac) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    public Date getFechaNac() {
        return fechaNac;
    }
}
