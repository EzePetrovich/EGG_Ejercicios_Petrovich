
package nespresso;
import entity.nespresso.Cafetera;
import java.io.IOException;
import service.entity.CafeteraService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner read = new Scanner(System.in).useDelimiter("\n");
       String resp, confirm = "";
       int porc_caf;
       CafeteraService func = new CafeteraService();
       Cafetera cafet = func.nuevaCafetera();
       System.out.println();
       do {
            porc_caf = (int) ((cafet.getCantAct() * 100) / cafet.getCapMax());
            System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.println("█ CAFÉ NESPRESSO █");
            System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀");
            System.out.println();
            System.out.println("Capacidad ocupada: "+porc_caf+"%");
            System.out.println();
            System.out.println("1] Llenar cafetera.");
            System.out.println("2] Servir en taza.");
            System.out.println("3] Vaciar cafetera.");
            System.out.println("4] Agregar café.");
            System.out.println("5] Estado de cafetera.");
            System.out.println("6] Salir.");
            System.out.println();
            System.out.print("» Seleccione una opción [1|2|3|4|5|6]: ");
            resp = read.next();
            System.out.println();
            switch(resp) {
                case "1":
                    func.llenarCafetera(cafet);
                    break;
                case "2":
                    func.servirTaza(cafet);
                    break;
                case "3":
                    func.vaciarCafetera(cafet);
                    break;
                case "4":
                    func.agregarCafe(cafet);
                    break;
                case "5":
                    func.estadoCafetera(cafet);
                    break;
                case "6":
                    System.out.print("¿Está seguro que desea salir? [y/n]: ");
                    confirm = read.next();
                    break;
                default:
                    System.out.println("Error: opción ingresada no válida.");
                    System.out.println("Presione intro para seguir...");
                    try{System.in.read();}
                    catch(IOException e){}
                    
            }
        } while(!confirm.equalsIgnoreCase("y"));
    }
}
