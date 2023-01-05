
package service;

import entity.Editorial;
import utilities.Tools;

public class EditorialService implements Tools {
    
    public void create() {
        Editorial editorial = new Editorial();
        System.out.println("\nCREAR EDITORIAL\n");
        System.out.print("» Nombre editorial: ");
        editorial.setNombre(read.next());
        editorial.setAlta(Boolean.TRUE);
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
    }
    
    public Editorial findEditorial(Integer id) {
        Editorial editorial = em.find(Editorial.class, id);
        return editorial;
    }
    
    public void consult() {
        System.out.println("\nCONSULTAR EDITORIAL\n");
        System.out.print("» ID editorial: ");
        Editorial editorial = findEditorial(read.nextInt());
        try {
            System.out.println("·ID: " + editorial.getId());
            System.out.println("·Nombre: " + editorial.getNombre());
            Tools.pressIntro();
        }
        catch(NullPointerException e) {
            System.err.println("ERROR: no se encontro la editorial.");
            Tools.pressIntro();
        }
    }
    
    public void modify() {
        String resp;
        System.out.println("");
        Editorial editorial = findEditorial(read.nextInt());
        if(editorial != null) {
            System.out.println("\nMODIFICAR EDITORIAL (n para omitir)\n");
            System.out.print("» Nombre? [s/n]: ");
            resp = read.next();
            if(!resp.equalsIgnoreCase("n")) {
                System.out.print("» Nuevo nombre: ");
                editorial.setNombre(read.next());
            }
        }
        else {System.err.println("ERROR: no se encontro la editorial.");}
        
    }
    
    public void remove() {
        System.out.println("\nREMOVER EDITORIAL\n");
        System.out.print("» ID editorial: ");
        Editorial editorial = findEditorial(read.nextInt());
        try {
            editorial.setAlta(Boolean.FALSE);
            em.getTransaction().begin();
            em.merge(editorial);
            em.getTransaction().commit();
            System.out.println("\nBaja logica con exito.");
            Tools.pressIntro();
        }
        catch(NullPointerException e) {
            System.err.println("ERROR: no se encontro la editorial.");
            Tools.pressIntro();
        }
    }
    
    public void subMenu() {
        Boolean quit = false;
        do {
            System.out.println("\nSUBMENU EDITORIAL\n");
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
