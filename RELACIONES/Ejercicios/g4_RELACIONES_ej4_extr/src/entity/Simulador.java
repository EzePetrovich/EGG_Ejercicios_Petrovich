
package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class Simulador {
    
    // Scanner for user inputs
    
    public Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    // Attributes
    
    private ArrayList<Alumno> alumnos = new ArrayList();
    private ArrayList<Alumno> facilitadores = new ArrayList();
    private HashSet<Voto> votos = new HashSet();
    
    // Constructors
    
    public Simulador() {}
    
    // Getters
    
    public ArrayList<Alumno> getAlumnos() {return alumnos;}
    public ArrayList<Alumno> getFacilitadores() {return facilitadores;}
    public HashSet<Voto> getVotos() {return votos;}
    
    // Setters
    
    public void setAlumnos(ArrayList<Alumno> alumnos) {this.alumnos = alumnos;}
    public void setFacilitadores(ArrayList<Alumno> facilitadores) {this.facilitadores = facilitadores;}
    public void setVotos(HashSet<Voto> votos) {this.votos = votos;}
    
    // Methods of the class
    
    public ArrayList<String> nombresFullRandom(int n) {
       ArrayList<String> nombresCompletos = new ArrayList();
       for(int i = 1; i <= n; i++) {nombresCompletos.add("Nombre " + (new java.util.Random().nextInt(n) + 1) + " Apellido " + (new java.util.Random().nextInt(n) + 1));}
       return nombresCompletos;
    }
    
    public int randomDNI() {
        int dni = (int) ((Math.random() * 10));
        while(dni < 2 || dni >= 5) {
            dni = (int) ((Math.random() * 10));
        }
        dni = dni * 10000000;
        dni = dni + (int) ((Math.random() * 10000000));
        return dni;
    }
    
    public ArrayList<Integer> combinacionesDNI(int n) {
        ArrayList<Integer> combinacionesDNI = new ArrayList();
        for(int i = 1; i <= n; i++) {combinacionesDNI.add(randomDNI());}
        return combinacionesDNI;
    }
    
    public boolean existeDNI(int dni) {
        boolean find = false;
        if(!alumnos.isEmpty()) {
            Iterator<Alumno> it = alumnos.iterator();
            Alumno a;
            while(it.hasNext()) {
                a = it.next();
                if(a.getDNI() == dni) {
                    find = true;
                    break;
                }
            }
        }
        return find;
    }
    
    public void crearAlumnos() {
        System.out.print("» Número de alumnos a crear: ");
        int nAlumnos = read.nextInt();
        int randomNom, randomDNI;
        ArrayList<String> nombres = nombresFullRandom(nAlumnos);
        ArrayList<Integer> dnis = combinacionesDNI(nAlumnos);
        Alumno a;
        for(int i = 0; i < nAlumnos; i++) {
            a = new Alumno();
            randomNom = new java.util.Random().nextInt(nAlumnos);
            a.setCompleteName(nombres.get(randomNom));
            randomDNI = new java.util.Random().nextInt(nAlumnos);
            while(existeDNI(dnis.get(randomDNI))) {
                randomDNI = new java.util.Random().nextInt(nAlumnos);
            }
            a.setDNI(dnis.get(randomDNI));
            alumnos.add(a);
        }
    }
    
    public void mostrarAlumnos() {
        System.out.println("ALUMNOS.");
        System.out.println();
        alumnos.forEach((a) -> {System.out.println(a);});
    }
    
    public void votacion() {
        Voto v;
        for(Alumno a: alumnos) {
            v = new Voto();
            v.setAlumno(a);
            int posVoto = new java.util.Random().nextInt(alumnos.size());
            Alumno alVotado = alumnos.get(posVoto);
            for(int i = 0; i < 3; i++) {
                while(Objects.equals(a.getDNI(), alVotado.getDNI()) || v.getAlumnosVotados().contains(alVotado)) {
                    posVoto = new java.util.Random().nextInt(alumnos.size());
                    alVotado = alumnos.get(posVoto);
                }
                v.getAlumnosVotados().add(alVotado);
                alVotado.setNVotos(alVotado.getNVotos() + 1);
            }
            votos.add(v);
        }
    }
    
    public void verVotos() {
        System.out.println("\nVOTOS DE ALUMNOS.");
        votos.stream().map((v) -> {
            System.out.println("\nVOTO DE ALUMNO " + v.getAlumno().getCompleteName() + ":");
            System.out.println(v.getAlumno());
            return v;
        }).map((v) -> {
            System.out.println("\n• Alumnos votados:");
            return v;
        }).map((v) -> {
            System.out.println();
            return v;
        }).forEachOrdered((v) -> {
            v.getAlumnosVotados().forEach((a) -> {
                System.out.println(a);
            });
        });
    }
    
    public void facilitadores() {
        alumnos.sort(Alumno.compararVotos);
        for(int i = 0; i < 10; i++) {
            if(i == 5) {System.out.println("\n-----FACILITADORES SUPLENTES-----");}
            facilitadores.add(alumnos.get(i));
            System.out.println(alumnos.get(i));
        }
    }
    
    /**
     * distintosDNI()
     * 
     * La utilicé para comprobar que no se repitan los dnis. Cree 2000 alumnos y luego busqué 
     * alguna coincidencia de dnis y no encontró ninguna. Dicho resultado me indica que funciona
     * bien la validación de dnis en alumnos (para que no se repitan).
     */
    
    /*public boolean distintosDNI() {
        boolean distinto = true, prim = true;
        int resgDNI = 0;
        for(Alumno a: alumnos) {
            if(prim) {
                resgDNI = a.getDNI();
                prim = false;
            } else if(resgDNI == a.getDNI()) {
                distinto = false;
                break;
            }
        }
        return distinto;
    }*/
}
