<<<<<<< HEAD

package Service.Entity;

import Entity.Banco.Cuenta;
import java.util.Scanner;

public class ServiceCuenta {

   private final Scanner read = new Scanner(System.in).useDelimiter("\n"); //.useDelimiter("\n") → para que no skipee los inputs

    public Cuenta crearCuenta() {
        Cuenta cuent = new Cuenta();
        System.out.println("CUENTA BANCARIA.");
        System.out.println("");
        System.out.print("» Ingrese número de cuenta: ");
        cuent.setNumCuenta(read.nextInt());
        System.out.print("» Ingrese el DNI del cliente: ");
        cuent.setDNI(read.nextLong());
        System.out.print("» Ingrese el saldo de la cuenta: $");
        cuent.setSaldo(read.nextInt());
        System.out.print("¿La cuenta tiene intereses? [y/n]: ");
        String resp = read.next();
        if (resp.equalsIgnoreCase("y")) {
            System.out.print("» Ingrese interes de la cuenta: $");
            cuent.setInteres(read.nextInt());
        } else {
            cuent.setInteres(0);
        }
        System.out.println();
        return cuent;
    }

    public void ingresar(Cuenta cuent) {
        System.out.println();
        System.out.print("» Cantidad de dinero a ingresar: $");
        double ingrs = read.nextDouble();
        cuent.setSaldo(cuent.getSaldo() + (int) ingrs);
    }

    public void retirar(Cuenta cuent) {
        System.out.println();
        System.out.print("» Cantidad de dinero a retirar: $");
        double retir = read.nextDouble();
        if (cuent.getSaldo() < (int) retir) {
            cuent.setSaldo(0);
        } else {
            cuent.setSaldo(cuent.getSaldo() - (int) retir);
        }
    }

    public void extraccionRapida(Cuenta cuent) {
        System.out.println();
        System.out.println("EXTRACCIÓN RÁPIDA.");
        System.out.println();
        System.out.println("(Solo se permite extraer hasta un 20% de su saldo.)");
        System.out.print("» Monto de extracción rápida: ");
        double extr_rap = read.nextDouble();
        if ((int) extr_rap <= (int) cuent.getSaldo() * 0.2) {
            cuent.setSaldo(cuent.getSaldo() - (int) extr_rap);
        } else {
            System.out.println();
            System.out.println("Error: solo puede retirar hasta un 20% de su saldo.");
            System.out.println();
            System.out.println("Su saldo: " + cuent.getSaldo());
            System.out.println("El 20% de su saldo: " + (int) (cuent.getSaldo() * 0.2));
            System.out.println();
            System.out.println("Presione intro para seguir...");
            read.next();
        }
        System.out.println("");
    }

    public void consultarSaldo(Cuenta cuent) {
        System.out.println();
        System.out.println("Su saldo es: $" + cuent.getSaldo());
        System.out.println();
        System.out.println("Presione intro para seguir...");
        read.next();
    }

    public void consultarDatos(Cuenta cuent) {
        System.out.println();
        System.out.println("DATOS DE LA CUENTA.");
        System.out.println();
        System.out.println("Nº Cuenta: " + cuent.getNumCuenta());
        System.out.println("DNI Cliente: " + cuent.getDNI());
        System.out.println("Saldo: $" + cuent.getSaldo());
        System.out.println("Interés: $" + cuent.getInteres());
        System.out.println();
        System.out.println("Presione intro para seguir...");
        read.next();
    }
}
=======

package Service.Entity;

import Entity.Banco.Cuenta;
import java.util.Scanner;

public class ServiceCuenta {

   private final Scanner read = new Scanner(System.in).useDelimiter("\n"); //.useDelimiter("\n") → para que no skipee los inputs

    public Cuenta crearCuenta() {
        Cuenta cuent = new Cuenta();
        System.out.println("CUENTA BANCARIA.");
        System.out.println("");
        System.out.print("» Ingrese número de cuenta: ");
        cuent.setNumCuenta(read.nextInt());
        System.out.print("» Ingrese el DNI del cliente: ");
        cuent.setDNI(read.nextLong());
        System.out.print("» Ingrese el saldo de la cuenta: $");
        cuent.setSaldo(read.nextInt());
        System.out.print("¿La cuenta tiene intereses? [y/n]: ");
        String resp = read.next();
        if (resp.equalsIgnoreCase("y")) {
            System.out.print("» Ingrese interes de la cuenta: $");
            cuent.setInteres(read.nextInt());
        } else {
            cuent.setInteres(0);
        }
        System.out.println();
        return cuent;
    }

    public void ingresar(Cuenta cuent) {
        System.out.println();
        System.out.print("» Cantidad de dinero a ingresar: $");
        double ingrs = read.nextDouble();
        cuent.setSaldo(cuent.getSaldo() + (int) ingrs);
    }

    public void retirar(Cuenta cuent) {
        System.out.println();
        System.out.print("» Cantidad de dinero a retirar: $");
        double retir = read.nextDouble();
        if (cuent.getSaldo() < (int) retir) {
            cuent.setSaldo(0);
        } else {
            cuent.setSaldo(cuent.getSaldo() - (int) retir);
        }
    }

    public void extraccionRapida(Cuenta cuent) {
        System.out.println();
        System.out.println("EXTRACCIÓN RÁPIDA.");
        System.out.println();
        System.out.println("(Solo se permite extraer hasta un 20% de su saldo.)");
        System.out.print("» Monto de extracción rápida: ");
        double extr_rap = read.nextDouble();
        if ((int) extr_rap <= (int) cuent.getSaldo() * 0.2) {
            cuent.setSaldo(cuent.getSaldo() - (int) extr_rap);
        } else {
            System.out.println();
            System.out.println("Error: solo puede retirar hasta un 20% de su saldo.");
            System.out.println();
            System.out.println("Su saldo: " + cuent.getSaldo());
            System.out.println("El 20% de su saldo: " + (int) (cuent.getSaldo() * 0.2));
            System.out.println();
            System.out.println("Presione intro para seguir...");
            read.next();
        }
        System.out.println("");
    }

    public void consultarSaldo(Cuenta cuent) {
        System.out.println();
        System.out.println("Su saldo es: $" + cuent.getSaldo());
        System.out.println();
        System.out.println("Presione intro para seguir...");
        read.next();
    }

    public void consultarDatos(Cuenta cuent) {
        System.out.println();
        System.out.println("DATOS DE LA CUENTA.");
        System.out.println();
        System.out.println("Nº Cuenta: " + cuent.getNumCuenta());
        System.out.println("DNI Cliente: " + cuent.getDNI());
        System.out.println("Saldo: $" + cuent.getSaldo());
        System.out.println("Interés: $" + cuent.getInteres());
        System.out.println();
        System.out.println("Presione intro para seguir...");
        read.next();
    }
}
>>>>>>> 9744b90784dd0a6f5c2cb2dc20ab7ea4ca4b0d5e
