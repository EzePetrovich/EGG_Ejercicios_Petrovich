
package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Poliza {
    
    // Scanner for user inputs
    
    private static Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    // Attributes
    
    private int id_poliza;
    private static int nuevaPoliza = 0;
    private Vehiculo vehic;
    private Cliente cli;
    private Date fecha_ini, fecha_fin;
    private ArrayList<Cuota> cuotas;
    private String form_pago;
    private double mon_tot_aseg;
    private boolean contraGranizo;
    private double mont_max_granizo;
    private String tipo_cober;

    // Constructors
    
    public Poliza() {cuotas = new ArrayList(); cli = new Cliente(); vehic = new Vehiculo(); nuevaPoliza++; id_poliza = nuevaPoliza;}

    public Poliza(Vehiculo vehic, Cliente cli, Date fecha_ini, Date fecha_fin, ArrayList<Cuota> cuotas, String form_pago, double mon_tot_aseg, boolean contraGranizo, double mont_max_granizo, String tipo_cober) {
        nuevaPoliza++;
        id_poliza = nuevaPoliza;
        this.vehic = vehic;
        this.cli = cli;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
        this.cuotas = cuotas;
        this.form_pago = form_pago;
        this.mon_tot_aseg = mon_tot_aseg;
        this.contraGranizo = contraGranizo;
        this.mont_max_granizo = mont_max_granizo;
        this.tipo_cober = tipo_cober;
    }
    
    // Getters

    public int getIDPoliza() {return id_poliza;}
    public Vehiculo getVehic() {return vehic;}
    public Cliente getCli() {return cli;}
    public Date getFechaIni() {return fecha_ini;}
    public Date getFechaFin() {return fecha_fin;}
    public ArrayList<Cuota> getCuotas() {return cuotas;}
    public String getFormPago() {return form_pago;}
    public double getMonTotAseg() {return mon_tot_aseg;}
    public boolean esContraGranizo() {return contraGranizo;}
    public double getMontMaxGranizo() {return mont_max_granizo;}
    public String getTipoCober() {return tipo_cober;}
    
    // Setters

    public void setIDPoliza(int id_poliza) {this.id_poliza = id_poliza;}
    public void setVehic(Vehiculo vehic) {this.vehic = vehic;}
    public void setCli(Cliente cli) {this.cli = cli;}
    public void setFechaIni(Date fecha_ini) {this.fecha_ini = fecha_ini;}
    public void setFechaFin(Date fecha_fin) {this.fecha_fin = fecha_fin;}
    public void setCuotas(ArrayList<Cuota> cuotas) {this.cuotas = cuotas;}
    public void setFormPago(String form_pago) {this.form_pago = form_pago;}
    public void setMonTotAseg(double mon_tot_aseg) {this.mon_tot_aseg = mon_tot_aseg;}
    public void setContraGranizo(boolean contraGranizo) {this.contraGranizo = contraGranizo;}
    public void setMontMaxGranizo(double mont_max_granizo) {this.mont_max_granizo = mont_max_granizo;}
    public void setTipoCober(String tipo_cober) {this.tipo_cober = tipo_cober;}

    // Format double
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    
    // toString()
    
    @Override
    public String toString() {
        String fechaFormat1 = new SimpleDateFormat("dd/MM/yyyy").format(fecha_ini), cubre;
        String fechaFormat2 = new SimpleDateFormat("dd/MM/yyyy").format(fecha_fin);
        if(contraGranizo) {cubre = "Si";} else {cubre = "No";}
        return "• ID Poliza: " + id_poliza + "\n" + vehic + "\n" + cli + "\n• Fecha de inicio de poliza: " + fechaFormat1 + "\n• Fecha de fin de poliza: " + fechaFormat2 + "\n• Nº de cuotas: " + cuotas.size() + "\n• Forma de pago: " + form_pago + "\n• Monto total asegurado: " + mon_tot_aseg + "\n• Seguro contra granizo: " + cubre + "\n• Monto maximo contra granizo: $" + mont_max_granizo + "\n• Tipo de cobertura: " + tipo_cober;
    }
    
    // Methods of the class
    
    public void gestionCliente() {
        System.out.println("\nCLIENTE.");
        System.out.println();
        System.out.print("» Nombre: "); cli.setName(read.next());
        System.out.print("» Apellido: "); cli.setSurname(read.next());
        System.out.print("» DNI: "); cli.setDNI(read.nextInt());
        System.out.print("» Mail: "); cli.setMail(read.next());
        System.out.print("» Domicilio: "); cli.setDomic(read.next());
        System.out.print("» Teléfono: "); cli.setTel(read.next());
        System.out.println();
    }
    
    public void gestionVehiculo() {
        System.out.println("\nVEHICULO.");
        System.out.println();
        System.out.print("» Marca: "); vehic.setMarca(read.next());
        System.out.print("» Modelo: "); vehic.setMod(read.next());
        System.out.print("» Año: "); vehic.setYear(read.nextInt());
        System.out.print("» Nº Motor: "); vehic.setNMotor(read.nextInt());
        System.out.print("» Nº Chasis: "); vehic.setChasis(read.next());
        System.out.print("» Color: "); vehic.setColor(read.next());
        System.out.print("» Tipo: "); vehic.setTipo(read.next());
        System.out.println();
    }
    
    public void gestionCuotas() {
        int aa, mm, dd;
        Cuota c = new Cuota();
        c.setNCuota(cuotas.size() + 1);
        System.out.println("\nCUOTA Nº " + c.getNCuota());
        System.out.println();
        c.setNCuota(cuotas.size() + 1);
        System.out.print("» Monto total: $"); c.setMontCuota(round(read.nextDouble(), 2));
        System.out.print("» Pagada [S / N]: "); c.setPagada(read.next().equalsIgnoreCase("S"));
        System.out.println("Fecha de vencimiento.");
        System.out.print("» Año [aaaa]: "); aa = read.nextInt() - 1900;
        System.out.print("» Mes [mm]: "); mm = read.nextInt() - 1;
        System.out.print("» Dia [dd]: "); dd = read.nextInt();
        c.setFechaVenc(new Date(aa, mm, dd));
        System.out.print("» Forma de pago: "); c.setFormPag(read.next());
        cuotas.add(c);
        System.out.println();
    }
    
    public void verCuotas() {
        System.out.println("\nCUOTAS.");
        System.out.println();
        cuotas.forEach((c) -> {System.out.println(c);});
    }

    
}
