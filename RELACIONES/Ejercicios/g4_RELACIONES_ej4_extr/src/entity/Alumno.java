
package entity;

import java.util.Comparator;

public class Alumno {
    
    // Attributes
    
    private String completeName;
    private Integer dni, n_votos = 0;
    
    // Constructors
    
    public Alumno() {}

    public Alumno(String completeName, int dni, int n_votos) {
        this.completeName = completeName;
        this.dni = dni;
        this.n_votos = n_votos;
    }
    
    // Getters
    
    public String getCompleteName() {return completeName;}
    public Integer getDNI() {return dni;}
    public Integer getNVotos() {return n_votos;}
    
    // Setters
    
    public void setCompleteName(String completeName) {this.completeName = completeName;}
    public void setDNI(Integer dni) {this.dni = dni;}
    public void setNVotos(Integer n_votos) {this.n_votos = n_votos;}
    
    // toString()
    
    @Override
    public String toString() {return "\n• Alumno: " + completeName + "\n• DNI: " + dni + "\n• Nº de votos: " + n_votos;}

    // Comparator
    
    public static Comparator<Alumno> compararVotos = new Comparator<Alumno>() {
        @Override
        public int compare(Alumno a1, Alumno a2) {
            return a2.getNVotos().compareTo(a1.getNVotos());
        }
    };

}
