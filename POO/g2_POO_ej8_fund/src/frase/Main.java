package frase;

import service.entity.CadenaService;
import entity.frase.Cadena;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        CadenaService serv = new CadenaService();
        Cadena frase = serv.nuevaFrase();
        String resp, confirm = "";
        System.out.println();
        do {
            System.out.println("▄▄▄▄▄▄▄▄▄▄");
            System.out.println("█ MENÚ FRASE █");
            System.out.println("▀▀▀▀▀▀▀▀▀▀");
            System.out.println();
            System.out.println("1] Contar vocales.");
            System.out.println("2] Invertir frase.");
            System.out.println("3] Nº de veces que se repite una letra.");
            System.out.println("4] Comparar longitudes con otra frase ingresada.");
            System.out.println("5] Unir frases.");
            System.out.println("6] Contiene letra ingresada.");
            System.out.println("7] Salir.");
            System.out.println();
            System.out.print("» Seleccione una opción [1|2|3|4|5|6|7]: ");
            resp = read.next();
            System.out.println();
            switch (resp) {
                case "1":
                    System.out.println("La frase tiene " + serv.contarVocals(frase) + " vocales.");
                    System.out.println("Presione intro para seguir...");
                    read.next();
                    break;
                case "2":
                    System.out.println("Frase invertida: " + serv.invertirFrase(frase));
                    System.out.println("Presione intro para seguir...");
                    read.next();
                    break;
                case "3":
                    System.out.print("» Ingrese una letra: ");
                    resp = read.next();
                    System.out.println("La letra se repite " + serv.vecesRepet(frase, resp) + " veces.");
                    System.out.println("Presione intro para seguir...");
                    read.next();
                    break;
                case "4":
                    System.out.print("» Ingrese una frase: ");
                    resp = read.next();
                    if(serv.compararLong(frase, resp)) {
                        System.out.println("Las frases tienen la misma longitud.");
                    } else {
                        System.out.println("Las frases no son de la misma longitud.");
                    }
                    System.out.println("Presione intro para seguir...");
                    read.next();
                    break;
                case "5":
                    System.out.print("» Ingrese una frase: ");
                    resp = read.next();
                    System.out.println("Las frases unidas: " + serv.unirFrases(frase, resp));
                    System.out.println("Presione intro para seguir...");
                    read.next();
                    break;
                case "6":
                    System.out.print("» Ingrese una letra: ");
                    resp = read.next();
                    if(serv.contiene(frase, resp)) {
                        System.out.println("Contiene la letra ingresada.");
                    } else {
                        System.out.println("No contiene la letra ingresada.");
                    }
                    System.out.println("Presione intro para seguir...");
                    read.next();
                    break;
                case "7":
                    System.out.print("¿Está seguro que desea salir? [y/n]: ");
                    confirm = read.next();
                    break;
                default:
                    System.out.println("Error: opción ingresada no válida.");
                    System.out.println("Presione intro para seguir...");
                    read.next();

            }
        } while (!confirm.equalsIgnoreCase("y"));
    }
}
