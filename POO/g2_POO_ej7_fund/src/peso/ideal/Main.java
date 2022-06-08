package peso.ideal;
import entity.peso.ideal.Persona;
import service.entity.PersonaService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner read = new Scanner(System.in).useDelimiter("\n");
            PersonaService serv = new PersonaService();
            System.out.print("» Ingrese cantidad de personas a crear: ");
            int cant_p = read.nextInt();
            System.out.println();
            Persona [] vect_p = new Persona [cant_p];
            int may_e = 0, men_e = 0, pes_i = 0, pes_s = 0, pes_b = 0, cont = 0;
            for(Persona p: vect_p) {
                    cont++;
                    System.out.println("PERSONA " + cont + ".");
                    p = serv.getMetodCrear();
                    switch(serv.calcularIMC(p)) {
                            case -1:
                                    pes_b++;
                                    break;
                            case 0:
                                    pes_i++;
                                    break;
                            case 1:
                                    pes_s++;
                                    break;
                    }
                    if(serv.esMayorEdad(p)) {
                            may_e++;
                    } else {
                            men_e++;
                    }
            }
            System.out.println("INFORME DE PERSONAS: ");
            System.out.println();
            System.out.println("• Porcentajes según IMC. ");
            System.out.println("·Bajo el ideal: "+((int) (pes_b * 100 / cant_p))+"%");
            System.out.println("·Ideal: "+((int) (pes_i * 100 / cant_p))+"%");
            System.out.println("·Encima del ideal: "+((int) (pes_s * 100 / cant_p))+"%");
            System.out.println();
            System.out.println("• Porcentaje según edad. ");
            System.out.println("·Mayores de 18: "+((int) (may_e * 100 / cant_p))+"%");
            System.out.println("·Menores de 18: "+((int) (men_e * 100 / cant_p))+"%");
    }
}