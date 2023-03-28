
package g1_ej15_fund;
import java.util.Scanner;

public class G1_ej15_fund {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int[] vect = new int[100];
        for(int i = 0; i < 100; i++) {
            vect[i] = i + 1;
        }
        /*for(int i = 99; i > -1; i--) {
            System.out.println(vect[i]);
        }*/
        for(int elemento: vect) {
            System.out.print(elemento + " ");
        }
    }
}
