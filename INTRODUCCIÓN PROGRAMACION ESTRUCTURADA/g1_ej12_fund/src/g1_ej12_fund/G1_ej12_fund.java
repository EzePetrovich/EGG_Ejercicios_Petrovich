
package g1_ej12_fund;
import java.util.Scanner;

public class G1_ej12_fund {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String caden;
        int val = 0, inval = 0;
        do {
            System.out.println("┌────────────┐");
            System.out.println("│ Dispositivo RS232 │");
            System.out.println("└────────────┘");
            System.out.println();
            System.out.print("» Ingrese una cadena [&&&&& para finalizar]: ");
            caden = read.nextLine();
            if(caden.length() <= 5 && "X".equals(caden.substring(0,1)) && "O".equals(caden.substring(caden.length()-1,caden.length()))) {
               val++;
            } else {
                if(!"&&&&&".equals(caden)) {
                    inval++;
                }
            }
        }while(!caden.equals("&&&&&"));
        System.out.println("╔══════╗");
        System.out.println("║ INFORME ║");
        System.out.println("╚══════╝");
        System.out.println();
        System.out.println("• Cantidad de cadenas válidas: "+val);
        System.out.println("• Cantidad de cadenas inválidas: "+inval);
    }
}
