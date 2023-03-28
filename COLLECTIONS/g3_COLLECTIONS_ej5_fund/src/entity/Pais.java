
package entity;

import java.util.Comparator;

public class Pais {
    private String name;
    public Pais() {}
    public Pais(String name) {this.name = name;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    @Override
    public String toString() {return "[País: " + name + "]";}
    public static Comparator<Pais> ordenName = new Comparator<Pais>() {
        @Override
        public int compare(Pais p1, Pais p2) {
            return p2.getName().compareTo(p1.getName());
        }
    };
}
