
package g1_ej6_fund;
import java.util.Scanner;

public class G1_ej6_fund {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int n = read.nextInt();
        if(n % 2 == 0){
            System.out.println("El número es par.");
        }else{
            System.out.println("El número es impar.");
        }
    }
    
}
