
package service.cancion;

import java.util.Scanner;
import entity.cancion.Cancion;

public class CancionService {
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    public Cancion crearCancion() {
        System.out.println("CANCIÓN ♪");
        System.out.println();
        System.out.print("» Ingrese título: ");
        String titulo = read.next();
        System.out.print("» Ingrese autor: ");
        String autor = read.next();
        System.out.println();
        return new Cancion(titulo, autor);
    }
    
    public void mostrarCancion(Cancion song) {
        System.out.println();
        System.out.println("• Título: " + song.getTitulo());
        System.out.println("• Autor: " + song.getAutor());
        System.out.println();
    }
}
