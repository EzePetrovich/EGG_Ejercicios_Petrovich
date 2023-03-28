
package entity;


public abstract class Alojamiento {
    
    // Attributes
    
    protected String nombre, dir, loc, gerente;
    
    // Constructors

    public Alojamiento() {}
    
    public Alojamiento(String nombre, String dir, String loc, String gerente) {
        this.nombre = nombre;
        this.dir = dir;
        this.loc = loc;
        this.gerente = gerente;
    }
    
    // Getters
    
    public String getNombre() {return nombre;}
    public String getDir() {return dir;}
    public String getLoc() {return loc;}
    public String getGerente() {return gerente;}
    
    // Setters

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setDir(String dir) {this.dir = dir;}
    public void setLoc(String loc) {this.loc = loc;}
    public void setGerente(String gerente) {this.gerente = gerente;}
    

}
