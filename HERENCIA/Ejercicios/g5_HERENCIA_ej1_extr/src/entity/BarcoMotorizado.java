
package entity;

public class BarcoMotorizado extends Barco {
    
    // Attribute
    
    protected int potCV;
    
    // Constructor
    
    public BarcoMotorizado() {}
    
    public BarcoMotorizado(int potCV, String matricula, int eslora, int añoFab) {
        super(matricula, eslora, añoFab);
        this.potCV = potCV;
    }
    
    // Getter and setter

    public int getPotCV() {return potCV;}
    public void setPotCV(int potCV) {this.potCV = potCV;}
    
    // Method of the class
    
    public void crearMotorizado() {
        super.crearBarco();
        System.out.print("» Potencia del motor [en CV]: ");
        potCV = super.read.nextInt();
    }
        
    @Override
    public int moduloBarco() {return super.moduloBarco() + potCV;}
}
