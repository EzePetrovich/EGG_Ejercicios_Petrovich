
package service.entity;

import java.util.Scanner;
import entity.persona.NIF;

public class NIFService {
    Scanner read = new Scanner(System.in);
    public NIF crearNIF() {
        String letra, letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        String [] nif_vect = new String [23];
        
        for(int i = 0; i < 23; i++){
            nif_vect[i] = letras.substring(i, i + 1);
        }
        
        System.out.print("» Ingrese el DNI de la persona: ");
        long dni = read.nextLong();
        System.out.println();
        if((int) dni % 23 < 0) {
            letra = "T";
        } else if((int) dni % 23 > 22) {
            letra = "E";
        } else {
            letra = nif_vect[(int) dni % 23];
        }
        return new NIF(dni, letra);
    }
    
    public void mostrarNIF(NIF nif) {
        System.out.println("NIF: " + nif.getDNI() + "-" + nif.getLetra());
    }
}
