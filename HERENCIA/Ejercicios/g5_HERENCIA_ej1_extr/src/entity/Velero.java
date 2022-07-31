
package entity;

public class Velero extends Barco {
    
    // Attribute
    
    private int numMastiles;
    
    // Constructor
    
    public Velero() {}
    
    public Velero(int numMastiles, String matricula, int eslora, int añoFab) {
        super(matricula, eslora, añoFab);
        this.numMastiles = numMastiles;
    }
    
    // Getter and setter
    
    public int getNumMastiles() {return numMastiles;}
    public void setNumMastiles(int numMastiles) {this.numMastiles = numMastiles;}
    
    // Method of the class

    public void crearVelero() {
        super.crearBarco();
        System.out.print("» Numero de mastiles: ");
        numMastiles = super.read.nextInt();
    }
        
    @Override
    public int moduloBarco() {return super.moduloBarco() + numMastiles;}
}
