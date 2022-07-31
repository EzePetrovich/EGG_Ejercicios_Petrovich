
package entity;

import java.util.Comparator;

public class Camping extends ExtraHotel {
    
    // Attributes
    
    private int capMaxCarp, cantBaños;
    private Boolean tieneRest;
    
    // Constructors
    
    public Camping() {}
    
    public Camping(int capMaxCarp, int cantBaños, boolean tieneRest, boolean esPrivado, int terreno, String nombre, String dir, String loc, String gerente) {
        super(esPrivado, terreno, nombre, dir, loc, gerente);
        this.capMaxCarp = capMaxCarp;
        this.cantBaños = cantBaños;
        this.tieneRest = tieneRest;
    }
    
    // Getters
    
    public int getCapMaxCarp() {return capMaxCarp;}
    public int getCantBaños() {return cantBaños;}
    public Boolean isTieneRest() {return tieneRest;}
    
    // Setters

    public void setCapMaxCarp(int capMaxCarp) {this.capMaxCarp = capMaxCarp;}
    public void setCantBaños(int cantBaños) {this.cantBaños = cantBaños;}
    public void setTieneRest(Boolean tieneRest) {this.tieneRest = tieneRest;}
    
    @Override
    public String toString() {
        String rest, priv;
        if(tieneRest) {rest = "Si";} else {rest = "No";}
        if(esPrivado) {priv = "Si";} else {priv = "No";}
        return "\nCamping: " + nombre + "\nLocalidad: " + loc + "\nDireccion: " + dir + "\nGerente: " + gerente + "\nTerreno: " + terreno + "m²" + "\nTiene restaurante: " + rest + "\nEs privado: " + priv + "\nCantidad de baños: " + cantBaños + "\nCapacidad máxima de carpas: " + capMaxCarp;
    }
    
    public static Comparator<Camping> compararPrecios = new Comparator<Camping>() {
      @Override
      public int compare(Camping c1, Camping c2) {
          return c2.isTieneRest().compareTo(c1.isTieneRest());
      }
    };
}
