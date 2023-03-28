
package entity;


public abstract class Animal {
    
    // Attributes
    
    protected String nombre, alimento, raza;
    protected int edad;

    // Constructors    
    
    public Animal(String nombre, String alimento, String raza, int edad) {
        this.nombre = nombre;
        this.alimento = alimento;
        this.raza = raza;
        this.edad = edad;
    }
    
    // Methods of the class
    
    public void Alimentarse() {System.out.println(nombre + " morfando " + alimento + "...");}
    public abstract void HacerRuido();
}
