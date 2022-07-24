
package g1_ej5_fund;
import java.util.Scanner;

public class G1_ej5_fund {

    public static void main(String[] args) {
       Scanner read = new Scanner(System.in);
       System.out.print("Ingrese un número: ");
       int n = read.nextInt();
       System.out.println("Su doble es: "+n*2);
       System.out.println("Su triple es: "+n*3);
       System.out.println("Su raíz cuadrada es: "+Math.sqrt(n));
    }
    
}
