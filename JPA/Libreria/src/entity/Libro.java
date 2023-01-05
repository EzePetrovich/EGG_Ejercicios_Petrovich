
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
    private String title;
    private Integer year;
    private Integer exemplars;
    private Integer borrowedExemplars;
    private Integer availablesExemplars;
    private Boolean entry;
    
    @ManyToOne
    private Autor author;
    
    @ManyToOne
    private Editorial editorial;
    
    // Getters
    
    public Long getIsbn() {return isbn;}
    public String getTitle() {return title;}
    public Integer getYear() {return year;}
    public Integer getExemplars() {return exemplars;}
    public Integer getBorrowedExemplars() {return borrowedExemplars;}
    public Integer getAvailablesExemplars() {return availablesExemplars;}
    public Boolean isEntry() {return entry;}
    public Autor getAuthor() {return author;}
    public Editorial getEditorial() {return editorial;}
    
    // Setters

    public void setIsbn(Long isbn) {this.isbn = isbn;}
    public void setTitle(String title) {this.title = title;}
    public void setYear(Integer year) {this.year = year;}
    public void setExemplars(Integer exemplars) {this.exemplars = exemplars;}
    public void setBorrowedExemplars(Integer borrowedExemplars) {this.borrowedExemplars = borrowedExemplars;}
    public void setAvailablesExemplars(Integer availablesExemplars) {this.availablesExemplars = availablesExemplars;}
    public void setEntry(Boolean entry) {this.entry = entry;}
    public void setAuthor(Autor author) {this.author = author;}
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
        return "Libro {isbn = " + isbn + "; title = " + title + "; year = " + year + "; exemplars = " + exemplars + "; borrowedExemplars = " + borrowedExemplars + "; availablesExemplars = " + availablesExemplars + "; author = " + author.name + "; editorial = " + editorial.name + "}";
    }
        
}
