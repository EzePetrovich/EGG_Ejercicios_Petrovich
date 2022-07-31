
package entity;


public abstract class FormaGeometrica implements calculosFormas {
    
    // Attribute
    
    protected String unidadMedida;
    
    // Constructor
    
    public FormaGeometrica(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    
    // Getter

    public String getUnidadMedida() {return unidadMedida;}
        
    // Setter
    
    public void setUnidadMedida(String unidadMedida) {this.unidadMedida = unidadMedida;}
    
    // Method of the class
    
    public void mostrarCalculos(String forma) {
        System.out.println("\n" + forma);
        System.out.println("\nEl area es: " + round(calcularArea(), 2) + unidadMedida);
        System.out.println("El perimetro es: " + round(calcularPerimetro(), 2) + unidadMedida);
    }
    
    // Format double
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    
}
