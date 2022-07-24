
package g1_ej4_fund;
import java.util.Scanner;

public class G1_ej4_fund {


    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Ingrese la temperatura en grados Centrigrados: ");
        double c_gr = read.nextDouble();
        double f_gr = 32 + (9 * c_gr / 5);
        System.out.println("En grados Fahrenheit es "+f_gr+"ºF.");
    }
}
