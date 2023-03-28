
package service.entity;

import entity.City;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CityService {
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    public City crearCiudad() {
        System.out.println();
        System.out.print("» Nombre de ciudad: "); String name = read.next();
        System.out.print("» Código postal: "); String codP = read.next();
        System.out.println();
        return new City(codP, name);
    }
    public HashMap<String, City> mapCities() {
        City c; HashMap<String, City> map = new HashMap();
        System.out.println("• Ingrese 3 ciudades. ");
        System.out.println();
        for(int i = 1; i < 4; i++) {
            System.out.print("CIUDAD " + i +": ");
            c = crearCiudad();
            map.put(c.getCodP(), c);
            System.out.println();
        }
        return map;
    }
    public void mostarCities(HashMap<String, City> map) {
        System.out.println("4) MOSTRAR CIUDADES.");
        System.out.println();
        for(City ciudad: map.values()) {
            System.out.println(ciudad);
        }
        System.out.println();
        System.out.print("Presione intro para seguir...");
        try{System.in.read();}
        catch(IOException e){}
    }
    
    /**
     * 
     * @param map: Recibe un mapa para buscar la ciudad.
     * @param cP: Recibe el código postal a buscar de la ciudad.
     * @return boolean: retorna true si encuentra la ciudad, caso contrario false.
     * 
     */
    
    public boolean existeCity(HashMap<String, City> map, String cP) {
        boolean find = false;
        for(String cod: map.keySet()) {
            if(cod.equals(cP)) {
                find = true;
            }
        }
        return find;
    }
    
    /**
     * @param map: Recibe el map en dónde buscar la ciudad según su código postal.
     * Busca la ciudad ingresada y la muestra.
     */
    
    public void buscarCity(HashMap<String, City> map) {
        System.out.println("3) BUSCAR CIUDAD.");
        System.out.println();
        System.out.print("» Ingrese un código postal: "); String cP = read.next();
        System.out.println();
        if(existeCity(map, cP)) {
            for(Map.Entry<String, City> entry: map.entrySet()) {
                if(entry.getKey().equals(cP)) {
                    System.out.print("Ciudad asociada: ");
                    System.out.println(entry.getValue());
                    System.out.println();
                    System.out.print("Presione intro para seguir...");
                    try{System.in.read();}
                    catch(IOException e){}
                    break;
                }
            }
        } else {
            System.out.println("No existe la ciudad ingresada.");
            System.out.println();
            System.out.print("Presione intro para seguir...");
            try{System.in.read();}
            catch(IOException e){}
        }
        System.out.println();
    }
    
    public void addCity(HashMap<String, City> map) {
        System.out.println("1) AÑADIR CIUDAD.");
        City c = crearCiudad();
        map.put(c.getCodP(), c);
    }
    
    public void removeCity(HashMap<String, City> map) {
        System.out.println("2) ELIMINAR CIUDAD.");
        System.out.println();
        System.out.print("» Ingrese un código postal: "); String cP = read.next();
        System.out.println();
        if(existeCity(map, cP)) {
            for(String codigo: map.keySet()) {
                if(codigo.equals(cP)) {
                    map.remove(codigo);
                    System.out.println("Se eliminó con éxito.");
                    System.out.println();
                    System.out.print("Presione intro para seguir...");
                    try{System.in.read();}
                    catch(IOException e){}
                    break;
                }
            }
        } else {
            System.out.println("No existe la ciudad ingresada.");
            System.out.println();
            System.out.print("Presione intro para seguir...");
            try{System.in.read();}
            catch(IOException e){}
        }
        System.out.println();
    }
}

/**
 * Ciudades de paises
 * :
 * 
 * ITALIA.
 * Acquaviva: 00017
 * Altoa Italia: 00142
 * Aurelio: 00165
 * Anticoli Corrado: 00022
 * Albanetta: 00018
 * 
 * UCRANIA.
 * Алушта: 98500
 * Верхня Кутузовка: 98533
 * Кипарисне: 98540
 * Виноградний: 98500
 * Бондаренкове: 98540
 */