
package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public abstract class Electrodomestico {
    
    // Scanner for inputs

    Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    // Attributes
    
    protected double precio;
    protected String color;
    protected char consumEnerg;
    protected int peso;
    
    // Constructors
    
    public Electrodomestico() {}

    public Electrodomestico(String color, char consumEnerg, int peso) {
        this.color = color;
        this.consumEnerg = consumEnerg;
        this.peso = peso;
        this.precio = 1000;
    }
    
    // Getters
    
    public double getPrecio() {return precio;}
    public String getColor() {return color;}
    public char getConsumEnerg() {return consumEnerg;}
    public int getPeso() {return peso;}
    
    // Setters

    public void setPrecio(double precio) {this.precio = precio;}
    public void setColor(String color) {this.color = color;}
    public void setConsumEnerg(char consumEnerg) {this.consumEnerg = consumEnerg;}
    public void setPeso(int peso) {this.peso = peso;}
    
    // Format double
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    
    // Methods of the class
    
    public void comprobarConsumoEnergetico(char consumEnerg) {
        String consumVal = "ABCDEF";
        consumEnerg = Character.toUpperCase(consumEnerg);
        if(!consumVal.contains(Character.toString(consumEnerg))) {consumEnerg = 'F';}
    }
    
    public void comprobarColor(String color) {
       String [] coloresVal = new String [] {"blanco", "negro", "rojo", "azul", "gris"};
       ArrayList<String> coloresList = new ArrayList(Arrays.asList(coloresVal));
       if(!coloresList.contains(color.toLowerCase())) {color = "blanco";}
    }
    
    public void crearElectrodomestico(String nombreElec) {
        System.out.println("\n" + nombreElec + ".\n");
        System.out.print("» Color: ");
        String colorElec = read.next();
        comprobarColor(colorElec);
        setColor(colorElec);
        System.out.print("» Consumo: ");
        char consumoElec = read.next().charAt(0);
        comprobarConsumoEnergetico(consumoElec);
        setConsumEnerg(consumoElec);
        System.out.print("» Peso [Kg]: ");
        setPeso(read.nextInt());
        setPrecio(round(1000, 2));
    }
    
    public void precioFinal() {
        switch(consumEnerg) {
            case 'A':
                precio = round(precio + 1000, 2);
                break;
            case 'B':
                precio = round(precio + 800 , 2);
                break;
            case 'C':
                precio = round(precio + 600 , 2);
                break;
            case 'D':
                precio = round(precio + 500 , 2);
                break;
            case 'E':
                precio = round(precio + 300 , 2);
                break;
            case 'F':
                precio = round(precio + 100 , 2);
                break;
        }
        if(peso > 79) {
            precio = round(precio + 1000, 2);
        } else if(peso > 49) {
            precio = round(precio + 800 , 2);
        } else if(peso > 20) {
            precio = round(precio + 500 , 2);
        } else if(peso >= 1) {
            precio = round(precio + 100 , 2);
        }
    }
    
}
