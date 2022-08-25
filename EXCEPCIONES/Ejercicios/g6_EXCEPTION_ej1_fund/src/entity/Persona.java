// @author J Ezequiel Petrovich

package entity;

public class Persona {
    
        // Attributes
    
	private String nombre;
	private Integer edad;
	private String sexo;
	private double peso;
	private double altura;
	private boolean pesoIdeal;
	
        //Constructors
        
	public Persona() {}
	public Persona(String nombre, Integer edad, String sexo, double peso, double altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
        // Getters
        
	public String getNombre() {return nombre;}
        public Integer getEdad() {return edad;}
	public String getSexo() {return sexo;}
	public double getPeso() {return peso;}
	public double getAltura() {return altura;}
	public boolean getPesoIdeal() {return pesoIdeal;}
	
        //Setters
        
        public void setNombre(String nombre) {this.nombre = nombre;}
        public void setEdad(Integer edad) {this.edad = edad;}
        public void setSexo(String sexo) {this.sexo = sexo;}
        public void setPeso(double peso) {this.peso = peso;}
        public void setAltura(double altura) {this.altura = altura;}
        public void setPesoIdeal(boolean pesoIdeal) {this.pesoIdeal = pesoIdeal;}
}