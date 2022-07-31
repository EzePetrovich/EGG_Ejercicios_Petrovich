/**
 * @author J. Ezequiel Petrovich
 */

package entity;

public class Profesor extends Empleado {
    
    // Attribute
    
    private String dpto; // lenguajes, matemáticas, arquitectura...
    
    // Constructors
    
    public Profesor() {}
    
    public Profesor(String dpto, Integer anioIncorp, Integer numDesp, String nombre, String apellido, String sexo, String dni, String estadoCivil) {
        super(anioIncorp, numDesp, nombre, apellido, sexo, dni, estadoCivil);
        this.dpto = dpto;
    }
    
    // Getter
    
    public String getDpto() {return dpto;}
    
    // Setter

    public void setDpto(String dpto) {this.dpto = dpto;}
    
    // Method of the class
    
    public void cambioDpto() {
        super.reasignacionDespacho();
        System.out.print("» Nuevo departamento: ");
        dpto = read.next();
    }
    
    @Override
    public String toString() {return "\nPROFESOR." + "\nNombre y apellido: " + nombre + " " + apellido + "\nSexo: " + sexo + "\nDNI: " + dni + "\nEstado civil: " + estadoCivil + "\nDepartamento: " + dpto + "\nNº Despacho: " + numDesp + "\nAnio incorporacion: " + anioIncorp;}
}
