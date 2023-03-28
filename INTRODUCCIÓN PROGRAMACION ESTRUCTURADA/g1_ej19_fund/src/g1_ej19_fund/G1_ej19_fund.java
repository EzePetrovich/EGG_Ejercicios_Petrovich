
package g1_ej19_fund;
import java.util.Scanner;

public class G1_ej19_fund {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        boolean antisim = true;
        int [][] matrix = new int[3][3];
        int [][] trasp = new int [3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print("» Ingrese un número para la posición ["+i+"]["+j+"]: ");
                matrix[i][j] = read.nextInt();
                trasp[j][i] = matrix[i][j];
            }
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(matrix[i][j] == -(trasp[i][j])) {
                    antisim = antisim && true;
                } else {
                    antisim = false;
                }
            }
        }
        System.out.println();
        if(antisim) {
            System.out.println("Es matriz antisimétrica");
        } else {
            System.out.println("No es matriz antisimétrica");
        }
    }
}
