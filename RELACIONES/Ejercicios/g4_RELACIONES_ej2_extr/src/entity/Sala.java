
package entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sala {
    
    //Attributes
    
    private static String [][] asientos;
    private int asientosOcupados;
    private Pelicula movie;
    private ArrayList<Espectador> espectadores;
    private ArrayList<Espectador> espectadoresInSala;
    private int precioIn;
    private final Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    // Getters and setters
    
    public String [][] getAsientos() {return asientos;}
    
    public int getAsientosOcupados() {return asientosOcupados;}
    public void setAsientosOcupados(int asientosOcupados) {this.asientosOcupados = asientosOcupados;}
    
    public void setMovie(Pelicula movie) {this.movie = movie;}
    public Pelicula getMovie() {return movie;}
    
    public ArrayList<Espectador> getEspectadores() {return espectadores;}
    public void setEspectadores(ArrayList<Espectador> espectadores) {this.espectadores = espectadores;}
    
    public ArrayList<Espectador> getEspectadoresInSala() {return espectadoresInSala;}
    public void setEspectadoresInSala(ArrayList<Espectador> espectadoresInSala) {this.espectadoresInSala = espectadoresInSala;}
    
    public int getPrecioIn() {return precioIn;}
    public void setPrecioIn(int precioIn) {this.precioIn = precioIn;}
    
    
    // Constructor vacio (Crea la sala con la matriz de asientos)
    
    public Sala() {
        movie = new Pelicula();
        espectadores = new ArrayList();
        espectadoresInSala = new ArrayList();
        asientosOcupados = 0;
        asientos = new String [8][6];
        for(int j = 0; j < 6; j++) {
            String letra = "ABCDEF";
            for(int i = 7; i >= 0; i--) {
                asientos[i][j] = (8 - i) + letra.substring(j, j + 1) + " ";
                if(j != 5) {asientos[i][j] = asientos[i][j] + "|";}
            }
        }
    }
    
    // Métodos de la sala
    
    public void verSala() {
        System.out.println("SALA.");
        System.out.println();
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 6; j++) {
                System.out.print(asientos[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("PELÍCULA: " + movie);
        System.out.println("PRECIO ENTRADA: $" + precioIn);
        mostrarEspectadores();
    }
    
    public void crearPelicula() {
        System.out.println("PELICULA.");
        System.out.println();
        System.out.print("Título: "); String tit = read.next();
        System.out.print("Director: "); String dir = read.next();
        System.out.print("Duración (en horas): "); int dur = read.nextInt();
        System.out.print("Clasificación (edad mínima): "); int clasif = read.nextInt();
        System.out.print("Precio de entrada: $"); precioIn = read.nextInt();
        System.out.println();
        movie = new Pelicula(tit, dir, dur, clasif);
    }
    
    public void crearEspectadores(int n) {
        String name; int edad, dinero;
        for(int i = 1 ; i <= n; i++) {
            name = "Espectador " + i;
            edad = (int) ((Math.random() * 10 + 1) + (Math.random() * 10 + 1) + (Math.random() * 10 + 1));
            dinero = (int) ((Math.random() * 1000) + (Math.random() * 100));
            espectadores.add(new Espectador(name, edad, dinero));
        }
    }
    
    public void mostrarEspectadores() {
        if(!espectadoresInSala.isEmpty()) {
            System.out.println("ESPECTADORES:");
            System.out.println();
            espectadoresInSala.forEach((e) -> {System.out.println(e);});
        } else {
            System.out.println("No hay espectadores.");
            System.out.println();
            System.out.print("Presione intro para seguir...");
            try{System.in.read();}
            catch(IOException e) {}
        }
    }
    
    public void ubicarEspectadores() {
        int filAl, colAl;
        String asientOcup;
        for(Espectador e: espectadores) {
            asientOcup = "";
            if(e.getEdad() >= movie.getEdadMin() && e.getDinero() >= precioIn && asientosOcupados != 48) {
                    do{
                        filAl = (int) ((Math.random() * 10) * 0.8);
                        colAl = (int) ((Math.random() * 10) * 0.56);
                    } while(asientos[filAl][colAl].substring(2, 3).equals("X"));
                    for(int i = 0; i < asientos[filAl][colAl].length(); i++) {
                        if(i == 2) {
                            espectadoresInSala.add(e);
                            e.setAsiento(asientOcup);
                            asientOcup = asientOcup + "X";
                            asientosOcupados++;
                        } else {
                            asientOcup = asientOcup + asientos[filAl][colAl].substring(i, i + 1);
                        }
                    }
                    asientos[filAl][colAl] = asientOcup;
            } else if (asientosOcupados == 48) {
                System.out.println("Se llenó la sala no entran más espectadores.");
                System.out.println();
                try{System.in.read();}
                catch(IOException exc) {}
                break;
            }
        }
    }
}
