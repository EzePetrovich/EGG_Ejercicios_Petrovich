/*La clase incluirá un método para crear el rectángulo con
los datos del Rectángulo dados por el usuario. También incluirá un método para calcular la
superficie del rectángulo y un método para calcular el perímetro del rectángulo. Por último,
tendremos un método que dibujará el rectángulo mediante asteriscos usando la base y la
altura.*/


package Service.Entity;
import java.util.Scanner;
import Entity.Rectangulo.Rectangulo;

public class ServiceRectangulo {
    Scanner read = new Scanner(System.in);
    public Rectangulo crearRectangulo() {
        Rectangulo rectang = new Rectangulo();
        System.out.print("» Ingrese la base del rectángulo: ");
        rectang.setBase(read.nextInt());
        System.out.print("» Ingrese la altura del rectángulo: ");
        rectang.setAltura(read.nextInt());
        System.out.println();
        return rectang;
    }
    public int areaRectangulo(Rectangulo rectang) {
        int area = rectang.getBase() * rectang.getAltura();
        return area;
    }
    public int perimRectangulo(Rectangulo rectang) {
        int perim = (rectang.getAltura() + rectang.getBase()) * 2;
        return perim;
    }
    public void dibujarRectangulo(Rectangulo rectang) {
        System.out.println("Réctangulo: ");
        System.out.println();
        for(int h = 1; h <= rectang.getAltura(); h++) {
            for(int b = 1; b <= rectang.getBase(); b++) {
                if(h == 1 || h == rectang.getAltura()) {
                    System.out.print(" • ");
                } else if(b == 1 || b == rectang.getBase()) {
                    System.out.print(" • ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}
