
package entity;

import static entity.Poliza.round;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Seguros {
    
    // Scanner for user inputs
    
    private final Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    // Attribute
    
    private ArrayList<Poliza> polizas;
    
    // Constructor
    
    public Seguros() {polizas = new ArrayList();}
    
    // Getter
    
    public ArrayList<Poliza> getPolizas() {return polizas;}
    
    // Setter
    
    public void setPolizas(ArrayList<Poliza> polizas) {this.polizas = polizas;}
    
    // Methods of the class
    
    /**
     * gestionPoliza()
     * 
     * Registra la poliza con los datos ingresados por el usuario.
     */
    
    public void gestionPoliza() {
        Poliza p = new Poliza();
        int aa, mm, dd, nCuotas;
        System.out.println("\n1) NUEVA POLIZA.");
        p.gestionVehiculo();
        p.gestionCliente();
        System.out.println("Fecha de inicio de poliza.");
        System.out.print("» Año [aaaa]: "); aa = read.nextInt() - 1900;
        System.out.print("» Mes [mm]: "); mm = read.nextInt() - 1;
        System.out.print("» Día [dd]: "); dd = read.nextInt();
        p.setFechaIni(new Date(aa, mm, dd)); 
        System.out.println("Fecha de fin de poliza.");
        System.out.print("» Año [aaaa]: "); aa = read.nextInt() - 1900;
        System.out.print("» Mes [mm]: "); mm = read.nextInt() - 1;
        System.out.print("» Día [dd]: "); dd = read.nextInt();
        p.setFechaFin(new Date(aa, mm, dd)); 
        System.out.print("» Nº de cuotas: "); 
        nCuotas = read.nextInt();
        System.out.println();
        for(int i = 0; i < nCuotas; i++) {p.gestionCuotas();}
        System.out.print("» Forma de pago: "); 
        p.setFormPago(read.next());
        System.out.print("» Monto total asegurado: $");
        p.setMonTotAseg(round(read.nextDouble(), 2));
        System.out.print("» Asegurado contra granizo [S / N]: ");
        p.setContraGranizo(read.next().equalsIgnoreCase("S"));
        if(p.esContraGranizo()) {System.out.print("» Monto maximo contra granizo: $");
        p.setMontMaxGranizo(round(read.nextDouble(), 2));} else {p.setMontMaxGranizo(0);}
        System.out.print("» Tipo de cobertura: ");
        p.setTipoCober(read.next());
        polizas.add(p);
        System.out.println();
    }
    
    /**
     * buscarPoliza()
     * 
     * Pide al usuario un id de poliza para buscarla dentro de las polizas registradas y 
     * luego mostrarla.
     */
    
    public void buscarPoliza() {
        boolean find = false;
        System.out.println("\n2) BUSCAR POLIZA.");
        System.out.println();
        System.out.print("» Ingrese un número de poliza: "); int n_poliza = read.nextInt();
        Iterator<Poliza> it = polizas.iterator();
        Poliza p;
        while(it.hasNext()) {
            p = it.next();
            if(p.getIDPoliza() == n_poliza) {
                System.out.println(p);
                find = true;
                break;
            }
        }
        if(!find) {System.out.println("No se encontro la poliza ingresada.");}
        System.out.println();
        System.out.print("Presione intro para seguir...");
        try{System.in.read();}
        catch(IOException e) {}
        System.out.println();
    }
    
    /**
     * mostrarCuotas()
     * 
     * Pide al usuario un id de poliza para mostrar las cuotas asociadas a la misma.
     */
    
    public void mostrarCuotas() {
        boolean find = false;
        System.out.println("\n4) MOSTRAR CUOTAS DE POLIZA.");
        System.out.println();
        System.out.print("» Ingrese un número de poliza: "); int n_poliza = read.nextInt();
        Iterator<Poliza> it = polizas.iterator();
        Poliza p;
        while(it.hasNext()) {
            p = it.next();
            if(p.getIDPoliza() == n_poliza) {
                p.verCuotas();
                find = true;
                break;
            }
        }
        if(!find) {System.out.println("No se encontro la poliza ingresada.");}
        System.out.println();
        System.out.print("Presione intro para seguir...");
        try{System.in.read();}
        catch(IOException e) {}
        System.out.println();
    }
    
    /**
     * mostrarPolizas()
     * 
     * Muestra las polizas registradas por el usuario.
     */
    
    public void mostrarPolizas() {
        System.out.println("\n3) MOSTRAR POLIZAS.");
        System.out.println();
        polizas.forEach((p) -> {System.out.println(p); System.out.print("Presione intro para seguir..."); try{System.in.read();} catch(IOException e){} System.out.println();});
    }
}
