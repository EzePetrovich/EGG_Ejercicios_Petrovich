
package entity;

public class City {
    private String codP;
    private String name;
    
    public City() {}
    public City(String codP, String name) {this.codP = codP; this.name = name;}
    public String getCodP() {return codP;}
    public void setCodP(String codP) {this.codP = codP;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    @Override
    public String toString() {return "{Ciudad: " + name + "; Código postal: " + codP + "}";}
}
