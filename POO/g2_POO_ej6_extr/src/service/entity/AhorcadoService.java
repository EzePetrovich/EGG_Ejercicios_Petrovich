
package service.entity;

import static game.Main.clearScreen;
import java.util.Scanner;
import entity.game.Ahorcado;
import java.util.Arrays;

public class AhorcadoService {
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    public Ahorcado crearJuego() {
        System.out.println("AHORCADO");
        System.out.println();
        System.out.print("» Ingrese una palabra: ");
        String palabra = read.next().toUpperCase();
        String [] palabra_vect = new String [palabra.length()];
        String [] palabra_adv = new String [palabra.length()];
        for(int i = 0; i < palabra.length(); i++) {
            palabra_vect[i] = palabra.substring(i, i + 1);
            if(i == 0 || i == palabra.length() - 1) {
                palabra_adv[i] = palabra_vect[i];
            } else {
                palabra_adv[i] = "_";
            }
        }
        System.out.print("» Ingrese cantidad de intentos permitidos: ");
        int intentos = read.nextInt();
        return new Ahorcado(palabra_vect, palabra_adv, intentos);
    }
    
    public int longitud(Ahorcado game) {
        return game.getPalabra().length;
    }
    
    public boolean buscarLetra(Ahorcado game, String letra) {
        if((Arrays.toString(game.getPalabra())).substring(4, (longitud(game) * 3) - 4).contains(letra)) {
            System.out.println("La letra es parte de la palabra.");
        } else {
            System.out.println("La letra no es parte de la palabra.");
        }
        return (Arrays.toString(game.getPalabra())).substring(4, (longitud(game) * 3) - 4).contains(letra);
    }
    
    public boolean encontradas(Ahorcado game, String letra) {
        String [] palabra = game.getPalabra();
        String [] pal_adv = game.getPalabraAdv();
        if(buscarLetra(game, letra)) {
            for(int i = 1; i < longitud(game) - 1; i++) {
                    if(letra.equalsIgnoreCase(palabra[i])) {
                        pal_adv[i] = palabra[i];
                        game.setLetrsAcert(game.getLetrsAcert() + 1);
                    }
                }
            game.setPalabraAdv(pal_adv);
        }
        System.out.println("Se han encontrado: " + game.getLetrsAcert());
        System.out.println("Le queda por encontrar: " + ((longitud(game) - 2) - game.getLetrsAcert()));
        System.out.println();
        return Arrays.toString(game.getPalabra()).contains(letra);
    }
    
    public void intentos(Ahorcado game) {
        System.out.println("Le quedan " + game.getIntentos() + " intentos.");
    }
    
    public void juego(Ahorcado game) {
        int cont = -1, incorr = 0;
        String ahorcado = "█▀▀▀▀▀▀▀█      █  AHORCADO  │ █              █              █              █______________";
        String personita = "○║╔╗//", letra;
        
        String [][] ahorcado_format = new String [6][15];
        
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 15; j++) {
                cont++;
                ahorcado_format[i][j] = ahorcado.substring(cont, cont + 1);
            }
        }
        do {
            for(int i = 0; i < 6; i++) {
                for(int j = 0; j < 15; j++) {
                    System.out.print(ahorcado_format[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            for(int i = 0; i < longitud(game); i++) {
                System.out.print((game.getPalabraAdv())[i] + " ");
            }
            System.out.println();
            System.out.println();
            System.out.print("» Ingrese una letra: ");
            letra = read.next().toUpperCase();
            game.setIntentos(game.getIntentos() - 1);
            
            if(!encontradas(game, letra)) {
                incorr++;
            }
            
            intentos(game);
            System.out.println("Presione intro para seguir...");
            read.next();
            
            if(incorr > 0) {
                switch(incorr) {
                    case 1:
                        ahorcado_format[2][13] = "○";
                        break;
                    case 2:
                        ahorcado_format[3][13] = "║";
                        break;
                    case 3:
                        ahorcado_format[3][13] = " ";
                        ahorcado_format[3][12] = "║";
                        ahorcado_format[3][11] = "╔";
                        break;
                    case 4:
                        ahorcado_format[3][13] = "╗";
                        break;
                    case 5:
                        ahorcado_format[4][12] = "/";
                        break;
                    case 6:
                        ahorcado_format[4][13] = "/";
                        break;
                }
            }
            clearScreen();
        } while(game.getIntentos() != 0 && game.getLetrsAcert() != longitud(game) - 2);
        
        for(int i = 0; i < 6; i++) {
                for(int j = 0; j < 15; j++) {
                System.out.print(ahorcado_format[i][j]);
            }
            System.out.println();
            }
        System.out.println();
        if(game.getLetrsAcert() == longitud(game) - 2) {
            System.out.println("¡Felicidades ganaste el juego!");
        } else {
            System.out.println("Ya no le quedan más intentos.");
        }
    }
}
