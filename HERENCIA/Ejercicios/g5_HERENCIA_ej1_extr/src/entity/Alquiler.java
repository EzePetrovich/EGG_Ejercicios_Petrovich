
package entity;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class Alquiler {
    
    // Scanner for inputs
    
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    // Attributes
    
    private String nameCli;
    private String dniCli;
    private Date fechaAlq = new Date();
    private Date fechaDev = new Date();
    private int posAmarre;
    private Barco barco;
    
    // Constructors
    
    public Alquiler() {}

    public Alquiler(String nameCli, String dniCli, Date fechaAlq, Date fechaDev, int posAmarre, Barco barco) {
        this.nameCli = nameCli;
        this.dniCli = dniCli;
        this.fechaAlq = fechaAlq;
        this.fechaDev = fechaDev;
        this.posAmarre = posAmarre;
        this.barco = barco;
    }
    
    // Getters

    public String getNameCli() {return nameCli;}
    public String getDniCli() {return dniCli;}
    public Date getFechaAlq() {return fechaAlq;}
    public Date getFechaDev() {return fechaDev;}
    public int getPosAmarre() {return posAmarre;}
    public Barco getBarco() {return barco;}
    
    // Setters

    public void setNameCli(String nameCli) {this.nameCli = nameCli;}
    public void setDniCli(String dniCli) {this.dniCli = dniCli;}
    public void setFechaAlq(Date fechaAlq) {this.fechaAlq = fechaAlq;}
    public void setFechaDev(Date fechaDev) {this.fechaDev = fechaDev;}
    public void setPosAmarre(int posAmarre) {this.posAmarre = posAmarre;}
    public void setBarco(Barco barco) {this.barco = barco;}
        
    // Methods of the class
    
    public void calcularAlquiler() {
        String tipo;
        System.out.println("ALQUILER DE AMARRE.");
        System.out.print("\n» Nombre completo de cliente: ");
        nameCli = read.next();
        System.out.print("» DNI de cliente: ");
        dniCli = read.next();
        System.out.println("• Fecha de inicio: ");
        System.out.print("· Año [aaaa]: ");
        fechaAlq.setYear(read.nextInt() - 1900);
        System.out.print("· Mes [mm]: ");
        fechaAlq.setMonth(read.nextInt() - 1);
        System.out.print("· Día [dd]: ");
        fechaAlq.setDate(read.nextInt());
        System.out.println("\n• Fecha de devolucion: ");
        System.out.print("· Año [aaaa]: ");
        fechaDev.setYear(read.nextInt() - 1900);
        System.out.print("· Mes [mm]: ");
        fechaDev.setMonth(read.nextInt() - 1);
        System.out.print("· Día [dd]: ");
        fechaDev.setDate(read.nextInt());
        System.out.print("\n» Posicion de amarre: ");
        posAmarre = read.nextInt();
        System.out.println("» Tipo de barco:");
        System.out.println("\nVelero → V");
        System.out.println("Motorizado → M");
        System.out.println("Yate → Y");
        System.out.print("\n» Ingrese un tipo [V|M|Y]: ");
        tipo = read.next().toUpperCase();
        switch(tipo) {
            case "Y":
                    Yate y = new Yate();
                    y.crearYate();
                    barco = y;
                    break;
            case "M":
                    BarcoMotorizado bM = new BarcoMotorizado();
                    bM.crearMotorizado();
                    barco = bM;
                    break;
            case "V":
                    Velero v = new Velero();
                    v.crearVelero();
                    barco = v;
                    break;
            default:
                System.out.println("ERROR: opcion no valida.");
        }
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
        
        String fechaIniFormat = new SimpleDateFormat("dd MM yyyy").format(fechaAlq);
        LocalDate fechaIni =  LocalDate.parse(fechaIniFormat, dtf);
        
        String fechaFinFormat = new SimpleDateFormat("dd MM yyyy").format(fechaDev);
        LocalDate fechaFin =  LocalDate.parse(fechaFinFormat, dtf);
        
        int dias = (int) ChronoUnit.DAYS.between(fechaIni, fechaFin);
        int precioFinal = dias * barco.moduloBarco();
        System.out.println("\nPrecio final de alquiler: $" + precioFinal);
    }
}

//String fechaFormat = new SimpleDateFormat("dd/MM/yyyy").format(fecha_venc)
