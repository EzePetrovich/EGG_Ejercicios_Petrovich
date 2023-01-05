
package service;

import entity.Autor;
import entity.Editorial;
import entity.Libro;
import utilities.Tools;

public class LibroService implements Tools {
    
    public Libro findLibro(Long isbn) {
        Libro libro = em.find(Libro.class, isbn);
        return libro;
    }
    
    public void create() {
        Libro libro = new Libro();
        System.out.println("\nCREAR LIBRO\n");
        System.out.print("· ID de autor: ");
        Autor autor = em.find(Autor.class, read.nextInt());
        System.out.print("· ID de editorial: ");
        Editorial editorial = em.find(Editorial.class, read.nextInt());
        System.out.print("· Titulo: ");
        libro.setTitulo(read.next());
        System.out.print("· Anio: ");
        libro.setAnio(read.nextInt());
        System.out.print("· Ejemplares: ");
        libro.setEjemplares(read.nextInt());
        System.out.print("· Ejemplares prestados: ");
        libro.setEjemplaresPrest(read.nextInt());
        libro.setEjemplaresDisp(libro.getEjemplares() - libro.getEjemplaresPrest());
        libro.setAlta(Boolean.TRUE);
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }
    
    public void consult() {
        System.out.println("\nCONSULTAR LIBRO\n");
        System.out.print("» ISBN de libro: ");
        long isbn = read.nextLong();
        try {
            Libro libro = findLibro(isbn);
            if(libro.isAlta()) {
                System.out.println("·ISBN: " + libro.getIsbn());
                System.out.println("·Titulo: " + libro.getTitulo());
                System.out.println("·Anio: " + libro.getAnio());
                System.out.println("·Autor: " + libro.getAutor().getNombre());
                System.out.println("·Editorial: " + libro.getEditorial().getNombre());
                System.out.println("·Ejemplares: " + libro.getEjemplares());
                System.out.println("·Ejemplares prestados: " + libro.getEjemplaresPrest());
                System.out.println("·Ejemplares disponibles: " + libro.getEjemplaresDisp());
                Tools.pressIntro();
            }
        }
        catch(NullPointerException e) {
            System.err.println("ERROR: no se encontró el libro ingresado.");
            Tools.pressIntro();
        }
        System.out.println("");
    }
    
    public void modify() {
        
        String resp;
        System.out.print("» Ingrese ISBN del libro: ");
        Libro libro = findLibro(read.nextLong());
        if(libro != null) {
            System.out.println("\nMODIFICAR LIBRO (s/n)\n");
            System.out.print("» Titulo? [s/n]: ");
            resp = read.next();
            if(!resp.equalsIgnoreCase("n")) {
                System.out.print("» Nuevo titulo: ");
                libro.setTitulo(read.next());
            }
            System.out.print("» Anio? [s/n]: ");
            resp = read.next();
            if(!resp.equalsIgnoreCase("n")) {
                System.out.print("» Nuevo anio: ");
                libro.setAnio(read.nextInt());
            }
            System.out.print("» Autor? [s/n]: ");
            resp = read.next();
            if(!resp.equalsIgnoreCase("n")) {
                System.out.print("» Ingrese ID del nuevo autor: ");
                Integer id = read.nextInt();
                try {
                    Autor autor = em.find(Autor.class, id);
                    libro.setAutor(autor);
                }
                catch(NullPointerException e) {
                    System.err.println("ERROR: el autor ingresado no existe. Debe crearlo.");
                    Tools.pressIntro();
                }
            }
            System.out.print("» Editorial? [s/n]: ");
            resp = read.next();
            if(!resp.equalsIgnoreCase("n")) {
                System.out.print("» Ingrese ID de la nueva editorial: ");
                Integer id = read.nextInt();
                try {
                    Editorial editorial = em.find(Editorial.class, id);
                    libro.setEditorial(editorial);
                }
                catch(NullPointerException e) {
                    System.err.println("ERROR: la editorial ingresada no existe. Debe crearla.");
                    Tools.pressIntro();
                }
            }
            System.out.print("» Ejemplares? [s/n]: ");
            resp = read.next();
            if(!resp.equalsIgnoreCase("n")) {
                System.out.print("» Nueva cantidad de ejemplares: ");
                libro.setEjemplares(read.nextInt());
            }
            System.out.print("» Ejemplares prestados? [s/n]: ");
            resp = read.next();
            if(!resp.equalsIgnoreCase("n")) {
                System.out.println("» Nueva cantidad de ejemplares prestados: ");
                libro.setEjemplaresPrest(read.nextInt());
            }
        } 
        else {System.err.println("ERROR: el libro ingresado no existe.");}
    }
    
    public void remove() {
        System.out.println("\nREMOVER LIBRO\n");
        System.out.print("» ISBN de libro: ");
        Libro libro = findLibro(read.nextLong());
        try {
            libro.setAlta(Boolean.FALSE);
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
            System.out.println("\nBaja logica con exito.");
            Tools.pressIntro();
        }
        catch(NullPointerException e) {
            System.err.println("ERROR: no se encontro el libro.");
            throw e;
        }
    }
    
    public void subMenu() {
        Boolean quit = false;
        do {
            System.out.println("\nSUBMENU LIBRO\n");
            System.out.println("1) Crear.");
            System.out.println("2) Modificar.");
            System.out.println("3) Consultar.");
            System.out.println("4) Remover.");
            System.out.println("5) Volver al menu principal.");
            System.out.print("\n» Ingrese una opcion: ");
            String resp = read.next();
            switch(resp) {
                case "1":
                    create();
                    break;
                case "2":
                    modify();
                    break;
                case "3":
                    consult();
                    break;
                case "4":
                    remove();
                    break;
                case "5":
                    quit = true;
                    break;
                default:
                    System.err.println("ERROR: opcion ingresada inexistente.");
                    Tools.pressIntro();
                    break;
            }
        } while(!quit);
    }
    
}
