package g1_ej11_fund;
import java.util.Scanner;

public class G1_ej11_fund{
    public static void main(String arg[]){
        Scanner read = new Scanner(System.in);
        String item,opc;
        boolean val,quit;
        quit = false;
        float oper = 0;
        System.out.print("Ingrese un número: ");
        float a = read.nextFloat();
        System.out.print("Ingrese otro número: ");
        float b = read.nextFloat();
        read.nextLine();
        do{
            val = false;
            System.out.println("");
            System.out.println("MENÚ");
            System.out.println("1) Suma.");
            System.out.println("2) Resta.");
            System.out.println("3) Multiplicación.");
            System.out.println("4) División.");
            System.out.println("5) Salir.");
            System.out.println("");
            System.out.print("» Seleccione una opción [1|2|3|4|5]: ");
            opc = read.nextLine();
            switch(opc){
                case "1":
                        val = true;
                        oper = a + b;
                        break;
                case "2":
                        System.out.println("a) "+a+" - "+b);
                        System.out.println("b) "+b+" - "+a);
                        System.out.print("» Seleccione una opción para la resta [a|b]: ");
                        item = read.nextLine();
                        switch(item.toLowerCase()){
                            case "a":
                                    val = true;
                                    oper = a - b;
                                    break;
                            case "b":
                                    val = true;
                                    oper = b - a;
                                    break;
                            default:
                                    System.out.println("Error: opción no válida para la resta.");
                        }
                        break;
                case "3":
                        val = true;
                        oper = a * b;
                        break;
                case "4":
                        System.out.println("a) "+a+" / "+b);
                        System.out.println("b) "+b+" / "+a);
                        System.out.print("» Seleccione una opción para la división [a|b]: ");
                        item = read.nextLine();
                        switch(item.toLowerCase()){
                            case "a":
                                    val = true;
                                    oper = a / b;
                                    break;
                            case "b":
                                    val = true;
                                    oper = b / a;
                                    break;
                            default:
                                    System.out.println("Error: opción no válida para la división.");
                        }
                        break;
                case "5":   
                        System.out.print("» ¿Está seguro que desea salir? [S/N]: ");
                        item = read.nextLine();
                        if(item.equalsIgnoreCase("S")){
                            quit = true;
                        }
                        break;
                default:
                        System.out.println("Error: opción no válida.");
            }
            if(val == true){
                System.out.println("El resultado es: "+oper);
                System.out.print("Presione intro para seguir...");
                read.nextLine();
            }
        }while(quit != true);
    }
}