<<<<<<< HEAD

package Banco;
import Entity.Banco.Cuenta;
import Service.Entity.ServiceCuenta;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        String resp, confirm = "";
        ServiceCuenta serv = new ServiceCuenta();
        Cuenta cuent = serv.crearCuenta();
        do {
            System.out.println("▄▄▄▄▄▄▄▄▄▄");
            System.out.println("█ MENÚ CAJERO █");
            System.out.println("▀▀▀▀▀▀▀▀▀▀");
            System.out.println();
            System.out.println("1] Ingresar dinero.");
            System.out.println("2] Retirar dinero.");
            System.out.println("3] Extracción rápida.");
            System.out.println("4] Consultar saldo.");
            System.out.println("5] Consultar datos.");
            System.out.println("6] Salir.");
            System.out.println();
            System.out.print("» Seleccione una opción [1|2|3|4|5|6]: ");
            resp = read.next();
            switch(resp) {
                case "1":
                    serv.ingresar(cuent);
                    break;
                case "2":
                    serv.retirar(cuent);
                    break;
                case "3":
                    serv.extraccionRapida(cuent);
                    break;
                case "4":
                    serv.consultarSaldo(cuent);
                    break;
                case "5":
                    serv.consultarDatos(cuent);
                    break;
                case "6":
                    System.out.print("¿Está seguro que desea salir? [y/n]: ");
                    confirm = read.next();
                    break;
                default:
                    System.out.println("Error: opción ingresada no válida.");
                    System.out.println("Presione intro para seguir...");
                    read.next();
                    
            }
        } while(!confirm.equalsIgnoreCase("y"));
        
        
        
    }
    
}
=======

package Banco;
import Entity.Banco.Cuenta;
import Service.Entity.ServiceCuenta;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        String resp, confirm = "";
        ServiceCuenta serv = new ServiceCuenta();
        Cuenta cuent = serv.crearCuenta();
        do {
            System.out.println("▄▄▄▄▄▄▄▄▄▄");
            System.out.println("█ MENÚ CAJERO █");
            System.out.println("▀▀▀▀▀▀▀▀▀▀");
            System.out.println();
            System.out.println("1] Ingresar dinero.");
            System.out.println("2] Retirar dinero.");
            System.out.println("3] Extracción rápida.");
            System.out.println("4] Consultar saldo.");
            System.out.println("5] Consultar datos.");
            System.out.println("6] Salir.");
            System.out.println();
            System.out.print("» Seleccione una opción [1|2|3|4|5|6]: ");
            resp = read.next();
            switch(resp) {
                case "1":
                    serv.ingresar(cuent);
                    break;
                case "2":
                    serv.retirar(cuent);
                    break;
                case "3":
                    serv.extraccionRapida(cuent);
                    break;
                case "4":
                    serv.consultarSaldo(cuent);
                    break;
                case "5":
                    serv.consultarDatos(cuent);
                    break;
                case "6":
                    System.out.print("¿Está seguro que desea salir? [y/n]: ");
                    confirm = read.next();
                    break;
                default:
                    System.out.println("Error: opción ingresada no válida.");
                    System.out.println("Presione intro para seguir...");
                    read.next();
                    
            }
        } while(!confirm.equalsIgnoreCase("y"));
        
        
        
    }
    
}
>>>>>>> 9744b90784dd0a6f5c2cb2dc20ab7ea4ca4b0d5e
