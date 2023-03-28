
package service.entity;

import java.util.Scanner;
import entity.CantanteFamoso;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class CantanteFamosoService {
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    public CantanteFamoso crearCantante() {
        System.out.println("1) NUEVO CANTANTE.");
        System.out.println();
        System.out.print("» Nombre cantante: "); String name = read.next();
        System.out.print("» Disco más vendido: "); String discoMasVendido = read.next();
        System.out.println();
        return new CantanteFamoso(name, discoMasVendido);
    }
    public void eliminarCantante(ArrayList<CantanteFamoso> cantantes) {
        boolean find = false;
        System.out.println("2) ELIMINAR CANTANTE.");
        System.out.println();
        System.out.print("» Nombre cantante: "); String name = read.next();
        System.out.println();
        Iterator<CantanteFamoso> it = cantantes.iterator();
        while(it.hasNext()) {
            if(it.next().getName().equals(name)) {
                it.remove();
                find = true;
            }
        }
        if(!find) {
            System.out.println("No se encontró el cantante ingresado.");
            System.out.print("Presione intro para seguir...");
            try{System.in.read();}
            catch(IOException e){}
        }
    }
    public void mostrarCantantes(ArrayList<CantanteFamoso> cantantes) {
        System.out.println("CANTANTES");
        System.out.println();
        if(!cantantes.isEmpty()) {
            for(CantanteFamoso c: cantantes) {
            System.out.println(c);
            }
        } else {System.out.println("No hay cantantes para mostrar.");}
        System.out.println();
        System.out.print("Presione intro para seguir...");
        try{System.in.read();}
        catch(IOException e){}
        System.out.println();
    }
}
