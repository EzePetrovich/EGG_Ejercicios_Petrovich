
package cine;

import entity.Pelicula;
import service.entity.PeliculaService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        PeliculaService serv = new PeliculaService();
        ArrayList<Pelicula> movies = new ArrayList(); String resp;
        do {
            System.out.print("¿Desea ingresar una nueva película? [S/N]: ");
            resp = read.next();
            if(!resp.equalsIgnoreCase("n")) {
                movies.add(serv.crearPelicula());
            }
        } while(!resp.equalsIgnoreCase("n"));
        System.out.println();
        System.out.println("• Películas ingresadas: ");
        serv.mostrarPeliculas(movies);
        System.out.println();
        System.out.println("• Películas de más de una hora: ");
        serv.mostrarPeliculas(serv.masDeUnaHora(movies));
        System.out.println();
        System.out.println("• Ordenadas según su duración: ");
        System.out.print("Descendente: ");
        Collections.sort(movies, Pelicula.ordenarPorDuracion);
        serv.mostrarPeliculas(movies);
        System.out.println();
        System.out.print("Ascendente: ");
        Collections.reverse(movies);
        serv.mostrarPeliculas(movies);
        System.out.println();
        System.out.println("• Ordenadas por títulos: ");
        Collections.sort(movies, Pelicula.ordenarPorTitulo);
        Collections.reverse(movies);
        serv.mostrarPeliculas(movies);
        System.out.println();
        System.out.println("• Ordenadas por Director: ");
        Collections.sort(movies, Pelicula.ordenarPorDirector);
        Collections.reverse(movies);
        serv.mostrarPeliculas(movies);
    }
}
