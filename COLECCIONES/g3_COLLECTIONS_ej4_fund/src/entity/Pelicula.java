
package entity;

import java.util.Comparator;

public class Pelicula {
    private String titulo, director;
    private Integer duracion;
    public Pelicula() {}
    public Pelicula(String titulo, String director, int duracion) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
    }
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getDirector() {return director;}
    public void setDirector(String director) {this.director = director;}
    public Integer getDuracion() {return duracion;}
    public void setDuracion(int duracion) {this.duracion = duracion;}
    @Override
    public String toString() {return "[Título: " + titulo + "; Director: " + director + "; Duración: " + duracion + "]";}
    public static Comparator<Pelicula> ordenarPorDuracion = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula mov1, Pelicula mov2) {
            return mov2.getDuracion().compareTo(mov1.getDuracion());
        }
    };
    public static Comparator<Pelicula> ordenarPorTitulo = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula mov1, Pelicula mov2) {
            return mov2.getTitulo().compareTo(mov1.getTitulo());
        }
    };
    public static Comparator<Pelicula> ordenarPorDirector = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula mov1, Pelicula mov2) {
            return mov2.getDirector().compareTo(mov1.getDirector());
        }
    };
}
