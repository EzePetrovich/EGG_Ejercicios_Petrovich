
package entity;

public class Yate extends BarcoMotorizado {
    
    // Attribute
    
    private int numCamarotes;
    
    // Constructor
    
    public Yate() {}
    
    public Yate(int numCamarotes, int potCV, String matricula, int eslora, int añoFab) {
        super(potCV, matricula, eslora, añoFab);
        this.numCamarotes = numCamarotes;
    }
    
    // Getter and setter
    
    public int getNumCamarotes() {return numCamarotes;}
    public void setNumCamarotes(int numCamarotes) {this.numCamarotes = numCamarotes;}
    
    // Method of the class

    public void crearYate() {
        super.crearMotorizado();
        System.out.print("» Numero de camarotes: ");
        numCamarotes = super.read.nextInt();
    }
    
    @Override
    public int moduloBarco() {return super.moduloBarco() + numCamarotes;}
    
}
