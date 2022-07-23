
package entity;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    
    private final ArrayList<Carta> cartas;
    private final ArrayList<Carta> repartidas;
    
    public Baraja() {
        cartas = new ArrayList();
        repartidas = new ArrayList();
        for(int i = 1; i <= 40; i++) {
            cartas.add(new Carta());
        }
    }
    
    public void barajar() {
        Collections.shuffle(cartas);
    }
    
    
    public void siguienteCarta() {
        if(!cartas.isEmpty()) {
            repartidas.add(cartas.get(0));
            System.out.println(cartas.get(0));
            System.out.println();
            cartas.remove(cartas.get(0));
        } else {System.out.println("No hay más cartas para repartir."); System.out.println();}
    }
    
    public int cartasDisponibles() {
        return cartas.size();
    }
    
    public void darCartas(int n) {
        if(n <= cartas.size()) {
            System.out.println("Cartas repartidas: ");
            for(int i = 1; i <= n; i++) {siguienteCarta();}
            
        } else {System.out.println("No se puede repartir la cantidad ingresada. Hay menos cartas en la baraja.");}
        System.out.println();
    }
    
    public void cartasMonton() {
        if(!repartidas.isEmpty()) {
            System.out.println("CARTAS REPARTIDAS.");
            System.out.println();
            repartidas.forEach((c) -> {System.out.println(c);});
        } else {System.out.println("Todavía no se repartieron cartas.");}
        System.out.println();
    }
    
    public void mostrarBaraja() {
        System.out.println("BARAJA.");
        System.out.println();
        if(!cartas.isEmpty()) {
            cartas.forEach((c) -> {System.out.println(c);});
            System.out.println();
        } else {System.out.println("No hay cartas."); System.out.println();}
    }
    // mostrarBaraja() | muestra todas las cartas de la baraja.
}
