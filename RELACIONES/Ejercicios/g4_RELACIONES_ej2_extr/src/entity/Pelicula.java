
package entity;

public class Pelicula {
    
    // Attributes
    
    private String titulo, director;
    private int duracion, edadMin;
    
    // Constructores
    
    public Pelicula() {}
    
    public Pelicula(String titulo, String director, int duracion, int edadMin) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.edadMin = edadMin;
    }
    
    // Getters and setters
    
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    
    public String getDirector() {return director;}
    public void setDirector(String director) {this.director = director;}
    
    public int getDuracion() {return duracion;}
    public void setDuracion(int duracion) {this.duracion = duracion;}
    
    public int getEdadMin() {return edadMin;}
    public void setEdadMin(int edadMin) {this.edadMin = edadMin;}
    
    // toString()
    
    @Override
    public String toString() {return "{Título: " + titulo + " | Director: " + director + " | Duración: " + duracion + " | Clasificación: +" + edadMin + "}";}
}
