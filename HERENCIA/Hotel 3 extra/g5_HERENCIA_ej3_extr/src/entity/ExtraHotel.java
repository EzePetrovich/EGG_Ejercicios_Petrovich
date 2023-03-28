
package entity;

import java.util.Comparator;

public abstract class ExtraHotel extends Alojamiento {
    
    // Attributes
    
    protected Boolean esPrivado;
    protected int terreno; // en m²
        
    // Constructors
    
    public ExtraHotel() {}
    
    public ExtraHotel(boolean esPrivado, int terreno, String nombre, String dir, String loc, String gerente) {
        super(nombre, dir, loc, gerente);
        this.esPrivado = esPrivado;
        this.terreno = terreno;
    }
    
    // Getters
    
    public Boolean isPrivado() {return esPrivado;}
    public int getTerreno() {return terreno;}
    
    //Setters

    public void setEsPrivado(Boolean esPrivado) {this.esPrivado = esPrivado;}
    public void setTerreno(int terreno) {this.terreno = terreno;}
    
    public static Comparator<ExtraHotel> compararSituacion = new Comparator<ExtraHotel>() {
      @Override
      public int compare(ExtraHotel e1, ExtraHotel e2) {
          return e2.isPrivado().compareTo(e1.isPrivado());
      }
    };
}
