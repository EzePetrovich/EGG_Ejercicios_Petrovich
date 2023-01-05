
package tienda;

import tienda.dominio.fabricante.FabricanteService;
import tienda.dominio.producto.ProductoService;
import tienda.utilites.Tools;

public class Main implements Tools {

    public static void main(String[] args) throws Exception {
        
        String resp = ""; boolean run = true;
        FabricanteService fabricante_sv = new FabricanteService();
        ProductoService producto_sv = new ProductoService();
        
        do {
            System.out.println("·MENÚ TIENDA·\n");
            System.out.println("1. Listar el nombre de todos los productos.");
            System.out.println("2. Listar nombre y precio de todos los productos.");
            System.out.println("3. Listar productos con precio entre $120 y $202.");
            System.out.println("4. Buscar y listar portatiles disponibles entre los productos.");
            System.out.println("5. Listar nombre y precio del producto más barato.");
            System.out.println("6. Ingresar un producto a la base de datos.");
            System.out.println("7. Ingresar un fabricante a la base de datos.");
            System.out.println("8. Editar un producto.");
            System.out.print("\n» Seleccione una opcion [\"q\" para salir]: ");
            resp = read.next();
            switch(resp) {
                case "1":
                    producto_sv.listarNombres();
                    break;
                case "2":
                    producto_sv.listarNombresPrecios();
                    break;
                case "3":
                    producto_sv.productosEntrePrecios();
                    break;
                case "4":
                    producto_sv.portatilesDisponibles();
                    break;
                case "5":
                    producto_sv.productLowPrice();
                    break;
                case "6":
                    producto_sv.addProdBDD();
                    break;
                case "7":
                   fabricante_sv.addFabricanteBDD();
                   break;
                case "8":
                    producto_sv.editProdBDD();
                    break;
                case "q":
                    run = false;
                    break;
                default:
                    System.err.println("ERROR: opcion ingresada no valida.");
                    Tools.pressIntro();
                    break;
            }
        } while(run);
    }
    
}
