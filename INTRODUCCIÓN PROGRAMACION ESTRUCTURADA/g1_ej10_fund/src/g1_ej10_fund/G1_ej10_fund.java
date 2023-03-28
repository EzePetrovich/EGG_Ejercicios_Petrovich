
package g1_ej10_fund;
import java.util.Scanner;

public class G1_ej10_fund {


    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Ingrese un número positivo: ");
        int lim = read.nextInt();
        int acum = 0;
        while(lim >= acum){
            System.out.print("Ingrese un número: ");
            acum = acum + read.nextInt();
        }
        System.out.println("Superó el límite "+lim+" con "+acum+".");
    }
    
}
