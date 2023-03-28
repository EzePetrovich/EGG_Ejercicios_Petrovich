
package g1_ej9_fund;
import java.util.Scanner;

public class G1_ej9_fund {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Ingrese una palabra o frase: ");
        String fra = read.nextLine();
        if("A".equals(fra.substring(0,1))){
            System.out.println("Bien ahí papá");
            
        }else{
            System.out.println("No flaco");
        }
    }
    
}
