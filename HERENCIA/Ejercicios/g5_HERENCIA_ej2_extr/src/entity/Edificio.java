
package entity;

//import java.io.IOException;
//import java.util.ArrayList;
import java.util.Scanner;

public abstract class Edificio {
    
    // Scanner for inputs
    
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    // Attributes
    
    protected double ancho, largo, alto;
    /**
     * ArrayList edificios
     * 
     * Para crear los edificios con método crearEdificio() y agregarlos sin necesidad de 
     * crear una lista en el main, es una manera que diseñé, no pide el ejercicio.
     * Para utilizarlo hay que descomentar el atributo de abajo ↓ y los métodos en
     * la clase padre e hijos.
     */
    
    // protected ArrayList<Edificio> edificios = new ArrayList();
    
    // Constructors
    
    public Edificio() {}
    
    public Edificio(double ancho, double largo, double alto) {
        this.ancho = ancho;
        this.largo = largo;
        this.alto = alto;
    }
    
    // Getters

    public double getAncho() {return ancho;}
    public double getLargo() {return largo;}
    public double getAlto() {return alto;}
    
    // Setters

    public void setAncho(double ancho) {this.ancho = ancho;}
    public void setLargo(double largo) {this.largo = largo;}
    public void setAlto(double alto) {this.alto = alto;}
        
    // Methods of the class
    
    public abstract double calcularSuperficie();
    public abstract double calcularVolumen();
    
    public void informarCalculos(String tipoEdif) {
        System.out.println("\n" + tipoEdif);
        System.out.println("\n· La superficie es: " + round(calcularSuperficie(), 2) + "m²");
        System.out.println("· El volumen es: " + round(calcularVolumen(), 2) + "m³");
    }
    
    /*public void crearEdificio() {
        Edificio e = null;
        boolean val = false;
        System.out.println("LONGITUDES DEL EDIFICIO.");
        System.out.print("\n» Ancho: ");
        double b = read.nextDouble();
        System.out.print("» Largo: ");
        double l = read.nextDouble();
        System.out.print("» Alto: ");
        double h = read.nextDouble();
        System.out.println("• Tipo de edificio a crear: ");
        System.out.println("· Polideportivo → P");
        System.out.println("· Edificio de oficinas → O");
        while(!val) {
            System.out.print("\n» Seleccione una opcion [P|O]: ");
            String resp = read.next().toUpperCase();
            switch(resp) {
                case "P":
                    val = true;
                    Polideportivo p = new Polideportivo(b, l, h);
                    p.crearPolideportivo();
                    edificios.add(p);
                    break;
                case "O":
                    val = true;
                    EdificioDeOficinas o = new EdificioDeOficinas(b, l, h);
                    o.crearEdificioDeOficinas();
                    edificios.add(o);
                    break;
                default:
                    System.out.println("ERROR: opcion no valida. Verifique que su ingreso se ajuste a lo indicado.");
                    System.out.print("\nPresione intro para seguir...");
                    try{System.in.read();}
                    catch(IOException exc) {}
            }
        }
    }*/
    
    // Format double
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
