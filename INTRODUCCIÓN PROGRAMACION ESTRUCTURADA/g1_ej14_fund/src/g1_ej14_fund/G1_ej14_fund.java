// Euros: € | Libras: £ | Dolares: $ | Yenes: ¥

package g1_ej14_fund;
import java.util.Scanner;

public class G1_ej14_fund {


    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String simb = "";
        System.out.println("┌────────────┐");
        System.out.println("│ DIVISAS € → $ £ ¥ │");
        System.out.println("└────────────┘");
        System.out.println();
        System.out.print("» Ingrese dinero en Euros [€]: ");
        double eu = read.nextDouble();
        read.nextLine();
        System.out.println();
        System.out.println("• Dolar [$]");
        System.out.println("• Libra [£]");
        System.out.println("• Yen [¥]");
        System.out.print("» Ingrese el nombre de una moneda: ");
        String mon = read.nextLine().toUpperCase();
        switch(mon) {
            case "LIBRA": simb = "£";
                          break;
            case "DOLAR": simb = "$";
                          break;
            case "YEN": simb = "¥";
                        break;
            default:
                System.out.println("Error: moneda ingresada no válida.");
        }
        divisas(eu, mon, simb);
    }
    public static void divisas(double eu, String mon, String simb) {
        double cambio = 0;
        switch(mon) {
            case "LIBRA":
                cambio = eu * 0.86;
                break;
            case "DOLAR":
                cambio = eu * 1.28611;
                break;
            case "YEN":
                cambio = eu * 129.852;
                break;
        }
        System.out.println("Su cambio: "+simb+cambio);
    }
}
