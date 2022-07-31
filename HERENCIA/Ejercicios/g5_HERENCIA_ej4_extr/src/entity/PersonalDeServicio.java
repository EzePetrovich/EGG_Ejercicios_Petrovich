/**
 * @author J. Ezequiel Petrovich
 */

package entity;

public class PersonalDeServicio extends Empleado {
    
    // Attribute
    
    private String seccion; // biblioteca, decanato, secretaría...

    // Constructors
    
    public PersonalDeServicio() {}

    public PersonalDeServicio(String seccion, Integer anioIncorp, Integer numDesp, String nombre, String apellido, String sexo, String dni, String estadoCivil) {
        super(anioIncorp, numDesp, nombre, apellido, sexo, dni, estadoCivil);
        this.seccion = seccion;
    }
    
    // Getters
        
    public String getSeccion() {return seccion;}
    
    // Setters
    
    public void setSeccion(String seccion) {this.seccion = seccion;}
    
    // Method of the class
    
    public void trasladarSeccion() {
        super.reasignacionDespacho();
        System.out.print("» Nueva seccion: ");
        seccion = read.next();
    }
    
    @Override
    public String toString() {return "\nPERSONAL DE SERVICIO." + "\nNombre y apellido: " + nombre + " " + apellido + "\nSexo: " + sexo + "\nDNI: " + dni + "\nEstado civil: " + estadoCivil + "\nSeccion: " + seccion + "\nNº Despacho: " + numDesp + "\nAnio incorporacion: " + anioIncorp;}
}
