
package entity;

import java.util.Scanner;

public abstract class Barco {
    
    // Scanner for inputs
    
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    // Attributes
    
    protected String matricula;
    protected int eslora;
    protected int añoFab;
    
    // Constructors
    
    public Barco() {}

    public Barco(String matricula, int eslora, int añoFab) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.añoFab = añoFab;
    }
    
    // Getters

    public String getMatricula() {return matricula;}
    public int getEslora() {return eslora;}
    public int getAñoFab() {return añoFab;}
    
    // Setters

    public void setMatricula(String matricula) {this.matricula = matricula;}
    public void setEslora(int eslora) {this.eslora = eslora;}
    public void setAñoFab(int añoFab) {this.añoFab = añoFab;}
    
    // Method of the class

    public void crearBarco() {
        System.out.println("\nDATOS DEL BARCO.");
        System.out.print("\n» Matricula: ");
        matricula = read.next();
        System.out.print("» Eslora [en metros]: ");
        eslora = read.nextInt();
        System.out.print("» Año de fabricacion: ");
        añoFab = read.nextInt();
    }
    
    public int moduloBarco() {return eslora * 10;}
}
