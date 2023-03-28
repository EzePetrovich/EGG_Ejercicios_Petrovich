
package g1_ej3_fund;
import java.util.Scanner;

public class G1_ej3_fund {

   
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Ingrese una frase: ");
        String frase = read.nextLine();
        System.out.println(frase.toUpperCase());
        System.out.println(frase.toLowerCase());
    }
    
}
