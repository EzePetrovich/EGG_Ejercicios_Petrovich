
package entity;

import java.util.Comparator;

public class Residencia extends ExtraHotel {
    
    // Attributes
    
    private int cantHabit;
    private Boolean doDescGrem, hasCampDeport;
    
    // Constructors
    
    public Residencia() {}
    
    public Residencia(int cantHabit, boolean doDescGrem, boolean hasCampDeport, boolean esPrivado, int terreno, String nombre, String dir, String loc, String gerente) {
        super(esPrivado, terreno, nombre, dir, loc, gerente);
        this.cantHabit = cantHabit;
        this.doDescGrem = doDescGrem;
        this.hasCampDeport = hasCampDeport;
    }
    
    // Getters
    
    public int getCantHabit() {return cantHabit;}
    public Boolean isDoDescGrem() {return doDescGrem;}
    public Boolean isHasCampDep() {return hasCampDeport;}
    
    // Setters

    public void setCantHabit(int cantHabit) {this.cantHabit = cantHabit;}
    public void setDoDescGrem(Boolean doDescGrem) {this.doDescGrem = doDescGrem;}
    public void setHasCampDep(Boolean hasCampDeport) {this.hasCampDeport = hasCampDeport;}
    
    @Override
    public String toString() {
        String priv, dep, desc;
        if(esPrivado) {priv = "Si";} else {priv = "No";}
        if(hasCampDeport) {dep = "Si";} else {dep = "No";}
        if(doDescGrem) {desc = "Si";} else {desc = "No";}
        return "\nResidencia: " + nombre + "\nLocalidad: " + loc + "\nDireccion: " + dir + "\nGerente: " + gerente + "\nTerreno: " + terreno + "m²" + "\nCantidad de habitaciones: " + cantHabit + "\nEs privado: " + priv + "\nTiene campo deportivo: " + dep + "\nDescuento a gremios: " + desc;
    }
    
    public static Comparator<Residencia> compararPrecios = new Comparator<Residencia>() {
      @Override
      public int compare(Residencia r1, Residencia r2) {
          return r2.isDoDescGrem().compareTo(r1.isDoDescGrem());
      }
    };
}
