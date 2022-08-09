
package entity;

public final class Perro extends Animal {
    public Perro(String nombre, String alimento, String raza, int edad) {
        super(nombre, alimento, raza, edad);
    }
    @Override
    public void HacerRuido() {System.out.println(nombre + " dice Wuau");}
}
