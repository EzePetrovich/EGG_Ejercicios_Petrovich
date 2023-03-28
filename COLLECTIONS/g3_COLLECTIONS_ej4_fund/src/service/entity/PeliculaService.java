
package service.entity;

import entity.Pelicula;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PeliculaService {
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    public Pelicula crearPelicula() {
        System.out.print("» Título: ");
        String tit = read.next();
        System.out.print("» Director: ");
        String dir = read.next();
        System.out.print("» Duración: ");
        int dur = read.nextInt();
        System.out.println();
        return new Pelicula(tit, dir, dur);
    }
    public void mostrarPeliculas(ArrayList <Pelicula> movies) {
        Iterator <Pelicula> it = movies.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
    public ArrayList<Pelicula> masDeUnaHora(ArrayList<Pelicula> movies) {
        ArrayList<Pelicula> movMasHora = new ArrayList();
        for(Pelicula movy : movies) {
            if(movy.getDuracion() > 1) {
                movMasHora.add(movy);
            }
        }
        return movMasHora;
    }
}
