/**
 * @author J. Ezequiel Petrovich
 */

package entity;

import java.util.Comparator;

public abstract class Persona implements Tools {
    
    // Attributes
    
    protected String nombre, apellido, sexo, dni, estadoCivil;
    
    // Constructors
    
    public Persona() {}

    public Persona(String nombre, String apellido, String sexo, String dni, String estadoCivil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dni = dni;
        this.estadoCivil = estadoCivil;
    }
    
    // Getters
    
    public String getNombre() {return nombre;}
    public String getApellido() {return apellido;}
    public String getSexo() {return sexo;}
    public String getDni() {return dni;}
    public String getEstadoCivil() {return estadoCivil;}
    
    // Setters

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public void setSexo(String sexo) {this.sexo = sexo;}
    public void setDni(String dni) {this.dni = dni;}
    public void setEstadoCivil(String estadoCivil) {this.estadoCivil = estadoCivil;}

    // Method of the class
    
    public void cambioEstadoCivil() {
        System.out.println("\n• ESTADO CIVIL.");
        System.out.println("\n· Soltero/a → S");
        System.out.println("· Casado/a → C");
        System.out.println("· Viudo/a → V");
        System.out.println("· Divorciado/a → D");
        System.out.print("\n» Seleccione una opcion [S|C|V|D]: ");
        switch(read.next().toUpperCase()) {
            case "S":
                    if(sexo.equalsIgnoreCase("Masculino")) {estadoCivil = "Soltero";}
                    else {estadoCivil = "Soltera";}
                    break;
            case "C":
                    if(sexo.equalsIgnoreCase("Masculino")) {estadoCivil = "Casado";}
                    else {estadoCivil = "Casada";}
                    break;
            case "V":
                    if(sexo.equalsIgnoreCase("Masculino")) {estadoCivil = "Viudo";}
                    else {estadoCivil = "Viuda";}
                    break;
            case "D":
                    if(sexo.equalsIgnoreCase("Masculino")) {estadoCivil = "Divorciado";}
                    else {estadoCivil = "Divorciada";}
                    break;
            default:
                System.out.println("\nERROR: opcion no valida.");
                Tools.presioneIntro();
        }
    }
    
    public static Comparator<Persona> compararClasses = new Comparator<Persona>() {
      @Override
      public int compare(Persona p1, Persona p2) {
          return p1.getClass().getName().compareTo(p2.getClass().getName());
      }
    };
}
