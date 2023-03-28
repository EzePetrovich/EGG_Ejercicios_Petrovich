<<<<<<< HEAD
/*Crear una clase llamada Libro que contenga los siguientes atributos: ISBN, Título, Autor,
Número de páginas, y un constructor con todos los atributos pasados por parámetro y un
constructor vacío. Crear un método para cargar un libro pidiendo los datos al usuario y
luego informar mediante otro método el número de ISBN, el título, el autor del libro y el
numero de páginas.*/

package Biblioteca;
import Service.Entity.ServicioLibro;
import Entity.Biblioteca.Libro;

public class Main {
    public static void main(String[] args) {
        ServicioLibro serv = new ServicioLibro();
        Libro lib = serv.CargarLibro();
        serv.MostrarLibro(lib);
    }
    
}
=======
/*Crear una clase llamada Libro que contenga los siguientes atributos: ISBN, Título, Autor,
Número de páginas, y un constructor con todos los atributos pasados por parámetro y un
constructor vacío. Crear un método para cargar un libro pidiendo los datos al usuario y
luego informar mediante otro método el número de ISBN, el título, el autor del libro y el
numero de páginas.*/

package Biblioteca;
import Service.Entity.ServicioLibro;
import Entity.Biblioteca.Libro;

public class Main {
    public static void main(String[] args) {
        ServicioLibro serv = new ServicioLibro();
        Libro lib = serv.CargarLibro();
        serv.MostrarLibro(lib);
    }
    
}
>>>>>>> 9744b90784dd0a6f5c2cb2dc20ab7ea4ca4b0d5e
