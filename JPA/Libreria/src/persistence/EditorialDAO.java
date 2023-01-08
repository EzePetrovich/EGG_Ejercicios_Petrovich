package persistence;

import entity.Editorial;
import java.util.List;

public class EditorialDAO extends DAO<Editorial> {
  
  @Override
  public void saveObj(Editorial editorial) {super.saveObj(editorial);}
  
  @Override
  public void modifyObj(Editorial editorial) {super.modifyObj(editorial);}
  
  public void deleteObj(Editorial editorial) {
    editorial.setAlta(Boolean.FALSE);
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
    Editorial editorial = em.createQuery("SELECT e FROM Editorial e WHERE e.name LIKE: nameEditorial").setParameter("nameEditorial", name).getSingleResult();
    disconnect();
    return editorial;
  }
  
}
