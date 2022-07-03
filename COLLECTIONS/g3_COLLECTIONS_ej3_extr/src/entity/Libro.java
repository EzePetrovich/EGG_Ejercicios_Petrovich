
package entity;

public class Libro {
    private String titulo, autor;
    private Integer numEj, numEjP;
    
    public Libro() {}
    public Libro(String titulo, String autor, Integer numEj, Integer numEjP) {
        this.titulo = titulo;
        this.autor = autor;
        this.numEj = numEj;
        this.numEjP = numEjP;
    }
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getAutor() {return autor;}
    public void setAutor(String autor) {this.autor = autor;}
    public Integer getNumEj() {return numEj;}
    public void setNumEj(Integer numEj) {this.numEj = numEj;}
    public Integer getNumEjP() {return numEjP;}
    public void setNumEjP(Integer numEjP) {this.numEjP = numEjP;}
    @Override
    public String toString() {return "{Título: " + titulo + "; Autor: " + autor + "; Ejemplares: " + numEj + "; Prestados: " + numEjP + "}";}
    public boolean prestamo() {
        int n = 1;
        if(numEj - 1 >= 0) {
            n = 0;
            numEj = numEj - 1;
            numEjP = numEjP + 1;
        }
        return numEj - n >= 0;
    }
    public boolean devolucion() {
        int n = 1;
        if(numEjP - 1 >= 0) {
            n = 0;
            numEj = numEj + 1;
            numEjP = numEjP - 1;
        }
        return numEjP - n >= 0;
    }
}
