
package Service.Entity;
import Entity.Biblioteca.Libro;
import java.util.Scanner;

public class ServicioLibro {
    public Libro CargarLibro() {
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        System.out.print("» Título del libro: ");
        String tit = read.nextLine(); 
        System.out.print("» Autor del libro: ");
        String autor = read.nextLine(); 
        System.out.print("» Número de páginas del libro: ");
        int n_pags = read.nextInt();
        System.out.print("» ISBN del libro: ");
        int isbn = read.nextInt(); 
        return new Libro(isbn, tit, autor, n_pags);
    }
    public void MostrarLibro(Libro lib) {
        System.out.println();
        System.out.println("DATOS DEL LIBRO.");
        System.out.println();
        System.out.println("ISBN: "+lib.isbn);
        System.out.println("Título: "+lib.titulo);
        System.out.println("Autor: "+lib.autor);
        System.out.println("Número de páginas: "+lib.n_pags);
    }
}
