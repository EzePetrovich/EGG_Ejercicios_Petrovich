
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor implements Serializable {
    
    // Attributes
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Boolean entry;
    
    // Getters
    
    public Integer getId() {return id;}
    public String getName() {return name;}
    public Boolean isEntry() {return entry;}
    
    // Setters
    
    public void setId(Integer id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setEntry(Boolean entry) {this.entry = entry;}
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Autor { id = " + id + "; name = " + name + " }";
    }
    
}
