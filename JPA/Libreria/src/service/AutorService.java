package service;

import entity.Autor;
import persistence.AutorDAO;
import java.util.List;
import utilities.Tools;

public class AutorService implements Tools {
    
    private final AutorDAO DAO;
    
    public AutorService() {this.DAO = new AutorDAO();}
    
    public void create() {
        Autor autor = new Autor();
        System.out.println("\nCREAR AUTOR\n");
        System.out.print("» Nombre autor: ");
        autor.setNombre(read.next());
        autor.setAlta(Boolean.TRUE);
        DAO.saveObj(autor);
    }
    
    public Autor findAutor(Integer id) {
        Autor autor = em.find(Autor.class, id);
        return autor;
    }
    
    public void listAll() {
        List<Autor> autores = DAO.listAll();
        autores.forEach((a) -> {System.out.println(a);});
        Tools.pressIntro();
    }
    
    public void searchByName() {
        System.out.print("» Nombre del autor: ");
        Autor autor = DAO.searchByName(read.next());
        try {
            System.out.println(autor);
            Tools.pressIntro();
        }
        catch(NullPointerException e) {
            System.err.println("ERROR: no se encontro el autor.");
            Tools.pressIntro();
        }
        Tools.pressIntro();
    }
    
    public void consult() {
        System.out.println("\nCONSULTAR AUTOR\n");
        System.out.println("1) Buscar por nombre.");
        System.out.println("2) Listar todos.");
        System.out.print("\n» Ingrese una opcion: ");
        String resp = read.next();
        switch(resp) {
            case "1":
                searchByName();
                break;
            case "2":
                listAll();
                break;
            default:
                System.err.println("ERROR: opcion ingresada no valida.");
                Tools.pressIntro();
                break;
        }
    }
    
    public void modify() {
        String resp;
        System.out.println("\nMODIFICAR AUTOR\n");
        System.out.print("\n» Id del autor: ");
        Autor autor = findAutor(read.nextInt());
        if(autor != null) {
            System.out.print("» Nombre? [s/n]: ");
            resp = read.next();
            if(!resp.equalsIgnoreCase("n")) {
                System.out.print("» Nuevo nombre: ");
                autor.setNombre(read.next());
            }
        }
        else {System.err.println("ERROR: no se encontro el autor.");}
    }
    
    public void remove() {
        System.out.println("\nREMOVER AUTOR\n");
        System.out.print("» Id del autor: ");
        Autor autor = findAutor(read.nextInt());
        try {
            autor.setAlta(Boolean.FALSE);
            em.getTransaction().begin();
            em.merge(autor);
            em.getTransaction().commit();
            System.out.println("\nBaja logica con exito.");
            Tools.pressIntro();
        }
        catch(NullPointerException e) {
            System.err.println("ERROR: no se encontro el autor.");
            Tools.pressIntro();
        }
    }
    
    public void subMenu() {
        Boolean quit = Boolean.FALSE;
        do {
            System.out.println("\nSUBMENU AUTOR\n");
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
                    quit = Boolean.TRUE;
                    break;
                default:
                    System.err.println("ERROR: opcion ingresada inexistente.");
                    Tools.pressIntro();
                    break;
            }
        } while(!quit);
    }
    
}
