
package service;

import entity.Editorial;
import utilities.Tools;

public class EditorialService implements Tools {
    
    private final EditorialDAO DAO = new EditorialDAO();
    
    public void create() {
        Editorial editorial = new Editorial();
        System.out.println("\nCREAR EDITORIAL\n");
        System.out.print("» Nombre editorial: ");
        editorial.setNombre(read.next());
        editorial.setAlta(Boolean.TRUE);
        DAO.saveObj(editorial);
    }
    
    public void listAll() {
        List<Editorial> editoriales = DAO.listAll();
        editoriales.forEach((e) -> {System.out.println(e);});
        Tools.pressIntro();
    }
    
    public void searchByName() {
        System.out.print("» Nombre de la editorial: ");
        Editorial editorial = DAO.searchByName(read.next());
        try {
            System.out.println(editorial);
            Tools.pressIntro();
        }
        catch(NullPointerException e) {
            System.err.println("ERROR: no se encontro la editorial.");
            Tools.pressIntro();
        }
    }
    
    public void consult() {
        System.out.println("\nCONSULTAR EDITORIAL\n");
        System.out.println("1) Buscar por nombre.");
        System.out.println("2) Listar todas.");
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
        System.out.println();
        Editorial editorial = findEditorial(read.nextInt());
        if(editorial != null) {
            System.out.println("\nMODIFICAR EDITORIAL (n para omitir)\n");
            System.out.print("» Nombre? [s/n]: ");
            resp = read.next();
            if(!resp.equalsIgnoreCase("n")) {
                System.out.print("» Nuevo nombre: ");
                editorial.setNombre(read.next());
                DAO.modifyObj(editorial);
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
            DAO.deleteObj(editorial);
            System.out.println("\nBaja logica con exito.");
            Tools.pressIntro();
        }
        catch(NullPointerException e) {
            System.err.println("ERROR: no se encontro la editorial.");
            Tools.pressIntro();
        }
    }
    
    public void subMenu() {
        Boolean quit = Boolean.FALSE;
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
