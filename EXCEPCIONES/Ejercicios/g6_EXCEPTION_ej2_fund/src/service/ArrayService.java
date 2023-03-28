<<<<<<< HEAD
/**
 * @author Ezequiel
 */

package service;

import java.util.Scanner;

public class ArrayService {
    
    public Scanner read = new Scanner(System.in).useDelimiter("\n");
    private Integer[] nums;
    
    public Integer[] getNums() {return nums;}
    public void setNums(Integer[] nums) {this.nums = nums;}
    
    public void crearArray() {
        System.out.println("CREAR ARRAY. (Numeros aleatorios)\n");
        System.out.print("» Ingrese cantidad de elementos: ");
        int cant = read.nextInt();
        nums = new Integer[cant];
        for(int i = 0; i < cant; i++) {nums[i] = (int) ((Math.random() * 10 + 1) + (Math.random() * 10 + 1));}
    }
    
    public void mostrarArray() {
        System.out.print("\nArray de numeros: ");
        for(Integer n: nums) {System.out.print(n + " ");}
        System.out.println("\n");
    }
    
    public void modifArray() {
        System.out.println("CAMBIO DE NUMERO.\n");
        System.out.print("» Ingrese numero: ");
        int n = read.nextInt();
        System.out.print("» Ingrese posicion: ");
        int pos = read.nextInt();
        nums[pos] = n;
        mostrarArray();
    }
    
}
=======
/**
 * @author Ezequiel
 */

package service;

import java.util.Scanner;

public class ArrayService {
    
    public Scanner read = new Scanner(System.in).useDelimiter("\n");
    private Integer[] nums;
    
    public Integer[] getNums() {return nums;}
    public void setNums(Integer[] nums) {this.nums = nums;}
    
    public void crearArray() {
        System.out.println("CREAR ARRAY. (Numeros aleatorios)\n");
        System.out.print("» Ingrese cantidad de elementos: ");
        int cant = read.nextInt();
        nums = new Integer[cant];
        for(int i = 0; i < cant; i++) {nums[i] = (int) ((Math.random() * 10 + 1) + (Math.random() * 10 + 1));}
    }
    
    public void mostrarArray() {
        System.out.print("\nArray de numeros: ");
        for(Integer n: nums) {System.out.print(n + " ");}
        System.out.println("\n");
    }
    
    public void modifArray() {
        System.out.println("CAMBIO DE NUMERO.\n");
        System.out.print("» Ingrese numero: ");
        int n = read.nextInt();
        System.out.print("» Ingrese posicion: ");
        int pos = read.nextInt();
        nums[pos] = n;
        mostrarArray();
    }
    
}
>>>>>>> 9744b90784dd0a6f5c2cb2dc20ab7ea4ca4b0d5e
