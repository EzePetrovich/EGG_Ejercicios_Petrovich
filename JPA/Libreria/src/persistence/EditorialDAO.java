package persistence;

import entity.Editorial;
import java.util.List;

public class EditorialDAO extends DAO<Editorial> {
  
  @Override
  public void saveObj(Editorial editorial) {
    super.saveObj(editorial);
  }
  
  public void deleteObj(Editorial editorial) {
    editorial.setAlta(false);
    super.modifyObj(editorial);
  }
  
  public List<Editorial> listAll() {
    connect();
    List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e").getResultList();
    disconnect();
    return editoriales;
  }
  
  public Editorial searchByName(String name) {
    connect();
    List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e WHERE e.name LIKE: nameEditorial").setParameter("nameEditorial", name).getResultList();
    disconnect();
    Editorial editorial = editoriales.get(0);
    return editorial;
  }
  
}