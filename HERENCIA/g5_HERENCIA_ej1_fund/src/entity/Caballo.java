
package entity;

public class Caballo extends Animal {
    public Caballo(String nombre, String alimento, String raza, int edad) {
        super(nombre, alimento, raza, edad);
    }
    @Override
    public void HacerRuido() {System.out.println(nombre + " dice Iiijijiji");}
}