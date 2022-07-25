
package entity;

public class Vehiculo {
    
    // Attributes
    
    private String marca, mod;
    private int year, n_motor;
    private String chasis, color, tipo;
    
    // Constructors
    
    public Vehiculo() {}

    public Vehiculo(String marca, String mod, int year, int n_motor, String chasis, String color, String tipo) {
        this.marca = marca;
        this.mod = mod;
        this.year = year;
        this.n_motor = n_motor;
        this.chasis = chasis;
        this.color = color;
        this.tipo = tipo;
    }
    
    // Getters

    public String getMarca() {return marca;}
    public String getMod() {return mod;}
    public int getYear() {return year;}
    public int getN_motor() {return n_motor;}
    public String getChasis() {return chasis;}
    public String getColor() {return color;}
    public String getTipo() {return tipo;}
    
    // Setters

    public void setMarca(String marca) {this.marca = marca;}
    public void setMod(String mod) {this.mod = mod;}
    public void setYear(int year) {this.year = year;}
    public void setNMotor(int n_motor) {this.n_motor = n_motor;}
    public void setChasis(String chasis) {this.chasis = chasis;}
    public void setColor(String color) {this.color = color;}
    public void setTipo(String tipo) {this.tipo = tipo;}
    
    // toString()
    
    @Override
    public String toString() {return "• VEHICULO.\n· Marca: " + marca + "\n· Modelo: " + mod + "\n· Año: " + year + "\n· Nº Motor: " + n_motor + "\n· Nº Chasis: " + chasis + "\n· Color: " + color + "\n· Tipo: " + tipo;}
}
