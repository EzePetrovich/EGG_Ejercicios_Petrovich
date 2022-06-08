package service.entity;

import java.util.Scanner;
import entity.frase.Cadena;

public class CadenaService {

    Scanner read = new Scanner(System.in).useDelimiter("\n");

    public Cadena nuevaFrase() {
        System.out.print("» Ingrese una frase: ");
        String frase = read.next();
        return new Cadena(frase);
    }

    public int contarVocals(Cadena cad) {
        String vocs = "AEIOU", letra_f;
        int n_vocs = 0;
        for (int i = 0; i < cad.getLongitud(); i++) {
            letra_f = cad.getFrase().substring(i, i + 1);
            for (int j = 0; j < 5; j++) {
                if (letra_f.equalsIgnoreCase(vocs.substring(j, j + 1))) {
                    n_vocs++;
                    break;
                }
            }
        }
        return n_vocs;
    }

    public String invertirFrase(Cadena cad) {
        String frase_inv = "";
        for (int i = cad.getLongitud(); i > 0; i--) {
            frase_inv += cad.getFrase().substring(i - 1, i);
        }
        return frase_inv;
    }

    public int vecesRepet(Cadena cad, String letra) {
        String letra_f;
        int rep = 0;
        for (int i = 0; i < cad.getLongitud(); i++) {
            letra_f = cad.getFrase().substring(i, i + 1);
            for (int j = 0; j < 5; j++) {
                if (letra_f.equalsIgnoreCase(letra)) {
                    rep++;
                    break;
                }
            }
        }
        return rep;
    }

    public boolean compararLong(Cadena cad, String frase) {
        boolean igual = frase.length() == cad.getLongitud();
        return igual;
    }

    public String unirFrases(Cadena cad, String frase) {
        String frase_union = cad.getFrase().concat(frase);
        return frase_union;
    }

    public String reemplazar(Cadena cad, String letra) {
        String letra_f;
        String sinA = "";
        for (int i = 0; i < cad.getLongitud(); i++) {
            letra_f = cad.getFrase().substring(i, i + 1);
            if (letra_f.equalsIgnoreCase("a")) {
                sinA = sinA.concat(letra);
            } else {
                sinA = sinA.concat(letra_f);
            }
        }
        return sinA;
    }

    public boolean contiene(Cadena cad, String letra) {
        boolean tiene = false;
        String letra_f;
        for (int i = 0; i < cad.getLongitud(); i++) {
            letra_f = cad.getFrase().substring(i, i + 1);
            if (letra_f.equalsIgnoreCase(letra)) {
                tiene = true;
            }
        }
        return tiene;
    }

}
