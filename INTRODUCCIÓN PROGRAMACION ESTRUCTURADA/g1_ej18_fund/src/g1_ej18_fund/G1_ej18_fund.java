
package g1_ej18_fund;
import java.util.Scanner;

public class G1_ej18_fund {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int [][] matrix = new int[4][4];
        int [][] trasp = new int [4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
                trasp[j][i] = matrix[i][j];
            }
        }
        System.out.println("Matríz:");
        System.out.println();
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Matríz traspuesta:");
        System.out.println();
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print(trasp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
