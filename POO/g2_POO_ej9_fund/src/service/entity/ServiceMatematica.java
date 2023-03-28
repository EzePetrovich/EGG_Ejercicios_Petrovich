<<<<<<< HEAD

package service.entity;

import entity.operations.Matematica;

public class ServiceMatematica {
    public static double devolverMayor(Matematica opers) {
        return Math.max(opers.getNum1(), opers.getNum2());
    }
    
    public static int calcularPot(Matematica opers) {
        int pot = 1;
        int bas = (int) Math.round(devolverMayor(opers));
        int exp = (int) Math.round(Math.min(opers.getNum1(), opers.getNum2()));
        for(int i = 0; i < exp; i++) {
            pot = pot * bas;
        }
        if(exp == 0) {
            pot = 1;
        }
        return pot;
    }
    
    public static double calcularRaiz(Matematica opers) {
        double men = Math.abs(Math.min(opers.getNum1(), opers.getNum2()));
        return Math.sqrt(men);
    }
    
    public static void mostrarOperandos(Matematica opers) {
        System.out.println("OPERANDOS. ");
        System.out.println();
        System.out.println("Número 1: " + opers.getNum1());
        System.out.println("Número 2: " + opers.getNum2());
        System.out.println();
    }
}
=======

package service.entity;

import entity.operations.Matematica;

public class ServiceMatematica {
    public static double devolverMayor(Matematica opers) {
        return Math.max(opers.getNum1(), opers.getNum2());
    }
    
    public static int calcularPot(Matematica opers) {
        int pot = 1;
        int bas = (int) Math.round(devolverMayor(opers));
        int exp = (int) Math.round(Math.min(opers.getNum1(), opers.getNum2()));
        for(int i = 0; i < exp; i++) {
            pot = pot * bas;
        }
        if(exp == 0) {
            pot = 1;
        }
        return pot;
    }
    
    public static double calcularRaiz(Matematica opers) {
        double men = Math.abs(Math.min(opers.getNum1(), opers.getNum2()));
        return Math.sqrt(men);
    }
    
    public static void mostrarOperandos(Matematica opers) {
        System.out.println("OPERANDOS. ");
        System.out.println();
        System.out.println("Número 1: " + opers.getNum1());
        System.out.println("Número 2: " + opers.getNum2());
        System.out.println();
    }
}
>>>>>>> 9744b90784dd0a6f5c2cb2dc20ab7ea4ca4b0d5e
