
package entity;

import java.util.Comparator;

public abstract class Hotel extends Alojamiento {
        
    // Attributes
    
    protected int nHabit, nCamas, nPisos;
    protected Double precHabit;
    
    // Constructors
    
    public Hotel() {}
    
    public Hotel(int nHabit, int nCamas, int nPisos, String nombre, String dir, String loc, String gerente) {
        super(nombre, dir, loc, gerente);
        this.nHabit = nHabit;
        this.nCamas = nCamas;
        this.nPisos = nPisos;
    }
    
    // Getters
    
    public int getnHabit() {return nHabit;}
    public int getnCamas() {return nCamas;}
    public int getnPisos() {return nPisos;}
    public Double getPrecHabit() {return precHabit;}
    
    //Setters

    public void setnHabit(int nHabit) {this.nHabit = nHabit;}
    public void setnCamas(int nCamas) {this.nCamas = nCamas;}
    public void setnPisos(int nPisos) {this.nPisos = nPisos;}
    public void setPrecHabit(Double precHabit) {this.precHabit = precHabit;}
    
    // Methods of the class

    public Double precioHabitacion() {
        precHabit = (double) (50 + (nHabit * nCamas));
        return precHabit;
    }
    
    public static Comparator<Hotel> compararPrecios = new Comparator<Hotel>() {
      @Override
      public int compare(Hotel h1, Hotel h2) {
          return h1.precioHabitacion().compareTo(h2.precioHabitacion());
      }
    };
}
