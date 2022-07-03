
package lista.numerica;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        ArrayList<Integer> serieNums = new ArrayList(); Integer n, sum = 0; boolean quit = false;
        do {
            System.out.print("» Ingrese un número [-99 para salir]: "); n = read.nextInt();
            System.out.println();
            if(n != -99) {
                sum += n;
                serieNums.add(n);
            } else {quit = true;}
        } while(!quit);
        System.out.print("• Números ingresados: ");
        for(Integer num: serieNums) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("• Sumatoria: " + sum);
        System.out.println("• Promedio: " + ((int) (sum / serieNums.size())));
    }
}
