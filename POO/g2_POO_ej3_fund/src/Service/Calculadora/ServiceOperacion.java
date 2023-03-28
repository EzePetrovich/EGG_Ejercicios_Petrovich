<<<<<<< HEAD

package Service.Calculadora;
import java.util.Scanner;
import Entity.Calculadora.Operacion;

public class ServiceOperacion {
    Scanner read = new Scanner(System.in);
    public Operacion crearOperacion() {
        Operacion oper = new Operacion();
        System.out.print("» Ingrese un número: ");
        oper.setNumero1(read.nextInt());
        System.out.print("» Ingrese otro número: ");
        oper.setNumero2(read.nextInt());
        System.out.println();
        return oper;
    }
    public double sumar(Operacion oper) {
        double suma;
        suma = oper.getNumero1() + oper.getNumero2();
        return suma;
    }
    public double restar(Operacion oper) {
        double resta;
        resta = oper.getNumero1() - oper.getNumero2();
        return resta;
    }
    public double multiplicar(Operacion oper) {
        double prod;
        if(oper.getNumero1() != 0 && oper.getNumero2() != 0) {
            prod = oper.getNumero1() * oper.getNumero2();
        } else {
            prod = 0;
        }
        return prod;
    }
    public double dividir(Operacion oper) {
        double div;
        if(oper.getNumero1() != 0 && oper.getNumero2() != 0) {
            div = oper.getNumero1() / oper.getNumero2();
        } else {
            div = 0;
        }
        return div;
    }
}
=======

package Service.Calculadora;
import java.util.Scanner;
import Entity.Calculadora.Operacion;

public class ServiceOperacion {
    Scanner read = new Scanner(System.in);
    public Operacion crearOperacion() {
        Operacion oper = new Operacion();
        System.out.print("» Ingrese un número: ");
        oper.setNumero1(read.nextInt());
        System.out.print("» Ingrese otro número: ");
        oper.setNumero2(read.nextInt());
        System.out.println();
        return oper;
    }
    public double sumar(Operacion oper) {
        double suma;
        suma = oper.getNumero1() + oper.getNumero2();
        return suma;
    }
    public double restar(Operacion oper) {
        double resta;
        resta = oper.getNumero1() - oper.getNumero2();
        return resta;
    }
    public double multiplicar(Operacion oper) {
        double prod;
        if(oper.getNumero1() != 0 && oper.getNumero2() != 0) {
            prod = oper.getNumero1() * oper.getNumero2();
        } else {
            prod = 0;
        }
        return prod;
    }
    public double dividir(Operacion oper) {
        double div;
        if(oper.getNumero1() != 0 && oper.getNumero2() != 0) {
            div = oper.getNumero1() / oper.getNumero2();
        } else {
            div = 0;
        }
        return div;
    }
}
>>>>>>> 9744b90784dd0a6f5c2cb2dc20ab7ea4ca4b0d5e
