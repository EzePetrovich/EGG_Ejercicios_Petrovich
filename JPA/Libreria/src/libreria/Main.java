
package libreria;


import service.AutorService;
import service.EditorialService;
import service.LibroService;
import utilities.Tools;

public class Main implements Tools {

    public static void main(String[] args) {
        
        AutorService as = new AutorService();
        EditorialService es = new EditorialService();
        LibroService ls = new LibroService();
        Boolean run = true;
        String resp;
        Tools.pressIntro();
        do {
            System.out.println("MENU LIBRERIA\n");
            System.out.println("1) Gestionar autores.");
            System.out.println("2) Gestionar editoriales.");
            System.out.println("3) Gestionar libros.");
            System.out.println("4) Salir.");
            System.out.print("\n» Ingrese una opcion: ");
            resp = read.next();
            switch(resp) {
                case "1":
                    as.subMenu();
                    break;
                case "2":
                    es.subMenu();
                    break;
                case "3":
                    ls.subMenu();
                    break;
                case "4":
                    System.out.print("Esta seguro? [s/n]: ");
                    run = !read.next().equalsIgnoreCase("s");
                    break;
                default:
                    System.err.println("ERROR: opcion ingresada inexistente.");
                    Tools.pressIntro();
                    break;
            }
            System.out.println();
        } while(run);
        
    }
    
}
