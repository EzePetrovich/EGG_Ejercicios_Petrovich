package utilities;

import service.AutorService;
import service.EditorialService;
import service.LibroService;

public class Menu() implements Tools {
	
	private final AutorService AS = new AutorService();
	private final EditorialService ES = new EditorialService();
	private final LibroService LS = new LibroService();
	
	public void principal() {
		Boolean run = Boolean.TRUE;
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
				    AS.subMenu();
				    break;
				case "2":
				    ES.subMenu();
				    break;
				case "3":
				    LS.subMenu();
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
