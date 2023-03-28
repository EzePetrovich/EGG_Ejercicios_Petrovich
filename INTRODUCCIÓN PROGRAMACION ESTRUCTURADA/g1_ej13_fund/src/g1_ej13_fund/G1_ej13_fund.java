
package g1_ej13_fund;
import java.util.Scanner;

public class G1_ej13_fund {   
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("» Ingrese dimensión del cuadrado: ");
        int dim = read.nextInt();
        System.out.println();
        for(int i = 1; i <= dim; i++) {
            for(int j = 1; j <= dim; j++) {
                if(i == 1 || i == dim) {
                    System.out.print("•");
                } else if(j == 1 || j == dim) {
                    System.out.print("•");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
