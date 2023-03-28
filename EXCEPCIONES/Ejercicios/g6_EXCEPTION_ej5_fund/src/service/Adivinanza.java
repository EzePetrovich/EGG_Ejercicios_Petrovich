<<<<<<< HEAD
/**
 * @author J Ezequiel Petrovich
 */

package service;

import java.util.InputMismatchException;
import utilities.Tools;

public class Adivinanza implements Tools {
    
    public Integer randomNumber() {
        return (int) (Math.random() * 500 + 1);
    }
    
    public void play() {
        Integer intents = 0;
        Integer nAdiv = randomNumber();
        Integer inpUser = null;
        boolean win = false;
        while(!win) {
            try {
                System.out.print("» Ingrese un numero [1..500]: ");
                inpUser = read.nextInt();
                if(inpUser > nAdiv) {
                    System.out.println("\nEl numero ingresado es mayor al secreto. Intentelo nuevamente.");
                    Tools.pressIntro();
                }
                else if(inpUser < nAdiv) {
                    System.out.println("\nEl numero ingresado es menor al secreto. Intentelo nuevamente.");
                    Tools.pressIntro();
                }
                System.out.println();
                win = nAdiv.equals(inpUser);
                intents++;
            }
            catch(InputMismatchException inp) {
                System.err.println("\nERROR: debe ingresar un numero no un caracter.");
                read.next();
                intents++;
                Tools.pressIntro();
                System.out.println();
            }
        }
        read.close();
        System.out.println("¡Felicidades acertaste!");
        System.out.println("\nNumero de intentos utilizados: " + intents);
    }
    
}
=======
/**
 * @author J Ezequiel Petrovich
 */

package service;

import java.util.InputMismatchException;
import utilities.Tools;

public class Adivinanza implements Tools {
    
    public Integer randomNumber() {
        return (int) (Math.random() * 500 + 1);
    }
    
    public void play() {
        Integer intents = 0;
        Integer nAdiv = randomNumber();
        Integer inpUser = null;
        boolean win = false;
        while(!win) {
            try {
                System.out.print("» Ingrese un numero [1..500]: ");
                inpUser = read.nextInt();
                if(inpUser > nAdiv) {
                    System.out.println("\nEl numero ingresado es mayor al secreto. Intentelo nuevamente.");
                    Tools.pressIntro();
                }
                else if(inpUser < nAdiv) {
                    System.out.println("\nEl numero ingresado es menor al secreto. Intentelo nuevamente.");
                    Tools.pressIntro();
                }
                System.out.println();
                win = nAdiv.equals(inpUser);
                intents++;
            }
            catch(InputMismatchException inp) {
                System.err.println("\nERROR: debe ingresar un numero no un caracter.");
                read.next();
                intents++;
                Tools.pressIntro();
                System.out.println();
            }
        }
        read.close();
        System.out.println("¡Felicidades acertaste!");
        System.out.println("\nNumero de intentos utilizados: " + intents);
    }
    
}
>>>>>>> 9744b90784dd0a6f5c2cb2dc20ab7ea4ca4b0d5e
