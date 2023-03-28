
package service.entity;
import entity.nespresso.Cafetera;
import java.io.IOException;
import java.util.Scanner;

public class CafeteraService {
    
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    public Cafetera nuevaCafetera() {
        System.out.println("NESPRESSO");
        System.out.println();
        System.out.print("» Ingrese la capacidad máxima en ml de su cafetera: ");
        int capMax = read.nextInt();
        System.out.println();
        return new Cafetera(capMax, 0);
    }
    
    public void llenarCafetera(Cafetera caf) {
        caf.setCantAct(caf.getCapMax());
    }
    
    public void servirTaza(Cafetera caf) {
        if(caf.getCantAct() != 0) {
            System.out.print("» Ingrese la capacidad en ml de su taza: ");
            int capTaza = read.nextInt();
            System.out.println();
            if(capTaza < caf.getCantAct()) {
                caf.setCantAct(caf.getCantAct() - capTaza);
                capTaza = 0;
            } else {
                capTaza -= caf.getCantAct();
                caf.setCantAct(0);
            }
            if(capTaza == 0) {
                System.out.println("La taza se llenó.");
                System.out.println();
                System.out.println("Presione intro para seguir...");
                read.next();
            } else {
                System.out.println("La taza no se llenó. Puede servirse " + capTaza + "ml más.");
                System.out.println("Presione intro para seguir...");
                try{System.in.read();}
                catch(IOException e){}
            }
            System.out.println();
        } else {
            System.out.println("La cafetera esta vacia, debe llenarla primero.");
            System.out.println();
            System.out.println("Presione intro para seguir...");
            try{System.in.read();}
            catch(IOException e){}
        }
    }
    
    public void vaciarCafetera(Cafetera caf) {
        caf.setCantAct(0);
    }
    
    public void agregarCafe(Cafetera caf) {
        int caf_disp = caf.getCapMax() - caf.getCantAct(); 
        System.out.print("» Ingrese la cantidad de café en ml a agregar ["+caf_disp+"ml disponibles]: ");
        int cant_caf = read.nextInt();
        if(cant_caf <= caf_disp) {
            caf.setCantAct(caf.getCantAct() + cant_caf);
        } else {
            caf.setCantAct(caf.getCapMax());
            cant_caf -= caf_disp;
            System.out.println("La cafetera se llenó. Sobraron "+cant_caf+"ml.");
            System.out.println();
            System.out.println("Presione intro para seguir...");
            try{System.in.read();}
            catch(IOException e){}
        }
        System.out.println();
    }
    
    public void estadoCafetera(Cafetera caf) {
        int caf_disp = caf.getCapMax() - caf.getCantAct();
        System.out.println("CAFETERA NESPRESSO");
        System.out.println();
        System.out.println("• Cantidad de café [ml]: "+caf.getCantAct());
        System.out.println("• Capacidad disponible: "+caf_disp);
        System.out.println();
        System.out.println("Presione intro para seguir...");
        try{System.in.read();}
        catch(IOException e){}
    }
    
}
