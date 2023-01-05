package persistence;

import entity.Libro;
import entity.Autor;
import entity.Editorial;
import java.util.List;

public class LibroDAO extends DAO<Libro> {
  
  @Override
  public void saveObj(Libro libro) {super.saveObj(libro);}
  
  @Override
  public void modifyObj(Libro libro) {super.modifyObj(libro);
  
  public void deleteObj(Libro libro) {
    libro.setAlta(Boolean.FALSE);
    super.modifyObj(libro);
  }
  
  public List<Libro> listAll() {
    connect();
    List<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
    disconnect();
    return libros;
  }
  
  public Autor findAutor(Integer id) {
    Autor autor = em.find(Autor.class, id);
    return autor;
  }
  
  public Editorial findEditorial(Integer id) {
    Editorial editorial = em.find(Editorial.class, id);
    return editorial;
  }
  
  public Libro searchByISBN(Long isbn) {
    Libro libro = em.find(Libro.class, isbn);
    return libro;
  }
  
  public Libro searchByTitle(String title) {
    connect();
    List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.title LIKE: titleLibro").setParameter("titleLibro", title).getResultList();
    Libro libro = libros.get(0);
    disconnect();
    return libro;
  }
  
  public Libro searchByNameAutor(String name) {
    connect();
    List<Libro> libros = em.createQuery("SELECT l FROM Libro l JOIN l.autor a WHERE l.autor.name LIKE: nameAutor").setParameter("nameAutor", name).getResultList();
    Libro libro = libros.get(0);
    disconnect();
    return libro;
  }
  
  public Libro searchByNameEditor(String name) {
    connect();
    List<Libro> libros = em.createQuery("SELECT l FROM Libro l JOIN l.editorial e WHERE l.editorial.name LIKE: nameEditorial").setParameter("nameEditorial", name).getResultList();
    Libro libro = libros.get(0);
    disconnect();
    return libro;
  }
  
}
