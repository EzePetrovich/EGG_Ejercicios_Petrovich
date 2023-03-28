
package g1_ej8_fund;
import java.util.Scanner;

public class G1_ej8_fund {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Ingrese una frase: ");
        String fr = read.nextLine();
        if(fr.length() == 8){
            System.out.println("Corrrrrrrecto");
        }else{
            System.out.println("No flaco te pasaste");
        }
    }
    
}
