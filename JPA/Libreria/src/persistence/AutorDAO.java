package persistence;

import entity.Autor;
import java.util.List;

public class AutorDAO extends DAO<Autor> {
  
  @Override
  public void saveObj(Autor autor) {super.saveObj(autor);}
  
  @Override
  public void modifyObj(Autor autor) {super.modifyObj(autor);}
  
  public void deleteObj(Autor autor) {
    autor.setAlta(Boolean.FALSE);
    super.modifyObj(autor);
  }
  
  public List<Autor> listAll() {
    connect();
    List<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
    disconnect();
    return autores;
  }
  
  public Autor searchByName(String name) {
    connect();
    List<Autor> autores = em.createQuery("SELECT a FROM Autor a WHERE a.name LIKE: nameAutor").setParameter("nameAutor", name).getResultList();
    disconnect();
    Autor autor = autores.get(0);
    return autor;
  }
  
}
