/**
 * @author J. Ezequiel Petrovich
 */

package entity;

public abstract class Empleado extends Persona {
    
    // Attributes
    
    protected Integer anioIncorp, numDesp;
    
    // Constructors

    public Empleado() {}

    public Empleado(Integer anioIncorp, Integer numDesp, String nombre, String apellido, String sexo, String dni, String estadoCivil) {
        super(nombre, apellido, sexo, dni, estadoCivil);
        this.anioIncorp = anioIncorp;
        this.numDesp = numDesp;
    }
    
    // Getters

    public Integer getAnioIncorp() {return anioIncorp;}
    public Integer getNumDesp() {return numDesp;}
    
    // Setters

    public void setAnioIncorp(Integer anioIncorp) {this.anioIncorp = anioIncorp;}
    public void setNumDesp(Integer numDesp) {this.numDesp = numDesp;}

    // Method of the class

    public void reasignacionDespacho() {
        System.out.print("\n» Nuevo despacho: ");
        numDesp = read.nextInt();
    }
}
