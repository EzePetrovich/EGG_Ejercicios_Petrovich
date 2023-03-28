
package votacionEGG;

import entity.Simulador;

public class Main {

    public static void main(String[] args) {
        Simulador s = new Simulador();
        System.out.println("\n-----CREA ALUMNOS-----");
        s.crearAlumnos();
        System.out.println("\n-----LOS MUESTRA-----");
        s.mostrarAlumnos();
        System.out.println("\n-----VOTACION-----");
        s.votacion();
        System.out.println("\n-----MUESTRA VOTOS-----");
        s.verVotos();
        System.out.println("\n-----FACILITADORES-----");
        s.facilitadores();
    }
}
