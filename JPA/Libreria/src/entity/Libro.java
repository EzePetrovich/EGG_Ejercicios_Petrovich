
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Libro implements Serializable {
    
    // Attributes
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long isbn;
    private String titulo;
    private Integer anio;
    private Integer ejemplares;
    private Integer ejemplaresPrest;
    private Integer ejemplaresDisp;
    private Boolean alta;
    
    @ManyToOne
    private Autor autor;
    
    @ManyToOne
    private Editorial editorial;
    
    // Getters
    
    public Long getIsbn() {return isbn;}
    public String getTitulo() {return titulo;}
    public Integer getAnio() {return anio;}
    public Integer getEjemplares() {return ejemplares;}
    public Integer getEjemplaresPrest() {return ejemplaresPrest;}
    public Integer getEjemplaresDisp() {return ejemplaresDisp;}
    public Boolean isAlta() {return alta;}
    public Autor getAutor() {return autor;}
    public Editorial getEditorial() {return editorial;}
    
    // Setters

    public void setIsbn(Long isbn) {this.isbn = isbn;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public void setAnio(Integer anio) {this.anio = anio;}
    public void setEjemplares(Integer ejemplares) {this.ejemplares = ejemplares;}
    public void setEjemplaresPrest(Integer ejemplaresPrest) {this.ejemplaresPrest = ejemplaresPrest;}
    public void setEjemplaresDisp(Integer ejemplaresDisp) {this.ejemplaresDisp = ejemplaresDisp;}
    public void setAlta(Boolean alta) {this.alta = alta;}
    public void setAutor(Autor autor) {this.autor = autor;}
    public void setEditorial(Editorial editorial) {this.editorial = editorial;}
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Libro[ id=" + isbn + " ]";
    }
        
}
