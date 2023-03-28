<<<<<<< HEAD

package entity;

public final class Televisor extends Electrodomestico {
    
    // Attributes
    
    private boolean tdt;
    private int resol; // inchs
    
    // Constructors
    
    public Televisor() {}

    public Televisor(boolean tdt, int resol, String color, char consumEnerg, int peso) {
        super(color, consumEnerg, peso);
        this.tdt = tdt;
        this.resol = resol;
    }
    
    // Getters

    public boolean hasTdt() {return tdt;}
    public double getResol() {return resol;}
    
    // Setters

    public void setTdt(boolean tdt) {this.tdt = tdt;}
    public void setResol(int resol) {this.resol = resol;}
    
    // Methods of the class
    
    public void crearTelevisor() {
        super.crearElectrodomestico("TELEVISOR");
        System.out.print("» Tiene sintonizador TDT [s/n]: ");
        setTdt(super.read.next().equalsIgnoreCase("s"));
        System.out.print("» Resolucion [inchs]: ");
        setResol(super.read.nextInt());
    }
    
    @Override
    public void precioFinal() {
        if(resol > 40) {precio = precio + round(precio * 1.3, 2);}
        if(hasTdt()) {precio = precio + round(500, 2);}
        System.out.println("\nPrecio final del televisor: $" + precio);
    }
    
}
=======

package entity;

public final class Televisor extends Electrodomestico {
    
    // Attributes
    
    private boolean tdt;
    private int resol; // inchs
    
    // Constructors
    
    public Televisor() {}

    public Televisor(boolean tdt, int resol, String color, char consumEnerg, int peso) {
        super(color, consumEnerg, peso);
        this.tdt = tdt;
        this.resol = resol;
    }
    
    // Getters

    public boolean hasTdt() {return tdt;}
    public double getResol() {return resol;}
    
    // Setters

    public void setTdt(boolean tdt) {this.tdt = tdt;}
    public void setResol(int resol) {this.resol = resol;}
    
    // Methods of the class
    
    public void crearTelevisor() {
        super.crearElectrodomestico("TELEVISOR");
        System.out.print("» Tiene sintonizador TDT [s/n]: ");
        setTdt(super.read.next().equalsIgnoreCase("s"));
        System.out.print("» Resolucion [inchs]: ");
        setResol(super.read.nextInt());
    }
    
    @Override
    public void precioFinal() {
        if(resol > 40) {precio = precio + round(precio * 1.3, 2);}
        if(hasTdt()) {precio = precio + round(500, 2);}
        System.out.println("\nPrecio final del televisor: $" + precio);
    }
    
}
>>>>>>> 9744b90784dd0a6f5c2cb2dc20ab7ea4ca4b0d5e
