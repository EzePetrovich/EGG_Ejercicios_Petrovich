
package paises;

import java.util.HashSet;
import entity.Pais;
import java.util.Collections;
import service.entity.PaisService;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in).useDelimiter("\n"); String resp; 
        PaisService serv = new PaisService(); HashSet<Pais> paises = new HashSet();
        do {
            System.out.print("» ¿Desea ingresar un nuevo país? [S/N]: "); resp = read.next();
            if(!resp.equalsIgnoreCase("n")) {
                paises.add(serv.crearPais());
            }
        } while(!resp.equalsIgnoreCase("n"));
        System.out.print("• Conjunto de países: ");
        serv.mostrarPaisesHash(paises);
        System.out.println();
        System.out.print("• Conjunto de países ordenados alfabéticamente: ");
        TreeSet<Pais> paisesTree = new TreeSet(Collections.reverseOrder(Pais.ordenName));
        serv.llenarTree(paises, paisesTree);
        serv.mostrarPaisesTree(paisesTree);
        System.out.println();
        serv.eliminarPais(paisesTree);
        System.out.println();
        System.out.print("• Conjunto sin el país ingresado: ");
        serv.mostrarPaisesTree(paisesTree);
    }
    
}
