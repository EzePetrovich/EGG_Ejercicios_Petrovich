
package entity;

import java.util.Comparator;

public class HotelCuatroEstrellas extends Hotel {
    
    // Attributes
    
    protected String gym, nomRest;
    protected int capRest;
    protected Double precioRandom;
    
    // Constructors

    public HotelCuatroEstrellas() {}
    
    public HotelCuatroEstrellas(String gym, String nomRest, int capRest, int nHabit, int nCamas, int nPisos, String nombre, String dir, String loc, String gerente) {
        super(nHabit, nCamas, nPisos, nombre, dir, loc, gerente);
        this.gym = gym;
        this.nomRest = nomRest;
        this.capRest = capRest;
    }
    
    // Getters
    
    public String getGym() {return gym;}
    public String getNomRest() {return nomRest;}
    public int getCapRest() {return capRest;}
    public Double getPrecioRandom() {return precioRandom;}
    
    // Setters

    public void setGym(String gym) {this.gym = gym;}
    public void setNomRest(String nomRest) {this.nomRest = nomRest;}
    public void setCapRest(int capRest) {this.capRest = capRest;}
    
    // Methods of the class
    
    @Override
    public Double precioHabitacion() {
        precHabit = super.precioHabitacion();
        if(capRest > 50) {precHabit += 50;} 
        else if(capRest >= 30) {precHabit += 30;} 
        else if(capRest < 30) {precHabit += 10;}
        if(gym.equalsIgnoreCase("A")) {precHabit += 50;}
        else if(gym.equalsIgnoreCase("B")) {precHabit += 30;}
        return precHabit;
    }
    
    @Override
    public String toString() {return "\nHotel: " + nombre + "\nLocalidad: " + loc + "\nDireccion: " + dir + "\nGerente: " + gerente + "\nPisos: " + nPisos + "\nNumero de habitaciones: " + nHabit + "\nNumero de camas: " + nCamas + "\nRestaurante: " + nomRest + "\nCapacidad restaurante: " + capRest + "\nGimnasio tipo: " + gym + "\nPRECIO POR HABITACION: $" + precioHabitacion();}
    
    public static Comparator<HotelCuatroEstrellas> compararPrecios = new Comparator<HotelCuatroEstrellas>() {
      @Override
      public int compare(HotelCuatroEstrellas h1, HotelCuatroEstrellas h2) {
          return h1.precioHabitacion().compareTo(h2.precioHabitacion());
      }
    };
}
