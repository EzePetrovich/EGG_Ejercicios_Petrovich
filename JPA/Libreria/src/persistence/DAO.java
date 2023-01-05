package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO<Object> {
  
  protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("LibreriaPU");
  protected EntityManager em = EMF.createEntityManager();
  
  protected void connect() {
    if(!em.isOpen()) {em = EMF.createEntityManager();}
  }
  
  protected void disconnect() {
    if(em.isOpen()) {em.close();}
  }
  
  protected void saveObj(Object objeto) {
    connect();
    em.getTransaction().begin();
    em.persist(objeto);
    em.getTransaction().commit();
    disconnect();
  }
  
  protected void modifyObj(Object objeto) {
    connect();
    em.getTransaction().begin();
    em.merge(objeto);
    em.getTransaction().commit();
    disconnect();
  }
  
  /* Por buenas prácticas de programación, no se realiza la eliminación física del objeto.
  *  Se realiza la baja lógica (se asigna FALSE al atributo alta del objeto).
  *  Por lo anteriormente mencionado, no utilizaremos el método 'remove()' del EntityManager,
  *  haremos la baja modificando el atributo 'alta' del objeto y luego realizaremos 'merge()'.
  */
  
}