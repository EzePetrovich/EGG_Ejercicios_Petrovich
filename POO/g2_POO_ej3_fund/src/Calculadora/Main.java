<<<<<<< HEAD

package Calculadora;
import Entity.Calculadora.Operacion;
import Service.Calculadora.ServiceOperacion;

public class Main {
    public static void main(String[] args) {
        ServiceOperacion serv = new ServiceOperacion();
        Operacion opers = serv.crearOperacion();
        System.out.println("Suma: "+serv.sumar(opers));
        System.out.println("Resta: "+serv.restar(opers));
        if(serv.multiplicar(opers) == 0) {
            System.out.println("Error: no se permite la multiplicación por cero.");
        } else {
            System.out.println("Producto: "+serv.multiplicar(opers));
        }
        if(serv.dividir(opers) == 0) {
            System.out.println("Error: no se permite la división por cero.");
        } else {
            System.out.println("Cociente: "+serv.dividir(opers));
        }
        
    }
    
}
=======

package Calculadora;
import Entity.Calculadora.Operacion;
import Service.Calculadora.ServiceOperacion;

public class Main {
    public static void main(String[] args) {
        ServiceOperacion serv = new ServiceOperacion();
        Operacion opers = serv.crearOperacion();
        System.out.println("Suma: "+serv.sumar(opers));
        System.out.println("Resta: "+serv.restar(opers));
        if(serv.multiplicar(opers) == 0) {
            System.out.println("Error: no se permite la multiplicación por cero.");
        } else {
            System.out.println("Producto: "+serv.multiplicar(opers));
        }
        if(serv.dividir(opers) == 0) {
            System.out.println("Error: no se permite la división por cero.");
        } else {
            System.out.println("Cociente: "+serv.dividir(opers));
        }
        
    }
    
}
>>>>>>> 9744b90784dd0a6f5c2cb2dc20ab7ea4ca4b0d5e
