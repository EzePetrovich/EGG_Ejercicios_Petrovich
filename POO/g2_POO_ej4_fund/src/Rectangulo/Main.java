<<<<<<< HEAD

package Rectangulo;
import Entity.Rectangulo.Rectangulo;
import Service.Entity.ServiceRectangulo;

public class Main {

    public static void main(String[] args) {
        ServiceRectangulo servRectang = new ServiceRectangulo();
        Rectangulo rectangle = servRectang.crearRectangulo();
        System.out.println("La superficie del rectángulo es: "+servRectang.areaRectangulo(rectangle));
        System.out.println("El perímetro del rectángulo es: "+servRectang.perimRectangulo(rectangle));
        System.out.println();
        servRectang.dibujarRectangulo(rectangle);
    }
    
}
=======

package Rectangulo;
import Entity.Rectangulo.Rectangulo;
import Service.Entity.ServiceRectangulo;

public class Main {

    public static void main(String[] args) {
        ServiceRectangulo servRectang = new ServiceRectangulo();
        Rectangulo rectangle = servRectang.crearRectangulo();
        System.out.println("La superficie del rectángulo es: "+servRectang.areaRectangulo(rectangle));
        System.out.println("El perímetro del rectángulo es: "+servRectang.perimRectangulo(rectangle));
        System.out.println();
        servRectang.dibujarRectangulo(rectangle);
    }
    
}
>>>>>>> 9744b90784dd0a6f5c2cb2dc20ab7ea4ca4b0d5e
