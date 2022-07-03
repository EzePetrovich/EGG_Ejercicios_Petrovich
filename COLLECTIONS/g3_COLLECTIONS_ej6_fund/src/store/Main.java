
package store;

import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import service.entity.ProductService;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        HashMap<String, Integer> products = new HashMap(); String resp, confirm = ""; ProductService sv = new ProductService();
        do {
            System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.println("█ MENÚ DE TIENDA █");
            System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀");
            System.out.println();
            System.out.println("1) Añadir nuevo producto.");
            System.out.println("2) Eliminar un producto.");
            System.out.println("3) Modificar precio de un producto.");
            System.out.println("4) Mostrar productos.");
            System.out.println("5) Salir.");
            System.out.println();
            System.out.print("» Ingrese una opción [1|2|3|4|5]: ");
            resp = read.next();
            System.out.println();
            switch(resp) {
                case "1":
                    sv.añadirProducto(products);
                    break;
                case "2":
                    if(!products.isEmpty()) {sv.eliminarProducto(products);}
                    else {
                        System.out.println("No tiene productos para eliminar.");
                        System.out.print("Presione intro para seguir...");
                        try{System.in.read();}
                        catch(IOException e){}
                    }
                    break;
                case "3":
                    if(!products.isEmpty()) {sv.modificarPrecio(products);}
                    else {
                        System.out.println("No tiene productos para modificar.");
                        System.out.print("Presione intro para seguir...");
                        try{System.in.read();}
                        catch(IOException e){}
                    } 
                    break;
                case "4":
                    sv.mostrarProductos(products);
                    break;
                case "5":
                    System.out.print("¿Está seguro? [S/N]: "); confirm = read.next();
                    break;
                default:
                    System.out.println("Error: opción ingresada no válida.");
                    System.out.print("Presione intro para seguir...");
                    try{System.in.read();}
                    catch(IOException e){}
            }
        } while(!confirm.equalsIgnoreCase("S"));
        System.out.println();
        System.out.println("¡Adios!");
    }
    
}
