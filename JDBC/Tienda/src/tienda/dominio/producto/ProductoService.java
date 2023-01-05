
package tienda.dominio.producto;

import java.util.Collection;
import tienda.persistence.ProductoDAO;
import tienda.utilites.Tools;

public final class ProductoService implements Tools {
    
    private final ProductoDAO dao = new ProductoDAO();
    
    public void addProdBDD() throws Exception {
        try {
                Producto prod = new Producto();
                System.out.println("\nPRODUCTO\n");
                System.out.print("» Nombre de producto: ");
                prod.setNombre(read.next());
                System.out.print("» Precio de producto: $");
                prod.setPrecio(read.nextInt());
                System.out.print("» Codigo de fabricante: ");
                prod.setCodFab(read.nextInt());
                if(dao.searchProductByName(prod.getNombre()) != null) {throw new Exception("ERROR: el producto ya existe.");}
                dao.saveProduct(prod);
            } catch(Exception e) {throw e;}
    }
    
    public void editProdBDD() throws Exception {
        try {
            System.out.println("\nMODIFICAR PRODUCTO\n");
            System.out.print("» Ingrese el codigo de producto: ");
            Producto prod = dao.searchProductByCod(read.nextInt());
            if(prod == null) {throw new Exception("ERROR: el producto no existe.");}
            System.out.println("\n1) Eliminar producto.");
            System.out.println("2) Modificar nombre.");
            System.out.println("3) Modificar precio.");
            System.out.println("4) Modificar codigo de fabricante.");
            System.out.print("\n» Ingrese una opcion: ");
            switch(read.next()) {
                case "1":
                    dao.deleteProduct(prod.getCodProd());
                    break;
                case "2":
                    System.out.print("» Ingrese nuevo nombre: ");
                    dao.modifyName(read.next(), prod.getCodProd());
                    break;
                case "3":
                    System.out.print("» Ingrese nuevo precio: $");
                    dao.modifyPrice(read.nextInt(), prod.getCodProd());
                    break;
                case "4":
                    System.out.print("» Ingrese nuevo codigo de fabricante: ");
                    dao.modifyCodFab(read.nextInt(), prod.getCodProd());
                    break;
            }
        }
        catch(Exception e) {throw e;}
    }
    
    public void listarNombres() throws Exception {
        Collection<Producto> prods = dao.listProductsName();
        System.out.println("\nNombre de los productos disponibles:\n");
        prods.forEach((p) -> {System.out.println(p.getNombre());});
        Tools.pressIntro();
    }
    
    public void listarNombresPrecios() throws Exception {
        Collection<Producto> prods = dao.listProductsNamePrice();
        System.out.println("\nNombre y precio de los productos disponibles:\n");
        prods.forEach((p) -> {System.out.println(p.getNombre() + " | $" + p.getPrecio());});
        Tools.pressIntro();
    }
    
    public void productosEntrePrecios() throws Exception {
        Collection<Producto> prods = dao.listProductsPriceBetween();
        System.out.println("\nProductos con precio entre $120 y $202:\n");
        prods.forEach((p) -> {System.out.println("Cod_prod: " + p.getCodProd() + " | Nombre: " + p.getNombre() + " | Precio: $" + p.getPrecio() + " | Cod_fab: " + p.getCodFab());});
        Tools.pressIntro();
    }
    
    public void portatilesDisponibles() throws Exception {
        Collection<Producto> prods = dao.portatilesDisp();
        System.out.println("\nPortátiles disponibles:\n");
        prods.forEach((p) -> {System.out.println("Cod_prod: " + p.getCodProd() + " | Nombre: " + p.getNombre() + " | Precio: $" + p.getPrecio() + " | Cod_fab: " + p.getCodFab());});
        Tools.pressIntro();
    }
    
    public void productLowPrice() throws Exception {
        Producto prod = dao.searchProductLowPrice();
        System.out.println("\nProducto más barato:\n");
        System.out.println("Nombre: " + prod.getNombre() + " | Precio: $" + prod.getPrecio());
        Tools.pressIntro();
    }
    
}
