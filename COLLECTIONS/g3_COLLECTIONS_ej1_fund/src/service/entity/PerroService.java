
package service.entity;

import java.util.Scanner;
import java.util.ArrayList;
import entity.Perro;

public class PerroService {
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    String resp, raza;
    public ArrayList <Perro> listarRazas() {
        ArrayList <Perro> listaPerros = new ArrayList();
        Perro guau;
        do {
            System.out.print("¿Desea ingresar una raza de perro? [S → Si | N → No]: ");
            resp = read.next();
            System.out.println();
            if(!resp.equalsIgnoreCase("N")) {
                System.out.print("» Raza de perro: ");
                raza = read.next();
                System.out.println();
                guau = new Perro(raza);
                listaPerros.add(guau);
            }
        } while(!resp.equalsIgnoreCase("N"));
        return listaPerros;
    }
    
    public void mostrarPerros(ArrayList <Perro> Perros) {
        Perros.forEach((perro) -> {
            System.out.print(perro + " ");
        });
    }
}

