
package service.entity;

import entity.Pais;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class PaisService {
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    public Pais crearPais() {
        System.out.print("» Nombre de país: "); String name = read.next();
        System.out.println();
        return new Pais(name);
    }
    public void mostrarPaisesHash(HashSet<Pais> paises) {
        for(Pais p : paises) {
            System.out.print(p + " ");
        }
    }
    public void mostrarPaisesTree(TreeSet<Pais> paises) {
        for(Pais p : paises) {
            System.out.print(p + " ");
        }
    }
    public void eliminarPais(TreeSet<Pais> paises) {
        boolean find = false;
        Iterator<Pais> it = paises.iterator();
        System.out.print("» Ingrese un país: "); String name = read.next();
        while(it.hasNext()) {
            if(it.next().getName().equals(name)) {
                it.remove();
                find = true;
            }
        }
        if(!find) {System.out.println("No se encontró el país ingresado.");}
    }
    public void llenarTree(HashSet<Pais> paises, TreeSet<Pais> paisesTree) {
        Iterator<Pais> itH = paises.iterator();
        while(itH.hasNext()) {
            paisesTree.add(itH.next());
        }
    }
}
