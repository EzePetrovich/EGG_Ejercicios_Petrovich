
package g1_ej21_fund;
import java.util.Scanner;

public class G1_ej21_fund {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        boolean contenida = false;
        int [][] matrix = new int[10][10];
        int [][] submatrix = new int[3][3];
        System.out.println("Matriz M [10 x 10]: ");
        System.out.println();
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Matriz P [3 x 3]: ");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print("» Ingrese un número para la posición ["+i+"]["+j+"]: ");
                submatrix[i][j] = read.nextInt();
            }
        }
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(matrix[i][j] == submatrix[0][0] && i < 8 && j < 8) {
                    for(int i2 = 0; i2 < 3; i2++) {
                        for(int j2 = 0; j2 < 3; j2++) {
                            if(matrix[i + i2][j + j2] == submatrix[i2][j2]) {
                                contenida = true;
                            } else {
                                contenida = contenida && false;
                            }
                        }
                    }
                }
                if(contenida) {
                    break;
                }
            }
            if(contenida) {
                break;
            }
        }
        System.out.println();
        if(contenida) {
            System.out.println("La matriz P ingresada es submatriz de la matriz M.");
        } else {
            System.out.println("La matriz P no es submatriz de la matriz M.");
        }
    } 
}
