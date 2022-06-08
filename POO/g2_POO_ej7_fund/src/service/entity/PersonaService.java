
package service.entity;
import entity.peso.ideal.Persona;
import java.util.Scanner;

public class PersonaService {
	Scanner read = new Scanner(System.in).useDelimiter("\n");
        
        //Encapsule el método crearPersona()
        
	private Persona crearPersona() {
                Persona p = new Persona();
		boolean val = false;
		System.out.print("» Ingrese nombre: ");
		String nombre = read.next();
                p.setNombre(nombre);
		System.out.print("» Ingrese edad: ");
		int edad = read.nextInt();
                p.setEdad(edad);
		while(val == false) {
			System.out.print("» Ingrese sexo [M → Masculino | F → Femenino]: ");
			String sexo = read.next();
			if(!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F")) {
                                System.out.println();
				System.out.println("Error: el sexo ingresado no es válido.");
				System.out.println("Presione intro para seguir...");
				read.next();
			} else {
				val = true;
                                p.setSexo(sexo);
			}
		}
		System.out.print("» Ingrese peso [kg]: ");
		double peso = read.nextDouble();
                p.setPeso(peso);
		System.out.print("» Ingrese altura [m]: ");
		double altura = read.nextDouble();
                p.setAltura(altura);
		System.out.println();
		return p;
	}
        
        //Cree un get para el método crearPersona()
        
        public Persona getMetodCrear() {
            return crearPersona();
        }
	
	public int calcularIMC(Persona pers) {
                int ret = 0;
		int imc = (int) (pers.getPeso() / Math.pow(pers.getAltura(), 2));
		pers.setPesoIdeal(false);
		if(imc < 20) {
			ret = -1;
		} else if(imc >= 20 && imc <= 25) {
			pers.setPesoIdeal(true);
			ret = 0;
		} else if(imc > 25) {
			ret = 1;
		}
                return ret;
	}
	
	public boolean esMayorEdad(Persona pers) {
		return pers.getEdad() > 17;
	}
	
}