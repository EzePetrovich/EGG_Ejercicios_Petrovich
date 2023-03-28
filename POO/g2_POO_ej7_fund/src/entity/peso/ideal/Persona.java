package entity.peso.ideal;

public class Persona {
	private String nombre;
	private int edad;
	private String sexo;
	private double peso;
	private double altura;
	private boolean pesoIdeal;
	
	public Persona() {
	}
	
	public Persona(String nombre, int edad, String sexo, double peso, double altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public boolean getPesoIdeal() {
		return pesoIdeal;
	}
	
	public void setPesoIdeal(boolean pesoIdeal) {
		this.pesoIdeal = pesoIdeal;
	}
	
}