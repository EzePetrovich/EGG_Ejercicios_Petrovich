
package operations;

import service.entity.ServiceMatematica;
import entity.operations.Matematica;

public class Main {

    public static void main(String[] args) {
        Matematica opers = new Matematica();
        opers.setNum1(Math.random() * 10);
        opers.setNum2(Math.random() * 10);
        ServiceMatematica.mostrarOperandos(opers);
        System.out.println("El mayor es: " + ServiceMatematica.devolverMayor(opers));
        System.out.println();
        System.out.println("La potencia del mayor redondeado elevado al menor redondeado es: " + ServiceMatematica.calcularPot(opers));
        System.out.println("La raíz cuadrada del menor es: " + ServiceMatematica.calcularRaiz(opers));
    }
    
}
