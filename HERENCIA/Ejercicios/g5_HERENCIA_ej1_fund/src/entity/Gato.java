
package entity;

public final class Gato extends Animal {
    public Gato(String nombre, String alimento, String raza, int edad) {
        super(nombre, alimento, raza, edad);
    }
    @Override
    public void HacerRuido() {System.out.println(nombre + " dice Miau");}
}
