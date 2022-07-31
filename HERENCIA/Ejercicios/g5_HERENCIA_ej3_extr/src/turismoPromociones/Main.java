
package turismoPromociones;

import entity.Alojamiento;
import entity.HotelCuatroEstrellas;
import entity.HotelCincoEstrellas;
import entity.Camping;
import entity.Hotel;
import entity.Residencia;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    
    public static void presioneIntro() {
        System.out.print("\nPresione intro para seguir...");
        try{System.in.read();}
        catch(IOException e) {}
    }   
    
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        String resp, confirm = "";
        ArrayList<Alojamiento> alojamientos = new ArrayList();
        ArrayList<Hotel> hoteles = new ArrayList();
        ArrayList<Camping> campings = new ArrayList();
        ArrayList<Residencia> residencias = new ArrayList();
        
        // Hoteles cinco estrellas

        HotelCincoEstrellas hotelCincoEs1 = new HotelCincoEstrellas(5, 100, 50, "A", "Cantina e Cucina", 200, 150, 300, 7, "Hotel de la Ville", "Via del Governo Vecchio, 87", "Roma", "Fernando Martini");
        HotelCincoEstrellas hotelCincoEs2 = new HotelCincoEstrellas(8, 100, 60, "A", "Quel che c’è laboratorio Di Cucina", 350, 200, 400, 9, "Hotel Augustus Riccione", "Via Torino, 129", "Roma", "Chiara Parissi");
        HotelCincoEstrellas hotelCincoEs3 = new HotelCincoEstrellas(15, 100, 75, "A", "Tonnarello", 400, 200, 400, 11, "Hotel Diamante Alessandria", " Via della Paglia, 1/2/3", "Roma", "Luigi Di Martino");
        
        // Hoteles cuatro estrellas
        
        HotelCuatroEstrellas hotelCuatroEs1 = new HotelCuatroEstrellas("B", "Camelot", 35, 50, 100, 4, "Horly", "Italia 456", "Roma", "Mario Di Carlo");
        HotelCuatroEstrellas hotelCuatroEs2 = new HotelCuatroEstrellas("B", "Coco's", 25, 45, 90, 3, "Oasis", "Av. Davinci 1760", "Roma", "Daniel Di Angelo");
        HotelCuatroEstrellas hotelCuatroEs3 = new HotelCuatroEstrellas("A", "La Taberna De Diego", 45, 70, 140, 6, "Star in the night", "Milan 775", "Roma", "Justini Ferrari");
        
        // Extrahoteles campings
        
        Camping camp1 = new Camping(50, 50, true, true, 10000, "Camping Caperuza Roja", "Av. Maria Del Carmen 1450", "Milan", "Gerard Casais");
        Camping camp2 = new Camping(40, 40, true, false, 7500, "Camping Caperuza Azul", "Ruta 25 50km", "Milan", "Martino Vitale");
        Camping camp3 = new Camping(35, 35, false, true, 8000, "Camping Caperuza Amarilla", "Esparta 2150", "Milan", "Michael Jackson");
        
        // Extrahoteles residencias
        
        Residencia res1 = new Residencia(50, true, true, true, 10000, "Residencia Luigi", "Av. Riccione 1200", "Roma", "Massimo Di Porto");
        Residencia res2 = new Residencia(50, false, true, true, 10000, "Residencia Lorenzo", "Martino Tonarello 476", "Roma", "Mario Davinchi");
        Residencia res3 = new Residencia(50, true, true, true, 10000, "Residencia Francesco", "Alessandria Vecchia 2160", "Roma", "Carlo Torino");
        
        // Añade los elementos a la lista
        
        alojamientos.add(res3);
        alojamientos.add(hotelCuatroEs1);
        alojamientos.add(camp3);
        alojamientos.add(hotelCincoEs1);
        alojamientos.add(camp1);
        alojamientos.add(hotelCuatroEs2);
        alojamientos.add(hotelCincoEs2);
        alojamientos.add(res1);
        alojamientos.add(camp2);
        alojamientos.add(hotelCuatroEs3);
        alojamientos.add(hotelCincoEs3);
        alojamientos.add(res2);
        
        // Lista de hoteles ordenadas por precio por habitación
        
        alojamientos.stream().filter((a) -> (a instanceof HotelCuatroEstrellas || a instanceof HotelCincoEstrellas)).forEachOrdered((a) -> {hoteles.add((Hotel) a);});
        Collections.sort(hoteles, Hotel.compararPrecios);
        Collections.reverse(hoteles);
        
        // Lista de extrahoteles
        
        alojamientos.forEach((a) -> {
            if(a instanceof Camping) {
                if(((Camping) a).isTieneRest()) {campings.add((Camping) a);}
            } else if(a instanceof Residencia) {
                if(((Residencia) a).isDoDescGrem()) {residencias.add((Residencia) a);}
            }
        });
        do {
            System.out.println("CONSULTA DE ALOJAMIENTOS.");
            System.out.println("\n1) Todos los alojamientos.");
            System.out.println("2) Hoteles.");
            System.out.println("3) Campings con restaurantes.");
            System.out.println("4) Residencias con descuento a gremios.");
            System.out.println("5) Salir.");
            System.out.print("\n» Seleccione una opcion [1|2|3|4|5]: ");
            resp = read.next();
            switch(resp) {
                case "1":
                    alojamientos.stream().map((a) -> {System.out.println(a); return a;}).forEachOrdered((_item) -> {presioneIntro();});
                    break;
                case "2":
                    hoteles.forEach((h) -> {System.out.println(h); presioneIntro();});
                    break;
                case "3":
                    campings.forEach((c) -> {System.out.println(c); presioneIntro();});
                    break;
                case "4":
                    residencias.forEach((r) -> {System.out.println(r); presioneIntro();});
                    break;
                case "5":
                    System.out.print("¿Confirma salir? [s/n]: ");
                    confirm = read.next();
                    break;
                default:
                    System.out.println("\nERROR: opcion no valida.");
                    presioneIntro();
            }
            System.out.println();
        } while(!confirm.equalsIgnoreCase("S"));
    }
}
