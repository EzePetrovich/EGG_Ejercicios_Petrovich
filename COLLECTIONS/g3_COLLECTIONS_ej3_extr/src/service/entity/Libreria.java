
package service.entity;

import java.util.Scanner;
import entity.Libro;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class Libreria {
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    public Libro crearLibro() {
        System.out.print("» Título: "); String titulo = read.next();
        System.out.print("» Autor: "); String autor = read.next();
        System.out.print("» Ejemplares: "); Integer ej = read.nextInt();
        System.out.print("» Prestados: "); Integer ejP = read.nextInt();
        System.out.println();
        return new Libro(titulo, autor, ej, ejP);
    }
    public boolean existeLibro(HashSet<Libro> libros, String titulo) {
        boolean find = false;
        Iterator<Libro> it = libros.iterator();
        while(it.hasNext()) {
            if(it.next().getTitulo().equals(titulo)) {
                find = true;
            }
        }
        return find;
    }
    
    public Libro retornarLibro(HashSet<Libro> libros, String titulo) {
        Iterator<Libro> it = libros.iterator(); Libro lib = new Libro();
        while(it.hasNext()) {
            lib = it.next();
            if(lib.getTitulo().equals(titulo)) {
                break;
            }
        }
        return lib;
    }
    
    public void mostrarLibros(HashSet<Libro> libros) {
        System.out.println("3) MOSTRAR LIBROS.");
        System.out.println();
        for(Libro lib: libros) {
            System.out.println(lib + " ");
        }
        System.out.println();
        System.out.print("Presione intro para seguir...");
        try{System.in.read();}
        catch(IOException e){}
    }
}
