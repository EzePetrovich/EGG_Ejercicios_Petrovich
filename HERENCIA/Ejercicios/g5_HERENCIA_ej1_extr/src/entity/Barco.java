
package entity;

import java.util.Scanner;

public abstract class Barco {
    
    // Scanner for inputs
    
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    // Attributes
    
    protected String matricula;
    protected int eslora;
    protected int anioFab;
    
    // Constructors
    
    public Barco() {}

    public Barco(String matricula, int eslora, int anioFab) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anioFab = anioFab;
    }
    
    // Getters

    public String getMatricula() {return matricula;}
    public int getEslora() {return eslora;}
    public int getAnioFab() {return anioFab;}
    
    // Setters

    public void setMatricula(String matricula) {this.matricula = matricula;}
    public void setEslora(int eslora) {this.eslora = eslora;}
    public void setAnioFab(int anioFab) {this.anioFab = anioFab;}
    
    // Method of the class

    public void crearBarco() {
        System.out.println("\nDATOS DEL BARCO.");
        System.out.print("\n» Matricula: ");
        matricula = read.next();
        System.out.print("» Eslora [en metros]: ");
        eslora = read.nextInt();
        System.out.print("» Año de fabricacion: ");
        anioFab = read.nextInt();
    }
    
    public int moduloBarco() {return eslora * 10;}
}
