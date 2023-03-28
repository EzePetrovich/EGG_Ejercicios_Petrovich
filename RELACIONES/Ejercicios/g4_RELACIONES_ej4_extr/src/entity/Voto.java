
package entity;

import java.util.ArrayList;

public class Voto {
    
    // Atributtes
    
    private Alumno alumno;
    private ArrayList<Alumno> alumnosVotados = new ArrayList();
    
    // Constructors
    
    public Voto() {}

    public Voto(Alumno alumno, ArrayList<Alumno> alumnosVotados) {
        this.alumno = alumno;
        this.alumnosVotados = alumnosVotados;
    }
    
    // Getters
    
    public Alumno getAlumno() {return alumno;}
    public ArrayList<Alumno> getAlumnosVotados() {return alumnosVotados;}
    
    // Setters
    
    public void setAlumno(Alumno alumno) {this.alumno = alumno;}
    public void setAlumnosVotados(ArrayList<Alumno> alumnosVotados) {this.alumnosVotados = alumnosVotados;}
    
    
    
}
