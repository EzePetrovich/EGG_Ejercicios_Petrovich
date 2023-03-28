
package service.entity;

import entity.adivinanza.Mes;
import java.util.Scanner;

public class MesService {
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    public Mes nuevaAdivinanza() {
        int num_random;
        String [] meses = new String [12];
        for(int i = 0; i < 12; i++) {
            switch(i) {
                case 0:
                    meses[i] = "enero";
                    break;
                case 1:
                    meses[i] = "febrero";
                    break;
                case 2:
                    meses[i] = "marzo";
                    break;
                case 3:
                    meses[i] = "abril";
                    break;
                case 4:
                    meses[i] = "mayo";
                    break;
                case 5:
                    meses[i] = "junio";
                    break;
                case 6:
                    meses[i] = "julio";
                    break;
                case 7: 
                    meses[i] = "agosto";
                    break;
                case 8:
                    meses[i] = "septiembre";
                    break;
                case 9:
                    meses[i] = "octubre";
                    break;
                case 10:
                    meses[i] = "noviembre";
                    break;
                case 11:
                    meses[i] = "diciembre";
                    break;
            }
        }
        if(((int) (Math.random() * 10)) % 2 == 0) {
            num_random = (int) Math.round((double)((Math.random() * 10) / 3) + ((Math.random() * 10) / 3) + ((Math.random() * 10) / 3) + ((Math.random() * 10) / 3));
        } else {
            num_random = (int) Math.round((double)((Math.random() * 10) / 3) + ((Math.random() * 10) / 3));
        }
        
        String mesOculto = meses[num_random];
        return new Mes(meses, mesOculto);
    }
    
    public void adivinarMes(Mes m) {
        String resp;
        String [] meses = m.getMeses();
        int pos_sec = 0, pos_resp = 0;
        while(!m.getMesSecreto().equals(meses[pos_sec])) {
            pos_sec++;
        }
        do {
            System.out.print("» Adivine el mes que estoy pensando: ");
            resp = read.next().toLowerCase();
            for(int i = 0; i < 12; i++) {
                if(meses[i].equals(resp)) {
                    pos_resp = i;
                    break;
                }
            }
            if(resp.equals(m.getMesSecreto())) {
                System.out.println("¡Acertaste!");
            } else {
                if(pos_resp > pos_sec) {
                    System.out.println("Ese no es, está antes.");
                } else {
                    System.out.println("Ese no es, está despues.");
                }
                System.out.println("Presione intro para seguir...");
                read.next();
            }
        } while(!resp.equals(m.getMesSecreto()));
    }
}
