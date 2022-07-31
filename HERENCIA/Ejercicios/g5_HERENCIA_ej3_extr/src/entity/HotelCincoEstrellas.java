
package entity;

import java.util.Comparator;

public class HotelCincoEstrellas extends HotelCuatroEstrellas {
    
    // Attributes
    
    private int cantSalConf, cantSuites, cantLimosinas;
    
    // Constructors

    public HotelCincoEstrellas() {}
    
    public HotelCincoEstrellas(int cantSalConf, int cantSuites, int cantLimosinas, String gym, String nomRest, int capRest, int nHabit, int nCamas, int nPisos, String nombre, String dir, String loc, String gerente) {
        super(gym, nomRest, capRest, nHabit, nCamas, nPisos, nombre, dir, loc, gerente);
        this.cantSalConf = cantSalConf;
        this.cantSuites = cantSuites;
        this.cantLimosinas = cantLimosinas;
    }
    
    // Getters
    
    public int getCantSalConf() {return cantSalConf;}
    public int getCantSuites() {return cantSuites;}
    public int getCantLimosinas() {return cantLimosinas;}
    
    // Setters

    public void setCantSalConf(int cantSalConf) {this.cantSalConf = cantSalConf;}
    public void setCantSuites(int cantSuites) {this.cantSuites = cantSuites;}
    public void setCantLimosinas(int cantLimosinas) {this.cantLimosinas = cantLimosinas;}
    
    // Methods of the class
    
    @Override
    public Double precioHabitacion() {
        precHabit = super.precioHabitacion();
        precHabit += cantLimosinas * 15 + cantSuites;
        return precHabit;
    }
    
    @Override
    public String toString() {return "\nHotel: " + nombre + "\nLocalidad: " + loc + "\nDireccion: " + dir + "\nGerente: " + gerente + "\nPisos: " + nPisos + "\nCantidad de salas de conferencia: " + cantSalConf + "\nNumero de habitaciones: " + nHabit + "\nNumero de camas: " + nCamas + "\nCantidad de suites: " + cantSuites + "\nCantidad de limosinas: " + cantLimosinas + "\nRestaurante: " + nomRest + "\nCapacidad restaurante: " + capRest + "\nGimnasio tipo: " + gym + "\nPRECIO POR HABITACION: $" + precioHabitacion();}

    public static Comparator<HotelCincoEstrellas> compararPrecios = new Comparator<HotelCincoEstrellas>() {
      @Override
      public int compare(HotelCincoEstrellas h1, HotelCincoEstrellas h2) {
          return h2.precioHabitacion().compareTo(h1.precioHabitacion());
      }
    };
}
