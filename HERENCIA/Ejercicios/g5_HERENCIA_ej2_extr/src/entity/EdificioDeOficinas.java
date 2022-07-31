
package entity;

public class EdificioDeOficinas extends Edificio {
    
    // Attributes
    
    private int numOficinas, personasPorOf, numPisos;
    
    // Constructors
    
    public EdificioDeOficinas() {}
    
    public EdificioDeOficinas(double ancho, double largo, double alto) {super(ancho, largo, alto);}
    
    public EdificioDeOficinas(int numOficinas, int personasPorOf, int numPisos, double ancho, double largo, double alto) {
        super(ancho, largo, alto);
        this.numOficinas = numOficinas;
        this.personasPorOf = personasPorOf;
        this.numPisos = numPisos;
    }
    
    // Getters

    public int getNumOficinas() {return numOficinas;}
    public int getPersonasPorOf() {return personasPorOf;}
    public int getNumPisos() {return numPisos;}
    
    // Setters

    public void setNumOficinas(int numOficinas) {this.numOficinas = numOficinas;}
    public void setPersonasPorOf(int personasPorOf) {this.personasPorOf = personasPorOf;}
    public void setNumPisos(int numPisos) {this.numPisos = numPisos;}
    
    // Methods of the class
    
    @Override
    public double calcularSuperficie() {
        return ancho * largo;
    }
    
    @Override
    public double calcularVolumen() {
        return ancho * largo * alto;
    }
    
    /*public void crearEdificioDeOficinas() {
        System.out.print("\n» Numero de oficinas: ");
        numOficinas = super.read.nextInt();
        System.out.println("» Personas por oficina: ");
        personasPorOf = super.read.nextInt();
        System.out.println("» Numero de pisos: ");
        numPisos = super.read.nextInt();
    }*/
    
    @Override
    public void informarCalculos(String tipoEdif) {
        super.informarCalculos(tipoEdif);
        System.out.println("· Capacidad de personas: " + cantPersonas());
    }
    
    public int cantPersonas() {
        return numOficinas * personasPorOf * numPisos;
    }
    
}
