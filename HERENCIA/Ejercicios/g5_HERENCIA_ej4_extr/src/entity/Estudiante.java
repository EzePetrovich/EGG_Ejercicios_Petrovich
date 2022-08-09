/**
 * @author J. Ezequiel Petrovich
 */

package entity;

public final class Estudiante extends Persona {
    
    // Attribute
    
    private String cursoActual; // lenguajes, matemáticas, arquitectura...
    
    // Constructors
    
    public Estudiante() {}
    
    public Estudiante(String cursoActual, String nombre, String apellido, String sexo, String dni, String estadoCivil) {
        super(nombre, apellido, sexo, dni, estadoCivil);
        this.cursoActual = cursoActual;
    }
    
    // Getter
    
    public String getCursoActual() {return cursoActual;}
    
    // Setter

    public void setCursoActual(String cursoActual) {this.cursoActual = cursoActual;}
    
    // Methods of the class
    
    public void matricularEstudiante() {
        System.out.print("\n» Ingrese nuevo curso: ");
        cursoActual = read.next();
    }
    
    @Override
    public String toString() {return "\nESTUDIANTE." + "\nNombre y apellido: " + nombre + " " + apellido + "\nSexo: " + sexo + "\nDNI: " + dni + "\nEstado civil: " + estadoCivil + "\nCurso actual: " + cursoActual;}
}
