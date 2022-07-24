
package g1_ej17_fund;
import java.util.Scanner;

public class G1_ej17_fund {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n_una = 0, n_dos = 0, n_tre = 0, n_cua = 0, n_cin = 0;
        System.out.print("» Ingrese la dimensión del vector: ");
        int dim = read.nextInt();
        int[] vect = new int[dim];
        System.out.println();
        System.out.println("LLENAR VECTOR.");
        System.out.println();
        for(int i = 0; i < dim; i++) {
            System.out.print("» Ingrese un número (hasta 5 cifras) para la posición "+(i+1)+": ");
            vect[i] = read.nextInt();
        }
        for(int i = 0; i < dim; i++) {
            if(vect[i] / 10 == 0) {
                n_una++;
            } else if(vect[i] / 100 == 0) {
                n_dos++;
            } else if(vect[i] / 1000 == 0) {
                n_tre++;
            } else if(vect[i] / 10000 == 0) {
                n_cua++;
            } else if(vect[i] / 100000 == 0) {
                n_cin++;
            }
        }
        
        System.out.println();
        System.out.println("INFORME");
        System.out.println();
        System.out.print("Vector: ");
        for(int i = 0; i < dim; i++) {
            if(i != (dim - 1)) {
                System.out.print(vect[i]+" ");
            } else {
                System.out.println(vect[i]);
            }
        }
        System.out.println();
        System.out.println("•Números de una cifra: "+n_una);
        System.out.println("•Números de dos cifras: "+n_dos);
        System.out.println("•Números de tres cifras: "+n_tre);
        System.out.println("•Números de cuatro cifras: "+n_cua);
        System.out.println("•Números de cinco cifras: "+n_cin);
    }
    
}
