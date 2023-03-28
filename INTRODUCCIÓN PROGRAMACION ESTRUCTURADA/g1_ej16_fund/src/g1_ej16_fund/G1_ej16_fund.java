
package g1_ej16_fund;
import java.util.Scanner;

public class G1_ej16_fund {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int pos = 0,rep = 0;
        System.out.print("» Ingrese la dimensión del vector: ");
        int dim = read.nextInt();
        int[] vect = new int[dim];
        for(int i = 0; i < dim; i++) {
            vect[i] = (int) (Math.random()*10);
            if(i != (dim - 1)) {
                System.out.print(vect[i]+" ");
            } else {
                System.out.println(vect[i]);
            }
        }
        System.out.print("» Ingrese un número a buscar: ");
        int n = read.nextInt();
        for(int i = 0; i < dim; i++){
            if(vect[i] == n){
                if(rep == 0){
                    pos = i;
                    rep++;
                } else {
                    rep++;
                }
            }
        }
        if(rep != 0) {
            if(rep == 1){
                System.out.println("Se encontró en la posición "+pos+", no se repite.");
            } else {
                System.out.println("Se encontró en la posición "+pos+", se repite "+(rep - 1)+" veces.");
            }
            
        } else {
            System.out.println("No se encontró el número ingresado.");
        }
    }
}
