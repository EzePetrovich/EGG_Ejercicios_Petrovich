
package aseguradoraSystem;

import entity.Seguros;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        String confirm = "", resp;
        Seguros s = new Seguros();
        do {
            System.out.println("┌───────────┐"); 
            System.out.println("│LA TERCERA SEGUROS│");
            System.out.println("└───────────┘"); 
            System.out.println();
            System.out.println("1) Nueva poliza.");
            System.out.println("2) Buscar una poliza por id.");
            System.out.println("3) Mostrar polizas.");
            System.out.println("4) Ver cuotas de una poliza.");
            System.out.println("5) Salir.");
            System.out.println();
            System.out.print("» Seleccione una opcion: "); resp = read.next();
            switch(resp) {
                case "1":
                    s.gestionPoliza();
                    break;
                case "2":
                    s.buscarPoliza();
                    break;
                case "3":
                    if(!s.getPolizas().isEmpty()) {s.mostrarPolizas();}
                    else {
                        System.out.println("\nERROR: no hay polizas cargadas.");
                        System.out.print("\nPresione intro para seguir...");
                        try{System.in.read();}
                        catch(IOException e) {}
                        System.out.println();
                    }
                    break;
                case "4":
                    s.mostrarCuotas();
                    break;
                case "5":
                    System.out.print("\n¿Confirma salir? [S / N]: "); confirm = read.next();
                    break; 
            }
        } while(!confirm.equalsIgnoreCase("S"));
        System.out.println("\n¡Hasta luego!");
    }
}
