
package g2_poo_ej11_fund;

import java.util.Date;
import java.util.Scanner;

public class G2_POO_ej11_fund {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Date fechaAct = new Date();
        System.out.println("EDAD");
        System.out.println();
        System.out.print("» Ingrese día de nacimiento: ");
        int dia = read.nextInt();
        System.out.print("» Ingrese mes de nacimiento: ");
        int mes = read.nextInt() - 1;
        System.out.print("» Ingrese anio de nacimiento: ");
        int anio = read.nextInt() - 1900;
        Date fechaNac = new Date(anio, mes, dia);
        System.out.println();
        System.out.println("Fecha actual: " + fechaAct);
        System.out.println("Fecha de nacimiento: " + fechaNac);
        System.out.println();
        int edad = (fechaAct.getYear() - fechaNac.getYear()) - 1;
        
        if(fechaAct.getMonth() >= fechaNac.getMonth()) {
            if(fechaAct.getDate() >= fechaNac.getDate()) {
                edad++;
            }
        } 
        
        if(fechaAct.getDate() == fechaNac.getDate()) {
            System.out.println("¡Felíz cumpleaños!");
        }
        System.out.print("Usted tiene: " + edad + " anios");
    }
    
}
