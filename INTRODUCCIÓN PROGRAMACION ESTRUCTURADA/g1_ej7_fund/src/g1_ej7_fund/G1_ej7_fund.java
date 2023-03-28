
package g1_ej7_fund;
import java.util.Scanner;

public class G1_ej7_fund {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String eu = "eureka";
        System.out.print("Ingrese una frase: ");
        String f = read.nextLine();
        if(f.equals(eu)){
            System.out.println("Corrrrrrrecto");
        }else{
            System.out.println("No flaco");
        }
    }
    
}
