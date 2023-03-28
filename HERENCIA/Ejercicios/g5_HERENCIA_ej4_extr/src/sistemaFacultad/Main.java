/**
 * @author J. Ezequiel Petrovich
 */

package sistemaFacultad;

import entity.Empleado;
import entity.Estudiante;
import entity.Persona;
import entity.PersonalDeServicio;
import entity.Profesor;
import entity.Tools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Main implements Tools {
    public static void main(String[] args) {
        boolean find = false, noVacio = false;
        String confirm = "", dni;
        ArrayList<Persona> personas = new ArrayList();
        Persona p;
        // String cursoActual, String nombre, String apellido, String sexo, String dni, String estadoCivil
        Estudiante e1 = new Estudiante("Arquitectura", "Lautaro", "Sanchez Rios", "Masculino", "41634546", "Soltero");
        Estudiante e2 = new Estudiante("Arquitectura", "Megan", "Fox", "Femenino", "34786476", "Soltera");
        // String dpto, Integer anioIncorp, Integer numDesp, String nombre, String apellido, String sexo, String dni, String estadoCivil
        Profesor p1 = new Profesor("Arquitectura", 1995, 67, "Marlene", "Giogli", "Femenino", "27546346", "Casada");
        Profesor p2 = new Profesor("Arquitectura", 1995, 53, "Marlin", "Honda", "Masculino", "28546876", "Casado");
        // String seccion, Integer anioIncorp, Integer numDesp, String nombre, String apellido, String sexo, String dni, String estadoCivil
        PersonalDeServicio ps1 = new PersonalDeServicio("Decanato", 1985, 84, "Alberto", "Gomez", "Masculino", "11564786", "Casado");
        PersonalDeServicio ps2 = new PersonalDeServicio("Decanato", 1985, 84, "Roberto", "Gonzalez", "Masculino", "10564786", "Casado");
        // Agregamos las personas a la lista.
        personas.add(e1); personas.add(p1); personas.add(e2); personas.add(ps1); personas.add(p2); personas.add(ps2);
        // Ordena los objetos según su clase
        Collections.sort(personas, Persona.compararClasses);
        do {
            System.out.println("\nFACULTAD.");
            System.out.println("\n1) Cambiar estado civil de una persona.");
            System.out.println("2) Reasignar despacho de un empleado.");
            System.out.println("3) Matricular un estudiante en un nuevo curso.");
            System.out.println("4) Cambiar de departamento a un profesor.");
            System.out.println("5) Trasladar de seccion a un personal de servicio.");
            System.out.println("6) Mostrar personas.");
            System.out.println("7) Salir.");
            System.out.print("\n» Seleccione una opcion [1|2|3|4|5|6|7]: ");
            switch(read.next()) {
                case "1":
                        System.out.println("\n1) CAMBIO DE ESTADO CIVIL.");
                        System.out.print("\n» Ingrese el DNI de la persona: ");
                        dni = read.next();
                        Iterator<Persona> it = personas.iterator();
                        while(it.hasNext()) {
                            p = it.next();
                            if(p.getDni().equals(dni)) {
                                find = true;
                                p.cambioEstadoCivil();
                                System.out.println("¡Datos actualizados!");
                                System.out.println(p);
                                Tools.presioneIntro();
                                break;
                            }
                        }
                        if(!find) {System.out.println("\nERROR: No se encontro la persona ingresada."); Tools.presioneIntro();} 
                        else {find = false;}
                        break;
                case "2":
                        System.out.println("\n2) REASIGNAR DESPACHO A EMPLEADO.");
                        System.out.print("\n» Ingrese el DNI del empleado: ");
                        dni = read.next();
                        Iterator<Persona> itEmp = personas.iterator();
                        while(itEmp.hasNext()) {
                            p = itEmp.next();
                            if(p.getDni().equals(dni) && (p instanceof Empleado)) {
                                find = true;
                                ((Empleado) p).reasignacionDespacho();
                                System.out.println("¡Datos actualizados!");
                                System.out.println(p);
                                Tools.presioneIntro();
                                break;
                            }
                        }
                        if(!find) {System.out.println("\nERROR: No se encontro el empleado ingresado."); Tools.presioneIntro();} 
                        else {find = false;}
                        break;
                case "3":
                        System.out.println("\n3) MATRICULAR ESTUDIANTE EN NUEVO CURSO.");
                        System.out.print("\n» Ingrese el DNI del estudiante: ");
                        dni = read.next();
                        Iterator<Persona> itEst = personas.iterator();
                        while(itEst.hasNext()) {
                            p = itEst.next();
                            if(p.getDni().equals(dni) && (p instanceof Estudiante)) {
                                find = true;
                                ((Estudiante) p).matricularEstudiante();
                                System.out.println("¡Datos actualizados!");
                                System.out.println(p);
                                Tools.presioneIntro();
                                break;
                            }
                        }
                        if(!find) {System.out.println("\nERROR: No se encontro el estudiante ingresado."); Tools.presioneIntro();} 
                        else {find = false;}
                        break;
                case "4":
                        System.out.println("\n4) CAMBIO DE DEPARTAMENTO DE PROFESOR.");
                        System.out.print("\n» Ingrese el DNI del profesor: ");
                        dni = read.next();
                        Iterator<Persona> itProf = personas.iterator();
                        while(itProf.hasNext()) {
                            p = itProf.next();
                            if(p.getDni().equals(dni) && (p instanceof Profesor)) {
                                find = true;
                                ((Profesor) p).cambioDpto();
                                System.out.println("¡Datos actualizados!");
                                System.out.println(p);
                                Tools.presioneIntro();
                                break;
                            }
                        }
                        if(!find) {System.out.println("\nERROR: No se encontro el profesor ingresado."); Tools.presioneIntro();} 
                        else {find = false;}
                        break;
                case "5":
                        System.out.println("\n5) TRASLADO DE SECCION DE PERSONAL DE SERVICIO.");
                        System.out.print("\n» Ingrese el DNI del personal de servicio: ");
                        dni = read.next();
                        Iterator<Persona> itPServ = personas.iterator();
                        while(itPServ.hasNext()) {
                            p = itPServ.next();
                            if(p.getDni().equals(dni) && (p instanceof PersonalDeServicio)) {
                                find = true;
                                ((PersonalDeServicio) p).trasladarSeccion();
                                System.out.println("¡Datos actualizados!");
                                System.out.println(p);
                                Tools.presioneIntro();
                                break;
                            }
                        }
                        if(!find) {System.out.println("\nERROR: No se encontro el personal de servicio ingresado."); Tools.presioneIntro();} 
                        else {find = false;}
                        break;
                case "6":
                        System.out.println("\n6) MOSTRAR PERSONAS.");
                        System.out.println("\nA) Estudiantes.");
                        System.out.println("B) Profesores.");
                        System.out.println("C) Personal de servicio.");
                        System.out.println("D) Todas las personas.");
                        System.out.print("\n» Seleccione una opcion [A|B|C|D]: ");
                        switch(read.next().toUpperCase()) {
                            case "A":
                                    System.out.println("\nB) ESTUDIANTES.");
                                    Iterator<Persona> estuds = personas.iterator();
                                    while(estuds.hasNext()) {
                                        p = estuds.next();
                                        if(p instanceof Estudiante) {
                                            System.out.println(p);
                                            Tools.presioneIntro();
                                            noVacio = true;
                                        }
                                    }
                                    if(!noVacio) {System.out.println("ERROR: no hay estudiantes."); Tools.presioneIntro();}
                                    else {noVacio = false;}
                                    break;
                            case "B":
                                    System.out.println("\nB) PROFESORES.");
                                    Iterator<Persona> profs = personas.iterator();
                                    while(profs.hasNext()) {
                                        p = profs.next();
                                        if(p instanceof Profesor) {
                                            System.out.println(p);
                                            Tools.presioneIntro();
                                            noVacio = true;
                                        }
                                    }
                                    if(!noVacio) {System.out.println("ERROR: no hay profesores."); Tools.presioneIntro();}
                                    else {noVacio = false;}
                                    break;
                            case "C":
                                    System.out.println("\nC) PERSONAL DE SERVICIO.");
                                    Iterator<Persona> pServ = personas.iterator();
                                    while(pServ.hasNext()) {
                                        p = pServ.next();
                                        if(p instanceof PersonalDeServicio) {
                                            System.out.println(p);
                                            Tools.presioneIntro();
                                            noVacio = true;
                                        }
                                    }
                                    if(!noVacio) {System.out.println("ERROR: no hay personales de servicio."); Tools.presioneIntro();}
                                    else {noVacio = false;}
                                    break;
                            case "D":
                                    System.out.println("\nD) PERSONAS.");
                                    if(!personas.isEmpty()) {
                                        personas.forEach((person) -> {System.out.println(person); Tools.presioneIntro();});
                                    } else {System.out.println("ERROR: no hay personas para mostrar."); Tools.presioneIntro();}
                                    break;
                            default:
                                    System.out.println("ERROR: opcion no valida.");
                                    Tools.presioneIntro();
                        }
                        break;
                case "7":
                        System.out.print("\n¿Confirma salir? [s/n]: ");
                        confirm = read.next();
                        break;
                default:
                    System.out.println("\nERROR: opcion no valida.");
                    Tools.presioneIntro();
            }
        } while(!confirm.equalsIgnoreCase("s"));
    }
}
