
package fauna;

import entity.Animal;
import entity.Gato;
import entity.Perro;
import entity.Caballo;

public class Main {

    public static void main(String[] args) {
        Animal perro = new Perro("Stitch", "carne", "Boxer", 4);
        perro.HacerRuido();
        perro.Alimentarse();
        Animal gato = new Gato("Garfield", "sardinas", "Siamés", 6);
        gato.HacerRuido();
        gato.Alimentarse();
        Animal caballo = new Caballo("Tornado", "pastura", "Pura sangre", 8);
        caballo.HacerRuido();
        caballo.Alimentarse();
    }

}
