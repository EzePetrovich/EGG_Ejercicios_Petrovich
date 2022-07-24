
package g1_ej20_fund;
import java.util.Scanner;

public class G1_ej20_fund {
    public static void main(String[] args) {
        int col = 0, diag = 0, fil = 0;
        Scanner read = new Scanner(System.in);
        int [][] matrix = new int[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print("» Ingrese un número para la posición ["+i+"]["+j+"]: ");
                matrix[i][j] = read.nextInt();
            }
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(matrix[i][j] > 0 && matrix[i][j] < 10) {
                    if(i == j) {
                        diag += matrix[i][j];
                        if(i == 1) {
                            fil += matrix[i][j];
                        }
                    } else if(i == 1) {
                        fil += matrix[i][j];
                    }
                }
            }
            col += matrix[i][0];
        }
        if(diag == col && diag == fil) {
            System.out.println("Es matríz mágica.");
        } else {
            System.out.println("No es matríz mágica o sus elementos están fuera del rango [1 - 9].");
        }
    }
    
}
