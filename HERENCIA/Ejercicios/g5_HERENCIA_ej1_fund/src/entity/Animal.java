<<<<<<< HEAD

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
=======

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
>>>>>>> 9744b90784dd0a6f5c2cb2dc20ab7ea4ca4b0d5e
