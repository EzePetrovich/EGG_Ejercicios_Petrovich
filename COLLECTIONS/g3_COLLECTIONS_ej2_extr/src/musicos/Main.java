
package musicos;

import java.util.Scanner;
import entity.CantanteFamoso;
import java.io.IOException;
import service.entity.CantanteFamosoService;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in).useDelimiter("\n"); String resp, confirm = "";
        CantanteFamosoService sv = new CantanteFamosoService();
        ArrayList<CantanteFamoso> cantantes = new ArrayList();
        for(int i = 1; i < 6; i++) {
            cantantes.add(new CantanteFamoso(("Cantante " + i), ("Disco" + i)));
        }
        sv.mostrarCantantes(cantantes);
        do {
            System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.println("█ MENÚ CANTANTES █");
            System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀");
            System.out.println();
            System.out.println("1) Añadir nuevo cantante.");
            System.out.println("2) Eliminar un cantante.");
            System.out.println("3) Mostrar cantantes.");
            System.out.println("4) Salir.");
            System.out.println();
            System.out.print("» Ingrese una opción [1|2|3|4]: ");
            resp = read.next();
            System.out.println();
            switch(resp) {
                case "1":
                    cantantes.add(sv.crearCantante());
                    break;
                case "2":
                    if(!cantantes.isEmpty()) {
                        sv.eliminarCantante(cantantes);
                    } else {
                        System.out.println("No hay cantantes para eliminar.");
                        try{System.in.read();}
                        catch(IOException e){}
                    }
                    break;
                case "3":
                    sv.mostrarCantantes(cantantes);
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
        System.out.println();
        System.out.println("¡Adios!");
    }
}
