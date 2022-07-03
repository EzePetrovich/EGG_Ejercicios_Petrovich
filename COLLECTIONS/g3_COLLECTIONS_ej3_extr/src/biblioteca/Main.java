
package biblioteca;

import entity.Libro;
import java.io.IOException;
import service.entity.Libreria;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        HashSet<Libro> libros = new HashSet(); String resp, confirm = "", titulo = ""; Libreria sv = new Libreria();
        do {
            System.out.print("¿Ingresar un libro? [S/N]: "); resp = read.next();
            System.out.println();
            if(!resp.equalsIgnoreCase("N")) {
                libros.add(sv.crearLibro());
            }
        } while(!resp.equalsIgnoreCase("N"));
         do {
            System.out.println("▄▄▄▄▄▄▄▄▄");
            System.out.println("█ BIBLIOTECA █");
            System.out.println("▀▀▀▀▀▀▀▀▀");
            System.out.println();
            System.out.println("1) Prestar un libro.");
            System.out.println("2) Devolver un libro.");
            System.out.println("3) Mostrar libros.");
            System.out.println("4) Salir.");
            System.out.println();
            System.out.print("» Ingrese una opción [1|2|3|4]: ");
            resp = read.next();
            System.out.println();
            switch(resp) {
                case "1":
                    System.out.println("1) PRESTAR LIBRO.");
                    System.out.println();
                    System.out.print("» Título del libro: "); titulo = read.next();
                    System.out.println();
                    if(sv.existeLibro(libros, titulo)) {
                        if(sv.retornarLibro(libros, titulo).prestamo()) {
                            System.out.println("Prestado con éxito.");
                        } else {
                            System.out.println("No tiene más ejemplares para prestar.");
                        }
                    } else {
                        System.out.println("No existe el libro ingresado.");
                    }
                    System.out.println();
                    System.out.print("Presione intro para seguir...");
                    try{System.in.read();}
                    catch(IOException e){}
                    break;
                case "2":
                    System.out.println("1) DEVOLVER LIBRO.");
                    System.out.println();
                    System.out.print("» Título del libro: "); titulo = read.next();
                    System.out.println();
                    if(sv.existeLibro(libros, titulo)) {
                        if(sv.retornarLibro(libros, titulo).devolucion()) {
                            System.out.println("Devuelto con éxito.");
                        } else {
                            System.out.println("Ya devolvió todos los ejemplares.");
                        }
                    } else {
                        System.out.println("No existe el libro ingresado.");
                    }
                    System.out.println();
                    System.out.print("Presione intro para seguir...");
                    try{System.in.read();}
                    catch(IOException e){}
                    break;
                case "3":
                    sv.mostrarLibros(libros);
                    break;
                case "4":
                    System.out.print("¿Está seguro? [S/N]: "); confirm = read.next();
                    break;
                default:
                    System.out.println("Error: opción ingresada no válida.");
                    System.out.print("Presione intro para seguir...");
                    try{System.in.read();}
                    catch(IOException e){}
            }
        } while(!confirm.equalsIgnoreCase("S"));
    }
    
}
