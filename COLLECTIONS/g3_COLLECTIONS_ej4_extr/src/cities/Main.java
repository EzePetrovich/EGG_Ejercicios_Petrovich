
package cities;

import entity.City;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import service.entity.CityService;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in).useDelimiter("\n"); CityService cs = new CityService();
        HashMap<String, City> cities = cs.mapCities(); String resp, confirm = "";
        do {
            System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.println("█ MENÚ  CIUDADES █");
            System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀");
            System.out.println();
            System.out.println("1) Añadir ciudad.");
            System.out.println("2) Eliminar ciudad por código postal.");
            System.out.println("3) Buscar ciudad por código postal.");
            System.out.println("4) Mostrar ciudades.");
            System.out.println("5) Salir.");
            System.out.println();
            System.out.print("» Ingrese una opción [1|2|3|4|5]: ");
            resp = read.next();
            System.out.println();
            switch(resp) {
                case "1":
                    cs.addCity(cities);
                    break;
                case "2":
                    cs.removeCity(cities);
                    break;
                case "3":
                    cs.buscarCity(cities);
                    break;
                case "4":
                    cs.mostarCities(cities);
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